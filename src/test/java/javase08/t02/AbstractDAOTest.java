package javase08.t02;

import javase08.t02.DAO.AuthorDAO;
import javase08.t02.DAO.BookDAO;
import javase08.t02.Data.Author;
import javase08.t02.Data.Book;
import org.flywaydb.core.Flyway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

import static org.junit.Assert.*;

public abstract class AbstractDAOTest {
    abstract ConnectionPool getConnectionPool();
    abstract DataSource getDataSource();
    abstract BookDAO getBookDAO();
    abstract AuthorDAO getAuthorDAO();

    private final Flyway flyway;

    public AbstractDAOTest() {
        this.flyway = new Flyway();
        this.flyway.setDataSource(getDataSource());
        this.flyway.setLocations("db_javase08_t02");
    }

    @Before
    public void before() {
        flyway.migrate();
    }

    @After
    public void after() throws SQLException, InterruptedException {
        flyway.clean();
        try (Connection connection = getDataSource().getConnection()) {
            final Statement statement = connection.createStatement();
            statement.execute("drop table if exists book");
            statement.execute("drop table if exists author");
        }
    }

    @Test
    public void exists() throws SQLException, InterruptedException{
        assertTrue(getBookDAO().exists("Summa technologiae","Stanislaw Lem"));
    }

    @Test
    public void notExists() throws SQLException, InterruptedException{
        assertFalse(getBookDAO().exists("War and piece","Lev Tolstoj"));
    }

    @Test
    public void getBookByName(){
        List<Book> books = getBookDAO().getByName("The mother");
        for(Book book : books){
            assertEquals(book.getName(),"The mother");
            if (book.getAuthor_id() == 3)
                assertEquals(4,book.getId());
            else if (book.getAuthor_id() == 4)
                assertEquals(5,book.getId());
            else
                fail("Wrong author");
        }
    }

    @Test
    public void getNonexistentBookByName(){
        List<Book> books = getBookDAO().getByName("War and piece");
        assertNull(books);
    }

    @Test
    public void getBookByAuthor(){
        List<Book> books = getBookDAO().getByAuthor("O. Henry");
        for(Book book : books){
            assertEquals(book.getAuthor_id(),1);
            assert book.getId() == 1L && book.getName().equals("The third ingredient") || book.getId() == 2L && book.getName().equals("The romance of a busy broker");
        }
    }

    @Test
    public void getBookByNonexistentAuthor(){
        List<Book> books = getBookDAO().getByName("Lermontov");
        assertNull(books);
    }

    @Test
    public void getAuthorByName(){
        Author author = getAuthorDAO().getByName("O. Henry");
        assertEquals(1,author.getId());
        assertEquals("O. Henry", author.getName());
    }

    @Test
    public void getNonexistentAuthorByName(){
        Author author = getAuthorDAO().getByName("Lev Tolstoj");
        assertNull(author);
    }

    @Test
    public void addNewBookWithNewAuthor() throws SQLException{
        assertTrue(getBookDAO().addNewBook("War and piece","Lev Tolstoj"));
        Connection connection = getDataSource().getConnection();
        Statement statement = connection.createStatement();
        try(ResultSet resultSet = statement.executeQuery("select name from book where author_id = 5")) {
            resultSet.next();
            assertEquals("War and piece", resultSet.getString("name"));
        }
    }

    @Test
    public void addNewBookWithAlreadyExistentAuthor() throws SQLException{
        assertTrue(getBookDAO().addNewBook("Jeff Peters as a Personal Magnet","O. Henry"));
        Connection connection = getDataSource().getConnection();
        Statement statement = connection.createStatement();
        try(ResultSet resultSet = statement.executeQuery("select name, author_id from book where id = 6")) {
            resultSet.next();
            assertEquals("Jeff Peters as a Personal Magnet", resultSet.getString("name"));
            assertEquals(1, resultSet.getInt("author_id"));
        }
    }

    /*@Test
    public void update() throws SQLException{
        try(Connection connection = getConnectionPool().getConnection()) {
            Statement statement = connection.createStatement();
            int updatedRows = statement.executeUpdate("update data set password='haha'");
            assertEquals(3,updatedRows);
            ResultSet passwords = statement.executeQuery("select password from data");
            while(passwords.next()){
                String curPwd = passwords.getString("password");
                assertEquals("haha",curPwd);
            }
        }

    }


    @Test
    public void selectAll() throws SQLException{
        try(Connection connection = getConnectionPool().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select login, password from data where login = 'Hajam'");
            resultSet.next();
            String curLogin = resultSet.getString("login");
            String curPwd = resultSet.getString("password");
            assertEquals("Yjexbnnjq",curPwd);
            assertEquals("Hajam",curLogin);
        }
    }

    @Test
    public void insert() throws SQLException{
        try(Connection connection = getConnectionPool().getConnection()) {
            Statement statement = connection.createStatement();
            int affectedRows = statement.executeUpdate("insert into data values('alexmich','pfxtvyfvhs,fhfptcnmbrhf')");
            assertEquals(1,affectedRows);
            ResultSet lastRecord = statement.executeQuery("select password from data where login='alexmich'");
            assertEquals(true,lastRecord.next());
            String insertedPwd = lastRecord.getString("password");
            assertEquals("pfxtvyfvhs,fhfptcnmbrhf",insertedPwd);
            assertEquals(false,lastRecord.next());
        }
    }

    @Test(expected = SQLException.class)
    public void dropTable() throws SQLException{
        try(Connection connection = getConnectionPool().getConnection()) {
            final Statement statement = connection.createStatement();
            statement.execute("drop table if exists data");
            statement.execute("drop table data");
        }
    }*/
}

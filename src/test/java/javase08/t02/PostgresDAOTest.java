package javase08.t02;

import javase08.t02.DAO.AuthorDAO;
import javase08.t02.DAO.BookDAO;
import javase08.t02.DAO.DAOFactory;
import javase08.t02.DAO.postgres.PgDAOFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresDAOTest extends AbstractDAOTest {
    private static DataSource ds;
    private static ConnectionPool pool;
    private static BookDAO bookDAO;
    private static AuthorDAO authorDAO;


    @BeforeClass
    public static void startup(){
        String user = "postgres";
        String password = "postgres";
        String dbName = "test";

        final PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(dbName);
        PostgresDAOTest.ds = ds;

        final Properties info = new Properties();
        info.setProperty("user",user);
        info.setProperty("password",password);
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/" + dbName;
        PostgresDAOTest.pool = new ConnectionPool(driver,url,info);

        DAOFactory factory = new PgDAOFactory();
        bookDAO = factory.getBookDAO(pool);
        authorDAO = factory.getAuthorDAO(pool);
    }

    @AfterClass
    public static void finish() throws SQLException{
        pool.close();
    }

    @Override
    DataSource getDataSource(){
        return ds;
    }

    @Override
    ConnectionPool getConnectionPool() {
        return pool;
    }

    @Override
    BookDAO getBookDAO() {
        return bookDAO;
    }

    @Override
    AuthorDAO getAuthorDAO() {
        return authorDAO;
    }
}

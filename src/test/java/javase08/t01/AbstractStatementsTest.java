package javase08.t01;

import org.flywaydb.core.Flyway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.*;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStatementsTest {
    abstract DataSource getDataSource();
    private final Flyway flyway;


    //todo убрать информацию flyway в логи
    public AbstractStatementsTest() {
        this.flyway = new Flyway();
        this.flyway.setDataSource(getDataSource());
        this.flyway.setLocations("db");
    }

    @Before
    public void before() {
        flyway.migrate();
    }

    @After
    public void after() throws SQLException {
        flyway.clean();
        try (Connection connection = getDataSource().getConnection()) {
            final Statement statement = connection.createStatement();
            statement.execute("drop table if exists data");
        }
    }

    @Test
    public void selectPassword() throws SQLException{

        try(Connection connection = getDataSource().getConnection()){
            PreparedStatement select = connection.prepareStatement("select password from data where login = ?;", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            select.setString(1,"Esenin");
            final ResultSet resultSet = select.executeQuery();
            resultSet.next();
            String password = resultSet.getString("password");
            assertEquals("Ujhbpdtplfvjzytgflfq",password);
        }
    }

    @Test
    public void update() throws SQLException{
        try(Connection connection = getDataSource().getConnection()) {
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
        try(Connection connection = getDataSource().getConnection()) {
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
        try(Connection connection = getDataSource().getConnection()) {
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
        try(Connection connection = getDataSource().getConnection()) {
            final Statement statement = connection.createStatement();
            statement.execute("drop table if exists data");
            statement.execute("drop table data");
        }
    }
}

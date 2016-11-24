package javase08.t01;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.junit.BeforeClass;

import javax.sql.DataSource;

public class MysqlStatementTest extends AbstractStatementsTest{
    private static DataSource ds;

    @BeforeClass
    public static void startup(){
        final MysqlDataSource ds = new MysqlDataSource();
        ds.setUser("root");
        ds.setPassword("MYSQL");
        ds.setDatabaseName("test");
        MysqlStatementTest.ds = ds;
    }

    @Override
    DataSource getDataSource() {
        return ds;
    }
}

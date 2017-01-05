package javase08.t01;

import org.junit.BeforeClass;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class PostgresStatementTest extends AbstractStatementsTest {
    private static DataSource ds;


    @BeforeClass
    public static void startup(){
        final PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setUser("postgres");
        ds.setPassword("postgres");
        ds.setDatabaseName("test");
        PostgresStatementTest.ds = ds;
    }

    @Override
    DataSource getDataSource() {
        return ds;
    }
}

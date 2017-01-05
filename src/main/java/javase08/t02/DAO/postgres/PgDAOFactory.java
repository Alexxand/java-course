package javase08.t02.DAO.postgres;

import javase08.t02.ConnectionPool;
import javase08.t02.DAO.AuthorDAO;
import javase08.t02.DAO.BookDAO;
import javase08.t02.DAO.DAOFactory;

public class PgDAOFactory implements DAOFactory{
    @Override
    public AuthorDAO getAuthorDAO(ConnectionPool pool) {
        return new PgAuthorDAO(pool);
    }

    @Override
    public BookDAO getBookDAO(ConnectionPool pool) {
        return new PgBookDAO(pool);
    }
}

package javase08.t02.DAO;

import javase08.t02.ConnectionPool;

public interface DAOFactory {
    AuthorDAO getAuthorDAO(ConnectionPool pool);
    BookDAO getBookDAO(ConnectionPool pool);
}

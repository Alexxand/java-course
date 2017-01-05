package javase08.t02.DAO.postgres;

import javase08.t02.ConnectionPool;
import javase08.t02.DAO.AuthorDAO;
import javase08.t02.Data.Author;
import javase08.t02.Data.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PgAuthorDAO implements AuthorDAO {
    private ConnectionPool pool;
    PgAuthorDAO(ConnectionPool pool){
        this.pool = pool;
    }

    /**
     * Get an Author with the given author's name.
     * Return object Author with the given name
     * if the author with this name exists in database
     * and there weren't errors during execution of this method
     * and null otherwise.
     * @param name Name of the author
     * @return object Author or null
     */
    @Override
    public Author getByName(String name) {
        try (Connection connection = pool.getConnection()){
            PreparedStatement authorStatement = connection.prepareStatement("select id from author where name = ?;");
            authorStatement.setString(1,name);
            try (ResultSet authorSet = authorStatement.executeQuery()) {
                if (authorSet.next()) {
                    int id = authorSet.getInt("id");
                    return new Author(id, name);
                }
            }
            return null;
        } catch (SQLException e){
            e.printStackTrace();
        }
        catch (InterruptedException  e){
            Thread.currentThread().interrupt();
        }
        return null;
    }
}

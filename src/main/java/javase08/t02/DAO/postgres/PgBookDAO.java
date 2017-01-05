package javase08.t02.DAO.postgres;

import javase08.t02.ConnectionPool;
import javase08.t02.DAO.BookDAO;
import javase08.t02.Data.Book;
import org.postgresql.util.PGobject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PgBookDAO implements BookDAO {
    private ConnectionPool pool;

    PgBookDAO(ConnectionPool pool){
        this.pool = pool;
    }

    @Override
    public boolean exists(String bookName, String authorName){
        try (Connection connection = pool.getConnection()){
            PreparedStatement bookStatement = connection.prepareStatement("select author_id from book where name = ?;");
            bookStatement.setString(1,bookName);
            try (ResultSet authorIdSet = bookStatement.executeQuery()) {
                while (authorIdSet.next()) {
                    int authorId = authorIdSet.getInt("author_id");
                    Statement authorStatement = connection.createStatement();
                    ResultSet authorNameSet = authorStatement.executeQuery("select (name) from author where id = " + authorId + ";");
                    if (authorNameSet.next())
                        return true;
                }
            }
            return false;
        } catch (SQLException e){
            e.printStackTrace();
        }
        catch (InterruptedException  e){
            Thread.currentThread().interrupt();
        }

        return false;
    }

    @Override
    public List<Book> getByName(String bookName){
        try (Connection connection = pool.getConnection()){
            PreparedStatement bookStatement = connection.prepareStatement("select id, author_id from book where name = ?;");
            bookStatement.setString(1,bookName);
            try (ResultSet bookSet = bookStatement.executeQuery()) {
                List<Book> bookList = new ArrayList<>();
                while (bookSet.next()) {
                    int id = bookSet.getInt("id");
                    int authorId = bookSet.getInt("author_id");
                    bookList.add(new Book(id, bookName, authorId));
                }
                if (bookList.isEmpty())
                    return null;
                return bookList;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        catch (InterruptedException  e){
            Thread.currentThread().interrupt();
        }
        return null;
    }

    @Override
    public List<Book> getByAuthor(String authorName) {
        try (Connection connection = pool.getConnection()){
            PreparedStatement authorStatement = connection.prepareStatement("select id from author where name = ?;");
            authorStatement.setString(1,authorName);
            try(ResultSet authorIdSet = authorStatement.executeQuery()) {
                List<Book> bookList = new ArrayList<>();
                if (!authorIdSet.next())
                    return null;
                int authorId = authorIdSet.getInt("id");
                Statement bookStatement = connection.createStatement();
                try (ResultSet bookSet = bookStatement.executeQuery("select id, name from book where author_id = " + authorId + ";")) {
                    while (bookSet.next()) {
                        int id = bookSet.getInt("id");
                        String selectedBookName = bookSet.getString("name");
                        bookList.add(new Book(id, selectedBookName, authorId));
                    }
                    if (bookList.isEmpty())
                        return null;
                    return bookList;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        catch (InterruptedException  e){
            Thread.currentThread().interrupt();
        }
        return null;
    }

    @Override
    public boolean addNewBook(String bookName, String authorName) {
        try (Connection connection = pool.getConnection()){
            PreparedStatement selectAuthorStatement = connection.prepareStatement("select id from author where name = ?;");
            selectAuthorStatement.setString(1,authorName);
            ResultSet authorIdSet = selectAuthorStatement.executeQuery();

            int authorId;
            if (!authorIdSet.next()) {
                PreparedStatement insertAuthorStatement = connection.prepareStatement("insert into author (name) values (?);");
                insertAuthorStatement.setString(1, authorName);
                if (insertAuthorStatement.executeUpdate() != 1)
                    return false;
                authorIdSet = selectAuthorStatement.executeQuery();
                authorIdSet.next();
            }
            authorId = authorIdSet.getInt("id");

            PreparedStatement insertBookStatement = connection.prepareStatement("insert into book (name, author_id) values (?," + authorId + ") ;");
            insertBookStatement.setString(1, bookName);
            if (insertBookStatement.executeUpdate() != 1)
                return false;
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        catch (InterruptedException  e){
            Thread.currentThread().interrupt();
        }
        return false;
    }
}

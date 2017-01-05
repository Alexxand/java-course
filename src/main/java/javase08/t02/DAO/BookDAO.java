package javase08.t02.DAO;

import javase08.t02.Data.Book;

import java.util.List;

public interface BookDAO {
    boolean exists(String bookName, String authorName);
    List<Book> getByName(String bookName);
    List<Book> getByAuthor(String authorName);
    boolean addNewBook(String bookName, String authorName);
}

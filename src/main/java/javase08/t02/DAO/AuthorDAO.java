package javase08.t02.DAO;

import javase08.t02.Data.Author;

public interface AuthorDAO {
    Author getByName(String name);
}

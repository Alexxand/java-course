package javase04.t04;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode
public class MovieCollection implements Serializable {
    private Map<Movie,List<Actor>> movieMap = new HashMap<>();

    public void put(Movie movie, List<Actor> mainActors) throws IllegalArgumentException{
        if (movieMap.containsKey(movie))
            throw new IllegalArgumentException("This movie already exist in the collection");
        movieMap.put(movie,mainActors);
    }

    public List<Actor> get(Movie movie) throws IllegalArgumentException{
        if (!movieMap.containsKey(movie))
            throw new IllegalArgumentException("There isn't such movie in this collection");
        return movieMap.get(movie);
    }

}

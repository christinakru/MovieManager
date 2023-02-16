import org.junit.jupiter.api.Test;
import org.manager.MovieManager;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    @Test
    void createManager() {
        MovieManager manager = new MovieManager();

        int expLen = 0;
        int actLen = manager.findAll().length;

        assertEquals(expLen, actLen);
    }

    @Test
    void defaultLimit() {
        MovieManager manager = new MovieManager();

        int exp = 10;
        int act = manager.limit;

        assertEquals(exp, act);
    }

    @Test
    void customLimit() {
        MovieManager manager = new MovieManager(100);

        int exp = 100;
        int act = manager.limit;

        assertEquals(exp, act);
    }

    @Test
    void addMoviesAndFindAll() {
        MovieManager manager = new MovieManager(100);
        String[] movies = new String[]{"Человек-Паук", "Черная Пантера", "Тор", "Гарри Поттер", "Зодиак", "Малифисента"};
        for (String movie :
                movies) {
            manager.addNewMovie(movie);
        }

        String[] act = manager.findAll();

        assertArrayEquals(movies, act);
    }

    @Test
    void addMoviesAndFindLast() {
        MovieManager manager = new MovieManager(3);
        String[] movies = new String[]{"Человек-Паук", "Черная Пантера", "Тор", "Гарри Поттер", "Зодиак", "Малифисента"};
        for (String movie :
                movies) {
            manager.addNewMovie(movie);
        }

        String[] exp = new String[]{"Малифисента", "Зодиак", "Гарри Поттер"};
        String[] act = manager.findLast();

        assertArrayEquals(exp, act);
    }

    @Test
    void addMoviesAndFindLastDefaultLimit() {
        MovieManager manager = new MovieManager();
        String[] movies = new String[]{"Человек-Паук", "Черная Пантера", "Тор", "Гарри Поттер", "Зодиак", "Малифисента"};
        for (String movie :
                movies) {
            manager.addNewMovie(movie);
        }

        String[] act = manager.findLast();
        Collections.reverse(Arrays.asList(movies));

        assertArrayEquals(movies, act);
    }
}

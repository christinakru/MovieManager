package org.manager;

public class MovieManager {
    private String[] movies;
    public int limit;

    public MovieManager() {
        limit = 10;
        movies = new String[]{};
    }

    public MovieManager(int limit) {
        this.limit = limit;
        movies = new String[]{};
    }

    public void addNewMovie(String movie) {
        int len = movies.length;

        String[] newArr = new String[len + 1];
        System.arraycopy(movies, 0, newArr, 0, len);
        newArr[len] = movie;
        movies = newArr;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] findLast() {
        int len = movies.length;
        int resLen = Math.min(len, limit);

        String[] newArr = new String[resLen];
        for (int i = 0; i < resLen; i++) {
            newArr[i] = movies[len - 1 - i];
        }
        return newArr;
    }
}

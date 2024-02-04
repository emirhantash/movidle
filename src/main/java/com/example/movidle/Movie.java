package com.example.movidle;

import java.io.*;
import java.util.*;

public class Movie {
    private final String no, title, year, genre, origin, director, star, imdbLink;

    public Movie(String no, String title, String year, String genre, String origin, String director, String star, String imdbLink) {
        this.no = no;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.origin = origin;
        this.director = director;
        this.star = star;
        this.imdbLink = imdbLink;
    }

    public String getNo() {
        return no;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {return year;}

    public String getGenre() {
        return genre;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDirector() {
        return director;
    }

    public String getStar() {
        return star;
    }

    public static void movieReader(ArrayList<Movie> movieList) throws IOException {
        String filePath = ".\\imdb_top_250.csv"; //abs
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // skip the firstLine
                }
                String[] parts = line.split(";");
                String no = parts[0].trim();
                String title = parts[1].trim();
                String year = parts[2].trim();
                String genre = parts[3].trim();
                String origin = parts[4].trim();
                String director = parts[5].trim();
                String star = parts[6].trim();
                String imdbLink = parts[7].trim();
                movieList.add(new Movie(no, title, year, genre, origin, director, star, imdbLink));
            }
            for (Movie movie : movieList) {
                System.out.println(movie.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Movie movieSelector(ArrayList<Movie> movieList) {
        Random rand = new Random();
        int a = rand.nextInt(251);
        String movieNo = Integer.toString(a);
        for (Movie movie : movieList) {
            if (movie.getNo().equals(movieNo)) {
                Movie selectedMovie = new Movie(movie.getNo(), movie.getTitle(), movie.getYear(), movie.getGenre(), movie.getOrigin(), movie.getDirector(), movie.getStar(), "link");
                System.out.println(selectedMovie);
                return selectedMovie;
            }
        }
        return null;
    }

    public static boolean titleComparator(ArrayList<Movie> movieList, Movie selectedMovie, String movie) {
        for (Movie movies : movieList) {
            if (movie.equalsIgnoreCase(movies.title)) {
                if (movies.title.equalsIgnoreCase(selectedMovie.title)) return true;
            }
        }
        return false;
    }

    public static boolean yearComparator(ArrayList<Movie> movieList, Movie selectedMovie, String movie) {
        for (Movie movies : movieList) {
            if (movie.equalsIgnoreCase(movies.title)) {
                if (movies.year.equals(selectedMovie.year)) return true;
            }
        }
        return false;
    }

    public static boolean genreComparator(ArrayList<Movie> movieList, Movie selectedMovie, String movie) {
        for (Movie movies : movieList) {
            if (movie.equalsIgnoreCase(movies.title)) {
                if (movies.genre.equals(selectedMovie.genre)) return true;
            }
        }
        return false;
    }

    public static boolean originComparator(ArrayList<Movie> movieList, Movie selectedMovie, String movie) {
        for (Movie movies : movieList) {
            if (movie.equalsIgnoreCase(movies.title)) {
                if (movies.origin.equals(selectedMovie.origin)) return true;
            }
        }
        return false;
    }

    public static boolean directorComparator(ArrayList<Movie> movieList, Movie selectedMovie, String movie) {
        for (Movie movies : movieList) {
            if (movie.equalsIgnoreCase(movies.title)) {
                if (movies.director.equals(selectedMovie.director)) return true;
            }
        }
        return false;
    }

    public static boolean starComparator(ArrayList<Movie> movieList, Movie selectedMovie, String movie) {
        for (Movie movies : movieList) {
            if (movie.equalsIgnoreCase(movies.title)) {
                if (movies.star.equals(selectedMovie.star)) return true;
            }
        }
        return false;
    }

    public static String getLabelYear(ArrayList<Movie> movieList, String movie) {
        for (Movie movies : movieList) {
            if (movie.equalsIgnoreCase(movies.title))
                return movies.year;
        }
        return null;
    }

    public static String getLabelGenre(ArrayList<Movie> movieList, String movie) {
        for (Movie movies : movieList) {
            if (movie.equalsIgnoreCase(movies.title))
                return movies.genre;
        }
        return null;
    }

    public static String getLabelOrigin(ArrayList<Movie> movieList, String movie) {
        for (Movie movies : movieList) {
            if (movie.equalsIgnoreCase(movies.title))
                return movies.origin;
        }
        return null;
    }

    public static String getLabelDirector(ArrayList<Movie> movieList, String movie) {
        for (Movie movies : movieList) {
            if (movie.equalsIgnoreCase(movies.title))
                return movies.director;
        }
        return null;
    }

    public static String getLabelStar(ArrayList<Movie> movieList, String movie) {
        for (Movie movies : movieList) {
            if (movie.equalsIgnoreCase(movies.title))
                return movies.star;
        }
        return null;
    }

    @Override
    public String toString() {
        return no + " " + title + " " + year + " " + genre + " " + origin + " " + director + " " + star + " " + imdbLink;
    }
}
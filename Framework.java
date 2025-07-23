import java.util.ArrayList;
import java.util.Objects;

// Class representing a movie
class Movie {
    private String title;
    private int month;
    private int year;
    private int ratings;

    // Constructor to initialize Movie object
    public Movie(String title, int month, int year, int ratings) {
        this.title = title;
        this.month = month;
        this.year = year;
        this.ratings = ratings;
    }

    // Getter for ratings
    public int getRatings() {
        return ratings;
    }

    // Setter for ratings
    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    // Override toString() for easy printing
    @Override
    public String toString() {
        return title + " (" + month + "/" + year + ") - Rating: " + ratings;
    }

    // Override equals() and hashCode() to allow object comparison (for remove and indexOf)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return month == movie.month &&
               year == movie.year &&
               ratings == movie.ratings &&
               Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, month, year, ratings);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an ArrayList to store Movie objects
        ArrayList<Movie> movies = new ArrayList<>();

        // Print initial size of the list (should be 0)
        System.out.println("Initial movie count: " + movies.size());

        // Add movies to the list
        movies.add(new Movie("Movie 1", 10, 2024, 9));
        movies.add(new Movie("Movie 2", 11, 2025, 7));
        movies.add(new Movie("Movie 3", 12, 2027, 4));

        // Print all movies
        System.out.println("\nMovies after adding:");
        for (Movie temp : movies)
            System.out.println(temp);

        // Remove a movie (needs equals method to work correctly)
        movies.remove(new Movie("Movie 2", 11, 2025, 7));

        // Print after removal
        System.out.println("\nMovies after removing 'Movie 2':");
        for (Movie temp : movies)
            System.out.println(temp);

        // Replace the first movie with a new one.
        movies.set(0, new Movie("Zero", 1, 2000, 10));

        // Print after replacement
        System.out.println("\nMovies after replacing first movie with 'Zero':");
        for (Movie temp : movies)
            System.out.println(temp);

        // Increase ratings of all movies by 1.
        for (Movie temp : movies)
            temp.setRatings(temp.getRatings() + 1);

        // Find the index of a specific movie
        int index = movies.indexOf(new Movie("Movie 3", 12, 2027, 5)); // ratings was incremented
        System.out.println("\nIndex of 'Movie 3' after rating increment: " + index);
    }
}

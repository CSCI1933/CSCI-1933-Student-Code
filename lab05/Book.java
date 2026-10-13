// CSCI 1933 Lab 06

public class Book implements Comparable<Book> {
  private String title;
  private String author;
  private double rating;  // An average rating out of 5

  public Book(String title, String author, double rating) {
      this.title = title;
      this.author = author;
      this.rating = rating;
  }

  // Accessors
  public String getTitle() { return title; }
  public String getAuthor() { return author; }
  public double getRating() { return rating; }

  // Mutators
  public void setTitle(String newTitle) { title = newTitle; }
  public void setAuthor(String newAuthor) { author = newAuthor; }
  public void setRating(double newRating) { rating = newRating; }

  public String toString() {
      return title + ", " + author + ", " + rating;
  }

  /**
   * Author and title must be the same
   * Ratings must be very close, but not necessarily equivalent.
   *    QUESTION: Why is that?
   */
  public boolean equals(Book other) {
      boolean authorMatch = author.equals(other.getAuthor());
      boolean titleMatch = title.equals(other.getTitle());
      boolean ratingMatch = (Math.abs(rating - other.getRating()) < 0.0001);
      return authorMatch && titleMatch && ratingMatch;
  }

  // If not given something to compare by, compares by title.
  // NOTE: The natural ordering given by this function is inconsistent with equals
  public int compareTo(Book other) {
      return title.compareTo(other.getTitle());
  }

  /**
   * Compares two books based off of one of their attributes
   * 'A' compares by author (A->Z)
   * 'T' compares by title (A->Z)
   * 'R' compares by rating (high->low)
   *
   *  a.compareTo(b, 'T') is the same as a.compareTo(b)
   */
  public int compareTo(Book other, char compareBy) {
      int result;

      switch(compareBy) {
          case 'a':
          case 'A':
              result = author.compareTo(other.getAuthor());
              break;
          case 't':
          case 'T':
              result = title.compareTo(other.getTitle());
              break;
          case 'r':
          case 'R':
              result = (int) (1000 * (other.getRating() - rating));
              break;
          default:
              result = 0;
              break;
      }

      return result;
  }
}
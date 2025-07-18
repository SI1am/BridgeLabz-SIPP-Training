package ScenarioBased.LibraryOrganiser;

public class Book {
    String genre;
    String title;
    String author;
    int copies;

    public Book(String genre, String title, String author) {
        this.genre = genre;
        this.title = title;
        this.author = author;
        this.copies = 1;
    }

    public void increaseCopy() {
        this.copies++;
    }

    public boolean decreaseCopy() {
        if (copies > 0) {
            copies--;
            return true;
        }
        return false;
    }

    public int getCopies() {
        return copies;
    }

    @Override
    public String toString() {
        return "[" + genre + "] \"" + title + "\" by " + author + " (Copies: " + copies + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        Book other = (Book) obj;
        return this.title.equalsIgnoreCase(other.title) &&
               this.author.equalsIgnoreCase(other.author) &&
               this.genre.equalsIgnoreCase(other.genre);
    }

    @Override
    public int hashCode() {
        return title.toLowerCase().hashCode() +
               author.toLowerCase().hashCode() +
               genre.toLowerCase().hashCode();
    }
}

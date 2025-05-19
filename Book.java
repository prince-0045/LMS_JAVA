public class Book {
     String title;
     String author;
     String isbn;
  boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    @Override
    public String toString() {
        return title + "," + author + "," + isbn + "," + isAvailable;  
    }

    public static Book fromString(String bookString) {
        String[] parts = bookString.split(",");
        if (parts.length < 4) {  
            throw new IllegalArgumentException("Invalid book data: " + bookString);
        }
        Book book = new Book(parts[0], parts[1], parts[2]);
        book.setAvailable(Boolean.parseBoolean(parts[3]));
        return book;
    }
}

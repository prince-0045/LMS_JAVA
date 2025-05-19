
import java.util.*;

public class Library {
    public List<Book> books = new ArrayList<>();
    public static final String CSV_FILE = "library.csv";

    public Library() { 
        loadBooks();
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    public boolean removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
        saveBooks();
        return true;
        
    }

    public Book searchByIsbn(String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().orElse(null);
    }

    public List<Book> listBooks() {
        return new ArrayList<>(books);
    }

    public boolean borrowBook(String isbn) {
        Book book = searchByIsbn(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            saveBooks();
        }
        return true;
      
    }

    public boolean returnBook(String isbn) {
        Book book = searchByIsbn(isbn);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            saveBooks();
        }
        return true;
    }

    public void loadBooks() {
        books = CSVUtility.readBooksFromCSV(CSV_FILE);  
    }

    public  void saveBooks() {
        CSVUtility.writeBooksToCSV(CSV_FILE, books);  
    }
}

     
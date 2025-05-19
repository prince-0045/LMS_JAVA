import java.util.*;

public class Lms{
   public static Library library = new Library();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book by ISBN");
            System.out.println("4. List Books");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    borrowBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        library.addBook(new Book(title, author, isbn));
        System.out.println("Book added.");
    }

    private static void removeBook() {
        System.out.print("Enter book ISBN to remove: ");
        String isbn = scanner.nextLine();
        library.removeBook(isbn);
        System.out.println("Book removed.");
    }

    private static void searchBook() {
        System.out.print("Enter book ISBN to search: ");
        String isbn = scanner.nextLine();
        Book book = library.searchByIsbn(isbn);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void listBooks() {
        List<Book> books = library.listBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void borrowBook() {
        System.out.print("Enter book ISBN to borrow: ");
        String isbn = scanner.nextLine();
        library.borrowBook(isbn);
        System.out.println("Book borrowed.");
    }

    private static void returnBook() {
        System.out.print("Enter book ISBN to return: ");
        String isbn = scanner.nextLine();
        library.returnBook(isbn);
        System.out.println("Book returned.");
    }
}


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LMSAWT extends Frame {
    CardLayout cardLayout = new CardLayout();
    Library library = new Library();  

    Panel mainPanel = new Panel(cardLayout);

    Panel homePanel = new ImagePanel("lmsjava.jpeg");
    Panel addBookPanel = new ImagePanel("1.jpeg");
    Panel deleteBookPanel = new ImagePanel("1.jpeg");
    Panel borrowBookPanel = new ImagePanel("1.jpeg");
    Panel returnBookPanel = new ImagePanel("1.jpeg");

    Label feedbackLabel = new Label("", Label.CENTER); 

    public LMSAWT() {
        super("Library Management System");

        setSize(600, 400);
        setLayout(new BorderLayout());

        Panel navPanel = new Panel(new FlowLayout());
        navPanel.setBackground(new Color(52, 73, 94));

        Button homeButton = new Button("Home");
        Button addButton = new Button("Add Book");
        Button deleteButton = new Button("Delete Book");
        Button borrowButton = new Button("Borrow Book");
        Button returnButton = new Button("Return Book");

        navPanel.add(homeButton);
        navPanel.add(addButton);
        navPanel.add(deleteButton);
        navPanel.add(borrowButton);
        navPanel.add(returnButton);

        add(navPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(feedbackLabel, BorderLayout.SOUTH);

        setupHomePanel();
        setupAddBookPanel();
        setupDeleteBookPanel();
        setupBorrowBookPanel();
        setupReturnBookPanel();

        mainPanel.add(homePanel, "Home");
        mainPanel.add(addBookPanel, "AddBook");
        mainPanel.add(deleteBookPanel, "DeleteBook");
        mainPanel.add(borrowBookPanel, "BorrowBook");
        mainPanel.add(returnBookPanel, "ReturnBook");

        homeButton.addActionListener(e -> switchPanel("Home"));
        addButton.addActionListener(e -> switchPanel("AddBook"));
        deleteButton.addActionListener(e -> switchPanel("DeleteBook"));
        borrowButton.addActionListener(e -> switchPanel("BorrowBook"));
        returnButton.addActionListener(e -> switchPanel("ReturnBook"));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void switchPanel(String panelName) {
        feedbackLabel.setText("");  
        cardLayout.show(mainPanel, panelName);
    }

    public void setupHomePanel() {
        homePanel.setLayout(new BorderLayout());
    }

   public void setupAddBookPanel() {
        addBookPanel.setLayout(new GridBagLayout()); 
       
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);
        
        Label titleLabel = new Label("Title:");
        titleLabel.setFont(labelFont);
        TextField titleField = new TextField(20); 
        titleField.setFont(fieldFont);
        
        Label authorLabel = new Label("Author:");
        authorLabel.setFont(labelFont);
        TextField authorField = new TextField(20);
        authorField.setFont(fieldFont);
        
        Label idLabel = new Label("ID:");
        idLabel.setFont(labelFont);
        TextField idField = new TextField(20);
        idField.setFont(fieldFont);
        
        Button addBookButton = new Button("Add Book");
        addBookButton.setFont(new Font("Arial", Font.BOLD, 14));
        addBookButton.setBackground(new Color(247, 246, 245)); 
        addBookButton.setForeground(Color.BLACK);
        
        addBookButton.addActionListener(e -> {
            String title = titleField.getText();
            String author = authorField.getText();
            String id = idField.getText();
            if (!title.isEmpty() && !author.isEmpty() && !id.isEmpty()) {
                library.addBook(new Book(title, author, id));
                feedbackLabel.setText("Book added successfully!");
                clearFields(titleField, authorField, idField);
            } else {
                feedbackLabel.setText("All fields are required!");
            }
        });
        
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        addBookPanel.add(titleLabel, gbc);
        
        gbc.gridx = 1;
        addBookPanel.add(titleField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        addBookPanel.add(authorLabel, gbc);
        
        gbc.gridx = 1;
        addBookPanel.add(authorField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        addBookPanel.add(idLabel, gbc);
        
        gbc.gridx = 1;
        addBookPanel.add(idField, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        addBookPanel.add(addBookButton, gbc);       
    }
    
    public void setupDeleteBookPanel() {
        deleteBookPanel.setLayout(new FlowLayout());
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);

        TextField idField = new TextField(20);
        Button deleteButton = new Button("Delete Book");
        deleteButton.setFont(labelFont);

        deleteButton.addActionListener(e -> {
            String id = idField.getText();
            if (library.removeBook(id)) {
                feedbackLabel.setText("Book deleted successfully!");
                idField.setText("");
            } else {
                feedbackLabel.setText("Book not found!");
            }
        });
        Label l=new Label("Enter Book ID to Delete:");
        l.setFont(labelFont);
        deleteBookPanel.add(l);
        deleteBookPanel.add(idField);
        deleteBookPanel.add(deleteButton);
    }

    public void setupBorrowBookPanel() {
        borrowBookPanel.setLayout(new FlowLayout());
        Font labelFont = new Font("Arial", Font.BOLD, 14);

        TextField idField = new TextField(20);
        Button borrowButton = new Button("Borrow Book");
        borrowButton.setFont(labelFont);

        borrowButton.addActionListener(e -> {
            String id = idField.getText();
            if (library.borrowBook(id)) {
                feedbackLabel.setText("Book borrowed successfully!");
                idField.setText("");
            } else {
                feedbackLabel.setText("Book not available!");
            }
        });
            Label l1=new Label("Enter Book ID to Borrow:");
            l1.setFont(labelFont);
        borrowBookPanel.add(l1);
        borrowBookPanel.add(idField);
        borrowBookPanel.add(borrowButton);
    }

    public void setupReturnBookPanel() {
        returnBookPanel.setLayout(new FlowLayout());
        Font labelFont = new Font("Arial", Font.BOLD, 14);

        TextField idField = new TextField(20);
        Button returnButton = new Button("Return Book");
        returnButton.setFont(labelFont);

        returnButton.addActionListener(e -> {
            String id = idField.getText();
            if (library.returnBook(id)) {
                feedbackLabel.setText("Book returned successfully!");
                idField.setText("");
            } else {
                feedbackLabel.setText("Invalid book ID!");
            }
        });
            Label l2=new Label("Enter Book ID to Return:");
            l2.setFont(labelFont);
        returnBookPanel.add(l2);
        returnBookPanel.add(idField);
        returnBookPanel.add(returnButton);
    }

    public  void clearFields(TextField... fields) {
        for (TextField field : fields) {
            field.setText("");
        }
    }

    public static void main(String[] args) {
        new LMSAWT();
    }
}


class ImagePanel extends Panel {
    private Image backgroundImage;

    public ImagePanel(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            System.out.println("Background image not found.");
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    public static void main(String[] args) {
        new LMSAWT();
    }
    
}

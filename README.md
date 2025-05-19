# LMS_JAVA
# 📚 Java Library Management System (AWT-based)

This is a simple **Library Management System** built using **Java AWT**. It allows users to add, delete, borrow, and return books. Book records are stored in a CSV file for persistence. The GUI is designed using Java AWT components with intuitive navigation and basic styling.

## 🔧 Features

- Add new books with title, author, and ID.
- Borrow or return books with availability status update.
- Delete books from the library.
- Data is saved in `library.csv`.
- Minimal GUI using AWT and CardLayout.
- Utility class for CSV read/write.

## 🗂️ Project Structure

📁 Lms java  
├── 📄 LMSAWT.java         # GUI frontend using AWT  
├── 📄 Lms.java            # Entry point or base logic  
├── 📄 Library.java        # Core logic for library operations  
├── 📄 Book.java           # Book model class  
├── 📄 CSVUtility.java     # CSV file handling  
├── 📄 library.csv         # Data storage  
├── 🖼️ 1.jpeg, lmsjava.jpeg  # UI assets  
└── 📁 .vscode             # VS Code settings  

## ▶️ How to Run

1. **Requirements:**  
   - Java JDK 8 or later  
   - A code editor like VS Code or IntelliJ  

2. **Compile & Run:**

```bash
javac *.java  
java LMSAWT
```

## 📌 Notes

- All operations reflect in `library.csv` in real-time.
- Uses AWT components like `Frame`, `Panel`, `Label`, `Button`, etc.
- Clean navigation using `CardLayout`.


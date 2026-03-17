
import java.util.Scanner;

import dao.AuthorDAO;
import dao.BookDAO;
import dao.CategoryDAO;
import dao.TransactionDAO;
import dao.UserDAO;

import java.sql.Date;
import java.sql.SQLException;


public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        BookDAO bookDAO = new BookDAO();
        AuthorDAO authorDAO = new AuthorDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        UserDAO userDAO = new UserDAO();
        TransactionDAO transactionDAO = new TransactionDAO();

        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Author");
            System.out.println("2. Add Category");
            System.out.println("3. Add Book");
            System.out.println("4. View Books");
            System.out.println("5. Add User");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addAuthor(authorDAO);
                    break;

                case 2:
                    addCategory(categoryDAO);
                    break;

                case 3:
                    addBook(bookDAO);
                    break;

                case 4:
                    bookDAO.getAllBooks();
                    break;

                case 5:
                    addUser(userDAO);
                    break;

                case 6:
                    issueBook(transactionDAO);
                    break;

                case 7:
                    returnBook(transactionDAO);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);
    }

    // ================= FUNCTIONS =================

    private static void addAuthor(AuthorDAO authorDAO) {
        sc.nextLine();
        System.out.print("Enter author name: ");
        String name = sc.nextLine();

        System.out.print("Enter bio: ");
        String bio = sc.nextLine();

        authorDAO.addAuthor(name, bio);
    }

    private static void addCategory(CategoryDAO categoryDAO) {
        sc.nextLine();
        System.out.print("Enter category name: ");
        String name = sc.nextLine();

        categoryDAO.addCategory(name);
    }

    private static void addBook(BookDAO bookDAO) {
        sc.nextLine();
        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter author ID: ");
        int authorId = sc.nextInt();

        System.out.print("Enter category ID: ");
        int categoryId = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Enter publication year: ");
        int year = sc.nextInt();

        System.out.print("Enter copies: ");
        int copies = sc.nextInt();

        bookDAO.addBook(title, authorId, categoryId, isbn, year, copies);
    }

    private static void addUser(UserDAO userDAO) {
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter max books allowed: ");
        int maxBooks = sc.nextInt();

        Date membershipDate = new Date(System.currentTimeMillis());

        userDAO.addUser(name, email, membershipDate, maxBooks);
    }

    private static void issueBook(TransactionDAO transactionDAO) throws SQLException {
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        Date issueDate = new Date(System.currentTimeMillis());

        // Due date = 7 days later
        long millis = System.currentTimeMillis() + (7L * 24 * 60 * 60 * 1000);
        Date dueDate = new Date(millis);

        transactionDAO.issueBook(bookId, userId, issueDate, dueDate);
    }

    private static void returnBook(TransactionDAO transactionDAO) {
        System.out.print("Enter Transaction ID: ");
        int transactionId = sc.nextInt();

        Date returnDate = new Date(System.currentTimeMillis());

        transactionDAO.returnBook(transactionId, returnDate);
    }
}
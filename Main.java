import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final BookManager bookManager = new BookManager(initialBooks());

    public static void main(String[] args) { //statyczna instancja BookManager i inicjalizuje listą początkowych książek zwróconych 
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[1] Add book");
            System.out.println("[2] Remove book");
            System.out.println("[3] Update book");
            System.out.println("[4] List books");
            System.out.println("[5] Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  //odczyt danych wejściowych

            switch (option) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    removeBook(scanner);
                    break;
                case 3:
                    updateBook(scanner);
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static List<Book> initialBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Silent Patient", "Alex Michaelides", "978-1250301697", 2019));
        books.add(new Book("Where the Crawdads Sing", "Delia Owens", "978-0735219106", 2018));
        books.add(new Book("The Midnight Library", "Matt Haig", "978-0525559474", 2020));
        books.add(new Book("The Vanishing Half", "Brit Bennett", "978-0525536291", 2020));
        books.add(new Book("Project Hail Mary", "Andy Weir", "978-0593135204", 2021));
        return books;
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        bookManager.addBook(new Book(title, author, isbn, year));
    }

    private static void removeBook(Scanner scanner) {
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = scanner.nextLine();
        bookManager.removeBook(isbn);
    }

    private static void updateBook(Scanner scanner) {
        System.out.print("Enter ISBN of the book to update: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new author: ");
        String author = scanner.nextLine();
        System.out.print("Enter new ISBN: ");
        String newIsbn = scanner.nextLine();
        System.out.print("Enter new year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        bookManager.updateBook(isbn, new Book(title, author, newIsbn, year));
    }

    private static void listBooks() {
        List<Book> books = bookManager.getBooks();
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            books.forEach(System.out::println);
        }
    }
}

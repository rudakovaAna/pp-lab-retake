import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookManager implements BookOperations {
    private List<Book> books;

    public BookManager(List<Book> books) { //konstruktor
        this.books = books;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override //metoda do usuwania książki z listy na podstawie ISBN
    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    @Override
    public void updateBook(String isbn, Book newBook) {
        Optional<Book> optionalBook = books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst();
        if (optionalBook.isPresent()) {
            Book bookToUpdate = optionalBook.get();
            bookToUpdate.setTitle(newBook.getTitle());
            bookToUpdate.setAuthor(newBook.getAuthor());
            bookToUpdate.setIsbn(newBook.getIsbn());
            bookToUpdate.setYear(newBook.getYear());
        }
    }

    @Override
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
}

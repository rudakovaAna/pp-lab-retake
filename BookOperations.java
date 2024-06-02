import java.util.List;

public interface BookOperations {
    void addBook(Book book);
    void removeBook(String isbn);
    void updateBook(String isbn, Book newBook); //metoda przyjmuje dwa argumenty: ISBN książki, która ma być zaktualizowana oraz nowe informacje o książce
    List<Book> getBooks();
}
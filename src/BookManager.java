import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;


public class BookManager {
    private List<Book> books;
    private Set<String> uniquePublishers;


    public BookManager() {
        this.books = new ArrayList<>();
        this.uniquePublishers = new LinkedHashSet<>();
        loadBooks();
        loadUniquePublishers();
    }
    private void loadBooks(){
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "J. B. Lippincott & Co.", 7.99, 1960));
        books.add(new Book("1984", "George Orwell", "Secker and Warburg", 8.99, 1949));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons", 10.00, 1925));
        books.add(new Book("One Hundred Years of Solitude", "Gabriel Garcia Marquez", "Harper & Row", 12.99, 1967));
        books.add(new Book("A Passage to India", "E.M. Forster", "Edward Arnold", 9.99, 1924));
        books.add(new Book("Invisible Man", "Ralph Ellison", "Random House", 14.99, 1952));
        books.add(new Book("Don Quixote", "Miguel de Cervantes", "Francisco de Robles", 11.90, 1615));
        books.add(new Book("Beloved", "Toni Morrison", "Alfred Knopf", 9.99, 1987));
        books.add(new Book("Mrs. Dalloway", "Virginia Woolf", "Hogarth Press", 7.99, 1925));
        books.add(new Book("Ulysses", "James Joyce", "Sylvia Beach", 13.99, 1922));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", 12.99, 1951));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "George Allen & Unwin", 6.99, 1937));
        books.add(new Book("The Brothers Karamazov", "Fyodor Dostoevsky", "The Russian Messenger", 15.00, 1880));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "T. Egerton, Whitehall", 9.00, 1813));
        books.add(new Book("Wuthering Heights", "Emily Brontë", "Thomas Cautley Newby", 8.99, 1847));
        books.add(new Book("Catch-22", "Joseph Heller", "Simon & Schuster", 12.99, 1961));
        books.add(new Book("The Odyssey", "Homer", "Ancient Greece", 10.99, -800));
        books.add(new Book("War and Peace", "Leo Tolstoy", "The Russian Messenger", 13.99, 1869));
        books.add(new Book("Moby Dick", "Herman Melville", "Harper & Brothers", 11.99, 1851));
        books.add(new Book("The Divine Comedy", "Dante Alighieri", "Niccolò di Lorenzo", 15.99, 1320));
        books.add(new Book("The Adventures of Huckleberry Finn", "Mark Twain", "Chatto & Windus", 9.99, 1884));
        books.add(new Book("Jane Eyre", "Charlotte Brontë", "Smith, Elder & Co.", 8.50, 1847));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoevsky", "The Russian Messenger", 7.99, 1866));
        books.add(new Book("The Sun Also Rises", "Ernest Hemingway", "Charles Scribner's Sons", 12.99, 1926));
        books.add(new Book("The Iliad", "Homer", "Ancient Greece", 10.99, -850));
        books.add(new Book("Heart of Darkness", "Joseph Conrad", "Blackwood's Magazine", 6.99, 1899));
        books.add(new Book("Gulliver's Travels", "Jonathan Swift", "Benjamin Motte", 8.99, 1726));
        books.add(new Book("Frankenstein", "Mary Shelley", "Lackington, Hughes, Harding, Mavor & Jones", 7.50, 1818));
        books.add(new Book("Anna Karenina", "Leo Tolstoy", "The Russian Messenger", 13.99, 1877));
        books.add(new Book("A Tale of Two Cities", "Charles Dickens", "Chapman & Hall", 9.50, 1859));
        books.add(new Book("The Picture of Dorian Gray", "Oscar Wilde", "Ward, Lock, and Company", 8.99, 1890));
    }
    private void loadUniquePublishers() {
        uniquePublishers.clear();
        books.forEach(book -> uniquePublishers.add(book.getPublisher()));
    }
    public List<Book> getBooks() {
        return books;
    }
    public Set<String> getUniquePublishers() {
        return uniquePublishers;
    }
    public List<Book> searchBooks(String title, String author, String publisher, double minPrice, double maxPrice, int publicationYear) {
        return books.stream()
                .filter(book -> title.isEmpty() || book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .filter(book -> author.isEmpty() || book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .filter(book -> publisher.isEmpty() || book.getPublisher().toLowerCase().contains(publisher.toLowerCase()))
                .filter(book -> minPrice == 0 || book.getPrice() >= minPrice)
                .filter(book -> maxPrice == 0 || book.getPrice() <= maxPrice)
                .filter(book -> publicationYear == 0 || book.getPublicationYear() == publicationYear)
                .collect(Collectors.toList());
    }
}

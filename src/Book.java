public class Book {
    private String title;
    private String author;
    private String publisher;
    private double price;
    private int publicationYear;

    public Book(String title, String author, String publisher, double price, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.publicationYear = publicationYear;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }
    public double getPrice() {
        return price;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    @Override
    public String toString() {
        return title + " by " + author + " (" + publicationYear + ")";
    }
}

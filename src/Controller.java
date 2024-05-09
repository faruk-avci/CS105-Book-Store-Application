import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    private BookManager manager;
    private MainPanel panel;
    private List<Book> currentBooks;


    public Controller(MainPanel panel, BookManager manager) {
        this.panel = panel;
        this.manager = manager;
        currentBooks = new ArrayList<>();
        attachEventHandlers();
        SetPublisherComboBox();
    }
    private void SetPublisherComboBox(){
        for (String publisher : manager.getUniquePublishers()) {
            panel.getPublisherCB().addItem(publisher);
        }
    }
    private void attachEventHandlers(){
        panel.getAllB().addActionListener(e -> handleAll());
        panel.getSearchB().addActionListener(e -> handleSearch());
        panel.getClearB().addActionListener(e -> handleClear());
        panel.getOrderByCB().addActionListener(e -> handleOrderBy());
    }
    private void handleAll(){
        clearFrame();
        currentBooks = manager.getBooks();
        panel.getOrderByCB().setSelectedIndex(0);
        System.out.println("All books: ");
        for (Book book : currentBooks) {
            System.out.println(book);
        }
        List<Book> sortedBooks = currentBooks.stream().sorted((b1, b2) -> b1.getTitle().compareTo(b2.getTitle())).collect(Collectors.toList());
        viewTable((ArrayList<Book>) sortedBooks);
    }
    private void viewTable(ArrayList<Book> books){
        DefaultTableModel model = (DefaultTableModel) panel.getTable().getModel();
        model.setRowCount(0); // Clear existing data
        for (Book book : books) {
            Object[] row = new Object[] {
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPublisher(),
                    book.getPrice(),
                    book.getPublicationYear()
            };
            model.addRow(row);
        }
        panel.getFoundBooksL().setText("Books Found: " + books.size());
           panel.getFoundBooksL().setVisible(true);
    }
    private void handleSearch(){
        currentBooks = new ArrayList<>();
        String title = panel.getTitleTF().getText();
        String author = panel.getAuthorTF().getText();
        String publisher = (String) panel.getPublisherCB().getSelectedItem();
        String priceMinStr = panel.getPriceMinTF().getText();
        String priceMaxStr = panel.getPriceMaxTF().getText();
        String publicationYearStr = panel.getPublicationYearTF().getText();

        double priceMin = priceMinStr.isEmpty() ? 0 : Double.parseDouble(priceMinStr);
        double priceMax = priceMaxStr.isEmpty() ? Double.MAX_VALUE : Double.parseDouble(priceMaxStr);
        int publicationYear = publicationYearStr.isEmpty() ? 0 : Integer.parseInt(publicationYearStr);

        if (title.isEmpty() && author.isEmpty() && publisher.isEmpty() && priceMin == 0 && priceMax == Double.MAX_VALUE && publicationYear == 0) {
            JOptionPane.showMessageDialog(panel, "Please enter search criteria", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        currentBooks = manager.searchBooks(title, author, publisher, priceMin, priceMax, publicationYear);
        viewTable(new ArrayList<>(currentBooks));
    }
    private void handleClear(){
        DefaultTableModel model = (DefaultTableModel) panel.getTable().getModel();
        clearFrame();
        currentBooks = new ArrayList<>();
        model.setRowCount(0);

        panel.getFoundBooksL().setText("");  // Clear the label text
        panel.getFoundBooksL().setVisible(false);  // Make the label invisible

    }
    private void handleOrderBy() {
        String selectedOrder = (String) panel.getOrderByCB().getSelectedItem();
        switch (selectedOrder) {
            case "Title: A to Z":
                currentBooks.sort(Comparator.comparing(Book::getTitle));
                break;
            case "Title: Z to A":
                currentBooks.sort(Comparator.comparing(Book::getTitle).reversed());
                break;
            case "Price: Low to High":
                currentBooks.sort(Comparator.comparingDouble(Book::getPrice));
                break;
            case "Price: High to Low":
                currentBooks.sort(Comparator.comparingDouble(Book::getPrice).reversed());
                break;
            default:
                return;  // No sorting if unknown sort type
        }

        viewTable(new ArrayList<>(currentBooks));  // Update view
    }

    private void clearFrame(){
        panel.getTitleTF().setText("");
        panel.getAuthorTF().setText("");
        panel.getPriceMinTF().setText("");
        panel.getPriceMaxTF().setText("");
        panel.getPublicationYearTF().setText("");
        panel.getPublisherCB().setSelectedIndex(0);
        panel.getOrderByCB().setSelectedIndex(0);
    }
}

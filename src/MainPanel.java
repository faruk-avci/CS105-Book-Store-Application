import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainPanel extends JFrame {

    JButton allB, searchB, clearB;
    JLabel titleL, authorL, publisherL, priceL, publicationYearL, orderByL, foundBooksL;
    JTextField titleTF, authorTF, priceMinTF, priceMaxTF, publicationYearTF;
    JComboBox<String> publisherCB, orderByCB;

    JTable table;
    JScrollPane scrollPane;
    public MainPanel(){
        CreateComponents();
        setUpLayout();
        initializeTable();
        addAllItems();
    }

    private void CreateComponents(){
        allB = new JButton("All");
        searchB = new JButton("Search");
        clearB = new JButton("Clear");

        titleL = new JLabel("Title: ");
        authorL = new JLabel("Author: ");
        publisherL = new JLabel("Publisher: ");
        priceL = new JLabel("Price: ");
        publicationYearL = new JLabel("Year: ");
        orderByL = new JLabel("Order By: ");

        titleTF = new JTextField(20);
        authorTF = new JTextField(20);
        priceMinTF = new JTextField(5);
        priceMaxTF = new JTextField(5);
        publicationYearTF = new JTextField(5);

        publisherCB = new JComboBox<>();
        publisherCB.addItem("");
        orderByCB = new JComboBox<>();

        orderByCB.addItem("Title: A to Z");
        orderByCB.addItem("Title: Z to A");
        orderByCB.addItem("Price: Low to High");
        orderByCB.addItem("Price: High to Low");

        foundBooksL = new JLabel("");
    }
    private void setUpLayout(){
        setLayout(null);

        titleL.setBounds(40, 20, 80, 25);
        titleTF.setBounds(130, 20, 200, 25);
        authorL.setBounds(40, 50, 80, 25);
        authorTF.setBounds(130, 50, 200, 25);
        publisherL.setBounds(40, 80, 80, 25);
        publisherCB.setBounds(130, 80, 200, 25);
        priceL.setBounds(40, 110, 80, 25);
        priceMinTF.setBounds(130, 110, 60, 25);
        priceMaxTF.setBounds(200, 110, 60, 25);
        publicationYearL.setBounds(40, 140, 80, 25);
        publicationYearTF.setBounds(130, 140, 200, 25);
        orderByL.setBounds(40, 170, 80, 25);
        orderByCB.setBounds(130, 170, 200, 25);
        allB.setBounds(40, 200, 80, 25);
        searchB.setBounds(130, 200, 80, 25);
        clearB.setBounds(220, 200, 80, 25);

        foundBooksL.setBounds(10, 230, 480, 20);  // Set bounds (adjust as needed)

        addAllItems();


    }
    private void addAllItems(){
        add(allB);
        add(searchB);
        add(clearB);
        add(titleL);
        add(authorL);
        add(publisherL);
        add(priceL);
        add(publicationYearL);
        add(orderByL);
        add(titleTF);
        add(authorTF);
        add(priceMinTF);
        add(priceMaxTF);
        add(publicationYearTF);
        add(publisherCB);
        add(orderByCB);
        add(foundBooksL);
    }
    private void initializeTable() {
        // Column Names for the Table
        String[] columnNames = {"Title", "Author", "Publisher", "Price", "Year"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0); // 0 rows initially
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 250, 480, 200); // You may need to adjust the size and layout
        add(scrollPane);
    }
    public void setFrameProperties() {
        setTitle("Book Store Application");
        setSize(515, 500);
        setResizable(false);
        setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Getters for buttons
    public JButton getAllB() {
        return allB;
    }
    public JButton getSearchB() {
        return searchB;
    }
    public JButton getClearB() {
        return clearB;
    }

    // Getters  for text fields
    public JTextField getTitleTF() {
        return titleTF;
    }
    public JTextField getAuthorTF() {
        return authorTF;
    }
    public JTextField getPriceMinTF() {
        return priceMinTF;
    }
    public JTextField getPriceMaxTF() {
        return priceMaxTF;
    }
    public JTextField getPublicationYearTF() {
        return publicationYearTF;
    }

    // Getters for combo boxes
    public JComboBox<String> getPublisherCB() {
        return publisherCB;
    }
    public JComboBox<String> getOrderByCB() {
        return orderByCB;
    }

    // Getters for table
    public JTable getTable() {
        return table;
    }

    // Getter for foundBooksL
    public JLabel getFoundBooksL() {
        return foundBooksL;
    }

}

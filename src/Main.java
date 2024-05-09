public class Main
{
    public static void main(String[] args)
    {
        MainPanel panel = new MainPanel();
        panel.setFrameProperties();
        BookManager manager = new BookManager();
        Controller controller = new Controller(panel, manager);
    }
}

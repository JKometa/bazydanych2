import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: servlok
 * Date: 17.06.13
 * Time: 01:49
 * To change this template use File | Settings | File Templates.
 */
public class MainMenu extends JFrame {
    private  JMenuBar menuBar;

    void createMenuComponents() {
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Ewidencja " +
               "urządzeń");
        JMenuItem menuItem = new JMenuItem("Dodanie");
        menu.add(menuItem);
        menuItem = new JMenuItem("Usunięcie");
        menu.add(menuItem);
        menuItem = new JMenuItem("Wyszukiwanie");
        menu.add(menuItem);
        menuItem = new JMenuItem("Zmiana parametrów");
        menu.add(menuItem);
        menuBar.add(menu);

        menu = new JMenu("Zgłoszenia " +
                "napraw");
        menuItem = new JMenuItem("Dodanie");
        menu.add(menuItem);
        menuItem = new JMenuItem("Usunięcie");
        menu.add(menuItem);
        menuItem = new JMenuItem("Przydzielenie zespołu serwisowego");
        menu.add(menuItem);
        menuItem = new JMenuItem("Wyszukanie informacji o gwarancji");
        menu.add(menuItem);
        menuBar.add(menu);

        menu = new JMenu("Typy " +
                "urządzeń");
        menuItem = new JMenuItem("Dodanie");
        menu.add(menuItem);
        menuItem = new JMenuItem("Usunięcie");
        menu.add(menuItem);
        menuItem = new JMenuItem("Zmiana parametrów");
        menu.add(menuItem);
        menuBar.add(menu);

        menu = new JMenu("Zespoły " +
                "serwisowe");
        menuItem = new JMenuItem("Dodanie");
        menu.add(menuItem);
        menuItem = new JMenuItem("Usunięcie");
        menu.add(menuItem);
        menuItem = new JMenuItem("Przydzielenie pracownika");
        menu.add(menuItem);
        menuItem = new JMenuItem("Usunięcie pracownika");
        menu.add(menuItem);
        menuBar.add(menu);

        menu = new JMenu("Lokalizacja");
        menuItem = new JMenuItem("Zmiana lokalizacji");
        menu.add(menuItem);
        menuItem = new JMenuItem("Wyszukanie urządzenia");
        menu.add(menuItem);
        menuBar.add(menu);
    }

    public MainMenu() {
        createMenuComponents();
        this.setJMenuBar(menuBar);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}

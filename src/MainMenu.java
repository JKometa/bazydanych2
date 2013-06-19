import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: servlok
 * Date: 17.06.13
 * Time: 01:49
 * To change this template use File | Settings | File Templates.
 */
public class MainMenu extends JFrame implements ActionListener {
    private  JMenuBar menuBar;
    private  JMenuItem menuItem2;
    private  JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;

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
        menuItem2 = new JMenuItem("Dodanie");
        menu.add(menuItem2);
        menuItem3 = new JMenuItem("Usunięcie");
        menu.add(menuItem3);
        menuItem4 = new JMenuItem("Przydzielenie zespołu serwisowego");
        menu.add(menuItem4);
        menuItem5 = new JMenuItem("Wyszukanie informacji o gwarancji");
        menu.add(menuItem5);
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

        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);
        menuItem5.addActionListener(this);
    }

    public MainMenu() {
        createMenuComponents();
        this.setJMenuBar(menuBar);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == menuItem2) {
            AddNotification menu = new AddNotification();

            menu.setVisible(true);
            this.dispose();
        }
        if (source == menuItem3) {
            EraseList menu = new EraseList();

            menu.setVisible(true);
            this.dispose();
        }
        if (source == menuItem4) {
            AttachTeam menu = new AttachTeam();

            menu.setVisible(true);
            this.dispose();
        }
        if (source == menuItem5) {
            ShowWarant menu = new ShowWarant();

            menu.setVisible(true);
            this.dispose();
        }
        return;
    }
}

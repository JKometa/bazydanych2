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
        menuItem2 = new JMenuItem("Dodanie");
        menu.add(menuItem2);
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
    }

    public MainMenu() {
        createMenuComponents();
        this.setJMenuBar(menuBar);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == menuItem2) {
            AddTeam menu = new AddTeam();
            menu.setVisible(true);
            this.dispose();
        }
        return;
    }
}

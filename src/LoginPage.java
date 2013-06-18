import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: servlok
 * Date: 16.06.13
 * Time: 23:40
 * To change this template use File | Settings | File Templates.
 */
public class LoginPage extends JFrame implements ActionListener {
    private JLabel helloLabel;
    private JPanel loginPanel;
    private JTextField loginText;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JButton exitButton;
    private JPasswordField passwordText;

    private void createUIComponents() {
        loginButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    public LoginPage() {
        this.createUIComponents();
        this.add(loginPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setSize(600,400);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == loginButton) {
           MainMenu menu = new MainMenu();
           menu.setVisible(true);
           this.dispose();
        }
        if (source == exitButton) {
            System.exit(0);
        }
        return;
    }

}

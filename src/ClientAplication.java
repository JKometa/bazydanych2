/**
 * Created with IntelliJ IDEA.
 * User: servlok
 * Date: 17.06.13
 * Time: 00:15
 * To change this template use File | Settings | File Templates.
 */
public class ClientAplication {
    static MainMenu mainMenu = new MainMenu();

    public static void main(final String[] args) {
       mainMenu.setVisible(false);
       LoginPage loginFrame = new LoginPage();
       loginFrame.setVisible(true);
       return;

    }
}

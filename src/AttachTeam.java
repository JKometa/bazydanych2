import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
/*
 * Created by JFormDesigner on Tue Jun 18 11:45:07 CEST 2013
 */



/**
 * @author mdz mdz
 */
public class AttachTeam extends JFrame {

    private DataAccessObject dao = new DataAccessObject();

    public AttachTeam() {
        fillZgloszeniaLista();
        fillZespolLista();
        initComponents();
    }

    private void fillZgloszeniaLista() {
        DataAccessObject.connect(null,null);
        //TODO zmiana idika admina
        notifications = dao.getNotifications(1);
        for(DataAccessObject.Notification n: notifications) {
            listaZgloszenia.addElement("Id zgloszenia: "+n.id+" Id urzadzenie: "+n.device);
        }
        DataAccessObject.disconnect();

    }

    private void fillZespolLista() {
        DataAccessObject.connect(null,null);
        teams = dao.getTeams();
        for (DataAccessObject.Team t: teams) {
            listaZespoly.addElement("Id zepsolu: "+t.id+" Nazwa: "+t.name);
        }
        DataAccessObject.disconnect();
    }

    private void zatwierdzActionPerformed(ActionEvent e) {

        int attachIndex = zespoly.getSelectedIndex();
        int zgloszenieIndex = zgloszenia.getSelectedIndex();


        this.changeTeamNotifiaction(teams.get(attachIndex),notifications.get(zgloszenieIndex));

        ClientAplication.mainMenu.setVisible(true);
        this.dispose();


    }

    private void changeTeamNotifiaction(DataAccessObject.Team team, DataAccessObject.Notification notification) {
        DataAccessObject.connect(null,null);

        dao.changeTeamNotification(notification.id,team.id);

        DataAccessObject.disconnect();
    }

    private void cofnijActionPerformed(ActionEvent e) {
        ClientAplication.mainMenu.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mdz mdz
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        zgloszenia = new JList();
        scrollPane2 = new JScrollPane();
        zespoly = new JList();
        cofnij = new JButton();
        zatwierdz = new JButton();

        //======== this ========
        setTitle("Przydzielenie zespo\u0142u serwisowego");
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {71, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 257, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0, 1.0E-4};

        //---- label1 ----
        label1.setText("Lista zg\u0142osze\u0144:");
        contentPane.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- label2 ----
        label2.setText("Lista zespo\u0142\u00f3w:");
        contentPane.add(label2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(zgloszenia);
        }
        contentPane.add(scrollPane1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(zespoly);
        }
        contentPane.add(scrollPane2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- cofnij ----
        cofnij.setText("Cofnij");
        cofnij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cofnijActionPerformed(e);
            }
        });
        contentPane.add(cofnij, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- zatwierdz ----
        zatwierdz.setText("zatwierdz");
        zatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zatwierdzActionPerformed(e);
            }
        });
        contentPane.add(zatwierdz, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        zgloszenia.setModel(listaZgloszenia);
        zespoly.setModel(listaZespoly);
        for(int i = 0; i <= zgloszeniaLista.size()-1; ++i){
            listaZgloszenia.addElement(zgloszeniaLista.get(i));

        }
        for(int i = 0; i <= zespolyLista.size()-1; ++i){
            listaZespoly.addElement(zespolyLista.get(i));

        }

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mdz mdz
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JList zgloszenia;
    private JScrollPane scrollPane2;
    private JList zespoly;
    private JButton cofnij;
    private JButton zatwierdz;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    DefaultListModel listaZgloszenia = new DefaultListModel();
    DefaultListModel listaZespoly = new DefaultListModel();
    private ArrayList<String> zgloszeniaLista = new ArrayList<String>();
    private ArrayList<String> zespolyLista = new ArrayList<String>();

    private LinkedList<DataAccessObject.Notification> notifications;
    private LinkedList<DataAccessObject.Team> teams;

}

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
/*
 * Created by JFormDesigner on Mon Jun 17 21:41:34 CEST 2013
 */



/**
 * @author mdz mdz
 */
public class EraseList extends JFrame {
    DataAccessObject dao = new DataAccessObject();
    String[] sortOptions = {"id", "nazwa", "status"};

    public EraseList() {

        fillNotificationList();
        initComponents();
    }

    private void fillNotificationList() {
        DataAccessObject.connect(null,null);
        notifications = dao.getNotifications(LoginPage.userData.id);
        for(DataAccessObject.Notification n : notifications) {
            listaZgloszen.add("Id zgloszenia: "+n.id+" Id urzadzenie: "+n.device);
        }
        DataAccessObject.disconnect();
    }

    private void zgloszeniaValueChanged(ListSelectionEvent e) {
        // TODO add your code here
        int index = zgloszenia.getSelectedIndex();

        DataAccessObject.connect(null,null);
        DataAccessObject.Notification notification = notifications.get(index);
        DataAccessObject.disconnect();
        if(notification.id == 0) {
            szczegolyZgloszenia.setText("Brak zdefiniowanych szczegółów dla zgłoszenia");
            return;
        }
        szczegolyZgloszenia.setText("Id zgłoszenia: "+notification.id+"\n"+
                "Urządzenie: "+notification.device+"\n"+
                "Opis: "+notification.opis+"\n"
                 );




    }

    private void deleteNotification(DataAccessObject.Notification notification) {
        DataAccessObject.connect(null,null);
        dao.deleteNotifications(notification.id);
        DataAccessObject.disconnect();
    }

    private void usunActionPerformed(ActionEvent e) {
        Object index = zgloszenia.getSelectedValue();
        int listIndex = zgloszenia.getSelectedIndex();
        lista.removeElement(index);
        listaZgloszen.remove(index);
        deleteNotification(notifications.get(listIndex));
    }

    private void zakonczActionPerformed(ActionEvent e) {
        LoginPage.mainMenu.setVisible(true);
        this.dispose();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mdz mdz
        label1 = new JLabel();
        label2 = new JLabel();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        zgloszenia = new JList();
        scrollPane2 = new JScrollPane();
        szczegolyZgloszenia = new JTextArea();
        usun = new JButton();
        zakoncz = new JButton();

        //======== this ========
        setTitle("Usuwanie zg\u0142oszenia");
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {150, 190, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0, 0.0, 0.0, 1.0E-4};

        //---- label1 ----
        label1.setText("Lista zg\u0142osze\u0144:");
        contentPane.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- label2 ----
        label2.setText("Sczeg\u00f3\u0142y zg\u0142oszenia:");
        contentPane.add(label2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new GridLayout());
        }
        contentPane.add(panel1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //======== scrollPane1 ========
        {

            //---- zgloszenia ----
            zgloszenia.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    zgloszeniaValueChanged(e);
                }
            });
            scrollPane1.setViewportView(zgloszenia);
        }
        contentPane.add(scrollPane1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(szczegolyZgloszenia);
        }
        contentPane.add(scrollPane2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- usun ----
        usun.setText("Usun");
        usun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usunActionPerformed(e);
            }
        });
        contentPane.add(usun, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- zakoncz ----
        zakoncz.setText("Zakoncz");
        zakoncz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zakonczActionPerformed(e);
            }
        });
        contentPane.add(zakoncz, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        zgloszenia.setModel(lista);

        for(int i = 0; i <= listaZgloszen.size()-1; ++i){
            lista.addElement(listaZgloszen.get(i));

        }
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mdz mdz
    private JLabel label1;
    private JLabel label2;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JList zgloszenia;
    private JScrollPane scrollPane2;
    private JTextArea szczegolyZgloszenia;
    private JButton usun;
    private JButton zakoncz;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private ArrayList<String> listaZgloszen = new ArrayList<String>();
    DefaultListModel lista = new DefaultListModel();

    private LinkedList<DataAccessObject.Notification> notifications;

}

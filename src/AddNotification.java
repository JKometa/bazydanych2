import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
/*
 * Created by JFormDesigner on Tue Jun 18 22:16:54 CEST 2013
 */



/**
 * @author mdz mdz
 */
public class AddNotification extends JFrame {

    DataAccessObject dao = new DataAccessObject();

    public AddNotification() {
        initComponents();
    }

    private void cofnijActionPerformed(ActionEvent e) {
        LoginPage.mainMenu.setVisible(true);
        this.dispose();
    }

    private void addNotification() {
        DataAccessObject.connect(null,null);
        dao.addNotification(Integer.parseInt(idSprzet.getText()),1,"NOWE",opis.getText());
        DataAccessObject.disconnect();
    }

    private void zatwierdzActionPerformed(ActionEvent e) {
        if(!idSprzet.getText().equals("") ){
            // TODO DODAJ MNIE TUTAJ NOWE ZGLOSZENIE  A POTEM ODKOMENTUJ   TO CO TAM JEST ZAKOMENTOWANE
             addNotification();

            //opis.getText()   DA CI STRINGA OPISU
            //Integer.parseInt(idSprzet.getText())   DA CI ID SPRZETU
            //STATUS ZAWSZE BEDZIE USTAWIONE NA NOWE.


        //            ClientAplication.mainMenu.setVisible(true);
        //  this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,
                    "Proszę wypełnić wszystkie pola!",
                    "Błąd danych",
                    JOptionPane.WARNING_MESSAGE);
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Andrzej Kolanowski
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        opis = new JTextArea();
        label2 = new JLabel();
        idSprzet = new JTextField();
        label3 = new JLabel();
        status = new JComboBox();
        label5 = new JLabel();
        cofnij = new JButton();
        zatwierdz = new JButton();

        //======== this ========
        setTitle("Dodanie zg\u0142oszenia");
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {166, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {31, 97, 0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label1 ----
        label1.setText("Wprowad\u017a dane zg\u0142oszenia:");
        contentPane.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //======== scrollPane1 ========
        {

            //---- opis ----
            opis.setToolTipText("Wype\u0142nij opis");
            opis.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
            opis.setMaximumSize(new Dimension(300, 200));
            opis.setLineWrap(true);
            opis.setWrapStyleWord(true);
            scrollPane1.setViewportView(opis);
        }
        contentPane.add(scrollPane1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label2 ----
        label2.setText("Opis ");
        contentPane.add(label2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- idSprzet ----
        idSprzet.setToolTipText("Podaj ID");
        contentPane.add(idSprzet, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label3 ----
        label3.setText("Id sprz\u0119tu");
        contentPane.add(label3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));
        contentPane.add(status, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label5 ----
        label5.setText("Status");
        contentPane.add(label5, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- cofnij ----
        cofnij.setText("Cofnij");
        cofnij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cofnijActionPerformed(e);
            }
        });
        contentPane.add(cofnij, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- zatwierdz ----
        zatwierdz.setText("Zatwierd\u017a");
        zatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zatwierdzActionPerformed(e);
            }
        });
        contentPane.add(zatwierdz, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        status.addItem("Nowe");
        status.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    int selected = status.getSelectedIndex();
                }
            }
        });
        filter1.setNegativeAccepted(true);
        filter2.setNegativeAccepted(true);
        idSprzet.setDocument(filter2);


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Andrzej Kolanowski
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTextArea opis;
    private JLabel label2;
    private JTextField idSprzet;
    private JLabel label3;
    private JComboBox status;
    private JLabel label5;
    private JButton cofnij;
    private JButton zatwierdz;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JTextFieldFilter filter1 = new JTextFieldFilter(JTextFieldFilter.NUMERIC);
    JTextFieldFilter filter2 = new JTextFieldFilter(JTextFieldFilter.NUMERIC);

}

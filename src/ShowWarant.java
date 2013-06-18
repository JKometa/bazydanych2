

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
    /*
     * Created by JFormDesigner on Tue Jun 18 18:06:17 PDT 2013
     */



/**
 * @author Andrzej Kolanowski
 */
public class ShowWarant extends JFrame {

    private DataAccessObject dao = new DataAccessObject();

    public ShowWarant() {
        fillDevices();
        initComponents();
    }

    private void fillDevices() {
        DataAccessObject.connect(null,null);
        devices = dao.getDevices();
        for(DataAccessObject.Device d: devices) {
            listaUrzadzenia.addElement("Id: "+d.id+" Typ: "+d.type);
        }
        DataAccessObject.disconnect();
    }

    private void button1ActionPerformed(ActionEvent e) {
        LoginPage.mainMenu.setVisible(true);
        this.dispose();
    }

    private void list1ValueChanged(ListSelectionEvent e) {
        int index = list1.getSelectedIndex();

        DataAccessObject.connect(null,null);
        DataAccessObject.Warranty warranty = dao.getWarranty(devices.get(index).id);
        DataAccessObject.disconnect();
        if(warranty.id == 0) {
            textArea1.setText("Brak zdefiniowanej gwarancji dla urządzenia");
            return;
        }
        textArea1.setText("Id gwarancji: "+warranty.id+"\n"+
                "Nazwa: "+warranty.warrantyName+"\n"+
                "Ulica: "+warranty.street+"\n"+
                "Miasto: "+warranty.city+"\n"+
                "Rozpoczecie gwarancji: "+warranty.begin+"\n"+
                "Zakonczenie gwarancji: "+warranty.end+"\n"+
                "Numer gwarancji: "+warranty.nr);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mdz mdz
        label4 = new JLabel();
        label5 = new JLabel();
        hSpacer1 = new JPanel(null);
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        textArea1 = new JTextArea();
        button1 = new JButton();

        //======== this ========
        setTitle("Wy\u015bwietlanie informacji o gwarancji");
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {150, 150, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 187, 27, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label4 ----
        label4.setText("Lista urz\u0105dze\u0144:  ");
        contentPane.add(label4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label5 ----
        label5.setText("Opis gwarancji:  ");
        contentPane.add(label5, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 5, 0), 0, 0));
        contentPane.add(hSpacer1, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== panel2 ========
        {

            // JFormDesigner evaluation mark
            panel2.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel2.getBorder())); panel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel2.setLayout(new GridLayout(1, 2));

            //======== scrollPane1 ========
            {
                scrollPane1.setMaximumSize(new Dimension(100, 150));

                //---- list1 ----
                list1.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        list1ValueChanged(e);
                    }
                });
                scrollPane1.setViewportView(list1);
            }
            panel2.add(scrollPane1);
            panel2.add(textArea1);
        }
        contentPane.add(panel2, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- button1 ----
        button1.setText("Cofnij");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        contentPane.add(button1, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        list1.setModel(listaUrzadzenia);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mdz mdz
    private JLabel label4;
    private JLabel label5;
    private JPanel hSpacer1;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JList list1;
    private JTextArea textArea1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private DefaultListModel listaUrzadzenia = new DefaultListModel();

    private LinkedList<DataAccessObject.Device> devices;

}



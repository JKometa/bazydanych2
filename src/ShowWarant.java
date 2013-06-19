import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.event.*;
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
        ClientAplication.mainMenu.setVisible(true);
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
        // Generated using JFormDesigner Evaluation license - Andrzej Kolanowski
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        textArea1 = new JTextArea();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {198, 183, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {237, 27, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    list1ValueChanged(e);
                }
            });
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textArea1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
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
        contentPane.add(button1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        list1.setModel(listaUrzadzenia);

        this.setSize(600,400);
        this.add(scrollPane1);
        this.add(textArea1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Andrzej Kolanowski
    private JScrollPane scrollPane1;
    private JList list1;
    private JTextArea textArea1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private DefaultListModel listaUrzadzenia = new DefaultListModel();

    private LinkedList<DataAccessObject.Device> devices;

}



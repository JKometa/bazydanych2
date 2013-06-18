import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/*
 * Created by JFormDesigner on Mon Jun 17 21:41:34 CEST 2013
 */



/**
 * @author mdz mdz
 */
public class EraseList extends JFrame {
    public EraseList() {

        listaZgloszen.add("Pierwsze");
        listaZgloszen.add("Drugie");
        listaZgloszen.add("Trzecie");
        listaZgloszen.add("Czwarte");
        listaZgloszen.add("Piate");
        initComponents();
    }

    private void zgloszeniaValueChanged(ListSelectionEvent e) {
        // TODO add your code here


    }

    private void usunActionPerformed(ActionEvent e) {
        Object index = zgloszenia.getSelectedValue();
        lista.removeElement(index);
        listaZgloszen.remove(index);
    }

    private void zakonczActionPerformed(ActionEvent e) {
        ClientAplication.mainMenu.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mdz mdz
        scrollPane1 = new JScrollPane();
        zgloszenia = new JList();
        usun = new JButton();
        zakoncz = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 0.0, 0.0, 1.0E-4};

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
        contentPane.add(scrollPane1, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0,
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
        contentPane.add(usun, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0,
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
        contentPane.add(zakoncz, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        zgloszenia.setModel(lista);

        for(int i = 0; i <= listaZgloszen.size()-1; ++i){
            lista.addElement(listaZgloszen.get(i));

        }
        this.setSize(600,400);
        this.add(scrollPane1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mdz mdz
    private JScrollPane scrollPane1;
    private JList zgloszenia;
    private JButton usun;
    private JButton zakoncz;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private ArrayList<String> listaZgloszen = new ArrayList<String>();
    DefaultListModel lista = new DefaultListModel();
}

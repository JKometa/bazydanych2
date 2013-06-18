import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/*
 * Created by JFormDesigner on Tue Jun 18 11:45:07 CEST 2013
 */



/**
 * @author mdz mdz
 */
public class AttachTeam extends JFrame {
    public AttachTeam() {
        zgloszeniaLista.add("Pierwsze");
        zgloszeniaLista.add("Drugie");
        zgloszeniaLista.add("Trzecie");
        zgloszeniaLista.add("Czwarte");
        zgloszeniaLista.add("Piate");
        zespolyLista.add("Pierwsze");
        zespolyLista.add("Drugie");
        zespolyLista.add("Trzecie");
        zespolyLista.add("Czwarte");
        zespolyLista.add("Piate");
        initComponents();
    }

    private void zatwierdzActionPerformed(ActionEvent e) {

        Object attachTeam = zespoly.getSelectedValue();
        Object attachZgloszenie = zgloszenia.getSelectedValue();


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mdz mdz
        scrollPane1 = new JScrollPane();
        zgloszenia = new JList();
        scrollPane2 = new JScrollPane();
        zespoly = new JList();
        zatwierdz = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {71, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {257, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(zgloszenia);
        }
        contentPane.add(scrollPane1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(zespoly);
        }
        contentPane.add(scrollPane2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- zatwierdz ----
        zatwierdz.setText("zatwierdz");
        zatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zatwierdzActionPerformed(e);
            }
        });
        contentPane.add(zatwierdz, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
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
        this.setSize(600,400);
        this.add(scrollPane1);
        this.add(scrollPane2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mdz mdz
    private JScrollPane scrollPane1;
    private JList zgloszenia;
    private JScrollPane scrollPane2;
    private JList zespoly;
    private JButton zatwierdz;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    DefaultListModel listaZgloszenia = new DefaultListModel();
    DefaultListModel listaZespoly = new DefaultListModel();
    private ArrayList<String> zgloszeniaLista = new ArrayList<String>();
    private ArrayList<String> zespolyLista = new ArrayList<String>();
}

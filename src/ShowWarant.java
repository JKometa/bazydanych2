import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
/*
 * Created by JFormDesigner on Tue Jun 18 12:02:57 CEST 2013
 */



/**
 * @author mdz mdz
 */
public class ShowWarant extends JFrame {
    public ShowWarant() {
        urzadzeniaLista.add("Pierwsze");
        urzadzeniaLista.add("Drugie");
        urzadzeniaLista.add("Trzecie");
        urzadzeniaLista.add("Czwarte");
        urzadzeniaLista.add("Piate");
        initComponents();
    }

    private void urzadzeniaValueChanged(ListSelectionEvent e) {
        Object urzadzenie = urzadzenia.getSelectedValue();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mdz mdz
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        urzadzenia = new JList();
        panel2 = new JPanel();
        gwarant = new JTextArea();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new CardLayout());

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

            //======== scrollPane1 ========
            {

                //---- urzadzenia ----
                urzadzenia.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        urzadzeniaValueChanged(e);
                    }
                });
                scrollPane1.setViewportView(urzadzenia);
            }
            panel1.add(scrollPane1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel1, "card1");

        //======== panel2 ========
        {
            panel2.setLayout(new GridBagLayout());
            ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};
            panel2.add(gwarant, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel2, "card2");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        urzadzenia.setModel(listaUrzadzenia);
        for(int i = 0; i <= urzadzeniaLista.size()-1; ++i){
            listaUrzadzenia.addElement(urzadzeniaLista.get(i));

        }
        this.setSize(600,400);
        this.add(panel2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mdz mdz
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JList urzadzenia;
    private JPanel panel2;
    private JTextArea gwarant;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    DefaultListModel listaUrzadzenia = new DefaultListModel();
    private ArrayList<String> urzadzeniaLista = new ArrayList<String>();
}

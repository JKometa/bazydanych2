import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * Created by JFormDesigner on Mon Jun 17 17:23:38 CEST 2013
 */



/**
 * @author unknown
 */
public class AddTeam extends JFrame{
    public AddTeam() {
        initComponents();
    }

    private void nextActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(opis.getText() != null){
            //Rob costam

        }
        else{
            //wypelnij pole tektowe bo nie pojde dalej :(
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mdz mdz
        dodawanie = new JPanel();
        panel1 = new JPanel();
        opis = new JTextField();
        next = new JButton();
        panel2 = new JPanel();
        dodaj2 = new JTextField();
        next2 = new JButton();

        //======== dodawanie ========
        {

            // JFormDesigner evaluation mark
            dodawanie.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dodawanie.getBorder())); dodawanie.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dodawanie.setLayout(new CardLayout());

            //======== panel1 ========
            {
                panel1.setBackground(new Color(204, 204, 204));
                panel1.setLayout(new GridBagLayout());
                ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {160, 66, 0};
                ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 75, 0, 0};
                ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
                panel1.add(opis, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- next ----
                next.setText("next");
                next.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nextActionPerformed(e);
                    }
                });
                panel1.add(next, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dodawanie.add(panel1, "card1");

            //======== panel2 ========
            {
                panel2.setLayout(new GridBagLayout());
                ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {140, 96, 0};
                ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 69, 0, 0};
                ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
                panel2.add(dodaj2, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- next2 ----
                next2.setText("next");
                panel2.add(next2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dodawanie.add(panel2, "card2");
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mdz mdz
    private JPanel dodawanie;
    private JPanel panel1;
    private JTextField opis;
    private JButton next;
    private JPanel panel2;
    private JTextField dodaj2;
    private JButton next2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

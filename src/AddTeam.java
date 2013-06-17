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
        if(idSprzetu.getText() != null && idAdministratora.getText() != null && idLokalizacji.getText() != null && NazwaGwaranta.getText() != null){
            //Rob costam
            zgloszenie = new Zgloszenie(-1, Integer.parseInt(idSprzetu.getText()), Integer.parseInt(idLokalizacji.getText()), Integer.parseInt(idAdministratora.getText()), NazwaGwaranta.getText());
            panel2.setVisible(true);
            panel1.setVisible(false);
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
        Wprowadz = new JLabel();
        idSprzetu = new JTextField();
        label1 = new JLabel();
        idLokalizacji = new JTextField();
        label2 = new JLabel();
        idAdministratora = new JTextField();
        label3 = new JLabel();
        NazwaGwaranta = new JTextField();
        label4 = new JLabel();
        next = new JButton();
        panel2 = new JPanel();
        Wprowadz2 = new JLabel();
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
                ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {142, 66, 0};
                ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 38, 0, 0, 0, 0, 0};
                ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- Wprowadz ----
                Wprowadz.setText("Wrowadz dane Zgloszenia");
                panel1.add(Wprowadz, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                panel1.add(idSprzetu, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label1 ----
                label1.setText("Id Sprzetu");
                panel1.add(label1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));
                panel1.add(idLokalizacji, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label2 ----
                label2.setText("IdLokalizacji");
                panel1.add(label2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));
                panel1.add(idAdministratora, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label3 ----
                label3.setText("IdAdministratora");
                panel1.add(label3, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));
                panel1.add(NazwaGwaranta, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label4 ----
                label4.setText("Nazwa gwaranta");
                panel1.add(label4, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- next ----
                next.setText("next");
                next.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nextActionPerformed(e);
                    }
                });
                panel1.add(next, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dodawanie.add(panel1, "card1");

            //======== panel2 ========
            {
                panel2.setLayout(new GridBagLayout());
                ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {140, 96, 0};
                ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 69, 0, 0, 0, 0, 0};
                ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- Wprowadz2 ----
                Wprowadz2.setText("Wprowadz cos");
                panel2.add(Wprowadz2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                panel2.add(dodaj2, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- next2 ----
                next2.setText("next");
                panel2.add(next2, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dodawanie.add(panel2, "card2");
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setSize(600,400);
        this.add(dodawanie);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mdz mdz
    private JPanel dodawanie;
    private JPanel panel1;
    private JLabel Wprowadz;
    private JTextField idSprzetu;
    private JLabel label1;
    private JTextField idLokalizacji;
    private JLabel label2;
    private JTextField idAdministratora;
    private JLabel label3;
    private JTextField NazwaGwaranta;
    private JLabel label4;
    private JButton next;
    private JPanel panel2;
    private JLabel Wprowadz2;
    private JTextField dodaj2;
    private JButton next2;
    public Zgloszenie zgloszenie;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

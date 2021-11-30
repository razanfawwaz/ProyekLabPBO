import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Makanan{
    private JPanel panel;
    private JTable makananTable;
    private JTable minumanTable;
    private JButton showRecommendationButton;
    private JCheckBox manisCheckBox;
    private JCheckBox asinCheckBox;
    private JCheckBox pahitCheckBox;
    private JCheckBox pedasCheckBox;
    private JCheckBox asamCheckBox;
    private JCheckBox gurihCheckBox;
    private JTextPane textUang;
    private JComboBox cmbYesOrNo;
    private JButton backButton;
    private JTextPane txtCountry;
    private static JFrame frame;

    Object [][] listMinuman;
    public Makanan() {
        Object [][] listMakanan = {
                {"Spaghetti", "10.000", "Non-vegetarian" , "manis, asam, pedas, sehat", "Italia"},
                {"Nasi Goreng", "15.000", "Non-vegetarian" , "asin, asam, gurih, sehat", "Indonesia"},
                {"Roti Daging", "5.000", "Non-vegetarian" , "manis, asam, cepat saji", "China"},
                {"Ayam Penyet", "18.000", "Non-vegetarian" , "asin,  pedas, cepat saji", "Indonesia"},
                {"Burger", "30.000", "Non-vegetarian" , "asin, cepat saji", "Amerika"},
                {"Salad Buah", "25.000", "Vegetarian" , "asam, sehat", "Amerika"},
        };

        makananTable.setModel(new DefaultTableModel(
                listMakanan, new String[]{"Makanan", "Harga", "Tipe", "Tag", "Asal"}
        ));
        backButton.addActionListener(actionEvent -> {
            new Main().main(null);
            this.frame.setVisible(false);
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Rekomendasi Makanan");
        frame.setContentPane(new Makanan().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}

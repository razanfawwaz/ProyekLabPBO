import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Minuman {
    private JPanel panel;
    private JTable minumanTable;
    private JButton showRecommendationButton;
    private JCheckBox manisCheckBox;
    private JCheckBox asinCheckBox;
    private JCheckBox pahitCheckBox;
    private JCheckBox asamCheckBox;
    private JTextPane textUang;
    private JComboBox cmbSuhu;
    private JRadioButton kecilRadioButton;
    private JRadioButton sedangRadioButton;
    private JRadioButton besarRadioButton;
    private JTextPane txtCountry;
    private JButton backButton;

    Object [][] listMinuman;
    Object [][] listMakanan;
    public Minuman() {
        Object [][] listMinuman = {
                {"Ocha", "10.000", "M", "Dingin", "Non-kafein", "Pahit", "Jepang"},
                {"Esteh", "5.000", "M", "Dingin", "Non-kafein", "Manis", "Jepang"},
                {"Iced Coffee Latte", "60.000", "L", "Dingin", "Kafein", "pahit, manis", "Amerika"},
                {"Thaitea", "30.000", "M", "Dingin", "Non-kafein", "Manis", "Thailand"},
                {"Teh Tarik", "20.000", "L", "Dingin", "Non-kafein", "Manis", "Indonesia"},
        };

        minumanTable.setModel(new DefaultTableModel(
                listMinuman, new String[]{"Minuman", "Harga", "Ukuran", "Jenis", "Kategori", "Tag", "Asal"}
        ));
        backButton.addActionListener(actionEvent -> {
//            new Show();
            new Main().main(null);
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rekomendasi Minuman");
        frame.setContentPane(new Minuman().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

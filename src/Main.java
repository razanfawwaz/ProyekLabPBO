import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JPanel panel;
    private JTable makananTable;
    private JTable minumanTable;
    private JButton minumanButton;
    private JButton makananButton;

    Object [][] listMakanan;
    Object [][] listMinuman;
    public Main() {
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
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pemesanan");
        frame.setContentPane(new Main().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

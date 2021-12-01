import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import Method.DaftarMenu;
import Method.Makanan_Method;

public class Makanan{
    private JPanel panel;
    private JTable makananTable;
    private JButton showRecommendationButton;
    private JCheckBox manisCheckBox;
    private JCheckBox asinCheckBox;
    private JCheckBox pahitCheckBox;
    private JCheckBox pedasCheckBox;
    private JCheckBox asamCheckBox;
    private JCheckBox gurihCheckBox;
    private JComboBox cmbYesOrNo;
    private JButton backButton;
    private JComboBox cmbHealthy;
    private JTextField txtCountry;
    private JTextField txtUang;
    private static JFrame frame;
    static DaftarMenu menu = new DaftarMenu();
    static ArrayList<Makanan_Method> rekom = new ArrayList<>();

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
        cmbHealthy.addActionListener(actionEvent -> {
            String junkF,healtyF;
            junkF = String.valueOf(cmbHealthy.getSelectedItem());
            if (junkF.equalsIgnoreCase("Cepat Saji")){
                if (rekom.isEmpty()){
                    addMenuMakan();
                }
                int loop = rekom.size();
                int i = 0;
                while (i < loop){
                    if (rekom.get(i).getHealty()){
                        rekom.remove(i);
                        loop = rekom.size();
                        i = 0;
                    }else {i++;}
                }
            }
            healtyF = String.valueOf(cmbHealthy.getSelectedItem());
            if (healtyF.equalsIgnoreCase("Sehat")){
                if(rekom.isEmpty()) {
                    addMenuMakan();
                }
                int loop = rekom.size();
                int i = 0;
                while(i <= loop) {
                    if(rekom.get(i).getHealty()) {
                        i++;
                    } else {
                        rekom.remove(i);
                        loop = rekom.size();
                        i = 0;
                    }
                }
            }

        });
        showRecommendationButton.addActionListener(actionEvent -> {
            Show out = new Show();
            String pembuka = "Berikut makanan yang kami rekomendasikan: \n";
            int jlh = rekom.size();
            if (jlh == 1) {
                out.setTeks(pembuka +
                        rekom.get(0).getNama());
            } else if (jlh == 2) {
                out.setTeks(pembuka +
                        rekom.get(0).getNama() + "\n" +
                        rekom.get(1).getNama());
            } else if (jlh == 3) {
                out.setTeks(pembuka +
                        rekom.get(0).getNama() + "\n" +
                        rekom.get(1).getNama() + "\n" +
                        rekom.get(2).getNama());
            } else if (jlh == 4) {
                out.setTeks(pembuka +
                        rekom.get(0).getNama() + "\n" +
                        rekom.get(1).getNama() + "\n" +
                        rekom.get(2).getNama() + "\n" +
                        rekom.get(3).getNama());
            } else {
                out.setTeks("Maaf tidak ada rekomendasi yang sesuai dengan budget atau selera anda :(");
            }
//            out.main(null);
            frame.setVisible(false);
        });
        cmbYesOrNo.addActionListener(actionEvent ->{
            String vegetarian;
            vegetarian = String.valueOf(cmbYesOrNo.getSelectedItem());
            if (vegetarian.equalsIgnoreCase("Ya")){
                if(rekom.isEmpty()) {
                    addMenuMakan();
                }
                int loop = rekom.size();
                int i = 0;
                while(i <= loop) {
                    if(rekom.get(i).getVegan()) {
                        i++;
                    } else {
                        rekom.remove(i);
                        loop = rekom.size();
                        i = 0;
                    }

                }
            }
            else if (vegetarian.equalsIgnoreCase("Tidak")){
                if(rekom.isEmpty()) {
                    addMenuMakan();
                }
                int loop = rekom.size();
                int i = 0;
                while(i <= loop) {
                    if(rekom.get(i).getVegan()) {
                        rekom.remove(i);
                        loop = rekom.size();
                        i = 0;
                    } else {
                        i++;
                    }
                }
            }
        });
        manisCheckBox.addActionListener(actionEvent ->{
            if (manisCheckBox.isSelected()){
                rekom.add(menu.getSpaghetti());
                rekom.add(menu.getRotiDaging());
            }
        });
        asamCheckBox.addActionListener(actionEvent ->{
            if (asamCheckBox.isSelected()){
                rekom.add(menu.getSpaghetti());
                rekom.add(menu.getNasGor());
                rekom.add(menu.getRotiDaging());
                rekom.add(menu.getSaladBuah());
            }
        });
        asinCheckBox.addActionListener(actionEvent ->{
            if (asinCheckBox.isSelected()){
                rekom.add(menu.getSpaghetti());
                rekom.add(menu.getAyamPenyet());
                rekom.add(menu.getBurger());
            }
        });
        pedasCheckBox.addActionListener(actionEvent ->{
            if (pedasCheckBox.isSelected()){
                rekom.add(menu.getSpaghetti());
                rekom.add(menu.getAyamPenyet());
            }
        });
        gurihCheckBox.addActionListener(actionEvent ->{
            if (gurihCheckBox.isSelected()){
                rekom.add(menu.getNasGor());
            }
        });
        txtUang.addActionListener(actionEvent ->{
            if(rekom.isEmpty()) {
                addMenuMakan();
            }

            int money = Integer.parseInt(txtUang.getText());
            int loop = rekom.size();
            int i = 0;
            while(i <= loop) {
                if(money < rekom.get(i).getHarga()) {
                    rekom.remove(i);
                    loop = rekom.size();
                    i = 0;
                } else {
                    i++;
                }
            }
        });
        txtCountry.addActionListener(actionEvent ->{
            if(rekom.isEmpty()) {
                addMenuMakan();
            }

            if (txtCountry.getText().equalsIgnoreCase("China")) {
                int loop = rekom.size();
                int i = 0;
                while(i <= loop) {
                    if(rekom.get(i).getNegara().equalsIgnoreCase("China")) {
                        i++;
                    } else {
                        rekom.remove(i);
                        loop = rekom.size();
                        i = 0;
                    }
                }
            } else if (txtCountry.getText().equalsIgnoreCase("Indonesia")) {
                int loop = rekom.size();
                int i = 0;
                while(i <= loop) {
                    if(rekom.get(i).getNegara().equalsIgnoreCase("Indonesia")) {
                        i++;
                    } else {
                        rekom.remove(i);
                        loop = rekom.size();
                        i = 0;
                    }
                }
            } else if (txtCountry.getText().equalsIgnoreCase("Italia")) {
                int loop = rekom.size();
                int i = 0;
                while(i <= loop) {
                    if(rekom.get(i).getNegara().equalsIgnoreCase("Italia")) {
                        i++;
                    } else {
                        rekom.remove(i);
                        loop = rekom.size();
                        i = 0;
                    }
                }
            } else if(txtCountry.getText().equalsIgnoreCase("Amerika")) {
                int loop = rekom.size();
                int i = 0;
                while(i <= loop) {
                    if(rekom.get(i).getNegara().equalsIgnoreCase("Amerika")) {
                        i++;
                    } else {
                        rekom.remove(i);
                        loop = rekom.size();
                        i = 0;
                    }
                }
            }
        });
    }

    private void addMenuMakan() {
        rekom.add(menu.getSpaghetti());
        rekom.add(menu.getNasGor());
        rekom.add(menu.getRotiDaging());
        rekom.add(menu.getAyamPenyet());
        rekom.add(menu.getBurger());
        rekom.add(menu.getSaladBuah());
    }

    public static void main(String[] args) {
        frame = new JFrame("Rekomendasi Makanan");
        frame.setContentPane(new Makanan().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
class Show {
    private JTextArea txtOutput;
    private JPanel jpanelmain;


    public Show() {
        createAndShowGui();
    }

    public void setTeks(String text) {
        txtOutput.setText(text);
    }

    void createAndShowGui(){

        JFrame frame=new JFrame("Hasil Rekomendasi");
        frame.setLocationRelativeTo(null);
        jpanelmain = new JPanel();
        txtOutput = new JTextArea();
        jpanelmain.add(txtOutput);
        frame.setContentPane(jpanelmain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}

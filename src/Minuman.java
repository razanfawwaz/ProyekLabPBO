import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import Method.DaftarMenu;
import Method.Minuman_Method;

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
    private static JFrame frame;
    static DaftarMenu menu = new DaftarMenu();
    static ArrayList<Minuman_Method> rekom = new ArrayList<>();

    Object [][] listMinuman;
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
            new Main().main(null);
            this.frame.setVisible(false);
        });
        showRecommendationButton.addActionListener(actionEvent -> {
            Show out = new Show();
            String pembuka = "Berikut minuman yang kami rekomendasikan: \n";
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
        pahitCheckBox.addActionListener(actionEvent ->{
            if (pahitCheckBox.isSelected()){
                rekom.add(menu.getOcha());
                rekom.add(menu.getIcedCoffeeLatte());
            }
        });
        manisCheckBox.addActionListener(actionEvent ->{
            if (manisCheckBox.isSelected()){
                rekom.add(menu.getEsteh());
                rekom.add(menu.getThaitea());
                rekom.add(menu.getTehTarik());
                rekom.add(menu.getIcedCoffeeLatte());
            }
        });
        txtUang.addActionListener(actionEvent ->{
            if(rekom.isEmpty()) {
                addMenuMinum();
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
                addMenuMinum();
            }

            if (txtCountry.getText().equalsIgnoreCase("Jepang")) {
                int loop = rekom.size();
                int i = 0;
                while(i <= loop) {
                    if(rekom.get(i).getNegara().equalsIgnoreCase("Jepang")) {
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
            } else if (txtCountry.getText().equalsIgnoreCase("Amerika")) {
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
            } else if(txtCountry.getText().equalsIgnoreCase("Thailand")) {
                int loop = rekom.size();
                int i = 0;
                while(i <= loop) {
                    if(rekom.get(i).getNegara().equalsIgnoreCase("Thailand")) {
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

    private void addMenuMinum() {
        rekom.add(menu.getOcha());
        rekom.add(menu.getEsteh());
        rekom.add(menu.getIcedCoffeeLatte());
        rekom.add(menu.getThaitea());
        rekom.add(menu.getTehTarik());
    }

    public static void main(String[] args) {
        frame = new JFrame("Rekomendasi Minuman");
        frame.setContentPane(new Minuman().panel);
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

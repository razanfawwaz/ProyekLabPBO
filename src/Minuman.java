import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Method.Menu;
import Method.Minuman_Method;

public class Minuman {
    private JPanel panel;
    private JTable minumanTable;
    private JButton showRecommendationButton;
    private JCheckBox manisCheckBox;
    private JCheckBox pahitCheckBox;
    private JTextField textUang;
    private JComboBox cmbSuhu;
    private JRadioButton kecilRadioButton;
    private JRadioButton sedangRadioButton;
    private JRadioButton besarRadioButton;
    private JTextField txtCountry;
    private JButton backButton;
    private static JFrame frame;
    static Menu menu = new Menu();
    static ArrayList<Minuman_Method> rekom = new ArrayList<>();

    public Minuman() {
        // dingin = true, panas = false
        Object [][] listMinuman = {
                {"Ocha", "10.000", "M", "Dingin", "Non-kafein", "Pahit", "Jepang"},
                {"Esteh", "5.000", "M", "Dingin", "Non-kafein", "Manis", "Jepang"},
                {"Iced Coffee Latte", "60.000", "L", "Dingin", "Kafein", "pahit, manis", "Amerika"},
                {"Thaitea", "30.000", "M", "Dingin", "Non-kafein", "Manis", "Thailand"},
                {"Teh Tarik", "20.000", "L", "Panas", "Non-kafein", "Manis", "Indonesia"},
        };

        minumanTable.setModel(new DefaultTableModel(
                listMinuman, new String[]{"Minuman", "Harga", "Ukuran", "Jenis", "Kategori", "Tag", "Asal"}
        ));
        backButton.addActionListener(actionEvent -> {
            new Main().main(null);
            this.frame.setVisible(false);
        });
        cmbSuhu.addActionListener(actionEvent ->{
            String cool,hot;
            cool = String.valueOf(cmbSuhu.getSelectedItem());
            if(cool.equalsIgnoreCase("Dingin")){
                if(rekom.isEmpty()){
                    addMenuMinum();
                }
                int loop = rekom.size();
                int i = 0;
                while (i < loop){
                    if (rekom.get(i).getSuhu()){
                        rekom.remove(i);
                        loop = rekom.size();
                        i = 0;
                    }
                    else{
                        i++;
                    }
                }
            }
            hot = String.valueOf(cmbSuhu.getSelectedItem());
            if(hot.equalsIgnoreCase("Panas")){
                if(rekom.isEmpty()){
                    addMenuMinum();
                }
                int loop = rekom.size();
                int i = 0;
                while (i < loop){
                    if (rekom.get(i).getSuhu()){
                        rekom.remove(i);
                        loop = rekom.size();
                        i = 0;
                    }
                    else{
                        i++;
                    }
                }
            }
        });
        showRecommendationButton.addActionListener(actionEvent -> {
            Show out = new Show();
            String pembuka = "Berikut Minuman yang kami rekomendasikan: \n";
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
                out.setTeks("Maaf tidak ada rekomendasi yang \n sesuai dengan budget atau selera anda :(");
            }
//            out.main(null);
            frame.setVisible(false);
        });
        pahitCheckBox.addActionListener(actionEvent ->{
            if (pahitCheckBox.isSelected()){
                rekom.add(menu.getOcha());
                rekom.add(menu.getIcedcoffeelatte());
            }
        });
        manisCheckBox.addActionListener(actionEvent ->{
            if (manisCheckBox.isSelected()){
                rekom.add(menu.getEsteh());
                rekom.add(menu.getThaitea());
                rekom.add(menu.getTehtarik());
                rekom.add(menu.getIcedcoffeelatte());
            }
        });

        kecilRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kecilRadioButton.isSelected()){
                    sedangRadioButton.setSelected(false);
                    besarRadioButton.setSelected(false);
                    rekom.add(menu.getEsteh());
                }
            }
        });

        sedangRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sedangRadioButton.isSelected()){
                    kecilRadioButton.setSelected(false);
                    besarRadioButton.setSelected(false);
                    rekom.add(menu.getOcha());
                    rekom.add(menu.getThaitea());
                }
            }
        });

        besarRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (besarRadioButton.isSelected()){
                    kecilRadioButton.setSelected(false);
                    sedangRadioButton.setSelected(false);
                    rekom.add(menu.getIcedcoffeelatte());
                    rekom.add(menu.getTehtarik());
                }
            }
        });



        textUang.addActionListener(actionEvent ->{
            if(rekom.isEmpty()) {
                addMenuMinum();
            }

            int money = Integer.parseInt(textUang.getText());
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
        rekom.add(menu.getIcedcoffeelatte());
        rekom.add(menu.getThaitea());
        rekom.add(menu.getTehtarik());
    }

    public static void main(String[] args) {
        frame = new JFrame("Rekomendasi Minuman");
        frame.setContentPane(new Minuman().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}



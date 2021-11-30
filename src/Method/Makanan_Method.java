package Method;

import java.util.ArrayList;

public class Makanan_Method {
    private final String nama;
    private final int harga;
    private final boolean vegan;
    private final boolean jenis;
    private final ArrayList<String> tag;
    private final String negara;

    /**
     *
     * @param nama Nama makanan
     * @param harga Harga makanan
     * @param vegan Vegan atau bukan
     * @param jenis healty atau bukan
     * @param tag Tag
     * @param negara Asal negara
     */
    public Makanan_Method(String nama, int harga, boolean vegan, boolean jenis, ArrayList<String> tag, String negara) {
        this.nama = nama;
        this.harga = harga;
        this.vegan = vegan;
        this.jenis = jenis;
        this.tag = tag;
        this.negara = negara;
    }

    public String getNama() {
        return this.nama;
    }

    public int getHarga() {
        return this.harga;
    }

    public boolean getVegan() {
        return this.vegan;
    }

    public boolean getHealty() {
        return this.jenis;
    }

    public String getTag(int index) {
        return this.tag.get(index);
    }

    public String getNegara() {
        return this.negara;
    }

}

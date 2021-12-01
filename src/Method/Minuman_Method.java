package Method;

import java.util.ArrayList;

public class Minuman_Method {
    private final String nama;
    private final int harga;
    private String ukuran;
    private final Boolean suhu;
    private boolean kategori;
    private final ArrayList<String> tag;
    private final String negara;

    /**
     *
     * @param nama Nama minuman
     * @param harga Harga minuman
     * @param tag Tag
     * @param negara Asal negara
     */
    public Minuman_Method(String nama, int harga, String ukuran, Boolean suhu, Boolean kategori, ArrayList<String> tag, String negara){

        this.nama = nama;
        this.harga = harga;
        this.ukuran = ukuran;
        this.suhu = suhu;
        this.kategori = kategori;
        this.tag = tag;
        this.negara = negara;

    }
    public String getNama() {
        return this.nama;
    }

    public int getHarga() {
        return this.harga;
    }

    public String setUkuran(){
        return this.ukuran;
    }

    public boolean setSuhu(){
        return this.suhu;
    }

    public boolean setKategori(){
        return this.kategori;
    }

    public String getUkuran(){
        return this.ukuran;
    }

    public boolean getSuhu(){
        return this.suhu;
    }

    public boolean getKategori(){
        return this.kategori;
    }

    public String getTag(int index) {
        return this.tag.get(index);
    }

    public String getNegara() {
        return this.negara;
    }
}

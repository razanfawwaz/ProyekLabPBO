package Method;

import java.util.ArrayList;

/**
 *
 * @author Kelompok 6
 */
public class DaftarMenu {
    
    private Makanan_Method spaghetti;
    private Makanan_Method nasiGoreng;
    private Makanan_Method rotiDaging;
    private Makanan_Method ayamPenyet;
    private Makanan_Method burger;
    private Makanan_Method saladBuah;
    private ArrayList<Makanan_Method> menuMakanan = new ArrayList<>();
    private ArrayList<String> tagSpaghetti = new ArrayList<>();
    private ArrayList<String> tagNasiGoreng = new ArrayList<>();
    private ArrayList<String> tagRotiDaging = new ArrayList<>();
    private ArrayList<String> tagAyamPenyet = new ArrayList<>();
    private ArrayList<String> tagBurger = new ArrayList<>();
    private ArrayList<String> tagSaladBuah = new ArrayList<>();

    public DaftarMenu() {
        
        tagSpaghetti.add("manis");
        tagSpaghetti.add("asam");
        tagSpaghetti.add("pedas");
        tagSpaghetti.add("sehat");
    
        spaghetti = new Makanan_Method("Spaghetti", 10000, false, true, tagSpaghetti, "Italia");
          
        tagNasiGoreng.add("asin");
        tagNasiGoreng.add("asam");
        tagNasiGoreng.add("gurih");
        tagNasiGoreng.add("sehat");

        nasiGoreng = new Makanan_Method("Nasi Goreng", 15000, false, true, tagNasiGoreng, "Indonesia");

        tagRotiDaging.add("manis");
        tagRotiDaging.add("asam");
        tagRotiDaging.add("cepat saji");

        rotiDaging = new Makanan_Method("Roti Daging", 5000, false, false, tagRotiDaging, "China");

        
        tagAyamPenyet.add("asin");
        tagAyamPenyet.add("pedas");
        tagAyamPenyet.add("cepat saji");


        ayamPenyet = new Makanan_Method("Ayam Penyet", 18000, false, false, tagAyamPenyet, "Indonesia");

        tagBurger.add("asin");
        tagBurger.add("cepat saji");


        burger = new Makanan_Method("Burger", 30000, false, false, tagBurger, "Amerika");

        tagSaladBuah.add("asam");
        tagSaladBuah.add("sehat");


        saladBuah = new Makanan_Method("Salad Buah", 25000, true, true, tagSaladBuah, "Amerika");

        menuMakanan.add(spaghetti);
        menuMakanan.add(nasiGoreng);
        menuMakanan.add(rotiDaging);
        menuMakanan.add(ayamPenyet);
        menuMakanan.add(burger);
        menuMakanan.add(saladBuah);

    }

    public int getJlhMakanan() {
        return this.menuMakanan.size();
    }

    public Makanan_Method getSpaghetti() {
        return this.spaghetti;
    }
    
    public Makanan_Method getNasGor() {
        return this.nasiGoreng;
    }

    public Makanan_Method getRotiDaging() {
        return this.rotiDaging;
    }

    public Makanan_Method getAyamPenyet() {
        return this.ayamPenyet;
    }

    public Makanan_Method getBurger() {
        return this.burger;
    }

    public Makanan_Method getSaladBuah() {
        return this.saladBuah;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Method;

import java.util.ArrayList;
/**
 *
 * @author Kelompok 6
 */
public class Menu {
    private Minuman_Method ocha;
    private Minuman_Method esteh;
    private Minuman_Method icedcoffeelatte;
    private Minuman_Method thaitea;
    private Minuman_Method tehtarik;
    private ArrayList<Minuman_Method> menuMinuman = new ArrayList<>();
    private ArrayList<String> tagOcha = new ArrayList<>();
    private ArrayList<String> tagEsteh = new ArrayList<>();
    private ArrayList<String> tagIcedCoffeeLatte = new ArrayList<>();
    private ArrayList<String> tagThaitea = new ArrayList<>();
    private ArrayList<String> tagTehTarik = new ArrayList<>();

    public Menu() {

        // dingin = true, panas = false

        tagOcha.add("pahit");

        ocha = new Minuman_Method("Ocha", 10000, "M", true, false,tagOcha, "Jepang");

        tagEsteh.add("manis");

        esteh = new Minuman_Method("Esteh", 5000, "S", true, false, tagEsteh, "Jepang");

        tagIcedCoffeeLatte.add("pahit");
        tagIcedCoffeeLatte.add("manis");

        icedcoffeelatte = new Minuman_Method("Iced Coffee Latte", 60000, "L", true, true, tagIcedCoffeeLatte, "Amerika");


        tagThaitea.add("manis");

        thaitea = new Minuman_Method("Thaitea", 30000, "M", true, false, tagThaitea, "Thailand");

        tagTehTarik.add("manis");

        tehtarik = new Minuman_Method("Teh Tarik", 20000, "L",false,false,  tagTehTarik, "Indonesia");


        menuMinuman.add(ocha);
        menuMinuman.add(esteh);
        menuMinuman.add(icedcoffeelatte);
        menuMinuman.add(thaitea);
        menuMinuman.add(tehtarik);

    }

    public int getJlhMinuman() {
        return this.menuMinuman.size();
    }

    public Minuman_Method getOcha() {
        return this.ocha;
    }

    public Minuman_Method getEsteh() {
        return this.esteh;
    }

    public Minuman_Method getIcedcoffeelatte() {
        return this.icedcoffeelatte;
    }

    public Minuman_Method getThaitea() {
        return this.thaitea;
    }

    public Minuman_Method getTehtarik() {
        return this.tehtarik;
    }
  }

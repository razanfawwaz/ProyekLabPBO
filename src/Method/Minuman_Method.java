package Method;

public class Minuman_Method {
    private String ukuran;
    private String suhu;
    private boolean cafein;

    public Minuman_Method(String nama, int harga, String jenis, String tag, String negara){
        this.ukuran = ukuran;
        this.suhu = suhu;
        this.cafein = cafein;

    }

    public String setUkuran(){
        return this.ukuran;
    }

    public String setSuhu(){
        return this.suhu;
    }

    public boolean setCafein(){
        return this.cafein;
    }

    public String getUkuran(){
        return this.ukuran;
    }

    public String getSuhu(){
        return this.suhu;
    }

    public boolean getCafein(){
        return this.cafein;
    }

}
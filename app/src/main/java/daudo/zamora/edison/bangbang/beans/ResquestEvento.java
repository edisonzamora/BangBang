package daudo.zamora.edison.bangbang.beans;

public class ResquestEvento {
    private int id_usuari;
    private int id_evet;
    private String tockent;

    public int getId_usuari() {
        return id_usuari;
    }

    public void setId_usuari(int id_usuari) {
        this.id_usuari = id_usuari;
    }

    public int getId_evet() {
        return id_evet;
    }

    public void setId_evet(int id_evet) {
        this.id_evet = id_evet;
    }

    public String getTockent() {
        return tockent;
    }

    public void setTockent(String tockent) {
        this.tockent = tockent;
    }

    public ResquestEvento(int id_usuari, int id_evet, String tockent) {
        this.id_usuari = id_usuari;
        this.id_evet = id_evet;
        this.tockent = tockent;
    }
}

package daudo.zamora.edison.bangbang.beans;

public class Databean {
    private String calle;
    private String Nunemo;
    private String cp;
    private String ciudad;
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNunemo() {
        return Nunemo;
    }

    public void setNunemo(String nunemo) {
        Nunemo = nunemo;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Databean() {
        this.calle="Carrer de Tuset";
        this.Nunemo="143";
        this.ciudad="Barcelona";
        this.cp="08006";
    }

    public Databean(String calle, String nunemo, String cp, String ciudad) {
        this.calle = calle;
        Nunemo = nunemo;
        this.cp = cp;
        this.ciudad = ciudad;
    }
}

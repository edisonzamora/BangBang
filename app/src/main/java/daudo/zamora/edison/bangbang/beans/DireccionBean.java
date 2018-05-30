package daudo.zamora.edison.bangbang.beans;

import java.io.Serializable;

public class DireccionBean implements Serializable{
    private String Calle;
    private String numero;
    private String ciudad;
    private String cp;
    private String telefono;
    private String telefono_fijo;
    public DireccionBean() {
        this.Calle="Carre de Toset";
        this.numero="6";
        this.ciudad="Barcelona";
        this.cp="08916";
        this.telefono="678-234-845";
        this.telefono_fijo="911-453-534";
    }
    public String getCalle() {
        return Calle;
    }
    public void setCalle(String calle) {
        Calle = calle;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getCp() {
        return cp;
    }
    public void setCp(String cp) {
        this.cp = cp;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTelefono_fijo() {
        return telefono_fijo;
    }
    public void setTelefono_fijo(String telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }
    public DireccionBean(String calle, String numero, String ciudad, String cp, String telefono) {
        Calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.cp = cp;
        this.telefono = telefono;
    }
}

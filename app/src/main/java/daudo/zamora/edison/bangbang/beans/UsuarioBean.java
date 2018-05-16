package daudo.zamora.edison.bangbang.beans;

import java.io.Serializable;

public class UsuarioBean implements Serializable {
    private int id;
    private String nombre;
    private String apellido;
    private String pass;

    public UsuarioBean(int id, String nombre, String apellido, String pass) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

package daudo.zamora.edison.bangbang.beans;

import java.io.Serializable;

public class UsuarioBean implements Serializable {
    private int id;
    private String nombre;
    private String apellido;
    private String fechanaciemoto;
    private String sexo;
    private String telefono;
    private String pass;
    private String correo;

    public String getFechanaciemoto() {
        return fechanaciemoto;
    }
    public void setFechanaciemoto(String fechanaciemoto) {
        this.fechanaciemoto = fechanaciemoto;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public UsuarioBean(){}
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
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

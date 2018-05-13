package daudo.zamora.edison.bangbang.beans;

import java.io.Serializable;

public class EventBean implements Serializable {
    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    private int id_evento;
    private String nombre;
    private String fecha;
    private Databean direccion;
    private String comentario;
    private String imagen;
  public EventBean(int id_evento, String nombre, String comentario, String imagen) {
        this.id_evento = id_evento;
        this.nombre = nombre;
        this.comentario = comentario;
        this.imagen = imagen;
        direccion=new Databean();
    }

    public EventBean(){}

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Databean getDireccion() {
        return direccion;
    }

    public void setDireccion(Databean direccion) {
        this.direccion = direccion;
    }
}

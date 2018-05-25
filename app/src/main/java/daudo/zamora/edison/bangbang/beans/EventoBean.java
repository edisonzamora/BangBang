package daudo.zamora.edison.bangbang.beans;

import java.io.Serializable;

public class EventoBean implements Serializable {
    public String getId_evento() {
        return id_evento;
    }

    public void setId_evento(String id_evento) {
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

    private String id_evento;
    private String nombre;
    private String fecha;
    private DireccionBean direccion;
    private String imagen;
    private String comentario;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public DireccionBean getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionBean direccion) {
        this.direccion = direccion;
    }

    public EventoBean(String id_evento, String nombre, String fecha, String comentario,String imagen) {
        this.id_evento = id_evento;
        this.nombre = nombre;
        this.comentario = comentario;
        this.imagen = imagen;
        this.direccion= new DireccionBean();
        this.fecha=fecha;

    }

    public EventoBean() {
        direccion=new DireccionBean();
    }
}

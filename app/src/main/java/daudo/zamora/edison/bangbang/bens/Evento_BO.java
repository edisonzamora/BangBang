package daudo.zamora.edison.bangbang.bens;

/**
 * Created by Edison Zamora on 28/03/2018.
 */

public class Evento_BO  {
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

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
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
    private String comentario;
    private int imagen;

    public Evento_BO(int id_evento, String nombre, String comentario, int imagen) {
        this.id_evento = id_evento;
        this.nombre = nombre;
        this.comentario = comentario;
        this.imagen = imagen;
    }
}

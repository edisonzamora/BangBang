package daudo.zamora.edison.bangbang.beans;

import java.io.Serializable;

public class ReservaBean implements Serializable{
    private String id_reserva;
    private String id_usuario;
    private String nombre_evento;
    private String fechaReserva;
    private String fechaEvento;
    private String imagen;

    public ReservaBean(String id_reserva, String id_usuario, String nombre_evento, String fechaEvento, String fechaReserva, String imagen) {
        this.id_reserva = id_reserva;
        this.id_usuario = id_usuario;
        this.nombre_evento = nombre_evento;
        this.fechaReserva = fechaReserva;
        this.fechaEvento = fechaEvento;
        this.imagen = imagen;
    }
    public String getNombre_evento() {
        return nombre_evento;
    }

    public void setNombre_evento(String nombre_evento) {
        this.nombre_evento = nombre_evento;
    }




    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(String id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }




}

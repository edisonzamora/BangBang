package daudo.zamora.edison.bangbang.beans;

import java.io.Serializable;

public class ResevasBean implements Serializable{
    private String id_reseva;
    private String nombreEvent;
    private String fechaEvento;
    private String fechaReser;

    public String getId_reseva() {
        return id_reseva;
    }

    public void setId_reseva(String id_reseva) {
        this.id_reseva = id_reseva;
    }

    public String getNombreEvent() {
        return nombreEvent;
    }

    public void setNombreEvent(String nombreEvent) {
        this.nombreEvent = nombreEvent;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getFechaReser() {
        return fechaReser;
    }

    public void setFechaReser(String fechaReser) {
        this.fechaReser = fechaReser;
    }

    public ResevasBean(String id_reseva, String nombreEvent, String fechaEvento, String fechaReser) {
        this.id_reseva = id_reseva;
        this.nombreEvent = nombreEvent;
        this.fechaEvento = fechaEvento;
        this.fechaReser = fechaReser;
    }
}

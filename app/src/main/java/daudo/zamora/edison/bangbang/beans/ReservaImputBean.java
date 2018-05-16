package daudo.zamora.edison.bangbang.beans;

import java.io.Serializable;

public class ReservaImputBean implements Serializable{
    private int id_user;
    private int id_evento;
    private  String token;

    public ReservaImputBean(int id_user, int id_evento, String token) {
        this.id_user = id_user;
        this.id_evento = id_evento;
        this.token = token;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

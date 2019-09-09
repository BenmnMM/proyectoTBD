package proyecto.tbd.models;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.*;


public class Voluntario {

    private long id;


    private String nombreV;


    private String apellidoV;


	private String emailV;

    public String getNombreV() {
        return nombreV;
    }

    public void setNombreV(String nombreV) {
        this.nombreV = nombreV;
    }

    public String getApellidoV() {
        return apellidoV;
    }

    public void setApellidoV(String apellidoV) {
        this.apellidoV = apellidoV;
    }

    public String getEmailV() {
        return emailV;
    }

    public void setEmailV(String emailV) {
        this.emailV = emailV;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Voluntario(String nombreV, String apellidoV, String emailV) {
        this.nombreV = nombreV;
        this.apellidoV = apellidoV;
        this.emailV = emailV;
    }
}

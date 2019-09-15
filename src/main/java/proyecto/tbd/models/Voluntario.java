package proyecto.tbd.models;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Voluntario")
public class Voluntario implements Serializable {

    @Id
    private Long id;
    private String nombreV;

    public Voluntario(Long id, String nombreV) {
        this.id = id;
        this.nombreV = nombreV;
    }

    public Voluntario(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreV() {
        return nombreV;
    }

    public void setNombreV(String nombreV) {
        this.nombreV = nombreV;
    }
}

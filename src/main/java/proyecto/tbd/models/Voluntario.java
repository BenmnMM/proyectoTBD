package proyecto.tbd.models;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "voluntario")
public class Voluntario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;
    @Column(name = "nombreV", nullable = false)
    private String nombreV;

    public Voluntario(String nombreV) {

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

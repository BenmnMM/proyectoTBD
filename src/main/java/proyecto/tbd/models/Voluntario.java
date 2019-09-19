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
    private long id;


    @Column(name = "nombreV", nullable = false)
    private String nombreV;

    @Column(name = "edadV", nullable = false)
    private Integer edadV;

    @Column(name = "generoV", nullable = false)
    private  String generoV;


    public Voluntario(long id, String nombreV,Integer edadV, String generoV) {
        this.id = id;
        this.nombreV = nombreV;
        this.edadV=edadV;
        this.generoV=generoV;
    }

    public Voluntario(){}

    public Integer getEdadV() {
        return edadV;
    }

    public void setEdadV(Integer edadV) {
        this.edadV = edadV;
    }

    public String getGeneroV() {
        return generoV;
    }

    public void setGeneroV(String generoV) {
        this.generoV = generoV;
    }

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
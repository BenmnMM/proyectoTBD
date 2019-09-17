package proyecto.tbd.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.io.Serializable;

import java.util.List;

@Entity
@Table(name = "tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "cantidad_voluntarios", nullable = false)
    private Integer cantidad_voluntarios;
    //private List<Voluntario> voluntarios;

    /*@Column(name = "caracteristicas", nullable = false)*/
    @ManyToMany
    @JoinTable(name = "caracteristicas", joinColumns = @JoinColumn(name = "tarea"), inverseJoinColumns = @JoinColumn (name = "caracteristica"))
    private List<Caracteristica> caracteristicas;

    public Tarea(long id, String nombre,String descripcion, Integer cantidad_voluntarios, List<Caracteristica> caracteristicas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion=descripcion;
        this.cantidad_voluntarios=cantidad_voluntarios;
        this.caracteristicas=caracteristicas;
    }

    public Tarea(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad_voluntarios() {
        return cantidad_voluntarios;
    }

    public void setCantidad_voluntarios(Integer cantidad_voluntarios) {
        this.cantidad_voluntarios = cantidad_voluntarios;
    }



    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}

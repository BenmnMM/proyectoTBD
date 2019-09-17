package proyecto.tbd.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;
<<<<<<< HEAD
    private String direccion;
    private String edad;
    private List<Caracteristica> caracteristicas;
    private Tarea tarea;
=======

    @Column(name="rut", nullable = false)
    private String rut;

    @Column(name="id_rol", nullable = false)
    private Integer id_rol;

    public Usuario(){}

    public Usuario(String nombre, String apellido, String rut, Integer id_rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.id_rol = id_rol;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
>>>>>>> master

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea( Tarea tarea) { this.tarea = tarea; }
}

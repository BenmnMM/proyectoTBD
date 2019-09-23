package proyecto.tbd.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name="rut", nullable = false)
    private String rut;

    @Column(name="id_rol", nullable = false)
    private Integer id_rol;

    public Usuario(){}

    public Usuario(String nombre, String apellido, String rut, Integer id_rol,Integer edad ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.id_rol = id_rol;
        this.edad=edad;
    }

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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}

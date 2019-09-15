package proyecto.tbd.models;

import java.util.List;

public class Tarea {
    private String nombre;
    private String descripcion;
    private int cantidad_voluntarios;
    //private List<Voluntario> voluntarios;
    private List<Caracteristica> caracteristicas;

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

    public int getCantidad_voluntarios() {
        return cantidad_voluntarios;
    }

    public void setCantidad_voluntarios(int cantidad_voluntarios) {
        this.cantidad_voluntarios = cantidad_voluntarios;
    }



    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}

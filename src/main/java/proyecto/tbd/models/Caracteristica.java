package proyecto.tbd.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "caracteristica")
public class Caracteristica {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private long id;

	@Column(name = "nombre", nullable = false)
    private String nombre;

	public Caracteristica (){
	}

	public Caracteristica(String nombre) {
		this.nombre = nombre;
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
}

package proyecto.tbd.models;

import org.springframework.data.annotation.Id;
import java.util.List;


public class Caracteristica {

	private long id;
    private String nombreC;
    private String descripcionC;
	private List<Tarea> tareasC;
	//private List<Voluntario> voluntariosC;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreC() {
		return nombreC;
	}

	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}

	public String getDescripcionC() {
		return descripcionC;
	}

	public void setDescripcionC(String descripcionC) {
		this.descripcionC = descripcionC;
	}

	public List<Tarea> getTareasC() {
		return tareasC;
	}

	public void setTareasC(List<Tarea> tareasC) {
		this.tareasC = tareasC;
	}


}

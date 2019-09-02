package proyecto.tbd.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.util.Date;
import java.util.List;

public class Caracteristica {
	@Id
    private ObjectId _id;
    private String nombreC;
    private String descripcionC;
	private List<Tarea> tareasC;
	private List<Voluntario> voluntariosC;

    public String get_id(){
        return _id.toHexString();
    }
    public void set_id(ObjectId _id){
        this._id = _id;
    }
    public String getNombreC(){
        return nombreC;
    }
    public void setNombreC(String nombreC){
        this.nombreC = nombreC;
    }
    public String getDescripcionC(){
        return descripcionC;
    }
    public void setDescripcionC(String descripcionC){
        this.descripcionC = descripcionC;
    }
	public List<Tarea> getTareasC(){
		return tareasC;
	}
	public Tarea getTareaC(int posicion){
		return tareasC.get(posicion);
	}
	public void setTareasC(List<Tarea> tareasC){
		this.tareasC = tareasC;
	}
	public void setTareaC(Tarea tareaC, int posicion){
		this.tareasC.get(posicion) = tareaC;
	}
	public void deleteTareaC(int posicion){
		this.tareasC.remove(posicion);
	}
	public List<Voluntario> getVoluntariosC(){
		return voluntariosC;
	}
	public Voluntario getVoluntarioC(int posicion){
		return voluntariosC.get(posicion);
	}
	public void setVoluntariosC(List<Voluntario> volntariosC){
		this.voluntariosC = voluntariosC;
	}
	public void setVoluntarioC(Voluntario voluntarioC, int posicion){
		this.voluntariosC.get(posicion) = voluntarioC;
	}
	public void deleteVoluntarioC(int posicion){
		this.voluntariosC.remove(posicion);
	}
}

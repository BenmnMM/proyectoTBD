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

    public String get_id()
    {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id)
    {
        this._id = _id;
    }

    public String getNombreC()
    {
        return ombreC;
    }

    public void setNombreC(String nombreC)
    {
        this.nombreC = nombreC;
    }

    public String getDescripcionC()
    {
        return descripcionC;
    }

    public void setDescripcionC(String descripcionC)
    {
        this.descripcionC = descripcionC;
    }

}
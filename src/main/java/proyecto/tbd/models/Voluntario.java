package proyecto.tbd.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.util.Date;
import java.util.List;

public class Voluntario {
	@Id
    private ObjectId _id;
    private String nombreV;
    private String apellidoV;
	private String emailV;

    public String get_id(){
        return _id.toHexString();
    }
    public void set_id(ObjectId _id){
        this._id = _id;
    }
    public String getNombreV(){
        return nombreV;
    }
    public void setNombreV(String nombreV){
        this.nombreV = nombreV;
    }
    public String getApellidoV(){
        return apellidoV;
    }
    public void setApellidoV(String apellidoV){
        this.apellidoV = apellidoV;
    }
	public String getEmailV(){
        return emailV;
    }
    public void setEmailV(String emailV){
        this.emailV = emailV;
    }
}

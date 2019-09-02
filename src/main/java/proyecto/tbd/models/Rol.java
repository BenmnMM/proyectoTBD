package proyecto.tbd.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.util.Date;
import java.util.List;

public class Rol {
	@Id
    private ObjectId _id;
    private String nombreR;

    public String get_id(){
        return _id.toHexString();
    }
    public void set_id(ObjectId _id){
        this._id = _id;
    }
    public String getNombreR(){
        return nombreR;
    }
    public void setNombreR(String nombreR){
        this.nombreR = nombreR;
    }
}

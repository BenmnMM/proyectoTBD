package proyecto.tbd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proyecto.tbd.models.Rol;
import proyecto.tbd.repository.RolRepository;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(path = "/roles")
@CrossOrigin(origins = "*")
public class ControladorRol {
    @Autowired
    private RolRepository rolRepository;



    @GetMapping("")
    @ResponseBody
    public List<Rol> getRoles(){
        return rolRepository.findAll();
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public String actualizarRol (@PathVariable("id") long id, @RequestBody Rol rol ){

        Rol infRol = rolRepository.findByid(id);
        if(infRol != null){
            infRol.setNombreR(rol.getNombreR());
            rolRepository.save(infRol);
            return "Rol modificada correctamente.";


        }else{

            return "Rol no se encuentra en la base de datos.";
        }

    }
    @PostMapping(value = "/")
    @ResponseBody
    public String crearRol(@RequestBody Rol rol){

        if (rolRepository.findByid(rol.getId()) == null)
        {
            if(rol.getNombreR() != null) {

                rol.setNombreR(rol.getNombreR());
                rolRepository.save(rol);
                return "Rol creado con exito";

            }else{

                return "Debe completar todos los campos!";
            }



        }else{

            return "Rol no se encuentra!";
        }

    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public String deleteRol(@RequestParam Long id){
        Rol rol = rolRepository.findByid(id);
        this.rolRepository.delete(rol);
        return "Eliminado" + id;

    }
}

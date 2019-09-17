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
            infRol.setNombre(tarea.getNombre());
            infRol.setDescripcion(tarea.getDescripcion());
            infRol.setCantidad_voluntarios(tarea.getCantidad_voluntarios());
            rolRepository.save(infRol);
            return "Rol modificada correctamente.";


        }else{

            return "Tarea no se encuentra en la base de datos.";
        }

    }
}

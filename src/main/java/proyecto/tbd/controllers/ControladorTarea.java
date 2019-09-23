package proyecto.tbd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proyecto.tbd.models.Tarea;
import proyecto.tbd.repository.TareaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(path = "/tareas")
@CrossOrigin(origins = "*")
public class ControladorTarea {
    @Autowired
    private TareaRepository tareaRepository;



    @GetMapping("")
    @ResponseBody
    public List<Tarea> getTareas(){
        return tareaRepository.findAll();
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Tarea getTarea(@PathVariable long id){

        return tareaRepository.findByid(id);
    }


    @PutMapping(value = "/{id}")
    @ResponseBody
    public String actualizarTarea (@PathVariable("id") long id, @RequestBody Tarea tarea ){

        Tarea infTarea = tareaRepository.findByid(id);
        if(infTarea != null){
            infTarea.setNombre(tarea.getNombre());
            infTarea.setDescripcion(tarea.getDescripcion());
            infTarea.setCantidad_voluntarios(tarea.getCantidad_voluntarios());
            infTarea.setVoluntario(tarea.getVoluntario());
            infTarea.setEmergencia(tarea.getEmergencia());

            tareaRepository.save(infTarea);

            return "Tarea modificada correctamente.";


        }else{

            return "Tarea no se encuentra en la base de datos.";
        }

    }



    @PostMapping(value = "/crear")
    @ResponseBody
    public String crearTarea(@RequestBody Tarea tarea){

        if (tareaRepository.findByid(tarea.getId()) == null)
        {
            if(tarea.getNombre() != null && tarea.getDescripcion()!= null && tarea.getCantidad_voluntarios()!=null) {

                tarea.setNombre(tarea.getNombre());
                tarea.setDescripcion(tarea.getDescripcion());
                tarea.setCantidad_voluntarios(tarea.getCantidad_voluntarios());
                tarea.setVoluntario(tarea.getVoluntario());
                tarea.setEmergencia(tarea.getEmergencia());
                tareaRepository.save(tarea);
                return "Tarea creado con exito";

            }else{

                return "Debe completar todos los campos!";
            }



        }else{

            return "Tarea no se encuentra!";
        }


    }

    @DeleteMapping(value="/{id}")
    public String deleteTarea(@PathVariable long id){
        Tarea tarea = tareaRepository.findByid(id);
        this.tareaRepository.delete(tarea);
        return "Eliminado" + id;

    }
}

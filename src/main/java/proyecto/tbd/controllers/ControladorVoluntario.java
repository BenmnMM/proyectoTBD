package proyecto.tbd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proyecto.tbd.models.Voluntario;
import proyecto.tbd.repository.VoluntarioRepository;

import java.util.List;
import java.util.Optional;


@RestController
@Validated
@RequestMapping(path = "/voluntarios")
@CrossOrigin(origins = "*")
public class ControladorVoluntario {

    @Autowired
    private VoluntarioRepository voluntarioRepository;



    @GetMapping("")
    @ResponseBody
    public List<Voluntario> getVoluntarios(){
        return voluntarioRepository.findAll();
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Voluntario getVoluntario(@PathVariable Long id){

        return voluntarioRepository.findByid(id);
    }


    @PutMapping(value = "/{id}")
    @ResponseBody
    public String actualizarVoluntario (@PathVariable("id") long id, @RequestBody Voluntario voluntario ){

        Voluntario infVoluntario = voluntarioRepository.findByid(id);
        if(infVoluntario != null){
            infVoluntario.setGeneroV(voluntario.getGeneroV());
            infVoluntario.setEdadV(voluntario.getEdadV());
            infVoluntario.setNombreV(voluntario.getNombreV());
            voluntarioRepository.save(infVoluntario);
            return "Voluntario modificado correctamente.";


        }else{

            return "Voluntario no se encuentra en la base de datos.";
        }

    }



    @PostMapping(value = "/")
    @ResponseBody
    public String crearVoluntario(@RequestBody Voluntario voluntario){

        if (voluntarioRepository.findByid(voluntario.getId()) == null)
        {
            if(voluntario.getNombreV() != null && voluntario.getEdadV()!= null && voluntario.getGeneroV()!=null) {

                voluntario.setNombreV(voluntario.getNombreV());
                voluntario.setEdadV(voluntario.getEdadV());
                voluntario.setGeneroV(voluntario.getGeneroV());
                voluntarioRepository.save(voluntario);
                return "Voluntario creado con exito";

            }else{

                return "Debe completar todos los campos!";
            }



        }else{

            return "Voluntario no se encuentra!";
        }


    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public String deleteVoluntario(@RequestParam Long id){
        Voluntario voluntario = voluntarioRepository.findByid(id);
        this.voluntarioRepository.delete(voluntario);
        return "Eliminado" + id;

    }








}

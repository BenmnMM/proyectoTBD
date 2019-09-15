package proyecto.tbd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import proyecto.tbd.models.Voluntario;
import proyecto.tbd.repository.VoluntarioRepository;

import java.util.List;


@RestController
@RequestMapping("/voluntarios")
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

    @PostMapping(value = "/")
    @ResponseBody
    public void createVoluntario(@RequestBody Voluntario voluntario){

        if (voluntarioRepository.findByid(voluntario.getId()) == null)
        {

            voluntario.setNombreV(voluntario.getNombreV());
            voluntarioRepository.save(voluntario);
        }else{

            System.out.println("Usuario ya creado");
        }


    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public String deleteVoluntario(@RequestParam Long id){
        Voluntario voluntario = voluntarioRepository.findByid(id);
        this.voluntarioRepository.delete(voluntario);
        return "Eliminado" + id;

    }








}

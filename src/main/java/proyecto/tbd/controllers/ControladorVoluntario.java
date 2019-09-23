package proyecto.tbd.controllers;

import com.github.javafaker.Faker;
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
@CrossOrigin(origins = "http://localhost:4200")
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
    public Voluntario getVoluntario(@PathVariable long id){

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
            infVoluntario.setCaracteristicas(voluntario.getCaracteristicas());
            voluntarioRepository.save(infVoluntario);
            return "Voluntario modificado correctamente.";


        }else{

            return "Voluntario no se encuentra en la base de datos.";
        }

    }



    @PostMapping(value = "/crear")
    @ResponseBody
    public String crearVoluntario(@RequestBody Voluntario voluntario){

        if (voluntarioRepository.findByid(voluntario.getId()) == null)
        {
            if(voluntario.getNombreV() != null && voluntario.getEdadV()!= null && voluntario.getGeneroV()!=null) {

                voluntario.setNombreV(voluntario.getNombreV());
                voluntario.setEdadV(voluntario.getEdadV());
                voluntario.setGeneroV(voluntario.getGeneroV());
                voluntario.setCaracteristicas(voluntario.getCaracteristicas());
                voluntarioRepository.save(voluntario);
                return "Voluntario creado con exito";

            }else{

                return "Debe completar todos los campos!";
            }



        }else{

            return "Voluntario no se encuentra!";
        }


    }

    @DeleteMapping(value = "/{id}")
    public String deleteVoluntario(@PathVariable("id") long id){

        Voluntario voluntario = voluntarioRepository.findByid(id);

        if(voluntario != null){
            this.voluntarioRepository.delete(voluntario);
            return "Eliminado " + id;


        }else{
            return "El Voluntario con id " + id+ " no se encuentra";

        }
    }

    @PostMapping(value = "/seedFaker/{cap}")
    public String createVoluntarioWithFaker(@PathVariable("cap") int cap)
    {
        Faker faker = new Faker();

        for(int i = 0; i < cap; i++)
        {
            Voluntario voluntario = new Voluntario();
            voluntario.setNombreV(faker.name().fullName());
            voluntario.setEdadV(faker.number().numberBetween(1, 100));
            if (i % 2 == 0)
                voluntario.setGeneroV("Masculino");
            else
                voluntario.setGeneroV("Femenino");
            voluntarioRepository.save(voluntario);
        }

        return "Faker seeding was completed successfully";
    }
}

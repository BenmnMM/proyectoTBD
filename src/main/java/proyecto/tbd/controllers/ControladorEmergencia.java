package proyecto.tbd.controllers;


import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proyecto.tbd.models.Emergencia;
import proyecto.tbd.repository.EmergenciaRepository;

import java.util.List;

@RestController
@Validated
@RequestMapping(path = "/emergencias")
@CrossOrigin(origins = "*")
public class ControladorEmergencia
{
    @Autowired
    private EmergenciaRepository emergenciaRepository;

    @GetMapping("")
    @ResponseBody
    public List<Emergencia> getEmergencias() {

        return emergenciaRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Emergencia getEmergencia(@PathVariable long id)
    {

        return emergenciaRepository.findByid(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public String actualizarEmergencia (@PathVariable("id") long id, @RequestBody Emergencia emergencia)
    {
        Emergencia infEmergencia = emergenciaRepository.findByid(id);
        if (infEmergencia != null)
        {
            infEmergencia.setNombre(emergencia.getNombre());
            infEmergencia.setDescripcion(emergencia.getDescripcion());
            infEmergencia.setTareas(emergencia.getTareas());
            emergenciaRepository.save(infEmergencia);
            return "Emergencia modificada correctamente";
        }

        else
        {
            return "La emergencia no se encuentra en la base de datos.";
        }
    }

    @PostMapping(value = "/crear")
    @ResponseBody
    public String crearEmergencia(@RequestBody Emergencia emergencia)
    {
        if (emergenciaRepository.findByid(emergencia.getId()) == null)
        {
            if (emergencia.getNombre() != null && emergencia.getDescripcion() != null)
            {
                emergencia.setNombre(emergencia.getNombre());
                emergencia.setDescripcion(emergencia.getDescripcion());
                emergencia.setTareas(emergencia.getTareas());
                emergenciaRepository.save(emergencia);
                return "Emergencia creada con exito";
            }

            else {
                return "Debe completar todos los campos!";
            }
        }

        else
        {
            return "Emergencia no encontrada.";
        }
    }

    @DeleteMapping(value = "/{id}")
    public String deleteEmergencia(@PathVariable("id") long id)
    {
        Emergencia emergencia = emergenciaRepository.findByid(id);

        if(emergencia != null){
            this.emergenciaRepository.delete(emergencia);
            return "La emergencia " + id + "ha sido eliminada.";


        }else{
            return "La emergencia con id " + id + " no se encuentra";

        }

    }

    @PostMapping(value = "/seedFaker/{cap}")
    public String createEmergenciaWithFaker(@PathVariable("cap") int cap)
    {
        Faker faker = new Faker();

        for(int i = 0; i < cap; i++)
        {
            Emergencia emergencia = new Emergencia();
            emergencia.setNombre(faker.hacker().noun());
            emergencia.setDescripcion(faker.elderScrolls().quote());

            emergenciaRepository.save(emergencia);
        }

        return "Faker seeding was completed successfully";
    }
}

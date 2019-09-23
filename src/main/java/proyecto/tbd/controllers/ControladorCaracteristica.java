package proyecto.tbd.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proyecto.tbd.models.Caracteristica;
import proyecto.tbd.repository.CaracteristicaRepository;

import java.util.List;

@RestController
@Validated
@RequestMapping(path = "/caracteristicas")
@CrossOrigin(origins = "*")
public class ControladorCaracteristica {


    @Autowired
    private CaracteristicaRepository caracteristicaRepository;

    @GetMapping("")
    @ResponseBody
    public List<Caracteristica> getCaracteristicas() { return caracteristicaRepository.findAll(); }


    @GetMapping("/{id}")
    @ResponseBody
    public Caracteristica getCaracteristica(@PathVariable long id){

        return caracteristicaRepository.findByid(id);
    }

    @PostMapping("/crear")
    @ResponseBody
    public String crearCaracteristica (@RequestBody Caracteristica caracteristica){

        if (caracteristicaRepository.findByid(caracteristica.getId()) == null)
        {
            if(caracteristica.getNombre() != null) {

                caracteristica.setNombre(caracteristica.getNombre());
                caracteristicaRepository.save(caracteristica);
                return "Caracteristica creada con exito";

            }else{

                return "Debe completar todos los campos!";
            }



        }else{

            return "Caracteristica no se encuentra!";
        }



    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public String actualizarCaracteristica (@PathVariable("id") long id, @RequestBody Caracteristica caracteristica ){

        Caracteristica infCaracteristica = caracteristicaRepository.findByid(id);
        if(infCaracteristica != null){
            infCaracteristica.setNombre(caracteristica.getNombre());
            caracteristicaRepository.save(infCaracteristica);
            return "Caracteristica modificada correctamente.";


        }else{

            return "Caracteristica no se encuentra en la base de datos.";
        }

    }



    @DeleteMapping(value = "/{id}")
    public String deleteCaracteristica(@PathVariable("id") long id){

        Caracteristica caracteristica = caracteristicaRepository.findByid(id);

        if(caracteristica != null){
            this.caracteristicaRepository.delete(caracteristica);
            return "Eliminado " + id;


        }else{
            return "La caracteristica con id " + id+ " no se encuentra";

        }
    }





}

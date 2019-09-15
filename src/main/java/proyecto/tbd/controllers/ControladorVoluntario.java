package proyecto.tbd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proyecto.tbd.models.Voluntario;
import proyecto.tbd.repository.VoluntarioRepository;
import proyecto.tbd.services.VoluntarioService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/voluntarios")
public class ControladorVoluntario {

    @Autowired
    private VoluntarioService voluntarioService;

    @GetMapping(path = "/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Voluntario findById(@PathVariable Long id) {

        Voluntario voluntarios = voluntarioService.getVoluntario(id);
        return voluntarios;
    }






}

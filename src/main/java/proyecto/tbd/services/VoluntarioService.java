package proyecto.tbd.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.tbd.models.Voluntario;
import proyecto.tbd.repository.VoluntarioRepository;

import java.util.List;

@Service
public class VoluntarioService {


    @Autowired
    private VoluntarioRepository voluntarioRepository;

    //Get voluntario by name
    public Voluntario getVoluntario(Long id) {
        return voluntarioRepository.findByid(id);
    }

}

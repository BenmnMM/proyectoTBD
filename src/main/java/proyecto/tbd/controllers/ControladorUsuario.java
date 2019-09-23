package proyecto.tbd.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proyecto.tbd.models.Emergencia;
import proyecto.tbd.models.Usuario;
import proyecto.tbd.repository.UsuarioRepository;

import java.util.List;

@RestController
@Validated
@RequestMapping(path = "/usuarios")
@CrossOrigin(origins = "*")
public class ControladorUsuario {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("")
    @ResponseBody
    public List<Usuario> getUsuarios() { return usuarioRepository.findAll(); }


    @GetMapping("/{id}")
    @ResponseBody
    public Usuario getUsuario(@PathVariable long id)
    {
        return usuarioRepository.findByid(id);
    }


    @PutMapping(value = "/{id}")
    @ResponseBody
    public String actualizarUsuario (@PathVariable("id") long id, @RequestBody Usuario usuario)
    {
        Usuario infUsuario = usuarioRepository.findByid(id);
        if (infUsuario != null)
        {
            infUsuario.setNombre(usuario.getNombre());
            infUsuario.setApellido(usuario.getApellido());
            infUsuario.setRut(usuario.getRut());
            infUsuario.setEdad(usuario.getEdad());
            usuarioRepository.save(infUsuario);
            return "Usuario modificada correctamente";
        }

        else
        {
            return "El Usuario no se encuentra en la base de datos.";
        }
    }

    @PostMapping(value = "/crear")
    @ResponseBody
    public String crearUsuario(@RequestBody Usuario usuario)
    {
        if (usuarioRepository.findByid(usuario.getId()) == null)
        {
            if (usuario.getNombre() != null && usuario.getApellido() != null && usuario.getRut() != null && usuario.getId_rol()!=null)
            {
                usuario.setNombre(usuario.getNombre());
                usuario.setRut(usuario.getRut());
                usuario.setApellido(usuario.getApellido());
                usuario.setId_rol(usuario.getId_rol());
                usuarioRepository.save(usuario);
                return "Usuario creada con exito";
            }

            else {
                return "Debe completar todos los campos!";
            }
        }

        else
        {
            return "Usuario no encontrada.";
        }
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUsuario(@PathVariable("id") long id)
    {
        Usuario usuario = usuarioRepository.findByid(id);
        if(usuario != null){
            this.usuarioRepository.delete(usuario);
            return "El usuario" + id + "ha sido eliminado.";


        }else{
            return "El Usuario con id " + id+ " no se encuentra";

        }

    }



}

package proyecto.tbd.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.tbd.models.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByid(long id);
    List<Usuario> findAll();
}

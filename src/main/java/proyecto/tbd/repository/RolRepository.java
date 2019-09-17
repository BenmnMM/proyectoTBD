package proyecto.tbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import proyecto.tbd.models.Rol;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Rol findByid(long id);
    List<Rol> findAll();
}

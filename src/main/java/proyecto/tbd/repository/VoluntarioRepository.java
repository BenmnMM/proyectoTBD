package proyecto.tbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import proyecto.tbd.models.Voluntario;

import java.util.List;

@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Long>{
        Voluntario findByid(Long id);

}

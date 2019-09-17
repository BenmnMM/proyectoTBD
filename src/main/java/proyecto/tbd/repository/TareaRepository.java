package proyecto.tbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import proyecto.tbd.models.Tarea;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long>{
    Tarea findByid(long id);
    List<Tarea> findAll();
}

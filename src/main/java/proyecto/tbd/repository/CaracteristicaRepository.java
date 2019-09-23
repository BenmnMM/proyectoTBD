package proyecto.tbd.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.tbd.models.Caracteristica;

import java.util.List;

@Repository
public interface CaracteristicaRepository extends JpaRepository<Caracteristica, Long> {

    Caracteristica findByid(long id);
    List<Caracteristica> findAll();

}

package proyecto.tbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.tbd.models.Emergencia;

import java.util.List;

@Repository
public interface EmergenciaRepository extends JpaRepository<Emergencia, Long>
{
    Emergencia findByid(long id);
    List<Emergencia> findAll();
}

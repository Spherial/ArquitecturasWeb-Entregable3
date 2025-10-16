package ArquitecturasWeb.repository;

import ArquitecturasWeb.dto.EstudianteDTO;
import ArquitecturasWeb.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {


    @Query("SELECT e FROM Estudiante e ORDER BY e.apellido ASC")
    List<EstudianteDTO> getAllEstudiantesOrderByApellidoAsc();

    @Query("SELECT e FROM estudiante WHERE e.id = :id ") //TODO chequear
    EstudianteDTO getEstudianteById(int id);
}

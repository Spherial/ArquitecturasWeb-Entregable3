package ArquitecturasWeb.repository;

import ArquitecturasWeb.dto.ReporteDTO;
import ArquitecturasWeb.entities.Carrera;
import ArquitecturasWeb.entities.EstudianteCarrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, Long> {

    @Query(" SELECT new ArquitecturasWeb.dto.ReporteDTO( c.nombre,COUNT(ec.id),SUM(CASE WHEN ec.graduacion IS NOT NULL AND ec.graduacion <> 0 THEN 1 ELSE 0 END),ec.inscripcion) " +
            "FROM EstudianteCarrera ec " +
            "JOIN ec.carrera c " +
            "GROUP BY c.nombre, ec.inscripcion " +
            "ORDER BY c.nombre ASC, ec.inscripcion ASC")
    List<ReporteDTO> getReporteInscriptos();
}

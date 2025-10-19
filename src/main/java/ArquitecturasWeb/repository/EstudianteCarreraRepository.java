package ArquitecturasWeb.repository;

import ArquitecturasWeb.entities.Carrera;
import ArquitecturasWeb.entities.EstudianteCarrera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, Long> {
}

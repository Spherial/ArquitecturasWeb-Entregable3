package ArquitecturasWeb.repository;

import ArquitecturasWeb.dto.CarreraDTO;
import ArquitecturasWeb.entities.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

    @Query("SELECT new ArquitecturasWeb.dto.CarreraDTO(c.id, c.nombre, COUNT(ec)) " +
            "FROM Carrera c " +
            "JOIN c.estudianteCarrera ec " +
            "GROUP BY c.id, c.nombre " +
            "ORDER BY COUNT(ec) DESC")
    public List<CarreraDTO> getInscriptos();

}

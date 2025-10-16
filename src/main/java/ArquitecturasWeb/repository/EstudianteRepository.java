package ArquitecturasWeb.repository;

import ArquitecturasWeb.dto.EstudianteDTO;
import ArquitecturasWeb.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {

    @Query("SELECT new ArquitecturasWeb.dto.EstudianteDTO(e.dni, e.nombre,e.apellido,e.edad,e.genero,e.ciudad,e.LU) FROM Estudiante e ORDER BY e.apellido ASC")//TODO DSP CHEKEAMOS EL DTO QUE DEVOLVEMOS O LA CONSULTA
    List<EstudianteDTO> getAllEstudiantesOrderByApellidoAsc();

    @Query("SELECT new ArquitecturasWeb.dto.EstudianteDTO(e.dni, e.nombre,e.apellido,e.edad,e.genero,e.ciudad,e.LU) FROM Estudiante e WHERE e.LU = :LU ") //TODO chequear
    EstudianteDTO getEstudianteByLU(@Param("LU") int LU);

    @Query("SELECT new ArquitecturasWeb.dto.EstudianteDTO(e.dni, e.nombre,e.apellido,e.edad,e.genero,e.ciudad,e.LU) FROM Estudiante e WHERE e.genero = :genero")
    List<EstudianteDTO> getEstudiantesByGenero(@Param("genero") String genero);
}

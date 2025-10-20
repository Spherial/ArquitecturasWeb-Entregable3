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

    @Query("SELECT new ArquitecturasWeb.dto.EstudianteDTO(e.nombre,e.apellido,e.edad,e.genero,e.ciudad,e.LU) FROM Estudiante e ORDER BY e.apellido ASC")
    List<EstudianteDTO> getAllEstudiantesOrderByApellidoAsc();

    @Query("SELECT new ArquitecturasWeb.dto.EstudianteDTO(e.nombre,e.apellido,e.edad,e.genero,e.ciudad,e.LU) FROM Estudiante e WHERE e.LU = :LU ")
    EstudianteDTO getEstudianteByLU(@Param("LU") int LU);

    @Query("SELECT new ArquitecturasWeb.dto.EstudianteDTO(e.nombre,e.apellido,e.edad,e.genero,e.ciudad,e.LU) FROM Estudiante e WHERE e.genero = :genero")
    List<EstudianteDTO> getEstudiantesByGenero(@Param("genero") String genero);

    @Query("""
    SELECT new ArquitecturasWeb.dto.EstudianteDTO(
        e.nombre, e.apellido, e.edad, e.genero, e.ciudad, e.LU
    )
    FROM Estudiante e
    WHERE (:nombre IS NULL OR e.nombre LIKE %:nombre%)
      AND (:apellido IS NULL OR e.apellido LIKE %:apellido%)
      AND (:edad IS NULL OR e.edad = :edad)
      AND (:genero IS NULL OR e.genero LIKE %:genero%)
      AND (:ciudad IS NULL OR e.ciudad LIKE %:ciudad%)
      AND (:LU IS NULL OR e.LU = :LU)
    ORDER BY e.apellido ASC
""")
    List<EstudianteDTO> buscarEstudiantesPorCampos(
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("edad") Integer edad,
            @Param("genero") String genero,
            @Param("ciudad") String ciudad,
            @Param("LU") Integer LU
    );


    @Query("""
    select new ArquitecturasWeb.dto.EstudianteDTO(
        e.dni,
        e.nombre,
        e.apellido,
        e.edad,
        e.genero,
        e.ciudad,
        e.LU
    )
    from Estudiante e
    where e in (
        select ec.estudiante
        from EstudianteCarrera ec
        where ec.carrera.id = :id
    )
    """)
    List<EstudianteDTO>getEstudiantesPorIdCarrera(@Param("id")int id);

}

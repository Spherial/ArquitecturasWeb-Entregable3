package ArquitecturasWeb.services;

import ArquitecturasWeb.dto.EstudianteDTO;
import ArquitecturasWeb.entities.Estudiante;
import ArquitecturasWeb.repository.EstudianteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;


    @Transactional
    public void insertEstudiante(Estudiante estudiante){
        estudianteRepository.save(estudiante);
    }

    @Transactional
    public List<EstudianteDTO> getAllByOrderByApellidoAsc(){
        return estudianteRepository.getAllEstudiantesOrderByApellidoAsc();
    }

    @Transactional
    public EstudianteDTO getEstudiantePorLU(int LU){
        return estudianteRepository.getEstudianteByLU(LU);
    }

    @Transactional
    public List<EstudianteDTO> getEstudiantePorGenero(String genero){return estudianteRepository.getEstudiantesByGenero(genero);}

    @Transactional
    public List<EstudianteDTO> buscarEstudiantesPorCampos(String nombre,String apellido,Integer edad, String genero,String ciudad, Integer LU){
        return estudianteRepository.buscarEstudiantesPorCampos(nombre, apellido, edad, genero, ciudad,LU);
    }

    @Transactional
    public List<EstudianteDTO> getEstudiantesPorIdCarrera(int id, String ciudad){
        return estudianteRepository.getEstudiantesPorIdCarrera(id, ciudad);
    }




}

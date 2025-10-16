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

    @Autowired
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




}

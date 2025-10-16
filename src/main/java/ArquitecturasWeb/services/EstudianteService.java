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

    public List<EstudianteDTO> findAllByOrderByApellidoAsc(){
        return estudianteRepository.findAllByOrderByApellidoAsc();
    }

    public EstudianteDTO getEstudianteId(int id){
        return estudianteRepository.getEstudianteById(id);
    }




}

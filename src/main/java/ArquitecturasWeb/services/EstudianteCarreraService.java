package ArquitecturasWeb.services;

import ArquitecturasWeb.dto.ReporteDTO;
import ArquitecturasWeb.entities.Carrera;
import ArquitecturasWeb.entities.Estudiante;
import ArquitecturasWeb.entities.EstudianteCarrera;
import ArquitecturasWeb.repository.EstudianteCarreraRepository;
import ArquitecturasWeb.repository.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EstudianteCarreraService {

    private final EstudianteCarreraRepository estudianteCarreraRepository;

    public void matricular(Estudiante estudiante, Carrera carrera, int inscripcion, int graduacion, int antiguedad){
        EstudianteCarrera ec = new EstudianteCarrera(estudiante, carrera, inscripcion,graduacion,antiguedad);
        estudianteCarreraRepository.save(ec);
    }

    public List<ReporteDTO> getReporteInscriptos(){
        return estudianteCarreraRepository.getReporteInscriptos();
    }
}

package ArquitecturasWeb.controller;

import ArquitecturasWeb.dto.ReporteDTO;
import ArquitecturasWeb.entities.Carrera;
import ArquitecturasWeb.entities.Estudiante;
import ArquitecturasWeb.repository.EstudianteCarreraRepository;
import ArquitecturasWeb.services.EstudianteCarreraService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class EstudianteCarreraControlller {

    private final EstudianteCarreraService estudianteCarreraService;

    @JsonIgnoreProperties
    @GetMapping("/reportes")
    public Iterable<ReporteDTO> getReporteInscriptos(){
       return estudianteCarreraService.getReporteInscriptos();
    }

    @JsonIgnoreProperties
    @PostMapping("/agregar")
    public void matricular(@RequestBody @Validated Estudiante estudiante, Carrera carrera, int inscripcion, int graduacion, int antiguedad){
        estudianteCarreraService.matricular(estudiante, carrera, inscripcion, graduacion, antiguedad);
    }
}

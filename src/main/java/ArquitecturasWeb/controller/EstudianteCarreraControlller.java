package ArquitecturasWeb.controller;

import ArquitecturasWeb.dto.ReporteDTO;
import ArquitecturasWeb.services.EstudianteCarreraService;
import ArquitecturasWeb.dto.request.MatriculaRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.RequiredArgsConstructor;
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
    @PostMapping("/matricular")
    public void matricular(@RequestBody MatriculaRequestDTO request){
        estudianteCarreraService.matricular(
                request.getEstudiante(),
                request.getCarrera(),
                request.getInscripcion(),
                request.getGraduacion(),
                request.getAntiguedad());
    }
}

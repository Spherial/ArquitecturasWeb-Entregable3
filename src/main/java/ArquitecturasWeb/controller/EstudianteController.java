package ArquitecturasWeb.controller;

import ArquitecturasWeb.dto.EstudianteDTO;
import ArquitecturasWeb.entities.Estudiante;
import ArquitecturasWeb.services.EstudianteService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EstudianteController {

    private final EstudianteService estudianteService;


    @GetMapping("/estudiantes")
    public Iterable<EstudianteDTO> getEstudiantesApellidosAsc(){
        return estudianteService.getAllByOrderByApellidoAsc();
    }

    @JsonIgnoreProperties // ignora los campos que esten mal
    @GetMapping("/estudiantes/{lu}")
    public EstudianteDTO getEstudianteLU(@PathVariable int lu){
        return estudianteService.getEstudiantePorLU(lu);
    }

    @JsonIgnoreProperties
    @GetMapping("/estudiantes/genero/{genero}")
    public Iterable<EstudianteDTO> getEstudiantesByGenero(@PathVariable String genero){
        return estudianteService.getEstudiantePorGenero(genero);
    }

    @JsonIgnoreProperties
    @GetMapping("/estudiantes/buscarPorCampos")
    public Iterable<EstudianteDTO>buscarEstudiantesPorCampos(
             @RequestParam(required = false) String nombre,
             @RequestParam(required = false) String apellido,
             @RequestParam(required = false) Integer edad,
             @RequestParam(required = false) String genero,
             @RequestParam(required = false) String ciudad,
             @RequestParam(required = false) Integer LU){
        return estudianteService.buscarEstudiantesPorCampos(nombre, apellido, edad, genero, ciudad,LU);
    }

    @JsonIgnoreProperties
    @GetMapping("/estudiantes/{id}/{ciudad}")
    public Iterable<EstudianteDTO>getEstudiantesPorIdCarrera(
            @PathVariable @Validated int id,
            @PathVariable String ciudad){
        return estudianteService.getEstudiantesPorIdCarrera(id, ciudad);
    }

    @JsonIgnoreProperties
    @PostMapping("/estudiantes")
    public void insertEstudiante(@RequestBody @Validated Estudiante nuevoEstudiante){
        estudianteService.insertEstudiante(nuevoEstudiante);
    }


}

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
    @GetMapping("/buscarPorCampos")
    public Iterable<EstudianteDTO>buscarEstudiantesPorCampos(@RequestParam @Validated String nombre,String apellido,int edad, String genero,String ciudad, int LU ){
        return estudianteService.buscarEstudiantesPorCampos(nombre, apellido, edad, genero, ciudad,LU);
    }

    @JsonIgnoreProperties
    @GetMapping("/estudiantes/carrera/{idCarrera}")
    public Iterable<EstudianteDTO>getEstudiantesPorIdCarrera(@PathVariable int idCarrera){
        return estudianteService.getEstudiantesPorIdCarrera(idCarrera);
    }

    @JsonIgnoreProperties
    @PostMapping("/agregar")
    public void insertEstudiante(@RequestBody @Validated Estudiante nuevoEstudiante){//TODO: no deberian ser dtos?
        estudianteService.insertEstudiante(nuevoEstudiante);
    }


}

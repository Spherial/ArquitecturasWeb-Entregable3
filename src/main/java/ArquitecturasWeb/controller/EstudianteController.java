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
@RequestMapping("/estudiante")
@RequiredArgsConstructor
public class EstudianteController {

    @Autowired
    private final EstudianteService estudianteService;


    @GetMapping("/estudiantes")
    public Iterable<EstudianteDTO> getEstudiantesApellidosAsc(){
        return estudianteService.getAllByOrderByApellidoAsc();
    }

    @JsonIgnoreProperties // ignora los campos que esten mal
    @GetMapping("/LU")
    public EstudianteDTO getEstudianteLU(@RequestParam @Validated int LU){
        return estudianteService.getEstudiantePorLU(LU);
    }

    @JsonIgnoreProperties
    @GetMapping("/genero")
    public Iterable<EstudianteDTO> getEstudiantesByGenero(@RequestParam @Validated String genero){
        return estudianteService.getEstudiantePorGenero(genero);
    }

    @JsonIgnoreProperties
    @GetMapping("/buscarPorCampos")
    public Iterable<EstudianteDTO>buscarEstudiantesPorCampos(@RequestParam @Validated String nombre,String apellido,int edad, String genero,String ciudad, int LU ){
        return estudianteService.buscarEstudiantesPorCampos(nombre, apellido, edad, genero, ciudad,LU);
    }

    @JsonIgnoreProperties
    @GetMapping("/byIdCarrera")
    public Iterable<EstudianteDTO>getEstudiantesPorIdCarrera(@RequestParam @Validated int id){
        return estudianteService.getEstudiantesPorIdCarrera(id);
    }

    @JsonIgnoreProperties
    @PostMapping("/agregar")
    public void insertEstudiante(@RequestBody @Validated Estudiante nuevoEstudiante){//TODO: no deberian ser dtos?
        estudianteService.insertEstudiante(nuevoEstudiante);
    }


}

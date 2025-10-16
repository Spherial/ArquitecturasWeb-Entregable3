package ArquitecturasWeb.controller;

import ArquitecturasWeb.dto.EstudianteDTO;
import ArquitecturasWeb.entities.Estudiante;
import ArquitecturasWeb.services.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/id")
    public EstudianteDTO getEstudianteId(@RequestParam int id){
        return estudianteService.getEstudiantenId(id);

    }

    @PostMapping("/agregar")
    public void insertEstudiante(@RequestBody Estudiante nuevoEstudiante){//TODO: no deberian ser dtos?
        estudianteService.insertEstudiante(nuevoEstudiante);
    }


}

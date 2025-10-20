package ArquitecturasWeb.controller;

import ArquitecturasWeb.dto.CarreraDTO;
import ArquitecturasWeb.entities.Carrera;
import ArquitecturasWeb.services.CarreraService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarreraController {

    private final CarreraService carreraService;

    @GetMapping("/inscriptos")
    public Iterable<CarreraDTO> getCarrerasConInscriptos(){
        return carreraService.getIncriptos();
    }

    @PostMapping("/carreras")
    public void insertarCarrera(@RequestBody Carrera nuevaCarrera){
        carreraService.insert(nuevaCarrera);
    }


}

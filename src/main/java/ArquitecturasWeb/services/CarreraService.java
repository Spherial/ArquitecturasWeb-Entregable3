package ArquitecturasWeb.services;

import ArquitecturasWeb.dto.CarreraDTO;
import ArquitecturasWeb.entities.Carrera;
import ArquitecturasWeb.repository.CarreraRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarreraService {

    private final CarreraRepository carreraRepository;


    public List<Carrera> getAll(){
        return carreraRepository.findAll();
    }

    @Transactional
    public void insert(Carrera nuevaCarrera){
        carreraRepository.save(nuevaCarrera);
    }

    public List<CarreraDTO>getIncriptos(){
        return carreraRepository.getInscriptos();
    }


}

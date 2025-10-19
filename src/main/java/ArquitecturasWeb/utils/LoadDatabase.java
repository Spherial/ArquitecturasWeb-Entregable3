package ArquitecturasWeb.utils;


import ArquitecturasWeb.entities.Carrera;
import ArquitecturasWeb.entities.Estudiante;
import ArquitecturasWeb.entities.EstudianteCarrera;
import ArquitecturasWeb.repository.CarreraRepository;
import ArquitecturasWeb.repository.EstudianteCarreraRepository;
import ArquitecturasWeb.repository.EstudianteRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(
            EstudianteRepository estudianteRepo,
            CarreraRepository carreraRepo,
            EstudianteCarreraRepository estudianteCarreraRepo
    ) {
        return args -> {
            cargarEstudiantes(estudianteRepo);
            cargarCarreras(carreraRepo);
            cargarEstudianteCarrera(estudianteCarreraRepo, estudianteRepo, carreraRepo);
            log.info("Base de datos inicializada correctamente desde CSV.");
        };
    }

    private void cargarEstudiantes(EstudianteRepository repo) {
        String ruta = "data/estudiantes.csv";

        for (CSVRecord record : LectorCSV.leerCSV(ruta)) {
            Estudiante e = new Estudiante(
                    Integer.parseInt(record.get("DNI")),
                    record.get("nombre"),
                    record.get("apellido"),
                    Integer.parseInt(record.get("edad")),
                    record.get("genero"),
                    record.get("ciudad"),
                    Integer.parseInt(record.get("LU"))
            );
            repo.save(e);
        }
        log.info("Estudiantes insertados.");
    }

    private void cargarCarreras(CarreraRepository repo) {
        String ruta = "data/carreras.csv";

        for (CSVRecord record : LectorCSV.leerCSV(ruta)) {
            Carrera c = new Carrera(
                    Integer.parseInt(record.get("id_carrera")),
                    record.get("carrera"),
                    Integer.parseInt(record.get("duracion"))
            );
            repo.save(c);
        }
        log.info("Carreras insertadas.");
    }

    private void cargarEstudianteCarrera(EstudianteCarreraRepository repo,
                                         EstudianteRepository estudianteRepo,
                                         CarreraRepository carreraRepo) {
        String ruta = "data/estudianteCarrera.csv";

        for (CSVRecord record : LectorCSV.leerCSV(ruta)) {
            Estudiante estudiante = estudianteRepo.findById(Long.parseLong(record.get("id_estudiante"))).orElse(null);
            Carrera carrera = carreraRepo.findById(Long.parseLong(record.get("id_carrera"))).orElse(null);

            if (estudiante == null || carrera == null) {
                log.warn("No se encontró estudiante o carrera para el registro: {}", record);
                continue;
            }

            EstudianteCarrera ec = new EstudianteCarrera(
                    estudiante,
                    carrera,
                    Integer.parseInt(record.get("inscripcion")),
                    Integer.parseInt(record.get("graduacion")),
                    Integer.parseInt(record.get("antiguedad"))
            );

            repo.save(ec);
        }

        log.info("Relaciones Estudiante–Carrera insertadas.");
    }
}

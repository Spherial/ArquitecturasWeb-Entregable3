package ArquitecturasWeb.dto.request;

import ArquitecturasWeb.entities.Carrera;
import ArquitecturasWeb.entities.Estudiante;

public class MatriculaRequestDTO {
    private Estudiante estudiante;
    private Carrera carrera;
    private int inscripcion;
    private int graduacion;
    private int antiguedad;

    public MatriculaRequestDTO(Estudiante estudiante, int antiguedad, int graduacion, int inscripcion, Carrera carrera) {
        this.estudiante = estudiante;
        this.antiguedad = antiguedad;
        this.graduacion = graduacion;
        this.inscripcion = inscripcion;
        this.carrera = carrera;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public int getGraduacion() {
        return graduacion;
    }

    public int getInscripcion() {
        return inscripcion;
    }

    public Carrera getCarrera() {
        return carrera;
    }
}

package ArquitecturasWeb.dto;

public class ReporteDTO {
    private String nombreCarrera;
    private long cantidadInscriptos;
    private long cantidadEgresados;
    private int anio;

    public ReporteDTO(String nombreCarrera, long cantidadInscriptos, long cantidadEgresados, int anio) {
        this.nombreCarrera = nombreCarrera;
        this.cantidadInscriptos = cantidadInscriptos;
        this.cantidadEgresados = cantidadEgresados;
        this.anio = anio;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public long getCantidadInscriptos() {
        return cantidadInscriptos;
    }

    public void setCantidadInscriptos(long cantidadInscriptos) {
        this.cantidadInscriptos = cantidadInscriptos;
    }

    public long getCantidadEgresados() {
        return cantidadEgresados;
    }

    public void setCantidadEgresados(long cantidadEgresados) {
        this.cantidadEgresados = cantidadEgresados;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}

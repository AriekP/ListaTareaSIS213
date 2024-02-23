import java.time.*;
public class Tarea {

    private String descripcion;
    private LocalDate fecha;
    private LocalTime hInicio,hFin;
    private String Estado;

    public Tarea(LocalDate fecha, String descripcion,LocalTime hInicio,LocalTime hFin) {
        this.descripcion = descripcion;
        this.fecha=fecha;
        this.hFin=hFin;
        this.hInicio=hInicio;
        this.Estado="Nueva";
    }
    

    public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public LocalTime gethInicio() {
		return hInicio;
	}


	public void sethInicio(LocalTime hInicio) {
		this.hInicio = hInicio;
	}


	public LocalTime gethFin() {
		return hFin;
	}


	public void sethFin(LocalTime hFin) {
		this.hFin = hFin;
	}


	public String getEstado() {
		return Estado;
	}


	public void setEstado(String estado) {
		Estado = estado;
	}
	public void marcarEnCurso() {
		this.Estado="En Curso";
	}
	public void marcarCompletada() {
		this.Estado="Completada";
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getDescripcion() {
        return descripcion;
    }


	@Override
	public String toString() {
		return "Tarea [descripcion=" + descripcion + ", fecha=" + fecha + ", hInicio=" + hInicio + ", hFin=" + hFin
				+ ", Estado=" + Estado + "]";
	}

    

}

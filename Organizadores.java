
public class Organizadores {
	
	  private String descripcion;

	    public void Tarea(String descripcion) {
	        this.descripcion = descripcion;
	    }

	    public String getDescripcion() {
	        return descripcion;
	    }

	    @Override
	    public String toString() {
	        return descripcion;
	    }

}

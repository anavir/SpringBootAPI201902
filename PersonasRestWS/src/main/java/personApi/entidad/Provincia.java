package personApi.entidad;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name="provincias")
public class Provincia {
	
	@Id
	int idProvincia;
	String nombre;
	String region;
	
	public Provincia() {
		
	}
	public Provincia(int idProvincia, String nombre, String region) {
		super();
		this.idProvincia = idProvincia;
		this.nombre = nombre;
		this.region = region;
	}
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
}

package personApi.entidad;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="personas")
public class Persona {
	
	@EmbeddedId
	private PersonaPK personaId;
	private String nombreApellido;
	private String fechaNacimiento;
	private char genero;
	private boolean esArgentino;
	private String correoElectronico;
	private int idLocalidad;
	private String codigoPostal;
	
	public PersonaPK getPersonaId() {
		return personaId;
	}
	public void setPersonaId(PersonaPK personaId) {
		this.personaId = personaId;
	}
	public String getNombreApellido() {
		return nombreApellido;
	}
	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	public boolean isEsArgentino() {
		return esArgentino;
	}
	public void setEsArgentino(boolean esArgentino) {
		this.esArgentino = esArgentino;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public int getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
}

package personApi.entidad;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_documentos")
public class TipoDocumento {
	
	@Id
	private int idTipodocumento;
	private String nombre;
	private String abreviatura;
	private boolean validarComoCuit;
	
	public int getIdTipodocumento() {
		return idTipodocumento;
	}
	public void setIdTipodocumento(int idTipodocumento) {
		this.idTipodocumento = idTipodocumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	public boolean isValidarComoCuit() {
		return validarComoCuit;
	}
	public void setValidarComoCuit(boolean validarComoCuit) {
		this.validarComoCuit = validarComoCuit;
	}
}

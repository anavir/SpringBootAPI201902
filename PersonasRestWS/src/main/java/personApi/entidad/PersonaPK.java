package personApi.entidad;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PersonaPK implements Serializable {
	
	private static final long serialVersionUID = -7260052797976850887L;
	private int idTipodocumento;
	private int numeroDocumento;
	
	public int getTipoDocumento() {
		return idTipodocumento;
	}
	public void setTipoDocumento(int tipoDocumento) {
		this.idTipodocumento = tipoDocumento;
	}
	public int getNroDocumento() {
		return numeroDocumento;
	}
	public void setNroDocumento(int nroDocumento) {
		this.numeroDocumento = nroDocumento;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroDocumento;
		result = prime * result + idTipodocumento;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaPK other = (PersonaPK) obj;
		if (numeroDocumento != other.numeroDocumento)
			return false;
		if (idTipodocumento != other.idTipodocumento)
			return false;
		return true;
	}
}

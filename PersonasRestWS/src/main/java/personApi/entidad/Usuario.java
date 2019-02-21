package personApi.entidad;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@EmbeddedId
	private PersonaPK personaId;
	private String nombreUsuario;
	private String hashedPwd;
	
	public PersonaPK getPersonaId() {
		return personaId;
	}
	public void setPersonaId(PersonaPK personaId) {
		this.personaId = personaId;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getHashedPwd() {
		return hashedPwd;
	}
	public void setHashedPwd(String hashedPwd) {
		this.hashedPwd = hashedPwd;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hashedPwd == null) ? 0 : hashedPwd.hashCode());
		result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (hashedPwd == null) {
			if (other.hashedPwd != null)
				return false;
		} else if (!hashedPwd.equals(other.hashedPwd))
			return false;
		if (nombreUsuario == null) {
			if (other.nombreUsuario != null)
				return false;
		} else if (!nombreUsuario.equals(other.nombreUsuario))
			return false;
		return true;
	}
	
	
}

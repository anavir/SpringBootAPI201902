package personApi.servicio;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personApi.dao.PersonaDAO;
import personApi.entidad.Generos;
import personApi.entidad.Persona;
import personApi.entidad.PersonaPK;

@Service
public class PersonaServicio {

	@Autowired
	private PersonaDAO repository;

	public Iterable<Persona> listarPersonas() {
		return repository.findAll();
	}

	public String guardarPersona(Persona persona) {
		String erroresValidacionPersona = validarPersona(persona);
		if (erroresValidacionPersona.isEmpty()) {
			return persistirPersona(persona);
		} else
			return erroresValidacionPersona;
	}

	public String actualizarPersona(Persona persona) {
		String erroresValidacionPersona = validarPersona(persona);
		if (erroresValidacionPersona.isEmpty()) {
			return persistirPersona(persona);
		} else
			return erroresValidacionPersona;
	}

	private String validarPersona(Persona persona) {
		if (Arrays.stream(Generos.values()).anyMatch((t) -> t.name().equals(String.valueOf(persona.getGenero()))))
			return "";
		else
			return "Error agregando la persona. El género solo puede ser M o F.";
	}

	private String persistirPersona(Persona persona) {
		try {
			repository.save(persona);
			return "Persona guardada.";
		} catch (Exception e) {
			return "Error guardando la persona: " + e.getMessage();
		}
	}

	public Optional<Persona> obtenerPersona(int id, int numero) {
		return repository.findById(getPersonaPK(id, numero));
	}

	public String eliminarPersona(int id, int numero) {
		repository.deleteById(getPersonaPK(id, numero));
		return "Persona eliminada.";
	}

	private PersonaPK getPersonaPK(int idTipodocumento, int numeroDocumento) {
		PersonaPK personaPK = new PersonaPK();
		personaPK.setTipoDocumento(idTipodocumento);
		personaPK.setNroDocumento(numeroDocumento);
		return personaPK;
	}
}

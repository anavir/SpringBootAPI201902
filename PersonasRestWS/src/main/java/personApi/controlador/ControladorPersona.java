package personApi.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import personApi.entidad.Persona;
import personApi.servicio.PersonaServicio;

@RestController
public class ControladorPersona {

	@Autowired
	private PersonaServicio personaServicio;

	@RequestMapping(value = "persona", method = RequestMethod.GET)
	public Iterable<Persona> list() {
		return personaServicio.listarPersonas();
	}

	@RequestMapping(value = "persona", method = RequestMethod.POST)
	public @ResponseBody String create(@RequestBody Persona persona) {
		return personaServicio.guardarPersona(persona);
	}

	@RequestMapping(value = "persona/{id}/{numero}", method = RequestMethod.GET)
	public Optional<Persona> get(@PathVariable int id, @PathVariable int numero) {
		return personaServicio.obtenerPersona(id, numero);
	}

	@RequestMapping(value = "persona/{id}/{numero}", method = RequestMethod.PUT)
	public String update(@PathVariable int id, @PathVariable int numero, @RequestBody Persona persona) {
		return personaServicio.guardarPersona(persona);
	}

	@RequestMapping(value = "persona/{id}/{numero}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int id, @PathVariable int numero) {
		return personaServicio.eliminarPersona(id, numero);
	}
}

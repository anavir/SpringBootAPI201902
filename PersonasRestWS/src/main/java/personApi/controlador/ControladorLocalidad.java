package personApi.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import personApi.entidad.Localidad;
import personApi.servicio.LocalidadServicio;

@RestController
public class ControladorLocalidad {

	@Autowired
	private LocalidadServicio localidadServicio;

	@RequestMapping(value = "localidad", method = RequestMethod.GET)
	public Iterable<Localidad> list() {
		return localidadServicio.listadoLocalidades();
	}

	@RequestMapping(value = "localidad", method = RequestMethod.POST)
	public @ResponseBody String create(@RequestBody Localidad localidad) {
		return localidadServicio.guardarLocalidad(localidad);
	}

	@RequestMapping(value = "localidad/{id}", method = RequestMethod.GET)
	public Optional<Localidad> get(@PathVariable int id) {
		return localidadServicio.obtenerLocalidad(id);
	}

	@RequestMapping(value = "localidad/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable int id, @RequestBody Localidad localidad) {
		return localidadServicio.actualizarLocalidad(localidad);
	}

	@RequestMapping(value = "localidad/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int id) {
		return localidadServicio.eliminarLocalidad(id);
	}
}

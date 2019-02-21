package personApi.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import personApi.entidad.Provincia;
import personApi.servicio.ProvinciaServicio;

@RestController
public class ControladorProvincia {

	@Autowired
	private ProvinciaServicio provinciaServicio;

	@RequestMapping(value = "provincia", method = RequestMethod.GET)
	public Iterable<Provincia> list() {
		return provinciaServicio.listadoProvincias();
	}

	@RequestMapping(value = "provincia", method = RequestMethod.POST)
	public @ResponseBody String create(@RequestBody Provincia provincia) {
		return provinciaServicio.guardarProvincia(provincia);
	}

	@RequestMapping(value = "provincia/{id}", method = RequestMethod.GET)
	public Optional<Provincia> get(@PathVariable int id) {
		return provinciaServicio.obtenerProvincia(id);
	}

	@RequestMapping(value = "provincia/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable int id, @RequestBody Provincia provincia) {
		return provinciaServicio.actualizarProvincia(provincia);
	}

	@RequestMapping(value = "provincia/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int id) {
		return provinciaServicio.eliminarProvincia(id);
	}

}

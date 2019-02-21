package personApi.servicio;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personApi.dao.LocalidadDAO;
import personApi.entidad.Localidad;

@Service
public class LocalidadServicio {
	@Autowired
	private LocalidadDAO repository;

	public Iterable<Localidad> listadoLocalidades() {
		return repository.findAll();
	}

	public String guardarLocalidad(Localidad localidad) {
		try {
			repository.save(localidad);
			return "Localidad guardada.";
		} catch (Exception e) {
			return "Error guardando la localidad: " + e.getMessage();
		}
	}

	public String actualizarLocalidad(Localidad localidad) {
		try {
			repository.save(localidad);
			return "Localidad guardada.";
		} catch (Exception e) {
			return "Error guardando la localidad: " + e.getMessage();
		}
	}

	public Optional<Localidad> obtenerLocalidad(int id) {
		return repository.findById(id);
	}

	public String eliminarLocalidad(int id) {
		repository.deleteById(id);
		return "Eliminado";
	}

}

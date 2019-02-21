package personApi.servicio;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personApi.dao.ProvinciaDAO;
import personApi.entidad.Provincia;
import personApi.entidad.Regiones;

@Service
public class ProvinciaServicio {

	@Autowired
	private ProvinciaDAO repository;

	public Iterable<Provincia> listadoProvincias() {
		return repository.findAll();
	}

	public String guardarProvincia(Provincia provincia) {
		String erroresValidacionProvincia = validarProvincia(provincia);
		if (erroresValidacionProvincia.isEmpty()) {
			return persistirProvincia(provincia);
		} else
			return erroresValidacionProvincia;
	}

	public String actualizarProvincia(Provincia provincia) {
		String erroresValidacionProvincia = validarProvincia(provincia);
		if (erroresValidacionProvincia.isEmpty()) {
			return persistirProvincia(provincia);
		} else
			return erroresValidacionProvincia;
	}

	private String validarProvincia(Provincia provincia) {
		if (Arrays.stream(Regiones.values()).anyMatch((t) -> t.name().equals(String.valueOf(provincia.getRegion()))))
			return "";
		else
			return "Error agregando la provincia. La región solo puede ser: NOA, NEA, CUY, PAM, GBA o PAT";
	}

	private String persistirProvincia(Provincia provincia) {
		try {
			repository.save(provincia);
			return "Provincia guardada.";
		} catch (Exception e) {
			return "Error guardando la provincia: " + e.getMessage();
		}
	}

	public Optional<Provincia> obtenerProvincia(int id) {
		return repository.findById(id);
	}

	public String eliminarProvincia(int id) {
		repository.deleteById(id);
		return "Eliminado";
	}

}

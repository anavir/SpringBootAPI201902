package personApi.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personApi.dao.TipoDocumentoDAO;
import personApi.entidad.TipoDocumento;

@Service
public class TipoDocumentoServicio {

	@Autowired
	private TipoDocumentoDAO repository;

	public Iterable<TipoDocumento> listadoTipoDocumentos() {
		return repository.findAll();
	}

	public String guardarTipoDocumento(TipoDocumento tipoDocumento) {
		try {
			repository.save(tipoDocumento);
			return "TipoDocumento guardado.";
		} catch (Exception e) {
			return "Error guardando el Tipo de Documento: " + e.getMessage();
		}
	}

	public String actualizarTipoDocumento(TipoDocumento tipoDocumento) {
		try {
			repository.save(tipoDocumento);
			return "TipoDocumento guardado.";
		} catch (Exception e) {
			return "Error guardando el Tipo de Documento: " + e.getMessage();
		}
	}

	public Optional<TipoDocumento> obtenerTipoDocumento(int id) {
		return repository.findById(id);
	}

	public String eliminarTipoDocumento(int id) {
		repository.deleteById(id);
		return "Eliminado";
	}
}

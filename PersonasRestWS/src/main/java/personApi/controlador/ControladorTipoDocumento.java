package personApi.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import personApi.entidad.TipoDocumento;
import personApi.servicio.TipoDocumentoServicio;

@RestController
public class ControladorTipoDocumento {

	@Autowired
	private TipoDocumentoServicio tipoDocumentoServicio;

	@RequestMapping(value = "tipoDocumento", method = RequestMethod.GET)
	public Iterable<TipoDocumento> list() {
		return tipoDocumentoServicio.listadoTipoDocumentos();
	}

	@RequestMapping(value = "tipoDocumento", method = RequestMethod.POST)
	public @ResponseBody String create(@RequestBody TipoDocumento tipoDocumento) {
		return tipoDocumentoServicio.guardarTipoDocumento(tipoDocumento);
	}

	@RequestMapping(value = "tipoDocumento/{idTipodocumento}", method = RequestMethod.GET)
	public Optional<TipoDocumento> get(@PathVariable int idTipodocumento) {
		return tipoDocumentoServicio.obtenerTipoDocumento(idTipodocumento);
	}

	@RequestMapping(value = "tipoDocumento/{idTipodocumento}", method = RequestMethod.PUT)
	public String update(@PathVariable int idTipodocumento, @RequestBody TipoDocumento tipoDocumento) {
		return tipoDocumentoServicio.actualizarTipoDocumento(tipoDocumento);
	}

	@RequestMapping(value = "tipoDocumento/{idTipodocumento}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int idTipodocumento) {
		return tipoDocumentoServicio.eliminarTipoDocumento(idTipodocumento);
	}

}

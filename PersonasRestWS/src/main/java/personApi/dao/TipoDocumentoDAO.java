package personApi.dao;

import org.springframework.data.repository.CrudRepository;
import personApi.entidad.TipoDocumento;

public interface TipoDocumentoDAO extends CrudRepository<TipoDocumento, Integer> {

}

package personApi.dao;

import org.springframework.data.repository.CrudRepository;

import personApi.entidad.Persona;
import personApi.entidad.PersonaPK;

public interface PersonaDAO extends CrudRepository<Persona, PersonaPK> {
}

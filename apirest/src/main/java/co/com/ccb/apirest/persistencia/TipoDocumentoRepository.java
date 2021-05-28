package co.com.ccb.apirest.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.ccb.apirest.model.seguridad.TipoDocumento;


@Repository
public interface TipoDocumentoRepository extends CrudRepository<TipoDocumento, Long> {

}

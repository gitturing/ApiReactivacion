package co.com.ccb.apirest.persistencia;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.ccb.apirest.model.seguridad.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

	@Query(value = " SELECT * FROM  usuario u WHERE u.email = ?1", nativeQuery = true)
	Usuario findByEmail(String nombreUsuario);

}

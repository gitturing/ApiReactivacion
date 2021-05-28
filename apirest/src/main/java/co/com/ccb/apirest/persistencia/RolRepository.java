package co.com.ccb.apirest.persistencia;

import org.springframework.data.repository.CrudRepository;

import co.com.ccb.apirest.model.seguridad.Rol;

public interface RolRepository extends CrudRepository<Rol, Integer>{
}

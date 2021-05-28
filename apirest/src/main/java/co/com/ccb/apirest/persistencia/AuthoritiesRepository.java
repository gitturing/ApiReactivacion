package co.com.ccb.apirest.persistencia;


import org.springframework.data.repository.CrudRepository;

import co.com.ccb.apirest.model.seguridad.UsersAuthorities;

public interface AuthoritiesRepository extends CrudRepository<UsersAuthorities, Integer>{

}

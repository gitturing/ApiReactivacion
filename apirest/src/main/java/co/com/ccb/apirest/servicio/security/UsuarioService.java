package co.com.ccb.apirest.servicio.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.com.ccb.apirest.model.seguridad.Rol;
import co.com.ccb.apirest.model.seguridad.UsersAuthorities;
import co.com.ccb.apirest.model.seguridad.Usuario;
import co.com.ccb.apirest.persistencia.AuthoritiesRepository;
import co.com.ccb.apirest.persistencia.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username);
		List<GrantedAuthority> authorities = usuario.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRol().getNombreRol())).collect(Collectors.toList());
		return new User(username, usuario.getPassword(), true, true, true, true, authorities);
	}

}

package co.com.ccb.apirest.servicio.security;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.com.ccb.apirest.model.seguridad.Empresa;
import co.com.ccb.apirest.model.seguridad.Rol;
import co.com.ccb.apirest.model.seguridad.UsersAuthorities;
import co.com.ccb.apirest.model.seguridad.Usuario;
import co.com.ccb.apirest.persistencia.AuthoritiesRepository;
import co.com.ccb.apirest.persistencia.EmpresaRepository;
import co.com.ccb.apirest.persistencia.RolRepository;
import co.com.ccb.apirest.persistencia.UsuarioRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private AuthoritiesRepository auteService;

	@Transactional
	public Empresa saveEmpresa(Empresa empresa) {
		Empresa guardarEmpresa = empresaRepository.save(empresa);
		if (guardarEmpresa.getIdEmpresa() != null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String password =passwordEncoder.encode(empresa.getNumeroDocumento());
			
			Usuario usuario = Usuario.builder().nombreUsuario(guardarEmpresa.getRazonSocial())
					.email(guardarEmpresa.getCorreo()).password(password).confirmarPassword(password).build();

			Usuario usuarioReturn = saveUsuario(usuario);

			List<Rol> roles = (List<Rol>) rolRepository.findAll();

			Rol rolesSave = (Rol) roles.stream().filter(x -> x.getCodigo().equals("emp")).findFirst().get();

			UsersAuthorities rolUser = UsersAuthorities.builder().usuario(usuarioReturn).rol(rolesSave).build();

			saveRolUsuario(rolUser);

		}

		return guardarEmpresa;
	}

	public List<Empresa> listarEmpresas() {
		return (List<Empresa>) empresaRepository.findAll();
	}

	@Transactional
	public Empresa actualizarEmpresa(Long id, Empresa empresa) {
		Optional<Empresa> empresaConsultar = empresaRepository.findById(id);
		if (empresaConsultar.isPresent()) {
			return empresaRepository.save(empresa);
		} else {
			return null;
		}
	}

	@Transactional
	public Long delete(long id) {
		Optional<Empresa> empresa = empresaRepository.findById(id);
		if (empresa.isPresent()) {
			empresaRepository.delete(empresa.get());
			return empresa.get().getIdEmpresa();
		} else {
			return null;
		}

	}

	private Usuario saveUsuario(Usuario usuario) {
		Usuario usuario2 = usuarioRepository.save(usuario);
		return usuario2;

	}

	public void saveRolUsuario(UsersAuthorities rol) {
		auteService.save(rol);
	}
	

}

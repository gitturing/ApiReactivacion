package co.com.ccb.apirest.servicio.security;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ccb.apirest.model.seguridad.TipoEntidad;
import co.com.ccb.apirest.persistencia.EntidadRepository;


@Service
public class TipoEntidadService {

	@Autowired
	private EntidadRepository entidadRepository;

	@Transactional
	public List<TipoEntidad> getAll() {
		List<TipoEntidad> tipoEntidad = (List<TipoEntidad>) entidadRepository.findAll();
		return tipoEntidad;
	}

	@Transactional
	public TipoEntidad save(TipoEntidad tipoEntidad) {
		TipoEntidad tipoEntidadRes = entidadRepository.save(tipoEntidad);
		return tipoEntidadRes;
	}

	@Transactional
	public Long delete(long id) {
		Optional<TipoEntidad> tipoEntidad = entidadRepository.findById(id);
		if (tipoEntidad.isPresent()) {
			entidadRepository.delete(tipoEntidad.get());
			return tipoEntidad.get().getId_Entidad();
		} else {
			return null;
		}

	}

	@Transactional
	public TipoEntidad actualizarEntidad(Long id, TipoEntidad tipoEntidad) {
		Optional<TipoEntidad> entidadConsultar = entidadRepository.findById(id);
		if (entidadConsultar.isPresent()) {
			return entidadRepository.save(tipoEntidad);
		} else {
			return null;
		}
	}
}

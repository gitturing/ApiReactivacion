package co.com.ccb.apirest.servicio.security;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ccb.apirest.model.seguridad.Aseguradora;
import co.com.ccb.apirest.persistencia.AseguradoraRepository;


@Service
public class AseguradoraService {

	@Autowired
	private AseguradoraRepository aseguradoraRepository;

	@Transactional
	public List<Aseguradora> getAll() {
		List<Aseguradora> aseguradora = (List<Aseguradora>) aseguradoraRepository.findAll();
		return aseguradora;
	}

	@Transactional
	public Aseguradora save(Aseguradora aseguradora) {
		Aseguradora aseguradoraConsulta = aseguradoraRepository.save(aseguradora);
		return aseguradoraConsulta;
	}
	@Transactional
	public Long delete(long id) {
		Optional<Aseguradora> asegura = aseguradoraRepository.findById(id);
		if (asegura.isPresent()) {
			aseguradoraRepository.delete(asegura.get());
			return asegura.get().getIdAseguradora();
		} else {
			return null;
		}

	}

	@Transactional
	public Aseguradora actualizarAseguradora(Long id, Aseguradora aseguradora) {
		Optional<Aseguradora> AseguradoraConsultar = aseguradoraRepository.findById(id);
		if (AseguradoraConsultar.isPresent()) {
			return aseguradoraRepository.save(aseguradora);
		} else {
			return null;
		}
	}
}

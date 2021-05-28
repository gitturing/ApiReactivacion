package co.com.ccb.apirest.servicio.security;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ccb.apirest.model.seguridad.Eps;
import co.com.ccb.apirest.persistencia.EpsRepository;


@Service
public class EpsService {

	@Autowired
	private EpsRepository epsRepository;

	@Transactional
	public List<Eps> getAll() {
		List<Eps> eps = (List<Eps>) epsRepository.findAll();
		return eps;
	}

	@Transactional
	public Eps save(Eps eps) {
		Eps epsRes = epsRepository.save(eps);
		return epsRes;
	}

	@Transactional
	public Long delete(long id) {
		Optional<Eps> epsEnty = epsRepository.findById(id);
		if (epsEnty.isPresent()) {
			epsRepository.delete(epsEnty.get());
			return epsEnty.get().getIdEps();
		} else {
			return null;
		}

	}

	@Transactional
	public Eps actualizarEps(Long id, Eps eps) {
		Optional<Eps> epsConsultar = epsRepository.findById(id);
		if (epsConsultar.isPresent()) {
			return epsRepository.save(eps);
		} else {
			return null;
		}
	}
}

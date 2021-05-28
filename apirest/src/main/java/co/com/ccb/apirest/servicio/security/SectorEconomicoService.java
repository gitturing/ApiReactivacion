package co.com.ccb.apirest.servicio.security;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ccb.apirest.model.seguridad.SectorEconomico;
import co.com.ccb.apirest.persistencia.SectorEconomicoRepository;


@Service
public class SectorEconomicoService {

	@Autowired
	private SectorEconomicoRepository sectorEconomicoRepository;

	@Transactional
	public List<SectorEconomico> getAll() {
		List<SectorEconomico> sector = (List<SectorEconomico>) sectorEconomicoRepository.findAll();
		return sector;
	}

	@Transactional
	public SectorEconomico save(SectorEconomico sectorEconomico) {
		SectorEconomico sectorReturn = sectorEconomicoRepository.save(sectorEconomico);
		return sectorReturn;
	}

	@Transactional
	public Long delete(long id) {
		Optional<SectorEconomico> sector = sectorEconomicoRepository.findById(id);
		if (sector.isPresent()) {
			sectorEconomicoRepository.delete(sector.get());
			return sector.get().getIdSector();
		} else {
			return null;
		}

	}

	@Transactional
	public SectorEconomico actualizarSector(Long id, SectorEconomico sectorUpdate) {
		Optional<SectorEconomico> sectorConsultar = sectorEconomicoRepository.findById(id);
		if (sectorConsultar.isPresent()) {
			return sectorEconomicoRepository.save(sectorUpdate);
		} else {
			return null;
		}
	}
}

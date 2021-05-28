package co.com.ccb.apirest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ccb.apirest.model.seguridad.SectorEconomico;
import co.com.ccb.apirest.servicio.security.SectorEconomicoService;


@RestController
@RequestMapping("api/v1/sectorEconomico")
public class SectorEconomicoController {

	@Autowired
	private SectorEconomicoService sectorEconomicoService;

	@GetMapping()
	public ResponseEntity<List<SectorEconomico>> Listar() {
		List<SectorEconomico> listSector = sectorEconomicoService.getAll();
		return new ResponseEntity<>(listSector, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<SectorEconomico> crearSector(@Valid @RequestBody SectorEconomico economico) {
		SectorEconomico sectorGuardar = sectorEconomicoService.save(economico);
		return new ResponseEntity<>(sectorGuardar, HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{idSector}")
	public ResponseEntity<Long> eliminarSector(@PathVariable Long idSector) {
		long idEliminado = sectorEconomicoService.delete(idSector);
		return new ResponseEntity<>(idEliminado, HttpStatus.OK);
	}

	@PutMapping("/editar/{idSector}")
	public ResponseEntity<SectorEconomico> actualizarTipoDocumento(@PathVariable Long idSector,
			@RequestBody SectorEconomico sector) {
		SectorEconomico sectorUpdate = sectorEconomicoService.actualizarSector(idSector, sector);
		return new ResponseEntity<>(sectorUpdate, HttpStatus.OK);
	}

}

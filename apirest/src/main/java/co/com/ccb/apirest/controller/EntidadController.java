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

import co.com.ccb.apirest.model.seguridad.TipoEntidad;
import co.com.ccb.apirest.servicio.security.TipoEntidadService;

@RestController
@RequestMapping("api/v1/tipoEntidad")
public class EntidadController {
	
	@Autowired
	private TipoEntidadService entidadService;

	@GetMapping()
	public ResponseEntity<List<TipoEntidad>> Listar() {
		List<TipoEntidad> tipoEntidad = entidadService.getAll();
		return new ResponseEntity<>(tipoEntidad, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<TipoEntidad> crearTipoEntidad(@Valid @RequestBody TipoEntidad tipoEntidad) {
		TipoEntidad entidadGuardar = entidadService.save(tipoEntidad);
		return new ResponseEntity<>(entidadGuardar, HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{idEntidad}")
	public ResponseEntity<Long> actualizarEntidad(@PathVariable Long idEntidad) {
		long idEliminado = entidadService.delete(idEntidad);
		return new ResponseEntity<>(idEliminado, HttpStatus.OK);
	}

	@PutMapping("/editar/{idEntidad}")
	public ResponseEntity<TipoEntidad> actualizar(@PathVariable Long idEntidad,
			@RequestBody TipoEntidad entidad) {
		TipoEntidad entidadUpdate = entidadService.actualizarEntidad(idEntidad, entidad);
		return new ResponseEntity<>(entidadUpdate, HttpStatus.OK);
	}
	
}

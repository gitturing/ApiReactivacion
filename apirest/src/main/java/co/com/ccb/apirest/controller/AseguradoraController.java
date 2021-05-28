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

import co.com.ccb.apirest.model.seguridad.Aseguradora;
import co.com.ccb.apirest.servicio.security.AseguradoraService;


@RestController
@RequestMapping("api/v1/aseguradora")
public class AseguradoraController {
	
	@Autowired
	private AseguradoraService aseguradoraService;

	@GetMapping()
	public ResponseEntity<List<Aseguradora>> Listar() {
		List<Aseguradora> aseguradora = aseguradoraService.getAll();
		return new ResponseEntity<>(aseguradora, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Aseguradora> crearAseguradora(@Valid @RequestBody Aseguradora aseguradora) {
		Aseguradora aseguradoraGuardar = aseguradoraService.save(aseguradora);
		return new ResponseEntity<>(aseguradoraGuardar, HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{idAseguradora}")
	public ResponseEntity<Long> eliminarAseguradora(@PathVariable Long idAseguradora) {
		long idEliminado = aseguradoraService.delete(idAseguradora);
		return new ResponseEntity<>(idEliminado, HttpStatus.OK);
	}

	@PutMapping("/editar/{idAseguradora}")
	public ResponseEntity<Aseguradora> editarEntidad(@PathVariable Long idAseguradora,
			@RequestBody Aseguradora aseguradora) {
		Aseguradora AseguradoraUpdate = aseguradoraService.actualizarAseguradora(idAseguradora, aseguradora);
		return new ResponseEntity<>(AseguradoraUpdate, HttpStatus.OK);
	}
	
}

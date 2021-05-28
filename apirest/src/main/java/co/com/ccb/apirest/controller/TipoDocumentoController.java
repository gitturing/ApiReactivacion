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

import co.com.ccb.apirest.model.seguridad.TipoDocumento;
import co.com.ccb.apirest.servicio.security.TipoDocumentoService;


@RestController
@RequestMapping("api/v1/tipoDocumento")
public class TipoDocumentoController {

	@Autowired
	private TipoDocumentoService documentoService;

	@GetMapping()
	public ResponseEntity<List<TipoDocumento>> Listar() {
		List<TipoDocumento> documentos = documentoService.getAll();
		return new ResponseEntity<>(documentos, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<TipoDocumento> crearTipoDocumento(@Valid @RequestBody TipoDocumento documento) {
		TipoDocumento documentoGuardar = documentoService.save(documento);
		return new ResponseEntity<>(documentoGuardar, HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{idTipoDocumento}")
	public ResponseEntity<Long> eliminarDocumento(@PathVariable Long idTipoDocumento) {
		long idEliminado = documentoService.delete(idTipoDocumento);
		return new ResponseEntity<>(idEliminado, HttpStatus.OK);
	}

	@PutMapping("/editar/{idTipoDocumento}")
	public ResponseEntity<TipoDocumento> actualizarTipoDocumento(@PathVariable Long idTipoDocumento,
			@RequestBody TipoDocumento documento) {
		TipoDocumento documentoUpdate = documentoService.actualizarDocumento(idTipoDocumento, documento);
		return new ResponseEntity<>(documentoUpdate, HttpStatus.OK);
	}

}

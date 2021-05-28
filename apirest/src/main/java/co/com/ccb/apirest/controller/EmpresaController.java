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

import co.com.ccb.apirest.model.seguridad.Empresa;
import co.com.ccb.apirest.servicio.security.EmpresaService;


@RestController
@RequestMapping("api/v1/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	@GetMapping()
	public ResponseEntity<List<Empresa>> Listar() {
		List<Empresa> empresa = empresaService.listarEmpresas();
		return new ResponseEntity<>(empresa, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Empresa> crearEmpresa(@Valid @RequestBody Empresa empresa) {
		Empresa empresaGuardar = empresaService.saveEmpresa(empresa);
		return new ResponseEntity<>(empresaGuardar, HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{idEmpresa}")
	public ResponseEntity<Long> eliminarEmpresa(@PathVariable Long idEmpresa) {
		long idEliminado = empresaService.delete(idEmpresa);
		return new ResponseEntity<>(idEliminado, HttpStatus.OK);
	}

	@PutMapping("/editar/{idEmpresa}")
	public ResponseEntity<Empresa> actualizarEmpresa(@PathVariable Long idEmpresa, @RequestBody Empresa empresa) {
		Empresa empresaUpdate = empresaService.actualizarEmpresa(idEmpresa, empresa);
		return new ResponseEntity<>(empresaUpdate, HttpStatus.OK);
	}
}

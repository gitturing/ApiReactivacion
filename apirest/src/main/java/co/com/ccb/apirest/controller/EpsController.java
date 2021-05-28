package co.com.ccb.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.com.ccb.apirest.model.seguridad.Eps;
import co.com.ccb.apirest.servicio.security.EpsService;


@RestController
@RequestMapping("api/v1/eps")
public class EpsController {

	@Autowired
	private EpsService epsService;

	@GetMapping()
	public ResponseEntity<List<Eps>> Listar() {
		List<Eps> eps = epsService.getAll();
		return new ResponseEntity<>(eps, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Eps> crearEps(@Valid @RequestBody Eps eps) {
		Eps epsGuardar = epsService.save(eps);
		return new ResponseEntity<>(epsGuardar, HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{idEps}")
	public ResponseEntity<Long> eliminarEps(@PathVariable Long idEps) {
		long idEliminado = epsService.delete(idEps);
		return new ResponseEntity<>(idEliminado, HttpStatus.OK);
	}

	@PutMapping("/editar/{idEps}")
	public ResponseEntity<Eps> editarEps(@PathVariable Long idEps, @RequestBody Eps eps) {
		Eps epsUpdate = epsService.actualizarEps(idEps, eps);
		return new ResponseEntity<>(epsUpdate, HttpStatus.OK);
	}
	

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {


        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {

            String fieldNAme = ((FieldError) error).getField();
            String message = error.getDefaultMessage();

            errors.put(fieldNAme, message);
        });

        return errors;
    }

}

package co.com.ccb.apirest.servicio.security;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ccb.apirest.model.seguridad.TipoDocumento;
import co.com.ccb.apirest.persistencia.TipoDocumentoRepository;


@Service
public class TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository documentoRepository;

	@Transactional
	public List<TipoDocumento> getAll() {
		List<TipoDocumento> documentos = (List<TipoDocumento>) documentoRepository.findAll();
		return documentos;
	}

	@Transactional
	public TipoDocumento save(TipoDocumento documento) {
		TipoDocumento documento2 = documentoRepository.save(documento);
		return documento2;
	}

	@Transactional
	public Long delete(long id) {
		Optional<TipoDocumento> documento = documentoRepository.findById(id);
		if (documento.isPresent()) {
			documentoRepository.delete(documento.get());
			return documento.get().getId_Tipo_Documento();
		}else {
			return null;
		}
		
	}

	@Transactional
	public TipoDocumento actualizarDocumento(Long id, TipoDocumento documento) {
		Optional<TipoDocumento> documentoConsultar = documentoRepository.findById(id);
		if (documentoConsultar.isPresent()) {
			return documentoRepository.save(documento);
		} else {
			return null;
		}
	}

}

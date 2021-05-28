package co.com.ccb.apirest.model.seguridad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SectorEconomico")
public class SectorEconomico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSector")
	private Long idSector;
	
	@NotNull(message = "El tipo no puede ser nulo")
	@NotEmpty(message = "El tipo no puede ser vacio")
	@Column(name = "tipo")
	private String tipo;
	
	@NotNull(message = "El codigo no puede ser nulo")
	@NotEmpty(message = "El codigo no puede ser vacio")
	@Size(min = 2, max = 3)
	@Column(name = "codigo")
	private String codigo;
	
}

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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TipoEntidad")
public class TipoEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Entidad")
	private Long id_Entidad;

	@NotNull(message = "El tipo no puede ser nulo")
	@NotEmpty(message = "El tipo no puede ser vacio")
	@Size(min = 3, max = 20)
	@Column(name = "tipo")
	private String tipo;

	@NotNull(message = "El codigo no puede ser nulo")
	@NotEmpty(message = "El codigo no puede ser vacio")
	@Size(min = 2, max = 5)
	@Column(name = "codigo")
	private String codigo;
}

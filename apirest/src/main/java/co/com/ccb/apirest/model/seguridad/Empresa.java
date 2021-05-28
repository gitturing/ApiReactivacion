package co.com.ccb.apirest.model.seguridad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEmpresa")
	private Long idEmpresa;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Entidad")
	private TipoEntidad entidad;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Tipo_Documento")
	private TipoDocumento documento;

	@NotNull
	@NotEmpty
	@Size(min = 8, max = 12)
	@Column(name = "numeroDocumento")
	private String numeroDocumento;

	@NotNull
	@NotEmpty
	@Column(name = "razonSocial")
	private String razonSocial;

	@NotNull
	@NotEmpty
	@Column(name = "correo")
	private String correo;

	@NotNull
	@NotEmpty
	@Column(name = "direccion")
	private String direccion;

	@NotNull
	@NotEmpty
	@Column(name = "barrio")
	private String barrio;

	@NotNull
	@Column(name = "telefono")
	private Long telefono;

	@NotNull
	@Column(name = "telefonoMovil")
	private Long telefonoMovil;

	@NotNull
	@Column(name = "numeroEmpleados")
	private Long numeroEmpleados;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idSector")
	private SectorEconomico economico;

}

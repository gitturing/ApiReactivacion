package co.com.ccb.apirest.model.seguridad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Aseguradora")
public class Aseguradora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAseguradora")
	private Long idAseguradora;
	
	@NotNull(message = "El Nombre no puede ser nulo")
	@NotEmpty(message = "El Nombre no puede estar vacio")
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull(message = "El email no puede ser nulo")
	@NotEmpty(message = "El email no puede estar vacio")
	@Email(message = "el imail no tiene un formato corecto")
	@Column(name = "email")
	private String email;
	
	@NotNull(message = "El telefono no puede ser nulo")
	@NotEmpty(message = "El telefono no puede estar vacio")
	@Column(name = "telefono")
	private String telefono;
	
	@NotNull(message = "La direccion no puede ser nulo")
	@NotEmpty(message = "La direccion no puede estar vacio")
	@Column(name = "direccion")
	private String direccion;

}

package co.com.ccb.apirest.model.seguridad;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="UsersAuthorities")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UsersAuthorities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAutority;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idRol")
	private Rol rol;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
}

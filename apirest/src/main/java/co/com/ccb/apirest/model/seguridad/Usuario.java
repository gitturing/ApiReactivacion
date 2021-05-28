package co.com.ccb.apirest.model.seguridad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="usuario")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	@Column(unique = true, length = 20)
	private String nombreUsuario;
	@Column( length = 60)
	private String password;
	
	@Column(name = "confirmarPassword")
	private String confirmarPassword;
	
	@Column(name = "email")
	private String email;
	private boolean enabled;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario")
    @PrimaryKeyJoinColumn(referencedColumnName = "IdUsuario")
	List<UsersAuthorities> roles;

}

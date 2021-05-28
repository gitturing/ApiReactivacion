package co.com.ccb.apirest.model.seguridad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="roles")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;
	@Column(unique = true, length = 20)
	private String nombreRol;
	
	@Column(name = "codigo")
	private String codigo;
	
	
}

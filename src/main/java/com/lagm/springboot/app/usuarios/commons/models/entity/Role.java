package com.lagm.springboot.app.usuarios.commons.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Identity: Mysql, SQL Server, H2
	private Long id;

	@Column(unique = true, length = 30)
	private String nombre;
	
	/* Se puede implementar la relación bidireccional: Los roles que tienen a los usuarios
	  mappedBy: indica la relación inversa. Es requerido siempre y cuando queramos que la relación sea bidireccional*/
	/*@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private List<Usuario> usuarios;
	*/

	private static final long serialVersionUID = 234103176895355370L;

}

package com.lagm.springboot.app.commons.usuarios.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Identity: Mysql, SQL Server, H2
	private Long id;
	
	@Column(unique = true, length = 20)
	private String username;
	
	@Column(length = 60)
	private String password;
	private Boolean enabled;
	private String nombre;
	private String apellido;
	
	@Column(unique = true)
	private String email;
	
	// Se crea la tabla intermedia usuarios_roles
	@ManyToMany(fetch = FetchType.EAGER)
	/* Configurar tipo de fetch
	 EAGER: Configuración por defecto. Trae todo en una sola consulta. Trae el usuario con sus roles de una.
	 LAZY: Carga peresoza (recomendado). Solo en la consulta trae al usuario. Los roles se obtienen cuando invocamos al método getRoles
		   Se recomienda cuando existen muchas tablas y relaciones.
		   */
	@JoinTable(
		name = "usuarios_roles", 
		joinColumns = @JoinColumn(name="usuario_id"), 
		inverseJoinColumns = @JoinColumn(name="role_id"),
		uniqueConstraints = { // Restricción para hacer único el par usuario-rol
			@UniqueConstraint(columnNames = {"usuario_id", "role_id"})
		}
		)
		
	/* name: nombre de la tabla intermedia*/
	private List<Role> roles;
	
	private static final long serialVersionUID = -5912409350897560755L;
	
}

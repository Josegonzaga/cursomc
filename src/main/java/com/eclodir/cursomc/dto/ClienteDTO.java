package com.eclodir.cursomc.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.eclodir.cursomc.domain.Cliente;
import com.eclodir.cursomc.services.validation.ClienteUpdate;


@ClienteUpdate
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty (message="Preenchimento obrigatório")
	@Length (min=5, max=123, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	
	@NotEmpty (message="Preenchimento obrigatório")
	@Email (message="Email inválido")
	private String email;
	
	public ClienteDTO() {}
	public ClienteDTO(Cliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}

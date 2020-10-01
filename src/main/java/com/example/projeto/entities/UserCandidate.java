package com.example.projeto.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

@Entity
public class UserCandidate implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotEmpty
	@Length(min=11, max=11, message="tamanho do campo 11 digitos")
	private Integer cpf;
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=5, max=80, message="Tamanho do campo, minino 5 maximo 80")
	private String name;
	@Email
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=5, max=80, message="Tamanho do campo, minino 5 maximo 80")
	private String email;
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=5, max=8, message="Tamanho do campo, minino 5 maximo 8")
	private String password;
	
	@OneToMany(mappedBy = "candidato")
	private List<Post> post = new ArrayList<>();
	
	public UserCandidate() {
	}

	public UserCandidate(Long id, Integer cpf, String name, String email, String password) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getCpf() {
		return cpf;
	}
	
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserCandidate other = (UserCandidate) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

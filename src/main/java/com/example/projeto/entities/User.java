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
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import com.sun.istack.NotNull;

@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Email
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=5, max=80, message="Tamanho do campo, minino 5 maximo 80")
	private String email;
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=5, max=8, message="Tamanho do campo, minino 5 maximo 8")
	private String password;
	@CNPJ
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=14, max=14, message="Tamanho do campo precisa ter 14 digitos")
	private String cnpj;
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=5, max=80, message="Tamanho do campo, minino 5 maximo 80")
	private String nameCompany;
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Pattern(regexp = "(\\+55|0)[0-9]{9}")
	private String phone;
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=5, max=80, message="Tamanho do campo, minino 5 maximo 80")
	private String name;
	
	@OneToMany(mappedBy = "user")
	List<Jobs> jobs = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	List<Called> called = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	List<Post> post = new ArrayList<>();
	
	public User() {
	}

	public User(Long id, String email, String password, String cnpj, String nameCompany, String phone, String name) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.cnpj = cnpj;
		this.nameCompany = nameCompany;
		this.phone = phone;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", cnpj=" + cnpj + ", nameCompany="
				+ nameCompany + ", phone=" + phone + ", jobs=" + jobs + ", called=" + called + "]";
	}
}

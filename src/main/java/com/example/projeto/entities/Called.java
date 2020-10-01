package com.example.projeto.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

@Entity
public class Called implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=5, max=80, message="Tamanho do campo, minino 5 maximo 80")
	private String title;
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=5, max=80, message="Tamanho do campo, minino 5 maximo 80")
	private String department;
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=5, max=80, message="Tamanho do campo, minino 5 maximo 80")
	private String descrition;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Called() {
	}

	public Called(Long id, String title, String department, String descrition) {
		super();
		this.id = id;
		this.title = title;
		this.department = department;
		this.descrition = descrition;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		Called other = (Called) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Called [id=" + id + ", title=" + title + ", department=" + department + ", descrition=" + descrition
				+ ", user=" + user + "]";
	}
}

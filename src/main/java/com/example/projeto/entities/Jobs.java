package com.example.projeto.entities;

import java.io.Serializable;
import java.time.Instant;

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
public class Jobs implements Serializable{
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
	private Instant date;
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=5, max=80, message="Tamanho do campo, minino 5 maximo 80")
	private String skillRequisete;
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=5, max=80, message="Tamanho do campo, minino 5 maximo 80")
	private String salary;
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=5, max=80, message="Tamanho do campo, minino 5 maximo 80")
	private String locale;
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=5, max=80, message="Tamanho do campo, minino 5 maximo 80")
	private String localeCity;
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=5, max=80, message="Tamanho do campo, minino 5 maximo 80")
	private String localeState;
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=5, max=80, message="Tamanho do campo, minino 5 maximo 80")
	private String typeJob;
	@NotNull
	@NotEmpty(message="Preenchimento obrigátorio")
	@Length(min=5, max=80, message="Tamanho do campo, minino 5 maximo 80")
	private String descrition;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Jobs() {
	}

	public Jobs(Long id, String title, Instant date,String skillRequisete, String salary, String locale, String localeCity, String localeState,String typeJob,
			String descrition) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.skillRequisete = skillRequisete;
		this.salary = salary;
		this.locale = locale;
		this.localeCity = localeCity;
		this.localeState = localeState;
		this.typeJob = typeJob;
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
	
	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getSkillRequisete() {
		return skillRequisete;
	}

	public void setSkillRequisete(String skillRequisete) {
		this.skillRequisete = skillRequisete;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	public String getLocaleCity() {
		return locale;
	}

	public void setLocaleCity(String localeCity) {
		this.localeCity = localeCity;
	}
	
	public String getLocaleState() {
		return locale;
	}

	public void setLocaleState(String localeState) {
		this.localeState = localeState;
	}

	public String getTypeJob() {
		return typeJob;
	}

	public void setTypeJob(String typeJob) {
		this.typeJob = typeJob;
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
		Jobs other = (Jobs) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Jobs [id=" + id + ", title=" + title + ", date=" + date + ", skillRequisete=" + skillRequisete
				+ ", salary=" + salary + ", locale=" + locale + ", typeJob=" + typeJob + ", descrition=" + descrition
				+ ", user=" + user + "]";
	}
}

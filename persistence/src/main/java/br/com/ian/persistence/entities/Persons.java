package br.com.ian.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persons implements Serializable
{

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long					id;

	@Column
	@NotNull
	@NotEmpty
	private String					name;

	@Column(unique = true)
	@NotNull
	@NotEmpty
	@Email
	private String					email;

	@Column
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date					birth;

	@Column
	@NotNull
	@NotEmpty
	private String					userName;

	@Column(length = 10)
	@NotNull
	@NotEmpty
	@Size(min = 10, max = 10)
	private String					password;

	public Persons()
	{
	}

	public Persons(Long id, @NotNull @NotEmpty String name, @NotNull @NotEmpty @Email String email, @NotNull Date birth,
		@NotNull @NotEmpty String userName, @NotNull @NotEmpty String password)
	{
		this.id = id;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.userName = userName;
		this.password = password;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Date getBirth()
	{
		return birth;
	}

	public void setBirth(Date birth)
	{
		this.birth = birth;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}

package br.com.ian.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PersonsRequest implements Serializable
{
	private static final long	serialVersionUID	= 1L;

	@NotNull
	@NotEmpty
	private String					name;

	@NotNull
	@NotEmpty
	@Email
	private String					email;

	@NotNull
	private Date					birth;
	
	public PersonsRequest()
	{
	}

	public PersonsRequest(@NotNull @NotEmpty String name, @NotNull @NotEmpty @Email String email, @NotNull Date birth)
	{
		super();
		this.name = name;
		this.email = email;
		this.birth = birth;
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

}

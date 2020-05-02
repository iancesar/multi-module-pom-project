package br.com.ian.dtos;

import java.io.Serializable;
import java.util.Date;

public class PersonsResponse implements Serializable
{
	private static final long	serialVersionUID	= 1L;

	private Long					id;

	private String					name;

	private String					email;

	private Date					birth;

	private String					userName;

	public PersonsResponse()
	{
	}

	public PersonsResponse(Long id, String name, String email, Date birth, String userName)
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.userName = userName;
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

}

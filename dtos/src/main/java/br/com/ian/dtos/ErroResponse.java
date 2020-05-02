package br.com.ian.dtos;

public class ErroResponse
{

	private String message;

	public ErroResponse(String message)
	{
		super();
		this.message = message;
	}

	public ErroResponse(Exception e)
	{
		super();
		this.message = e.getMessage();
	}

	public String getMessage()
	{
		return message;
	}

}

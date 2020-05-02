package br.com.ian.rest.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.ian.dtos.ErroResponse;
import br.com.ian.services.exceptions.BusinessException;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException>
{

	@Override
	public Response toResponse(BusinessException exception)
	{
		return Response.status(Status.NOT_ACCEPTABLE).entity(new ErroResponse(exception)).build();
	}

}

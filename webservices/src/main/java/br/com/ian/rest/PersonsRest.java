package br.com.ian.rest;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.ian.dtos.PersonsRequest;
import br.com.ian.dtos.PersonsResponse;
import br.com.ian.services.PersonsService;

@Path("/persons")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class PersonsRest
{

	@Inject
	private PersonsService personsService;

	@GET
	public Response get()
	{
		return Response.ok(personsService.listAll()).build();
	}

	@POST
	public Response create(PersonsRequest request)
	{
		Optional<PersonsResponse> create = personsService.create(request);
		if(create.isPresent())
		{
			return Response.ok(create).build();
		}
		else
		{
			return Response.status(Status.NOT_ACCEPTABLE).entity("Não possível realizar a operação, tente novamente").build();
		}

	}

}

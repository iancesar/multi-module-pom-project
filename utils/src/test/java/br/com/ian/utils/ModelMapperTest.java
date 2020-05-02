package br.com.ian.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.ian.dtos.PersonsRequest;
import br.com.ian.dtos.PersonsResponse;
import br.com.ian.persistence.entities.Persons;

public class ModelMapperTest
{

	@Test
	public void parse() throws Exception
	{
		Persons persons = new Persons(1L, "ian", "email@email.com", new Date(), "ian", "123");

		PersonsResponse response = ModelMapperUtils.parse(persons, PersonsResponse.class);

		assertNotNull(response);
		assertEquals(persons.getName(), response.getName());
		assertEquals(persons.getBirth(), response.getBirth());

		PersonsRequest request = new PersonsRequest("ian", "email@email", new Date());
		persons = ModelMapperUtils.parse(request, Persons.class);

		assertNotNull(request);
		assertEquals(persons.getName(), request.getName());
		assertEquals(persons.getBirth(), request.getBirth());

	}

	@Test
	public void parseToList() throws Exception
	{
		List<Persons> personsList = Arrays.asList( //
			new Persons(1L, "ian", "email@email.com", new Date(), "ian", "123"), //
			new Persons(2L, "ian2", "email2@email.com", new Date(), "ian", "123"));

		List<PersonsResponse> responseList = ModelMapperUtils.parseToList(personsList, PersonsResponse.class);

		assertNotNull(responseList);
		assertEquals(responseList.get(0), personsList.get(0));
		assertEquals(responseList.get(1), personsList.get(1));
	}

}

package br.com.ian.utils;

import static org.junit.Assert.assertNotNull;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.johnzon.mapper.MapperBuilder;
import org.junit.Test;

import br.com.ian.dtos.PersonsResponse;
import br.com.ian.persistence.entities.Persons;

public class JohnzonArrayConverter
{

	@Test
	public void convertToArray() throws Exception
	{

		Persons person = new Persons(1l, "ian", "email@email.com", new Date(), "user", "123");

		List<PersonsResponse> dto = ModelMapperUtils.parseToList(Arrays.asList(person), PersonsResponse.class);

		StringWriter writer = new StringWriter();
		new MapperBuilder().build().writeArray(dto, writer);

		assertNotNull(writer);

	}

}

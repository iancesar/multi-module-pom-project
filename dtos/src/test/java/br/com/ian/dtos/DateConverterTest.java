package br.com.ian.dtos;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.apache.johnzon.mapper.MapperBuilder;
import org.junit.Test;

public class DateConverterTest
{
	@Test
	public void convert()
	{
		PersonsResponse response = new PersonsResponse();
		Date birth = Date.from(LocalDate.of(1993, 7, 22).atStartOfDay(ZoneId.systemDefault()).toInstant());
		response.setBirth(birth);

		final String actual = new MapperBuilder().build().writeObjectAsString(response);

		assertEquals("{\"birth\":\"1993-07-22T00:00:00-03:00\"}", actual);

	}
}

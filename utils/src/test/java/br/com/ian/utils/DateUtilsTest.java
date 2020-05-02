package br.com.ian.utils;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;

public class DateUtilsTest
{

	@Test
	public void getYear() throws Exception
	{
		Date date = Date.from(LocalDate.of(1993, 7, 22).atStartOfDay(ZoneId.systemDefault()).toInstant());
		int year = DateUtils.getYear(date);

		assertEquals(1993, year);
	}

}

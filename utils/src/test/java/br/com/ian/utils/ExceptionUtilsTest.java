package br.com.ian.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ExceptionUtilsTest
{

	@Test
	public void hasText() 
	{
		
		try
		{
			throw new NullPointerException();
		}
		catch(Exception e)
		{
			assertTrue(ExceptionUtils.hasText(e, "nullpointer"));
		}
		
		
	}
}

package br.com.ian.utils;

public class ExceptionUtils
{

	private ExceptionUtils()
	{
	}

	public static boolean hasText(Throwable e, String text)
	{
		return org.apache.commons.lang3.exception.ExceptionUtils.getMessage(e).toLowerCase().contains(text.toLowerCase());
	}

}

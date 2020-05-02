package br.com.ian.utils;

import java.time.ZoneId;
import java.util.Date;

public class DateUtils
{

	private DateUtils()
	{
	}

	public static int getYear(Date date)
	{
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear();
	}

}

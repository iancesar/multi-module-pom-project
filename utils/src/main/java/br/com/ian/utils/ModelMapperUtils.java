package br.com.ian.utils;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

public class ModelMapperUtils
{
	private static ModelMapper mapper;

	static
	{
		mapper = new ModelMapper();
		//		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

	}

	private ModelMapperUtils()
	{
	}

	public static <D> D parse(Object source, Class<D> destination)
	{
		return mapper.map(source, destination);
	}

	public static <D> D parse(Object source, Type type)
	{
		return mapper.map(source, type);
	}

	public static <D> List<D> parseToList(Object source, Class<D> destination)
	{
		Type listType = new TypeToken<List<D>>()
		{
		}.getType();

		return mapper.map(source, listType);
	}

}

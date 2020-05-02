package br.com.ian.services;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.ian.dtos.PersonsRequest;
import br.com.ian.dtos.PersonsResponse;
import br.com.ian.persistence.dao.PersonsDao;
import br.com.ian.persistence.entities.Persons;
import br.com.ian.services.exceptions.BusinessException;
import br.com.ian.utils.DateUtils;
import br.com.ian.utils.ExceptionUtils;
import br.com.ian.utils.ModelMapperUtils;
import br.com.ian.utils.StringUtils;

@Stateless
public class PersonsService
{

	@Inject
	private PersonsDao personsDao;

	public List<PersonsResponse> listAll()
	{
		List<Persons> persons = personsDao.findAll();

		List<PersonsResponse> parseToList = ModelMapperUtils.parseToList(persons, PersonsResponse.class);

		return parseToList;
	}

	public Optional<PersonsResponse> create(PersonsRequest personsRequest)
	{
		Persons persons = ModelMapperUtils.parse(personsRequest, Persons.class);

		createUserNameAndPassword(persons);

		try
		{
			persons = personsDao.perist(persons);

			return Optional.of(ModelMapperUtils.parse(persons, PersonsResponse.class));

		}
		catch(Exception e)
		{
			if(ExceptionUtils.hasText(e, "ConstraintViolationException"))
			{
				throw new BusinessException(MessageFormat.format("O e-mail {0} já foi cadastrado", persons.getEmail()));
			}
		}
		return Optional.empty();
	}

	private void createUserNameAndPassword(Persons persons)
	{
		if(persons.getId() == null)
		{
			persons.setUserName(createUserName(persons));
			persons.setPassword(createPassword());
		}
	}

	private String createUserName(Persons persons)
	{
		String emailUser = StringUtils.extractEmailUser(persons.getEmail()).get();
		int birthYear = DateUtils.getYear(persons.getBirth());

		return emailUser + birthYear;
	}

	private String createPassword()
	{
		return StringUtils.generatePassword();
	}

}

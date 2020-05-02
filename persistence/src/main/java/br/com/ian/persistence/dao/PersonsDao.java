package br.com.ian.persistence.dao;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.ian.persistence.entities.Persons;

@Stateless
public class PersonsDao
{

	@PersistenceContext(unitName = "h2")
	private EntityManager entityManager;

	public List<Persons> findAll()
	{
		return entityManager.createQuery("select p from Persons p", Persons.class).getResultList();
	}

	public Optional<Persons> find(Long id)
	{
		return Optional.ofNullable(entityManager.find(Persons.class, id));
	}

	public Persons perist(Persons persons)
	{
		if(persons.getId() != null)
		{
			merge(persons);
		}
		else
		{
			entityManager.persist(persons);
		}

		return persons;
	}

	private void merge(Persons persons)
	{
		persons = entityManager.merge(persons);
	}

	public boolean delete(Persons persons)
	{
		entityManager.remove(persons);
		return true;
	}

}

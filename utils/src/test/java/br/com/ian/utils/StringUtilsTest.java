package br.com.ian.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;

public class StringUtilsTest
{
	@Test
	public void extractEmailUser()
	{

		Optional<String> user = StringUtils.extractEmailUser("email@email.com");
		assertTrue(user.isPresent());
		assertEquals("email", user.get());

		user = StringUtils.extractEmailUser("email.2.2@email.com");
		assertTrue(user.isPresent());
		assertEquals("email.2.2", user.get());

		user = StringUtils.extractEmailUser("-email.-23232_tsst2@email.com");
		assertTrue(user.isPresent());
		assertEquals("-email.-23232_tsst2", user.get());

	}

	@Test
	public void generatePasswordTest()
	{
		String password = StringUtils.generatePassword();
		assertNotNull(password);
		assertEquals(10, password.length());
	}
}

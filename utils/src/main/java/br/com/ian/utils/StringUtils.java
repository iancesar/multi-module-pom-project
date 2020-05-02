package br.com.ian.utils;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class StringUtils
{

	private StringUtils()
	{
	}

	public static Optional<String> extractEmailUser(String email)
	{
		String regex = "(?i)[a-zA-Z0-9\\-._]*";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if(matcher.find())
		{
			return Optional.of(matcher.group());
		}
		else
		{
			return Optional.empty();
		}
	}

	public static String generatePassword()
	{
		CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);
		CharacterRule alphabetic = new CharacterRule(EnglishCharacterData.Alphabetical);

		PasswordGenerator passwordGenerator = new PasswordGenerator();
		return passwordGenerator.generatePassword(10, digits, alphabetic);
	}
}

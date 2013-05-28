package exercisesmanager.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pif.utils.string.Regex;

import exercisesmanager.pojos.User;

public class UpdateUserValidator implements Validator {

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	@Override
	public void validate(Object object, Errors errors) {
		User user = (User) object;
		
		if ((user.getUsername().length() < 5) || (user.getUsername().length() > 20)) {
			errors.rejectValue("username", "error.form.user.username.length");
		}
		checkRegex(errors, "username", user.getUsername(), "[^a-zA-Z_0-9_\\.]", "error.form.user.username.regex");
		
		user.setFirst_name(Regex.trimSpaces(user.getFirst_name()));
		if (user.getFirst_name().length() > 20) {
			errors.rejectValue("first_name", "error.form.user.firstName.length");
		}
		checkRegex(errors, "first_name", user.getFirst_name(), "[^a-zA-Z_\\'_\\u0020]", "error.form.user.firstName.regex");

		user.setLast_name(Regex.trimSpaces(user.getLast_name()));
		if (user.getLast_name().length() > 20) {
			errors.rejectValue("last_name", "error.form.user.lastName.length");
		}
		checkRegex(errors, "last_name", user.getLast_name(), "[^a-zA-Z_\\'_\\u0020]", "error.form.user.lastName.regex");
		
		if ((user.getEmail().length() < 6) || (user.getEmail().length() > 45)) {
			errors.rejectValue("email", "error.form.user.email.length");
		}
	}

	private void checkRegex(Errors errors, String property, String value, String regex, String errorMessage) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		if (matcher.find()) {
			errors.rejectValue(property, errorMessage);
		}
	}

}

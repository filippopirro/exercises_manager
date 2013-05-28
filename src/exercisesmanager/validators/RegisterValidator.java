package exercisesmanager.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import exercisesmanager.dao.implementors.UserDaoImpl;

import exercisesmanager.pojos.RegisterUser;
import exercisesmanager.pojos.User;

public class RegisterValidator implements Validator {

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterUser.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		RegisterUser user = (RegisterUser) object;
		if ((user.getUsername().length() < 5) || (user.getUsername().length() > 20)) {
			errors.rejectValue("username", "error.form.user.username.length");
		}
		checkIfUsernameAlreadyPresent(errors, user.getUsername());
		checkRegex(errors, "username", user.getUsername(), "[^a-zA-Z_0-9_\\.]", "error.form.user.username.regex");
		if ((user.getPassword().length() < 5) || (user.getPassword().length() > 20)) {
			errors.rejectValue("password", "error.form.user.password.length");
		}
		checkRegex(errors, "password", user.getPassword(), "[^a-zA-Z_0-9_\\.]", "error.form.user.password.regex");
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "error.form.user.confirmPassword.match");
		}
		if ((user.getFirst_name().length() < 5) || (user.getFirst_name().length() > 20)) {
			errors.rejectValue("first_name", "error.form.user.firstName.length");
		}
		checkRegex(errors, "first_name", user.getFirst_name(), "[^a-zA-Z_\\'_\\u0020]", "error.form.user.firstName.regex");
		if ((user.getLast_name().length() < 5) || (user.getLast_name().length() > 20)) {
			errors.rejectValue("last_name", "error.form.user.lastName.length");
		}
		checkRegex(errors, "last_name", user.getLast_name(), "[^a-zA-Z_\\'_\\u0020]", "error.form.user.lastName.regex");
		if ((user.getEmail().length() < 6) || (user.getEmail().length() > 45)) {
			errors.rejectValue("email", "error.form.user.email.length");
		}
	}

	private void checkIfUsernameAlreadyPresent(Errors errors, String username) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		try {
			User user = (User) userDaoImpl.selectByUsername(username);
			if (user == null) {
				errors.rejectValue("username", "error.form.user.username.alreadyPresent");
			}
		} catch (Exception e) {
			logger.error("checkIfUsernameAlreadyPresent: error checking if username is already present");
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

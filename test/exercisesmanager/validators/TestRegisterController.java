package exercisesmanager.validators;

import static org.junit.Assert.*;

import java.net.BindException;

import org.junit.Test;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;

import java.sql.Timestamp;
import java.util.Date;

import exercisesmanager.pojos.RegisterUser;

public class TestRegisterController {

	@Test
	public void testGet() {
		assert (true);
	}

	@Test
	public void testOnSubmit() {
		boolean assertValue = false;
		Long now = (new Date()).getTime();
		RegisterUser user = new RegisterUser(new Integer(1), "filippo", "aa?", "bb)", "tz7", "d\"amato",
				"peppino@foo.foo", new Timestamp(now), new Timestamp(now), new Timestamp(now), "Y");
		user.setUsername("filippo");
		RegisterValidator validator = new RegisterValidator();
		// BindException bindException = new BindException();
		DataBinder dataBinder = new DataBinder(user);
		validator.validate(user, dataBinder.getBindingResult());
		for (ObjectError error : dataBinder.getBindingResult().getAllErrors()) {
			System.out.println(error.toString());
			assertValue = true;
		}
		assert (assertValue);
	}

}

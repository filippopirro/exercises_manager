package exercisesmanager.web;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pif.system.session.DataCart;

import exercisesmanager.dao.UserDao;
import exercisesmanager.dao.implementors.UserDaoImpl;
import exercisesmanager.pojos.RegisterUser;
import exercisesmanager.pojos.User;
import exercisesmanager.validators.RegisterValidator;

@Controller
@RequestMapping("register.htm")
public class RegisterController {

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String get(final ModelMap model, HttpSession session) {
		RegisterUser user = new RegisterUser();
		model.addAttribute("registerUser", user);
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute(value = "registerUser") RegisterUser registerUser, BindingResult result,
			final ModelMap model, HttpSession session) {
		RegisterValidator validator = new RegisterValidator();
		validator.validate(registerUser, result);
		String exitPage="";
		if (result.hasErrors()){
			model.addAttribute("registerUser",registerUser);
			exitPage="register";
		} else {
			UserDao userDao = new UserDaoImpl();
			try {
				User user = new User(registerUser);
				userDao.insert(user);
			} catch (Exception e) {
				logger.error(e);
			}
			DataCart.setValue(session, "message", "User has been registered");
			exitPage="redirect:confirm.htm";
		}
		model.addAttribute(DataCart.DATACART, DataCart.getDataCart(session));
		return exitPage;
	}

}

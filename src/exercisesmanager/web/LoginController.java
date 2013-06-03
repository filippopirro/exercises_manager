package exercisesmanager.web;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pif.system.session.DataCart;

import exercisesmanager.dao.UserDao;
import exercisesmanager.pojos.User;
import exercisesmanager.validators.LoginValidator;

@Controller
@RequestMapping("login.htm")
public class LoginController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private UserDao userDao=null;
	
	private UserDao getUserDao(){
		return userDao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String get(final ModelMap model, HttpSession session) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute(DataCart.DATACART, DataCart.getDataCart(session));
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute(value = "user") User user, BindingResult result, final ModelMap model,
			HttpSession session) {
		LoginValidator loginValidator = new LoginValidator();
		loginValidator.validate(user, result);
		String returnPage = "";
		if (result.hasErrors()) {
			returnPage = "login";
		} else {
			UserDao userDao = getUserDao();
			try {
				User returnedUser = userDao.selectByCredentials(user);
				if (returnedUser != null) {
					logger.info("User logged in as " + user.getUsername());
					setUserParams(session, returnedUser);
				} else {
					logger.info("Failed to log in as " + user.getUsername());
				}
			} catch (Exception e) {
				logger.error(e);
			}
			returnPage = "redirect:main.htm";
		}
		model.addAttribute(DataCart.DATACART, DataCart.getDataCart(session));
		return returnPage;
	}

	private void setUserParams(HttpSession session, User returnedUser) {
		DataCart.setUserId(session, returnedUser.getId());
		DataCart.setUsername(session, returnedUser.getUsername());
		DataCart.setUserPassword(session, returnedUser.getPassword());
		DataCart.setUserAuthorizationLevel(session, new Integer(1));
		DataCart.setLoggedInFlagAsTrue(session);
	}

}

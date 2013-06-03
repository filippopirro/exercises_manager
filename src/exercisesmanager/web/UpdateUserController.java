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
import exercisesmanager.validators.UpdateUserValidator;

@Controller
@RequestMapping("updateuser.htm")
public class UpdateUserController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private UserDao userDao=null;
	
	private UserDao getUserDao() {
		return userDao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String get(final ModelMap model, HttpSession session) throws Exception {
		UserDao userDao = getUserDao();
		User user = userDao.selectById((Integer) DataCart.getUserId(session));
		model.addAttribute(DataCart.DATACART, DataCart.getDataCart(session));
		model.addAttribute("user", user);
		return "updateuser";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute(value = "user") User user, BindingResult result, final ModelMap model,
			HttpSession session) {
		UpdateUserValidator updateUserValidator = new UpdateUserValidator();
		updateUserValidator.validate(user, result);
		String returnPage = "";
		if (result.hasErrors()) {
			returnPage = "updateuser";
		} else {
			UserDao userDao = getUserDao();
			try {
				user.setId((Integer) DataCart.getUserId(session));
				user.setPassword(DataCart.getUserPassword(session));
				userDao.updateById(user);
			} catch (Exception e) {
				logger.error(e);
			}
			returnPage = "redirect:confirm.htm";
		}
		DataCart.setValue(session, "message", "User has been updated");
		return returnPage;
	}

}

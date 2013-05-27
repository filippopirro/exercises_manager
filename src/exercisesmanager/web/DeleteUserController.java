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
import exercisesmanager.pojos.User;

@Controller
@RequestMapping("deleteuser.htm")
public class DeleteUserController {

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String get(final ModelMap model, HttpSession session) throws Exception {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.selectById((Integer) DataCart.getUserId(session));
		model.addAttribute(DataCart.DATACART, DataCart.getDataCart(session));
		model.addAttribute("user", user);
		return "deleteuser";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute(value = "user") User user, BindingResult result, final ModelMap model,
			HttpSession session) {
		UserDao userDao = new UserDaoImpl();
		try {
			userDao.deleteById((Integer) DataCart.getUserId(session));
			DataCart.setLogInParamsAsEmpty(session);
		} catch (Exception e) {
			logger.error(e);
		}
		DataCart.setValue(session, "message", "User has been deleted");
		return "redirect:confirm.htm";
	}

}

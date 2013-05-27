package exercisesmanager.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pif.system.session.DataCart;

@Controller
@RequestMapping("logout.htm")
public class LogoutController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public String get(final ModelMap model,  HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		logger.info("Logout: 'get'");
		DataCart.setLogInParamsAsEmpty(session);
		model.addAttribute(DataCart.DATACART, DataCart.getDataCart(session));
		return "redirect:main.htm";
	}

}

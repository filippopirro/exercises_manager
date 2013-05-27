package exercisesmanager.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pif.system.session.DataCart;

@Controller
@RequestMapping("main.htm")
public class MainController {

	@RequestMapping(method = RequestMethod.GET)
	public String get(final ModelMap model, HttpSession session) {
		model.addAttribute(DataCart.DATACART, DataCart.getDataCart(session));
		return "main";
	}

}

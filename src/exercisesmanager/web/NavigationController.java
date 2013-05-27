package exercisesmanager.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pif.system.session.DataCart;

@Controller
@RequestMapping("navigation.htm")
public class NavigationController {

	@RequestMapping(method = RequestMethod.GET)
	public String get(final ModelMap model, @RequestParam(value = "page", required = true) String page,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		model.addAttribute(DataCart.DATACART, DataCart.getDataCart(session));
		return "redirect:" + page;
	}

}

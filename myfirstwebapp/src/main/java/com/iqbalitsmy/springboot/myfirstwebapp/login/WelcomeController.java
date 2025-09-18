package com.iqbalitsmy.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
//	private Logger logger = LoggerFactory.getLogger(getClass());
//
//	@RequestMapping("login")
//	public String gotoLoginPage(@RequestParam String name, ModelMap model) { // receive param using @RequestParam, send
//																				// data controller to JSP using model
//		model.put("name", name);
//		System.out.println(name);
//		logger.debug("logger console {}", name);
//		return "login";
//	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}

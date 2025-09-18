package com.iqbalitsmy.springboot.myfirstwebapp.signup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpControler {
	@RequestMapping("sign-up")
	public String gotoSignupPage(@RequestParam String name, ModelMap model ) {
		model.put("name", name);
		System.out.println(name);
		return "Signup";
	}
}

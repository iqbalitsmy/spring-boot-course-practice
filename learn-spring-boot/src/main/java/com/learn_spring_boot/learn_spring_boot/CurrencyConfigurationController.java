package com.learn_spring_boot.learn_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {
	@Autowired
	private CurrencyServiceConfigaration configaratio;
	
	@RequestMapping("/currency-configaration")
	public CurrencyServiceConfigaration retriveAllCourses() {
		return configaratio;
	}
}

package com.iqbalitsmy.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	@RequestMapping("say-hello")
	@ResponseBody // used to tell Spring MVC that the return value of a method should be written
					// directly to the HTTP response body
	public String sayHello() {
		return "Hello! What are you learning today?";
	}

	@RequestMapping("say-hello-html")
	@ResponseBody // used to tell Spring MVC that the return value of a method should be written
					// directly to the HTTP response body
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<htm>");
		sb.append("<head>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>Hello World</h1>");
		sb.append("</body>");
		sb.append("</htm>");
		return sb.toString();
	}
	
//	/src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
}

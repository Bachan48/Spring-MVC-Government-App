package myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String display_login_page()
	{
		return "manage_logins/loginPage";
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout()
	{
		return "manage_logins/logout";
	}
	@RequestMapping(value="/error",method=RequestMethod.GET)
	public String error()
	{
		return "manage_logins/error";
	}
}

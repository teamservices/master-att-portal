package com.att.controller;

import com.att.dao.RegisterDao;
import com.att.domain.Login;
import com.att.domain.User;
import com.att.util.HashCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired
	RegisterDao registerDao;

	@Autowired
	HashCode hashCode;

	@RequestMapping("registerform")
	public ModelAndView registrationForm(@ModelAttribute Login login) {
		return new ModelAndView("register", "login", login);
	}

	@RequestMapping("register")
	public ModelAndView registerUser(@ModelAttribute User login) {
		String hashPassword = hashCode.getHashPassword(login.getPassword());
		login.setPassword(hashPassword);
		registerDao.registerUser(login);
		return new ModelAndView("dashboard", "login", login);
	}

	@RequestMapping("login")
	public ModelAndView getLoginForm(@RequestParam(required = false) String authfailed, String logout, String denied) {
		String message = "";
		if (authfailed != null) {
			message = "Invalid username or password, try again !";
		} else if (logout != null) {
			message = "Logged out successfully, login again to continue !";
		} else if (denied != null) {
			message = "Access denied for this user !";
		}
		return new ModelAndView("login", "message", message);
	}

	@RequestMapping("user")
	public String geUserPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "user";
	}

	@RequestMapping("admin")
	public String geAdminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}

	@RequestMapping("403page")
	public String ge403denied() {
		return "redirect:login?denied";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}

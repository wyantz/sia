/**
 * 
 */
package com.jafis.learn.sia.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Awiyanto Ajisasongko
 *
 */
@Controller
public class FormController {
	
	@RequestMapping("/form/mahasiswa.html")
	public String form() {
		return "mahasiswa";
	}
	
	@RequestMapping("/login.html")
	public String loginForm() {
		return "login";
	}

	@RequestMapping("/home.html")
	public String home() {
		return "home";
	}
}

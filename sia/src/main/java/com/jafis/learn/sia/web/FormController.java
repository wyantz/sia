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
@RequestMapping("/form")
public class FormController {
	
	@RequestMapping("mahasiswa.html")
	public String form() {
		return "mahasiswa";
	}
}

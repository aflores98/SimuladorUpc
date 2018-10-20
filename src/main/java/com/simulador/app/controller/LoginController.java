package com.simulador.app.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	// cuando un boton haga referencia a /login , se ejecutara en el controllador
	// diversas opciones dependiendo del acceso o deniego
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
			RedirectAttributes flash) {

		if (principal != null) {
			flash.addFlashAttribute("info", "Ya ha inciado sesión anteriormente");
			return "redirect:/juego/nuevo";
		}

		if (error != null) {
			model.addAttribute("error","USUARIO Y/O CONTRASENA ERRONEAS");
		}

		if (logout != null) {
			model.addAttribute("exito", "Ha cerrado sesión con éxito!");
		}

		return "index";
	}
}

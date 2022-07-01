package org.autocar.controller;

import org.autocar.model.Usuario;
import org.autocar.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProyectoController {
	
	@Autowired
	private IUsuarioRepository repouser;
	
	@GetMapping("/index/principal")
	public String cargarPrincipal(Model model) {
		return "principal";  
	}
	
	@GetMapping("/user/login")
	public String cargarForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";  
	}
	
	@PostMapping("/usuario/validar")
	public String ValidarIngreso(@ModelAttribute Usuario usuario, Model model) {
		System.out.println(usuario);
		Usuario u = repouser.findByCorreoAndClave(usuario.getCorreo(), usuario.getClave());
		System.out.println(u);
		if(u == null) {
			model.addAttribute("usuario", new Usuario());
			model.addAttribute("mensaje", "Usuario o Clave incorrecta");
			return "login";
		}else {
			model.addAttribute("usuario", u);
			return "principal";
		}

	}

}


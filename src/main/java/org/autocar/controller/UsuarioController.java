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
public class UsuarioController {
	
	@Autowired
	private IUsuarioRepository repouser;
	
	@GetMapping("/usuario/registro")
	public String cargarForm(Model model) {
		return "Registro";  
	}
	@PostMapping("/usuario/crear")
	public String grabarForm(@ModelAttribute Usuario usuarioC, Model model) {
		try {
			repouser.save(usuarioC);
			model.addAttribute("MensajeExito", "Usuario registrado, Iniciar Sesión");
		} catch (Exception e) {
			model.addAttribute("MensajeError", "Error al registrar Usuario");
		}
		System.out.println(usuarioC);
		return "Registro";  
	}
	

}

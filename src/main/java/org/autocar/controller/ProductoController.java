package org.autocar.controller;

import org.autocar.model.Productos;
import org.autocar.repository.IProductoRepository;
import org.autocar.repository.IProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {

	@Autowired
	private IProveedorRepository reprove;

	@Autowired
	private IProductoRepository repro;

	@GetMapping("/producto/mantenimiento")
	public String manteForm(Model model) {
		model.addAttribute("productos", new Productos());

		// listado => cboProv
		model.addAttribute("lstProveedores", reprove.findAll());

		return "mantenimientoProd";
	}

	//para registro
	@PostMapping("/producto/grabarmante")
	public String grabarForm(@ModelAttribute Productos producto, Model model) {
		System.out.println(producto);

		model.addAttribute("lstProveedor", reprove.findAll());
		
		//grabar producto nuevo
		try {
			repro.save(producto);
			model.addAttribute("success", "Proceso realizado con éxito");
		} catch (Exception e) {
			model.addAttribute("error", "error al registrar producto");
		}

		return "mantenimientoProd";
	}
	
	//para actualizar producto
		@PostMapping("/producto/updateprod")
		public String updtaeprod(@ModelAttribute Productos p, Model model) {
			System.out.println(p);
			model.addAttribute("productos", repro.findById(p.getIdprod()));

			model.addAttribute("lstProveedor", reprove.findAll());
			
			//actualizar
			try {
				repro.save(p);
				model.addAttribute("success", "Proceso realizado con éxito");
			} catch (Exception e) {
				model.addAttribute("error", "error al registrar producto");
			}

			return "mantenimientoProd";
		}
	
	

	// metodo para el listado
	@GetMapping("/producto/listar")
	public String cargarListado(Model model) {
		model.addAttribute("lstProductos", repro.findAll());
		return "productos";
	}

	// metodo para que muestre los dtos en mantenimiento
	@PostMapping("/producto/mostrdatos")
	public String buscarProd(@ModelAttribute Productos p, Model model) {
		System.out.println(p);
		model.addAttribute("productos", repro.findById(p.getIdprod()));

		model.addAttribute("lstProveedores", reprove.findAll());

		return "mantenimientoProd";
	}
	
	//vista de carrito
	@GetMapping("/producto/carrito")
	public String cargarcarrin(Model model) {
		model.addAttribute("lstProductos", repro.findAll());
		return "carrito";
	}

}

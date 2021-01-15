package com.controller; 

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.model.producto.Producto;
import com.model.user.Usuario;
import com.service.IProductoService;
import com.util.Utilidades;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Value("${ruta.imagenes}")
	private String ruta;
	private Usuario usuario;
	

	@Autowired
	private IProductoService serviceProducto;
	
	@ModelAttribute
	public void init(Model modelo, HttpSession sesion) {
		usuario =  (Usuario) sesion.getAttribute("usuario");
		modelo.addAttribute("usuario", usuario);
	}
	
	@GetMapping("/list")
	public String list(Model modelo) {
		modelo.addAttribute("productos", serviceProducto.getAll());
		return "/producto/productoList";
	}
	@GetMapping("/create")
	public String create(Model modelo) {
		modelo.addAttribute("producto",new Producto());
		return "/producto/productoForm";
	}
	@PostMapping("/create")
	public String createForm(Producto producto, BindingResult resultado,@RequestParam("archivoImagen") MultipartFile imagen) {
		if(resultado.hasErrors()) {
			System.out.println(resultado.getAllErrors());
			return "redirect:/productos/create";
		}
		String rutaImg = Utilidades.guardarArchivo(imagen, ruta);
		if(rutaImg.endsWith("png")||rutaImg.endsWith("jpg"))producto.setImagen(rutaImg);
		serviceProducto.guardar(producto);
		return "redirect:/productos/list";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		serviceProducto.eliminar(id);
		return "redirect:/productos/list";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model modelo) {
		modelo.addAttribute("producto", serviceProducto.getById(id));
		return "producto/productoForm";
	}

}

package controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import model.Role;
import model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.RoleDAO;
import dao.UsuarioDAO;

@Controller
@Transactional
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO uDAO;

	@Autowired
	private RoleDAO rDAO;
	
	@RequestMapping("formularioUsuario")
	public String formularioUsuario(){
		return "formulario_usuario";
	}
	
	
	@RequestMapping("inserirUsuario")
	public String inserirUsuario(@Valid Usuario u, BindingResult r){
		if (r.hasErrors())
			return "formulario_usuario";
		
	
	u.addRole(new Role());
		uDAO.adicinar(u);
		System.out.println(u.toString() + "");
		return "usuario_adicionado";
	}
	
	@RequestMapping("formularioLogin")
	public String formularioLogin(){
		return "formulario_login";
	}
	
	@RequestMapping("loginUsuario")
	public String loginUsuario(Usuario u, HttpSession session){
		Usuario uBD = uDAO.buscarUsuario(u);
		if (uBD == null){
			return "formulario_login";
		}
		System.out.println(uBD.toString() + "controller");
		if (u.getSenha().equals(uBD.getSenha())){
			session.setAttribute("usuario", uBD);
			System.out.println("USUARIO SETADO!!");
			session.setAttribute("role", rDAO.buscarID(uBD.getId()));
			
			return "usuario_adicionado";
		}
		return "formulario_login";
		
	}
	
	@RequestMapping("listarUsuario")
	public String listarUsuario(Model m){
		List<Usuario> list = uDAO.listar();
		m.addAttribute("usuarios", list);
		return "listar_usuario";
	}
	
	@RequestMapping("alterarUsuario")
	public String alterarUsuario(Usuario u, BindingResult r){
		if (r.hasErrors())
			return "formulario_usuario";
		
		uDAO.alterar(u);
		return "redirect:listar_usuario";
	}
	
	@RequestMapping("removerUsuario")
	public String removerUsuario(Usuario u){
		uDAO.remover(u);
		return "redirect:listar_usuario";
	}
}

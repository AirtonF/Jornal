package controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import model.Comentario;
import model.Noticia;
import model.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.ComentarioDAO;

@Controller
@Transactional
public class ComentarioController {

	private ComentarioDAO cDAO;
	
	@RequestMapping("formularioComentario")
	public String formularioComentario(){
		return "formulario_comentario";
	}
	
	@RequestMapping("inserirComentario")
	public String inserirComentario(@Valid Comentario c, BindingResult result, HttpSession session){
		//FALTAR PEGAR USUARIO Do session e o ID da noticia
		
		Usuario u = new Usuario(1,"a","a","a","a", null);
		Noticia n = new Noticia();
		n.setId(1);
		
		c.setAutor(u);
		c.setIdNoticia(n);
		if(result.hasErrors())
			return "formulario_Comentario";
		
		cDAO.adicinar(c);
		return "comentario_inserido";
	}

	@RequestMapping("removerComentario")
	public String removerComentario(Comentario c){
		cDAO.remover(c);
		return "redirect:listar_comentario";
	}
	
	@RequestMapping("listarComentario")
	public String listarComentario(Model m){
		List<Comentario> list = cDAO.listar();
		m.addAttribute("comentario", list);
		return "listar_comentario";
	}

	@RequestMapping("alterarComentario")
	public String alterarComentario(Comentario c, BindingResult result){
		
		if(result.hasErrors())
			return "formulario_comentario";
		
		cDAO.alterar(c);
		return "redirect:listar_comentario";
	}
	
}

package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import model.Noticia;
import model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.NoticiaDAO;

@Controller
@Transactional
public class NoticiaController {
	
	@Autowired(required = false)
	private NoticiaDAO nDAO;
	
	@RequestMapping("formularioNoticia")
	public String formularioNoticia(){
		return "formulario_noticia";
	}

	@RequestMapping("inserirNoticia")
	public String inserirNoticia(Noticia n, HttpSession session){
		n.setAutor((Usuario)session.getAttribute("usuario"));
		n.setDataNoticia(new Date());
		nDAO.adicinar(n);
		System.out.println(n.toString());
		return "usuario_adicionado";
	}
		
	@RequestMapping("listarNoticia")
	public String listarNoticia(Model m){
		List<Noticia> list = nDAO.listar();
		m.addAttribute("noticias", list);
		return "listar_noticia";
	}
	
	@RequestMapping("removerNoticia")
	public String removerNoticia(Noticia n){
		nDAO.remover(n);
		return "redirect:listar_noticia";
	}
	
	@RequestMapping ("alterarNoticia")
	public String alterarNoticia(Noticia n, BindingResult result){
	 if (result.hasErrors())
		return "formulario_Noticia";
	
	nDAO.alterar(n);
	return "redirect:listar_noticia";
	}
	
		
	}


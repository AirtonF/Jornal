package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import model.Noticia;
import model.Secao;
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
	//	Usuario u = (Usuario)session.getAttribute("usuario");
		
		
		// falta so pegar pegar usuario e secao do session 
		Usuario u = new Usuario(1,"a","a","a","a", null);
		Secao s = new Secao(1, "a", "a");
		
		n.setAutor(u);
		n.setSecao(s);
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


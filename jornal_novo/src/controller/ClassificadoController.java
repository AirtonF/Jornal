package controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import model.Classificado;
import model.Noticia;
import model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.ClassificadoDAO;

@Controller
@Transactional
public class ClassificadoController {

	@Autowired
	private ClassificadoDAO cDAO;

	@RequestMapping("formularioClassificado")
	public String formularioClassificado(){
		return "formulario_classificado";
	}
	
	@RequestMapping("inserirClassificado")
	public String inserirClassificado(@Valid Classificado c, BindingResult result){
		if(result.hasErrors())
			return "formulario_classificado";
		//FALTAR PEGAR USUARIO Do session e o ID da noticia
		
				Usuario u = new Usuario(1,"a","a","a","a", null);
				
		
				c.setAutor(u);
				c.setDataOferta(new Date());
		cDAO.adicinar(c);
		return "usuario_adicionado";
	}

	@RequestMapping("removerClassificado")
	public String removerClassificado(Classificado c){
		cDAO.remover(c);
		return "redirect:listar_classificado";
	}
	
	@RequestMapping("listarClassificado")
	public String listarClassificado(Model m){
		List<Classificado> list = cDAO.listar();
		m.addAttribute("classificados", list);
		return "listar_classificado";
	}

	@RequestMapping("alterarClassificado")
	public String alterarClassificado(Classificado c, BindingResult result){
		
		if(result.hasErrors())
			return "formulario_classificado";
		
		cDAO.alterar(c);
		return "redirect:listar_classificado";
	}
}


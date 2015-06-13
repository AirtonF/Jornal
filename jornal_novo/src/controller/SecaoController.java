package controller;

import java.util.List;

import javax.validation.Valid;

import model.Secao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.SecaoDAO;

@Controller
@Transactional
public class SecaoController {

	@Autowired
	private SecaoDAO sDAO;
	
	@RequestMapping("formularioSecao")
	public String formularioSecao(){
		return "formulario_secao";
	}
	
	
	@RequestMapping("inserirSecao")
	public String inserirSecao(@Valid Secao s, BindingResult r){
		if(r.hasErrors())
			return "formulario_secao";
		
		System.out.println(s.toString() +"CONTROLLER");
		sDAO.adicinar(s);
		return "usuario_adicionado";
	}
	
	@RequestMapping("alrerarSecao")
	public String alterarSecao(Secao s, BindingResult r){
		if(r.hasErrors())
			return "formulario_secao";

		sDAO.alterar(s);
		return "redirect:listarSecao";
	}

	@RequestMapping("removerSecao")
	public String removerSecao(Secao s){
		sDAO.remover(s);
		return "redirect:listarSecao";
	}
	
	@RequestMapping("listarSecao")
	public String listarSecao(Model m){
		List<Secao> list = sDAO.listar();
		m.addAttribute("secaos", list);
	 	return "listar_secao";
	}
}
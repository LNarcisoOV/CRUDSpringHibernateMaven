package br.com.CRUDSpringHibernateMaven.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.CRUDSpringHibernateMaven.infra.MensagensPadronizadas;
import br.com.CRUDSpringHibernateMaven.model.Usuario;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String paginaDeLogin(){		
		return "login/Login";
	}
	
	@RequestMapping(value="/login/logar", method = RequestMethod.POST)
	public String efetuarLogin(@Valid Usuario usuario, BindingResult result, ModelMap model, HttpSession session){
		String mensagem = null;
		boolean podeLogar = false;
		
		if(result.hasFieldErrors("username") || result.hasFieldErrors("senha")){			
			mensagem = "Erro no login! Username ou senha errados!";
			model.addAttribute("mensagemTitulo", mensagem);
			return "forward:/login";
		}else{
			
			//Aqui teria uma validação mais precisa do usuário, acessando o service por meio de interface.
			if(usuario != null){
				podeLogar = true;		
			}
		}
		
		if(podeLogar){
			mensagem = new MensagensPadronizadas().loginSucesso;
			session.setAttribute("usuarioLogado", usuario);
			return "redirect:/menu";
		}else{
			mensagem = new MensagensPadronizadas().loginErro;
			model.addAttribute("mensagemTitulo", mensagem);
			return "forward:/login";
		}
	}
	
	@RequestMapping("/login/logout")
	public String logout(HttpSession session, ModelMap model){
		String mensagem = "Logout efetuado com sucesso!";
		model.addAttribute("mensagemTitulo", mensagem);
		session.invalidate();
		return paginaDeLogin();
	}
	
	@RequestMapping("/erro")
	public String paginaDeErro(HttpSession session, ModelMap model){
		return "erro/Erro";
	}
}

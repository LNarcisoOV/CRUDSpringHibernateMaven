package br.com.CRUDSpringHibernateMaven.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.CRUDSpringHibernateMaven.infra.MensagensPadronizadas;
import br.com.CRUDSpringHibernateMaven.model.Produto;

@Controller
public class ProdutoController {
	private MensagensPadronizadas mensagensPadronizadas = new MensagensPadronizadas();
	
	List<Produto> listaDeProdutosCadastrados = new ArrayList<Produto>(); 
			
	
	public ProdutoController(){
	}
	
	@RequestMapping("/produto")
	public String paginaDeCadastro() {
		return "produto/PaginaDeCadastro";
	}

	@RequestMapping(value = "/produto/salvarProduto", method = RequestMethod.POST)
	public String salvarProduto(@Valid Produto produto, BindingResult result, ModelMap model) {
		String mensagem = null;

		if (result.hasFieldErrors("nome") || result.hasFieldErrors("descricao") || result.hasFieldErrors("preco")) {
			mensagem = mensagensPadronizadas.erroAoCadastrarProduto;
			model.addAttribute("mensagemTituloProduto", mensagem);
			return "forward:/produto";
		} else {
			try {
				
				listaDeProdutosCadastrados.add(produto);
				mensagem = mensagensPadronizadas.produtoAdicionadoComSucesso;

			} catch (ValidationException e) {
				mensagem = e.getMessage();
			}

			model.addAttribute("mensagemTituloProduto", mensagem);
			return "forward:/produto";
		}
	}

	@RequestMapping(value = "/produto/PaginaDeConsulta")
	public String paginaDeLista(ModelMap model) {
		return "produto/PaginaDeConsulta";
	}
	
	@RequestMapping(value = "/produto/consultarProdutos", method = RequestMethod.POST)
	public String consultarProdutos(ModelMap model) {
		model.addAttribute("listaDeProdutosCadastrados", listaDeProdutosCadastrados);
		return "produto/PaginaDeConsulta";
	}

	@RequestMapping("/produto/editar")
	public String paginaDeEdicao(Long produtoId, ModelMap model) {
		return "produto/PaginaDeEdicao";
	}

	@RequestMapping("/produto/salvarEdicao")
	public String salvarEdicao(@Valid Produto produto, BindingResult result, ModelMap model) {
		String mensagem = null;
		if (result.hasFieldErrors("nome") || result.hasFieldErrors("descricao") || result.hasFieldErrors("preco")) {
			mensagem = mensagensPadronizadas.erroAoEditarProduto;
			model.addAttribute("mensagemTituloProduto", mensagem);
			return "forward:/produto/editar";
		} else {
			mensagem = "Produto editado com sucesso!";
			model.addAttribute("mensagemTituloProduto", mensagem );
			return "forward:/produto/visualizarProdutos";
		}
	}
}

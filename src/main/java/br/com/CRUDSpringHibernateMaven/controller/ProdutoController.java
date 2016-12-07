package br.com.CRUDSpringHibernateMaven.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.CRUDSpringHibernateMaven.infra.MensagensPadronizadas;
import br.com.CRUDSpringHibernateMaven.model.Produto;
import br.com.CRUDSpringHibernateMaven.service.ProdutoService;

@Controller
public class ProdutoController {
	private MensagensPadronizadas mensagensPadronizadas = new MensagensPadronizadas();
	
	List<Produto> listaDeProdutosCadastrados = new ArrayList<Produto>(); 
	ProdutoService produtoService = new ProdutoService();
		
	@RequestMapping("/produto")
	public String paginaDeCadastro() {
		return "produto/PaginaDeCadastro";
	}
	
	@RequestMapping("/produto/PaginaDeEdicao/{number}")
	public String paginaDeEdicao(@PathVariable("number") Long idProduto,  ModelMap model) {
		for(Produto produto : listaDeProdutosCadastrados){
			if(produto.getId().equals(idProduto)){
				model.addAttribute("produto", produto);
			}
		}
		return "produto/PaginaDeEdicao";
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
				
				Integer id = null;
				id = (listaDeProdutosCadastrados.size() + 1);
				
				produto.setId(Long.parseLong(id.toString()));
				produto = produtoService.preparaProdutoParaCadastro(produto);
				
				listaDeProdutosCadastrados.add(produto);
				mensagem = mensagensPadronizadas.produtoAdicionadoComSucesso;

			} catch (ValidationException e) {
				mensagem = e.getMessage();
			}

			model.addAttribute("mensagemTituloProduto", mensagem);
			return "forward:/produto";
		}
	}
	
	@RequestMapping(value = "/produto/salvarEdicao", method = RequestMethod.POST)
	public String salvarEdicao(@Valid Produto produto, BindingResult result, ModelMap model) {
		String mensagem = null;

		if (result.hasFieldErrors("nome") || result.hasFieldErrors("descricao") || result.hasFieldErrors("preco")) {
			mensagem = "Erro ao editar produto. Preencha todos os campos corretamente.";
			model.addAttribute("mensagemTituloProduto", mensagem);
			return "forward:/produto/PaginaDeEdicao/" + produto.getId();
		} else {
			try {
				
				for (Iterator<Produto> i = listaDeProdutosCadastrados.iterator(); i.hasNext();) {
					  Produto prod = i.next();
					  if (prod.getId().equals(produto.getId())) {
					    i.remove();
					    break;
					  }
				}
				
				listaDeProdutosCadastrados.add(produto);
				
				mensagem = "Produto editado com sucesso!";

			} catch (ValidationException e) {
				mensagem = e.getMessage();
			}

			model.addAttribute("mensagemTituloProduto", mensagem);
			return "forward:/produto/PaginaDeEdicao/" + produto.getId();
		}
	}
	
	@RequestMapping("/produto/Excluir/{number}")
	public String removerProduto(@PathVariable("number") Long idProduto, ModelMap model) {
		for (Iterator<Produto> i = listaDeProdutosCadastrados.iterator(); i.hasNext();) {
			  Produto prod = i.next();
			  if (prod.getId().equals(idProduto)) {
			    i.remove();
			    break;
			  }
		}
		model.addAttribute("mensagemTituloProduto", "Produto removido com sucesso.");
		return "forward:/produto/PaginaDeConsulta";
	}

	@RequestMapping(value = "/produto/PaginaDeConsulta")
	public String paginaDeConsulta(ModelMap model) {
		return "produto/PaginaDeConsulta";
	}
	
	@RequestMapping(value = "/produto/consultarProdutos", method = RequestMethod.POST)
	public String consultarProdutos(ModelMap model) {
		model.addAttribute("listaDeProdutosCadastrados", listaDeProdutosCadastrados);
		return "produto/PaginaDeConsulta";
	}
}

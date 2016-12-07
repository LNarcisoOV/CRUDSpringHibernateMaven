package br.com.CRUDSpringHibernateMaven.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import br.com.CRUDSpringHibernateMaven.model.Produto;

@Service
public class ProdutoService implements Produtos{

	public Produto preparaProdutoParaCadastro(Produto produto){
		produto.setDataCadastro(Calendar.getInstance().getTime());
		return produto;
	}
}

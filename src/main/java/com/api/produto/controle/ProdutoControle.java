package com.api.produto.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.produto.modelo.ProdutoModelo;
import com.api.produto.repositorio.ProdutoRepositorio;

@RestController
@RequestMapping("/api")
public class ProdutoControle {
	
	//Ações
	@Autowired
	private ProdutoRepositorio acoes; //pra dizer pro Spring que esse "acoes" é um repositorio a gente coloca a anotação @Autowired
	
	// Listar produtos
	@RequestMapping(value="/produtos", method=RequestMethod.GET) //aqui temos um controle "valor /produtos"
	public @ResponseBody List<ProdutoModelo> listar() {
		return acoes.findAll(); //o retorno vai ser do tipo List ProdutoModeo, que no caso é o findAll
	}
	
	// Cadastrar produtos
	@RequestMapping(value="/produtos", method=RequestMethod.POST) //ele vai executar essa posição de cadastro
	public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo produto) {
		return acoes.save(produto); //o save pede um ProdMod do tipo produto
	}
	

}

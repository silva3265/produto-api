package com.api.produto.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.produto.modelo.ProdutoModelo;
import com.api.produto.modelo.RespostaModelo;
import com.api.produto.repositorio.ProdutoRepositorio;

@RestController
@RequestMapping("/api")
public class ProdutoControle {
	
	//Ações
	@Autowired
	private ProdutoRepositorio acoes; //pra dizer pro Spring que esse "acoes" é um repositorio a gente coloca a anotação @Autowired
	
	// Listar Produtos
	@RequestMapping(value="/produtos", method=RequestMethod.GET) //aqui temos um controle "valor /produtos"
	public @ResponseBody List<ProdutoModelo> listar() {
		return acoes.findAll(); //o retorno vai ser do tipo List ProdutoModeo, que no caso é o findAll
	}
	
	// Cadastrar Produtos
	@RequestMapping(value="/produtos", method=RequestMethod.POST) //ele vai executar essa posição de cadastro
	public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo produto) {
		return acoes.save(produto); //o save pede um ProdMod do tipo produto
	}
	
	// Filtrar Produtos
	//Metodo para filtrar dados com o @Pathvariable
	@RequestMapping(value="/produtos/{codigo}", method=RequestMethod.GET) //pode ser "id" ou "codigo", ou qualquer outro nome
	public @ResponseBody ProdutoModelo filtrar(@PathVariable Integer codigo) {
		return acoes.findByCodigo(codigo);
	}
	
	// Alterar Produtos
	// o save pode ser utilizado para cadastro ou para alteração, a unica coisa que muda é a requisição (POST para PUT)
	@RequestMapping(value="/produtos", method=RequestMethod.PUT) //
	public @ResponseBody ProdutoModelo alterar(@RequestBody ProdutoModelo produto) {
		return acoes.save(produto);
	}
	
	//Remover Produtos
	//Primeiro vamos pegar o codigo, depois tranformar esse codigo no nosso produto e em seguida vamos fazer a exclusao
	@RequestMapping(value="/produtos/{codigo}", method=RequestMethod.DELETE)
	public @ResponseBody RespostaModelo remover(@PathVariable Integer codigo) {
		
		RespostaModelo resposta = new RespostaModelo();
		
		try {
			ProdutoModelo produto = filtrar(codigo);
			this.acoes.delete(produto);
			resposta.setMensagem("Produto removido com sucesso");
		}catch(Exception erro) {
			resposta.setMensagem("Falaha ao remover: " + erro.getMessage());
			}
		 
		return resposta;
		
	}

}







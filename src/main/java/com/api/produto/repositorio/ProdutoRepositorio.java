package com.api.produto.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.produto.modelo.ProdutoModelo;

public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Integer>{
	
	// Listar Todos os produtos
	List<ProdutoModelo> findAll(); //findAll() - comando para Fazer o select pelo o JPA
	
	// Pesquisar por codigo
	ProdutoModelo findByCodigo(int codigo); //"Procurar/percorrer pela a coluna Codigo" 
	
	// Remover produto
	void delete(ProdutoModelo produto); //para deletar tem que passar um Objeto, objeto do tipo ModeloProduto
	
	// Cadastrar/Alterar produto
	//ProdutoModelo save(ProdutoModelo produto); //Pra salvar tem que passra um objeto do tipo ProdutoModelo
	<ProdMod extends ProdutoModelo> ProdMod save (ProdMod produto);
}

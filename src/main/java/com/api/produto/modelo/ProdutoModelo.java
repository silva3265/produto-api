package com.api.produto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Vai criar uma tabela "ProdutoModelo" no banco de dados
@Table(name="produtos") //podemos renomear a tabela tambem
public class ProdutoModelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo") //não necessariamente precisa ser o nome igual ao do atributo
	private int codigo;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="valor")
	private Double valor;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

}
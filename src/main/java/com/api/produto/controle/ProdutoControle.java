package com.api.produto.controle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProdutoControle {
	
	// Pagina de Inicio
	@RequestMapping(value="", method=RequestMethod.GET)
	public @ResponseBody String Inicio() {
		return "Bem vindo a API de produtos";
	}
	
	// Pagia de Sobre
	@RequestMapping(value="/sobre", method=RequestMethod.GET)
	public @ResponseBody String Sobre() {
		return "Sobre a API...";
	}
	
	// Pagina de Contato
	@RequestMapping(value="/contato", method=RequestMethod.GET)
	public @ResponseBody String Contato() {
		return "Fale Conosco :";
	}

}

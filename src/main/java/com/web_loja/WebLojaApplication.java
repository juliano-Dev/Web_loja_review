package com.web_loja;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web_loja.domain.Categoria;
import com.web_loja.domain.Produto;
import com.web_loja.repositories.CategoriaRespository;
import com.web_loja.repositories.ProdutoRespository;

@SpringBootApplication
public class WebLojaApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRespository categoriaRespository;

	@Autowired
	private ProdutoRespository produtoRespository;

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(WebLojaApplication.class, args);


	}

    @Override
    public void run(String... args) throws Exception {

		Categoria c1 = new Categoria(null, "Informatica");
		Categoria c2 = new Categoria(null, "Escritorio");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		c1.getProdutos().addAll(List.of(p1, p2, p3));
		c1.getProdutos().add(p2);

		p1.getCategorias().add(c1);
		p2.getCategorias().addAll(List.of(c1, c2));
		p3.getCategorias().add(c1);

		categoriaRespository.saveAll(List.of(c1, c2));
		produtoRespository.saveAll(List.of(p1, p2, p3));

    }

}

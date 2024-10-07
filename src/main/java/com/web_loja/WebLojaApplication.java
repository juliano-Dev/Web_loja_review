package com.web_loja;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web_loja.domain.Categoria;
import com.web_loja.domain.Cidade;
import com.web_loja.domain.Cliente;
import com.web_loja.domain.Endereco;
import com.web_loja.domain.Estado;
import com.web_loja.domain.Pagamento;
import com.web_loja.domain.PagamentoBoleto;
import com.web_loja.domain.PagamentoCartao;
import com.web_loja.domain.Pedido;
import com.web_loja.domain.Produto;
import com.web_loja.domain.enums.EstadoPagamento;
import com.web_loja.domain.enums.TipoCliente;
import com.web_loja.repositories.CategoriaRespository;
import com.web_loja.repositories.CidadeRespository;
import com.web_loja.repositories.ClienteRespository;
import com.web_loja.repositories.EnderecoRepository;
import com.web_loja.repositories.EstadoRespository;
import com.web_loja.repositories.PagamentoRepository;
import com.web_loja.repositories.PedidoRepository;
import com.web_loja.repositories.ProdutoRespository;

@SpringBootApplication
public class WebLojaApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRespository categoriaRespository;

	@Autowired
	private ProdutoRespository produtoRespository;

	@Autowired
	private EstadoRespository estadoRepository;

	@Autowired
	private CidadeRespository cidadeRespository;

	@Autowired
	private ClienteRespository clienteRespository;

	@Autowired
	private EstadoRespository estadoRespository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRespository;

	@Autowired
	private PagamentoRepository pagamentoRepository;


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

		Estado e1 = new Estado(null, "RS");
		Estado e2 = new Estado(null, "SC");

		Cidade cid1 = new Cidade(null, "Porto Alegre", e1);
		Cidade cid2 = new Cidade(null, "Canoas", e1);
		Cidade cid3 = new Cidade(null, "Floripa", e2);
		Cidade cid4 = new Cidade(null, "Garopaba", e2);

		e1.getCidades().addAll(Arrays.asList(cid1, cid2));
		e2.getCidades().addAll(Arrays.asList(cid3, cid4));

		estadoRepository.saveAll(List.of(e1, e2));
		cidadeRespository.saveAll(List.of(cid1, cid2, cid3, cid4));

		Cliente cliente1 = new Cliente(null, "Novo cliente ", "cliente@cliente", "4234234234234", TipoCliente.PESSOA_FISICA);
		Cliente cliente2 = new Cliente(null, "Novo cliente2 ", "cliente2@cliente2", "4234234234234", TipoCliente.PESSOA_FISICA);
		cliente1.getTelefones().addAll(Arrays.asList("123123123", "456456456"));
		cliente2.getTelefones().addAll(Arrays.asList("222222", "4444444"));


		Endereco endereco1 = new Endereco(null, "Av. Brasil ", "1000", "CASA ", "São João ",  "91000-000", cliente1, cid1);
		Endereco endereco2 = new Endereco(null, "Av. Farrapos ", "1000", "CASA ", "Centro ",  "91000-000", cliente2, cid2);

		cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
		cliente2.getEnderecos().addAll(Arrays.asList(endereco1));

		clienteRespository.saveAll(List.of(cliente1, cliente2));
		enderecoRepository.saveAll(List.of(endereco1, endereco2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, cliente1, endereco1, sdf.parse("01/04/2024 11:00"));
		Pedido ped2 = new Pedido(null, cliente1, endereco2, sdf.parse("01/04/2024 10:00"));
		
		Pagamento pagto1 = new PagamentoCartao(null, 2 ,ped1, EstadoPagamento.QUITADO);
		Pagamento pagto2 = new PagamentoBoleto(null, sdf.parse("20/01/2022 08:55"), null, ped2, EstadoPagamento.PENDENTE);

		ped1.setPagamento(pagto1);
		ped2.setPagamento(pagto2);

		cliente1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRespository.saveAll(List.of(ped1, ped2));
		pagamentoRepository.saveAll(List.of(pagto1, pagto2));




    }

}

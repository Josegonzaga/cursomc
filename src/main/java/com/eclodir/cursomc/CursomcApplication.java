package com.eclodir.cursomc;


import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eclodir.cursomc.domain.Categoria;
import com.eclodir.cursomc.domain.Cidade;
import com.eclodir.cursomc.domain.Cliente;
import com.eclodir.cursomc.domain.Endereco;
import com.eclodir.cursomc.domain.Estado;
import com.eclodir.cursomc.domain.Pagamento;
import com.eclodir.cursomc.domain.PagamentoComBoleto;
import com.eclodir.cursomc.domain.PagamentoComCartao;
import com.eclodir.cursomc.domain.Pedido;
import com.eclodir.cursomc.domain.Produto;
import com.eclodir.cursomc.domain.enums.EstadoPagamento;
import com.eclodir.cursomc.domain.enums.TipoCliente;
import com.eclodir.cursomc.repositories.CategoriaRepository;
import com.eclodir.cursomc.repositories.CidadeRepository;
import com.eclodir.cursomc.repositories.ClienteRepository;
import com.eclodir.cursomc.repositories.EnderecoRepository;
import com.eclodir.cursomc.repositories.EstadoRepository;
import com.eclodir.cursomc.repositories.PagamentoRepository;
import com.eclodir.cursomc.repositories.PedidoRepository;
import com.eclodir.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
	
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
	
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.save(Arrays.asList(est1,est2));
		cidadeRepository.save(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria da Silva", "maria.silva@gmail.com", "00000000000", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("00000000","99999999"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "apt 3B", "Jardim", "76030000", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "30", "apt 3B", "America", "68516000", cli1, c2);
		
		cli1.setEnderecos(Arrays.asList(e1,e2));
		
		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("10/12/2017 12:45"),e1,cli1);
		Pedido ped2 = new Pedido(null, sdf.parse("11/12/2017 14:45"),e2,cli1);
		
		Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/12/2017 12:30"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		
		pedidoRepository.save(Arrays.asList(ped1,ped2));
		pagamentoRepository.save(Arrays.asList(pagto1, pagto2));
		
		
		
	}
}

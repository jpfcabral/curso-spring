package com.joaopedro.cursomc;

import java.util.Arrays;

import com.joaopedro.cursomc.domain.Categoria;
import com.joaopedro.cursomc.domain.Cidade;
import com.joaopedro.cursomc.domain.Cliente;
import com.joaopedro.cursomc.domain.Endereco;
import com.joaopedro.cursomc.domain.Estado;
import com.joaopedro.cursomc.domain.Produto;
import com.joaopedro.cursomc.domain.enums.TipoCliente;
import com.joaopedro.cursomc.repositories.CategoriaRepository;
import com.joaopedro.cursomc.repositories.CidadeRepository;
import com.joaopedro.cursomc.repositories.ClienteRepository;
import com.joaopedro.cursomc.repositories.EnderecoRepository;
import com.joaopedro.cursomc.repositories.EstadoRepository;
import com.joaopedro.cursomc.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

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

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Capinas", est2);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));

		Cliente cli1 = new Cliente(null, "Maria", "ala@gmail.com", "70220925402", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("31654561", "5454665"));

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "apt 101", "32410", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua AA", "AA", "apt 102", "2", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}

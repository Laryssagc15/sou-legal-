package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Cidade;
import com.example.demo.domain.Cliente;
import com.example.demo.domain.Endereco;
import com.example.demo.domain.Estado;
import com.example.demo.domain.enuns.TipoCliente;
import com.example.demo.repositories.CidadeRepository;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.EnderecoRepository;
import com.example.demo.repositories.EstadoRepository;

@SpringBootApplication
public class CursoSenaiApplication implements CommandLineRunner {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienterepository;

	@Autowired
	private EnderecoRepository enderecorepository;

	@Autowired
	private CidadeRepository cidaderepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoSenaiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		estadoRepository.saveAll(Arrays.asList(est1, est2));

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		cidaderepository.saveAll(Arrays.asList(c1, c2));

		Cliente cli1 = new Cliente(null, "Crispim Luiz", "12345678987", "c.luiz@fieng.com.br",
				TipoCliente.PESSOAFISICA);
		Cliente cli2 = new Cliente(null, "GodoFredo", "987654321", "teste@fieng.com.br", TipoCliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("34900000000", "98765432112"));
		cli1.getTelefones().addAll(Arrays.asList("34900000123", "96765400000"));
		cli2.getTelefones().addAll(Arrays.asList("7777777777", "99999999999"));
		clienterepository.saveAll(Arrays.asList(cli1, cli2));

		Endereco e1 = new Endereco(null, "Rua das Emboabas", "55b", "Ap 310", "Jardim", "3844587", cli1);
		Endereco e2 = new Endereco(null, "Rua Alameda Nasciute", "234", null, "Centro", "3455098", cli2);
		cli1.getEnderecos().addAll(Arrays.asList(e1));
		cli2.getEnderecos().addAll(Arrays.asList(e2));
		enderecorepository.saveAll(Arrays.asList(e1, e2));

	}

	public ClienteRepository getClienterepository() {
		return clienterepository;
	}

	public void setClienterepository(ClienteRepository clienterepository) {
		this.clienterepository = clienterepository;
	}

	public EnderecoRepository getEnderecorepository() {
		return enderecorepository;
	}

	public void setEnderecorepository(EnderecoRepository enderecorepository) {
		this.enderecorepository = enderecorepository;
	}

	public CidadeRepository getCidaderepository() {
		return cidaderepository;
	}

	public void setCidaderepository(CidadeRepository cidaderepository) {
		this.cidaderepository = cidaderepository;
	}
}
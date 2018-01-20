package br.com.fiap.helper;

import java.time.LocalDate;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Servico;

public class Dados {
	
	public static void insereClientesEServicos(GenericDao<Cliente> clienteDao) {
		
		Cliente cliente = new Cliente("Marcelo", "Endereco Um", LocalDate.of(2017, 10, 01), 01);		
		Servico servico = new Servico("Internet 15MB", 45.00, LocalDate.of(2017, 10, 01), cliente);
		Servico servico2 = new Servico("Assinatura Streaming", 25.00, LocalDate.of(2017, 12, 01), cliente);
		cliente.getServicos().add(servico);
		cliente.getServicos().add(servico2);
		
		clienteDao.adicionar(cliente);

		cliente = new Cliente("Thiago", "Endereco Dois", LocalDate.of(2018, 1, 01), 01);
		servico = new Servico("Internet 30MB", 60.00, LocalDate.of(2018, 1, 01), cliente);
		cliente.getServicos().add(servico);

		clienteDao.adicionar(cliente);
		
		cliente = new Cliente("Higor", "Endereco Três", LocalDate.of(2017, 8, 01), 01);
		servico = new Servico("Internet 45MB", 75.00, LocalDate.of(2017, 8, 01), cliente);
		cliente.getServicos().add(servico);
		
		clienteDao.adicionar(cliente);
	}

}

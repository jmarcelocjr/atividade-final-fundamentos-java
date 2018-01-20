package br.com.fiap.main;

import java.time.LocalDate;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Faturamento;
import br.com.fiap.helper.Dados;
import br.com.fiap.helper.Faturar;

public class Main {

	public static void main(String[] args) throws Exception {
		GenericDao<Cliente> clienteDao = new GenericDao<>(Cliente.class);
		
		Dados.insereClientesEServicos(clienteDao);
		
		LocalDate dataFaturamento = LocalDate.of(2018, 01, 01);
		GenericDao<Faturamento> faturamentoDao = new GenericDao<>(Faturamento.class);
		
		Faturar.faturarClientes(dataFaturamento, clienteDao, faturamentoDao);
		
		Faturar.listaFaturamento(dataFaturamento, faturamentoDao);
	}

}

package br.com.fiap.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Faturamento;
import br.com.fiap.helper.Dados;
import br.com.fiap.helper.Faturar;

public class Main {

	public static void main(String[] args) throws Exception {
		GenericDao<Cliente> clienteDao = new GenericDao<>(Cliente.class);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

		Dados.insereClientesEServicos(clienteDao);
		
		System.out.println("Informe a data que deseja faturar");
		Scanner scanner = new Scanner(System.in);
		String data = scanner.next();

		LocalDate dataFaturamento = LocalDate.parse(data, formatter);;
		GenericDao<Faturamento> faturamentoDao = new GenericDao<>(Faturamento.class);
		
		Faturar.faturarClientes(dataFaturamento, clienteDao, faturamentoDao);
		
		Faturar.listaFaturamento(dataFaturamento, faturamentoDao);
	}

}

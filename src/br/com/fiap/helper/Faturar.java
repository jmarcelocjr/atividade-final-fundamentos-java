package br.com.fiap.helper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Faturamento;

public class Faturar {

	public static void faturarClientes(
		LocalDate dataFaturamento,
		GenericDao<Cliente> clienteDao,
		GenericDao<Faturamento> faturamentoDao
	) throws Exception {
		List<Cliente> clientes = clienteDao.listar();
		
		for(Cliente cliente : clientes) {
			if(cliente.getDiaFaturamento() != dataFaturamento.getDayOfMonth()) {
				continue;
			}

			Faturamento faturamento = new Faturamento(cliente, cliente.getServicos(), dataFaturamento);
			faturamento.faturar();
			faturamentoDao.adicionar(faturamento);									
		}
	}
	
	public static void listaFaturamento(LocalDate dataFaturamento, GenericDao<Faturamento> faturamentoDao){
		List<Faturamento> faturamentos = faturamentoDao.listar();

		faturamentos = faturamentos
				.stream()
				.filter(faturamento -> faturamento.getData().isEqual(dataFaturamento))
				.collect(Collectors.toList());

		
		System.out.println("Data Faturamento "+dataFaturamento.toString());
		System.out.println("<=================================================>");

		for(Faturamento faturamento : faturamentos) {
			System.out.println("Cliente: "+faturamento.getCliente().getNome());
			System.out.println("Valor: "+faturamento.getTotal());
			System.out.println("<=================================================>");
		}
	}

}

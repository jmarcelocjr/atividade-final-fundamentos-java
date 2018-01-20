package br.com.fiap.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Faturamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne() 
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	@ManyToMany()
	@JoinTable(name = "faturamento_servico", catalog = "faturamento",
			joinColumns = {
				@JoinColumn(name = "id_faturamento", nullable = false, updatable = false) 
			},
			inverseJoinColumns = {
				@JoinColumn(name = "id_servico", nullable = false, updatable = false) 
			}
	)
	private List<Servico> servicos;
	
	@Column
	private LocalDate data;

	@Column
	private double total;
	
	public Faturamento() {
	}

	public Faturamento(Cliente cliente, List<Servico> servicos, LocalDate data) {
		super();
		this.cliente = cliente;
		this.servicos = servicos;
		this.data = data;
	}
	
	public void faturar() throws Exception {
		if(this.cliente == null || this.servicos == null) {
			throw new Exception("necessario definir o cliente e os servicos");
		}
		
		this.total = 0;
		for(Servico servico : this.servicos) {
			this.total += servico.getValor();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}

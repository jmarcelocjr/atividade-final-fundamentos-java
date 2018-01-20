package br.com.fiap.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Servico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String descricao;
	
	@Column
	private double valor;
	
	@Column
	private LocalDate dataAtivacao;
	
	@ManyToOne() 
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	public Servico() {
	}
	
	public Servico(String descricao, double valor, LocalDate dataAtivacao, Cliente cliente) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.dataAtivacao = dataAtivacao;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getDataAtivacao() {
		return dataAtivacao;
	}

	public void setDataAtivacao(LocalDate dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}

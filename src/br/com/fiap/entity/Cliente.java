package br.com.fiap.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;

	@Column
	private String endereco;

	@Column
	private LocalDate dataCadastro;
	
	@Column
	private int diaFaturamento;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER,mappedBy = "cliente")
	private List<Servico> servicos;
	
	public Cliente() {
		super();
		this.servicos = new ArrayList<>();
	}

	public Cliente(String nome, String endereco, LocalDate dataCadastro, int diaFaturamento) {
		this();
		this.nome = nome;
		this.endereco = endereco;
		this.dataCadastro = dataCadastro;
		this.diaFaturamento = diaFaturamento;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public int getDiaFaturamento() {
		return diaFaturamento;
	}

	public void setDiaFaturamento(int diaFaturamento) {
		this.diaFaturamento = diaFaturamento;
	}	
}

package br.com.crud.model;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.crud.converter.LocalDateDeserializer;
import br.com.crud.converter.LocalDateSerializer;

/**
 * Classe Pessoa
 * 
 * @author adriano.ribeiro
 *
 */
public class Pessoa {
	
	@Id
	private String id;
	
	@NotEmpty(message = "{pessoa.nome.vazio}")
	private String nome;
	
	@NotEmpty(message = "{pessoa.cpf.vazio}")
	private String cpf;
	
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate dtNascimento;
	
	@NotNull(message = "{pessoa.endereco.vazio}")
	@Valid
	private Endereco endereco;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}

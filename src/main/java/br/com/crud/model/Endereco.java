package br.com.crud.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * Classe endereço.
 * 
 * @author adriano.ribeiro
 *
 */
public class Endereco {

	@NotEmpty(message = "{endereco.logradouro.vazio}")
	private String logradouro;

	@NotEmpty(message = "{endereco.bairro.vazio}")
	private String bairro;
	
	@NotEmpty(message = "{endereco.cidade.vazio}")
	private String cidade;
	
	@NotEmpty(message = "{endereco.uf.vazio}")
	@Size(max=2, min=2, message = "{endereco.uf.tamanho}")
	private String uf;
	
	@NotEmpty(message = "{endereco.cep.vazio}")
	@Pattern(regexp = "\\d{8}", message = "{endereco.cep.tamanho}")
	private String cep;
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
}

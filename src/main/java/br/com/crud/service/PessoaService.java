package br.com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.model.Pessoa;
import br.com.crud.repository.PessoaRepository;

/**
 * 
 * Pessoa Service.
 * 
 * @author adriano.ribeiro
 *
 */
@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	/**
	 * Salva uma pessoa;
	 * @param pessoa - Pessoa
	 */
	public void save(final Pessoa pessoa){
		pessoaRepository.save(pessoa);
	}
	
	/**
	 * Retorna a pessoa pesquisada.
	 * @return Pessoa - `Pessoa.
	 */
	public Pessoa findOne(final String id){
		return pessoaRepository.findOne(id);
	}
	
	/**
	 * Retorna todas as pessoas cadastradas.
	 * @return list - Lista de pessoas.
	 */
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
	}
	
	/**
	 * Deleta uma pessoa.
	 * @param id
	 */
	public void delete(final String id){
		pessoaRepository.delete(id);
	}
}

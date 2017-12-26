package br.com.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.crud.model.Pessoa;
import br.com.crud.service.PessoaService;

/**
 * Pessoa Controller.
 * 
 * @author adriano.ribeiro
 *
 */
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	/**
	 * Retorna todas as pessoas cadastradas.
	 * @return list - Lista de pessoas.
	 */
	@GetMapping
	public List<Pessoa> findAll(){
		return pessoaService.findAll();
	}
	
	/**
	 * Retorna a pessoa pesquisada.
	 * @return Pessoa - `Pessoa.
	 */
	@GetMapping(value="/{id}")
	public Pessoa findOne(@PathVariable String id){
		return pessoaService.findOne(id);
	}
	
	/**
	 * Salva uma pessoa;
	 * @param pessoa - Pessoa
	 */
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public void create(@Valid @RequestBody Pessoa pessoa){
		
		pessoaService.save(pessoa);
	}
	
	/**
	 * Deleta uma pessoa.
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id){
		
		pessoaService.delete(id);
	}
}

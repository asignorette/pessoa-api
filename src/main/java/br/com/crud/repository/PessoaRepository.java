package br.com.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.crud.model.Pessoa;

/**
 * Pessoa Repository
 *  
 * @author adriano.ribeiro
 *
 */
@Repository
public interface PessoaRepository extends MongoRepository<Pessoa, String>{

}

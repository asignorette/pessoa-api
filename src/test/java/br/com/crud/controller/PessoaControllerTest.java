package br.com.crud.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import br.com.crud.model.Endereco;
import br.com.crud.model.Pessoa;
import br.com.crud.service.PessoaService;

/**
 *
 * @author adriano.ribeiro
 * 
 */
@RunWith(PowerMockRunner.class)
public class PessoaControllerTest {

	@InjectMocks
	private PessoaController controller;
	
	@Mock
	private PessoaService service;
	
	//Para rodar a validação nos atributos do objeto pessoa
	private static Validator validator;

	private Pessoa pessoa;
	
	@Before
	public void setUp() throws Exception {
		pessoa = new Pessoa();
		pessoa.setId("string_id");
		pessoa.setNome("Adriano");
		pessoa.setCpf("000000000000");
		pessoa.setDtNascimento(LocalDate.of(1990, 1, 1));
		
		final Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua X, 109");
		endereco.setBairro("Jardim Nova Europa");
		endereco.setCidade("Campinas");
		endereco.setUf("SP");
		endereco.setCep("13000001");
		
		pessoa.setEndereco(endereco);
		
		//Para rodar a validação nos atributos do objeto pessoa
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}
	
	@Test
	public void saveComSucesso(){
		
		controller.create(this.pessoa);
		verify(service).save(Matchers.any(Pessoa.class));

		//Rodando a validação nos atributos do objeto pessoa
		Set<ConstraintViolation<Pessoa>> violations = validator.validate(this.pessoa);
        assertTrue(violations.isEmpty());
	}
	
	@Test
	public void saveSemSucesso(){
		
		//Deverá apresentar erro nestes 2 atributos
		this.pessoa.setNome(null);
		this.pessoa.getEndereco().setCep("0");
		
		controller.create(this.pessoa);
		verify(service).save(Matchers.any(Pessoa.class));

		Set<ConstraintViolation<Pessoa>> violations = validator.validate(this.pessoa);
		violations.stream().forEach(error -> System.out.println(error));
		assertEquals(violations.size(), 2);
	}
	
	@Test
	public void findOne(){
		controller.findOne("string_id");
		verify(service).findOne(Matchers.any(String.class));
	}
	
	@Test
	public void findAll(){
		controller.findAll();
		verify(service).findAll();
	}
	
	@Test
	public void delete(){
		controller.delete("string_id");
		verify(service).delete(Matchers.any(String.class));
	}
}

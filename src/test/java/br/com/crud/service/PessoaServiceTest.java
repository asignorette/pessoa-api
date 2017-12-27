package br.com.crud.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import br.com.crud.model.Endereco;
import br.com.crud.model.Pessoa;
import br.com.crud.repository.PessoaRepository;
import br.com.crud.service.PessoaService;

/**
 *
 * @author adriano.ribeiro
 * 
 */
@RunWith(PowerMockRunner.class)
public class PessoaServiceTest {

	@InjectMocks
	private PessoaService service;
	
	@Mock
	private PessoaRepository customerRepository;
	
	private Pessoa pessoa;
	
	@Before
	public void setUp() throws Exception {
		pessoa = new Pessoa();
		pessoa.setId("string_id");
		//pessoa.setNome("Adriano");
		pessoa.setCpf("000000000000");
		pessoa.setDtNascimento(LocalDate.of(1990, 1, 1));
		
		final Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua X, 109");
		endereco.setBairro("Jardim Nova Europa");
		endereco.setCidade("Campinas");
		endereco.setUf("SP");
		endereco.setCep("13000001");
		
		pessoa.setEndereco(endereco);
	}
	
	@Test
	public void findOne(){
		when(service.findOne("string_id")).thenReturn(this.pessoa);
		final Pessoa pessoaReturned = service.findOne("string_id");
		
		verify(customerRepository).findOne(Matchers.any(String.class));
		assertEquals(this.pessoa.getNome(), pessoaReturned.getNome());
	}
	
	@Test
	public void findAll(){
		final List<Pessoa> list = new ArrayList<>();
		list.add(this.pessoa);
		
		when(customerRepository.findAll()).thenReturn(list);
		
		assertEquals(service.findAll().size(), 1);
		verify(customerRepository).findAll();
	}
	
	@Test
	public void save(){
		service.save(this.pessoa);
		verify(customerRepository).save(Matchers.any(Pessoa.class));
	}
	
	@Test
	public void delete(){
		service.delete("string_id");
		verify(customerRepository).delete(Matchers.any(String.class));
	}
}

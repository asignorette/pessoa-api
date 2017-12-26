package br.com.crud.common.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;

/**
 * Classe de validação.
 * 
 * @author Adriano
 *
 */
public class ValidationUtils {

	private ValidationUtils(){}
	
	public static List<String> getBindingResultErros(BindingResult result) {

		final List<String> listErrors = new ArrayList<>();
		result.getAllErrors().stream().forEach(
				objectError -> listErrors.add(objectError.getDefaultMessage()));
		
		return listErrors;
	}
}

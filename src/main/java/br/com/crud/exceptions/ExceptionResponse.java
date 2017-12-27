package br.com.crud.exceptions;

import java.util.List;

/**
 * 
 * Classe responsável por receber os erros do controller.
 * 
 * @author Adriano
 *
 */
public class ExceptionResponse {
    private String errorCode;
    private String errorMessage;
    private List<String> errors;

    public ExceptionResponse() {}

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}

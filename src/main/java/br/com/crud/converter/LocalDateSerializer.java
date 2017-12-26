package br.com.crud.converter;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 
 * LocalDate - Serializer
 * 
 * @author Adriano
 *
 */
public class LocalDateSerializer extends JsonSerializer<LocalDate>{

	@Override
	public void serialize(LocalDate date, JsonGenerator jsonGenerator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		jsonGenerator.writeString(date.toString());
	}

}

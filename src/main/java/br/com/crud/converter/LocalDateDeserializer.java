package br.com.crud.converter;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * 
 * LocalDate - Deserializer
 * 
 * @author Adriano
 *
 */
public class LocalDateDeserializer extends JsonDeserializer<LocalDate>{

	@Override
	public LocalDate deserialize(JsonParser jsonparser, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		
        String string = jsonparser.getText();

    	LocalDate dateTime = LocalDate.parse(string);
        return dateTime;//.toLocalDate();

        //return LocalDate.parse(string);
	}

}

package com.example.rest.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.stereotype.Service;
import com.example.rest.model.KeyValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DaoService {
	InputStream is;
	KeyValue keyValue;
	
	public KeyValue readFile()
	{
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			is = new FileInputStream("C:\\Users\\sonar\\Documents\\workspace-sts-3.9.8.RELEASE\\sampleRestProject\\src\\main\\resources\\static\\file.txt");
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		finally {
		try {
			keyValue = objectMapper.readValue(is, KeyValue.class);
			System.out.println(keyValue.getData());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	return keyValue;
	}
	
}


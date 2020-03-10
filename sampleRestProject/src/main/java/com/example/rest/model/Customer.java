package com.example.rest.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
public class Customer implements Serializable{
	public static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private List<String> hobbies;
}

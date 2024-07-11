package com.http.happypaws.dtos;

import lombok.Data;

@Data
//Creo los getters y los setters mediante Lombok

public class LoginDTO {
	
	private String username;
	private String password;
}

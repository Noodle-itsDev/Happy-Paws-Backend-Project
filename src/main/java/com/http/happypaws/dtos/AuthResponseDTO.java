package com.http.happypaws.dtos;

import lombok.Data;

@Data
//Creo los getters y setters mediante Lombok

//Esta clase nos devolverá el token

public class AuthResponseDTO {
	
	private String accesToken;
	private String tokenType = "Bearer";
	
	public AuthResponseDTO(String accesToken) {
		this.accesToken = accesToken;
	}
}

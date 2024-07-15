package com.http.happypaws.dtos;

public class AuthResponseDTO {
	
	private String accesToken;
	private String tokenType = "Bearer";
	
	
	public AuthResponseDTO() {
		super();
	}


	public AuthResponseDTO(String accesToken) {
		this.accesToken = accesToken;
	}


	public String getAccesToken() {
		return accesToken;
	}


	public void setAccesToken(String accesToken) {
		this.accesToken = accesToken;
	}


	public String getTokenType() {
		return tokenType;
	}


	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	
	
}

package com.http.happypaws.dtos;

import com.http.happypaws.models.Usuarios;

public class AuthResponseDTO {
	
	private String accesToken;
	private String tokenType = "Bearer";
  private Usuarios user;

	
	public AuthResponseDTO() {
		super();
	}


	public AuthResponseDTO(String accesToken, Usuarios user) {
		this.accesToken = accesToken;
    this.user = user;
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
  
  public Usuarios getUser() {
      return user;
  }
	
	
}

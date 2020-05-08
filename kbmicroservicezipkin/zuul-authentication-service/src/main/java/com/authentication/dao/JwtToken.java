package com.authentication.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name ="Jwt_Token")
public class JwtToken {
    @Id
    private String userName;
    private String token;

    public JwtToken(String userName , String token) {
    	this.userName = userName;
        this.token = token;
    }

    public JwtToken() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
    
}

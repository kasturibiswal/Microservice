package com.currency.conversionfactor.bean;

public class ResponseStatus {

	String status;
	String errorMessage;
	
	public ResponseStatus(String status, String errorMessage)
	{
		this.status  = status;
		this.errorMessage =  errorMessage;
	}
	
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}


}

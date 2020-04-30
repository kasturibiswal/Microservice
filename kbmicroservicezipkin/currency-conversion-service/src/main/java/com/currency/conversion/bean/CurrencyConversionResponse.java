package com.currency.conversion.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyConversionResponse {

	Double convertedAmount;
	String errorMessage;
	
	
	
	public CurrencyConversionResponse() {
		super();
	}
	public CurrencyConversionResponse(Double convertedAmount, String errorMessage) {
		super();
		this.convertedAmount = convertedAmount;
		this.errorMessage = errorMessage;
	}
	public Double getConvertedAmount() {
		return convertedAmount;
	}
	public void setConvertedAmount(Double conversionFactor) {
		this.convertedAmount = conversionFactor;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "ConversionFactorResponse [convertedAmount=" + convertedAmount + ", errorMessage=" + errorMessage
				+ "]";
	}
	
	
	

}

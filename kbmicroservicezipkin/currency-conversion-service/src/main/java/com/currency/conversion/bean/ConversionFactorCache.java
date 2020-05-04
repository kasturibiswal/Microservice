package com.currency.conversion.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Conversion_Factor_Cache")
public class ConversionFactorCache {
	@Id
	private String cacheKey;
	private Double conversionFactor;	
	
	
	public ConversionFactorCache() {
		super();
	}


	public ConversionFactorCache(String cacheKey, Double conversionFactor) {
		super();
		this.cacheKey = cacheKey;
		this.conversionFactor = conversionFactor;
	}


	public String getCacheKey() {
		return cacheKey;
	}




	public void setCacheKey(String cacheKey) {
		this.cacheKey = cacheKey;
	}




	public Double getConversionFactor() {
		return conversionFactor;
	}


	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}



}

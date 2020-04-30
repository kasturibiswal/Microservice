package com.currency.conversion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currency.conversion.bean.ConversionFactorResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CurrencyConversionDelegate {
	
@Autowired
CurrencyConversionServiceProxy proxyService;

private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@HystrixCommand(fallbackMethod = "fallBackGetConversionFactor")
	public ConversionFactorResponse getConversionFactor(String fromCurrency, String toCurrency)
	{
		
		logger.debug("Executing getConversionFactor");
		try {
		//ConversionFactorResponse conversionFactorResponse = restTemplate.getForObject(baseURL+"/"+fromCurrency+"/"+toCurrency, ConversionFactorResponse.class);
		ConversionFactorResponse conversionFactorResponse =proxyService.getCurrencyConversionFactor(fromCurrency, toCurrency) ;
		logger.debug("conversionFactorResponsefrom service = "+conversionFactorResponse);
		return conversionFactorResponse;
		}
		catch(RuntimeException ex)
		{
			throw new RuntimeException("Currency Conversion factor  service Not Available");
		}
		
	}
	
	public ConversionFactorResponse fallBackGetConversionFactor(String fromCurrency, String toCurrency)
	{
		logger.error("Exception from Currency Conversion Factor Service, executing fallBackGetConversionFactor***");
		ConversionFactorResponse conversionFactorResponse = new ConversionFactorResponse();
		conversionFactorResponse.setErrorMessage("Exception from Currency Conversion factory service, executed Fallback");
		return conversionFactorResponse;
		
	}
	
	

}

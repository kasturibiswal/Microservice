package com.currency.conversion.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currency.conversion.bean.ConversionFactorCache;
import com.currency.conversion.bean.ConversionFactorResponse;
import com.currency.conversion.repo.ConversionFactorCacheRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CurrencyConversionDelegate {
	
@Autowired
CurrencyConversionServiceProxy proxyService;
@ Autowired
private ConversionFactorCacheRepo conversionFactoryRepo;

private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@HystrixCommand(fallbackMethod = "fallBackGetConversionFactor")
	public ConversionFactorResponse getConversionFactor(String fromCurrency, String toCurrency)
	{
		
		logger.debug("Executing getConversionFactor");
		try {
		//ConversionFactorResponse conversionFactorResponse = restTemplate.getForObject(baseURL+"/"+fromCurrency+"/"+toCurrency, ConversionFactorResponse.class);
		ConversionFactorResponse conversionFactorResponse =proxyService.getCurrencyConversionFactor(fromCurrency, toCurrency) ;
		
		if(null!=conversionFactorResponse) {
			ConversionFactorCache conversionFactorCache = new ConversionFactorCache(fromCurrency+"_"+toCurrency, conversionFactorResponse.getConversionFactor());
			conversionFactoryRepo.save(conversionFactorCache);
			logger.debug("Conversion Factor saved to cache = "+conversionFactorCache);
		}
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
		 Optional<ConversionFactorCache> conversionFactor = conversionFactoryRepo.findById(fromCurrency+"_"+toCurrency);
		if(conversionFactor.isPresent()) {
			conversionFactorResponse.setConversionFactor(conversionFactor.get().getConversionFactor());
		}
		conversionFactorResponse.setErrorMessage("Exception from Currency Conversion factory service, executed Fallback to retrieve from cache");
		return conversionFactorResponse;
		
	}
	
	

}

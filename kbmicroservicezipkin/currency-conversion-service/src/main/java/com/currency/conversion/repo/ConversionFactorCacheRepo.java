package com.currency.conversion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currency.conversion.bean.ConversionFactorCache;

public interface ConversionFactorCacheRepo extends JpaRepository<ConversionFactorCache, String>{
	

}

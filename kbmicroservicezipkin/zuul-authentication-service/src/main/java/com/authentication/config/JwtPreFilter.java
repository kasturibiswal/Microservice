package com.authentication.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
@Component
public class JwtPreFilter  extends ZuulFilter {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
@Override
public String filterType() {
   return "pre";
}

@Override
public int filterOrder() {
   return 1;
}

@Override
public boolean shouldFilter() {
  return true;
}

@Override
public Object run() {
  RequestContext ctx = RequestContext.getCurrentContext();
  if (ctx != null && ctx.getRequest() != null) {
	logger.debug("Executing run");
	//Object tokenString =(String) ctx.getRequest().getAttribute("token");
	// HttpServletRequest request = ctx.getRequest();   
		/*
		 * ctx.addZuulRequestHeader("Authorization",
		 * request.getHeader("Authorization"));
		 */
	String tokenInDb = jwtTokenUtil.getTokenFromDB();
	 ctx.addZuulRequestHeader("Authorization","Bearer"+
			 tokenInDb);
}  
  return null;
 }


}

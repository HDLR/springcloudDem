package com.springcloud.train.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLimitFilter extends ZuulFilter{
	
	//每秒创建100个令牌
	private static final RateLimiter RATE_LINITER = RateLimiter.create(100);

	@Override
	public Object run() throws ZuulException {
		
		if(!RATE_LINITER.tryAcquire()) {
			
		}
		
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SERVLET_DETECTION_FILTER_ORDER - 1;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

}

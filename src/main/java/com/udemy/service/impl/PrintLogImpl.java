package com.udemy.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.component.RequestTimeInterceptor;
import com.udemy.service.PrintLog;

@Service("printlog")
public class PrintLogImpl implements PrintLog {
	
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

	@Override
	public String message() {
		// TODO Auto-generated method stub
		LOG.info("Message method executed");
		return "Message method executed";
	}
	
}

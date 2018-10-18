package com.ahextech.web.rest.util;

import java.util.UUID;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ResponseMessage1 {
	 private String responseMessage;

	 

	    public ResponseMessage1(String responseMessage){
	    	super();
			this.responseMessage = responseMessage;
	    }
	    public String getResponseMessage() {
	        return responseMessage;
	    }

	    public void setResponseMessage(String responseMessage) {
	        this.responseMessage = responseMessage;
	    }

		

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}

	
}

package com.ahextech.web.rest.util;

import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ResponseMessage  implements Serializable{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	   private String responseMessage;
	    private String token;
	    

	    public ResponseMessage(String responseMessage,String token) {
		super();
		this.responseMessage = responseMessage;
		this.token=token;
	    }

	    public ResponseMessage(String responseMessage){
	    	super();
			this.responseMessage = responseMessage;
	    }
	    public String getResponseMessage() {
	        return responseMessage;
	    }

	    public void setResponseMessage(String responseMessage) {
	        this.responseMessage = responseMessage;
	    }

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}


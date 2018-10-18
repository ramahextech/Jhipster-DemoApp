package com.ahextech.web.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahextech.domain.RegistrationEntity;
import com.ahextech.repository.RegistrationRepository;
import com.ahextech.service.MailService;

/**
 * RegistrationResource controller
 */
@RestController
@RequestMapping("/api/registration")
public class RegistrationResource {
    
    private final Logger log = LoggerFactory.getLogger(RegistrationResource.class);
    @Autowired
    private RegistrationRepository registrationRepository;
	int i=0;
	@Autowired
	MailService service;
	@Autowired
	PasswordEncoder passwordEncoder;
	/*@Value("true")
	private String tls;
	@Value("true")
	private String auth;
	@Value("true")
	private String required;
	@Value("500")
	private String connectiontimeout;
	@Value("500")
	private String timeout;
	@Value("500")
	private String writetimeout;
	*/
    /**
    * POST post
    * 
    *    */
/*	@Autowired
	JavaMailSender impl;
	 private void sendEmail() throws Exception{
		         JavaMailSender impl=new JavaMailSenderImpl();
		         
		         MimeMessage message = impl.createMimeMessage();
		        // Properties props = ((JavaMailSenderImpl) impl).getJavaMailProperties();  
		         props.setProperty("mail.smtp.starttls.enable",tls);
		         props.setProperty("mail.properties.mail.smtp.starttls.required",required);
		         props.setProperty("mail.smtp.auth",auth);
		         props.setProperty("mail.properties.mail.smtp.connectiontimeout",connectiontimeout);
		         props.setProperty("mail.properties.mail.smtp.timeout",timeout);
		         props.setProperty("mail.properties.mail.smtp.writetimeout",writetimeout);
		         MimeMessageHelper helper = new MimeMessageHelper(message);
		         helper.setTo("grajkumaryadav03@gmail.com");
		         helper.setText("How are you?");
		         helper.setSubject("Hi");
		         
				 helper.setFrom(jHipsterProperties.getMail().getFrom());
        	     impl.send(message);
		       
		     }*/

    @PostMapping
    public ResponseEntity<String> post(@Valid @RequestBody RegistrationEntity registrationEntity,HttpStatus status) {
    	
    	
    	    // Iterable<RegistrationEntity> regentity=registrationRepository.findAll();
    	     RegistrationEntity readRegEntity=registrationRepository.findByEmail(registrationEntity.getEmail());
    	     String email=registrationEntity.getEmail();
    	     String rawPassword=registrationEntity.getPassword();
    	     registrationEntity.setPassword(passwordEncoder.encode(rawPassword));
    	     if(readRegEntity==null){ 
    	    	
    	          registrationRepository.save(registrationEntity);
    	             i=1;
    	             if(i==1){
    	    	    	 try{
    	    	    	 service.sendEmail(email, "Registration Success", "you are registeresterd", false, false);
    	    	    	 System.out.println("Email sent to the user");
    	    	    	 }
    	    	    	 catch(Exception ex){
    	    	    	  	 System.out.println("Email not sent to the user");
    	    	        	 System.out.println("Exception is:"+ex);
    	    	    	 }
    	    	      }
    	    	  return new ResponseEntity<String>("Registration is successful ",status.CREATED);
    	        
    	     }else{
    	       return new ResponseEntity<String>("Already Registerd ",status.FOUND);
    	   }
      }	    	 
 } 	      	      
        	

  

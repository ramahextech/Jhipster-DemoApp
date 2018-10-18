package com.ahextech.web.rest;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahextech.domain.Login;
import com.ahextech.domain.RegistrationEntity;
import com.ahextech.domain.User;
import com.ahextech.repository.LoginRepository;
import com.ahextech.repository.RegistrationRepository;
import com.ahextech.repository.UserRepository;
import com.ahextech.web.rest.util.ResponseMessage;
import com.ahextech.web.rest.util.ResponseMessage1;

@RestController
@RequestMapping("/api/login")
public class LoginResource {
	private final Logger log = LoggerFactory.getLogger(LoginResource.class);
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private RegistrationRepository registrationRepository;
	int i=0;
     String uuid;
     UUID uuid1;
     private final int DEFAULT_TOKEN_VALIDITY_DAYS = 30;
     @Autowired
 	 PasswordEncoder passwordEncoder;
     @Autowired
     UserRepository userRepository;
     Login existedLogin;
     User user=new User();
    /**
    * POST post
    */
    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody Login login,HttpStatus status) {
    	String requestEmail=login.getEmail();
    	String password=login.getPassword();
    	//login.setPassword(passwordEncoder.encode(password));
    	Date firstLoginDate=new Date();
    	Date presentlogin=new Date();
    	//login.setDate(presentlogin);
    	RegistrationEntity existRegEntity=registrationRepository.findByEmail(requestEmail);
    	if(existRegEntity!=null){
    		String password1=existRegEntity.getPassword();
    		if(passwordEncoder.matches(password,password1 ) ){
    	    	 Login existLogin=loginRepository.findByEmail(requestEmail);
                 if(existLogin==null){
                	uuid1=UUID.randomUUID();
         			uuid=uuid1.toString();
         			login.setExpirydays(DEFAULT_TOKEN_VALIDITY_DAYS);
         			login.setUuid(uuid);
         			login.setDate(firstLoginDate);
         			login.setPassword(password1);
         			Login saveLogin=loginRepository.save(login);
         		    user.setId((long) saveLogin.getId());
                    user.setPassword(password1);
                    user.setEmail(login.getEmail());
                    user.setLogin(existRegEntity.getUsername());
                    userRepository.save(user);
         			return new ResponseEntity<>(new ResponseMessage("Login data is saved with token",uuid),status.CREATED);
                 }
                 else{
                	 
                	 Date existlogindate=existLogin.getDate();
                	 String existUuid=existLogin.getUuid();
                    // Date datepresent=login.getDate();
                     long diff = existlogindate.getTime()-presentlogin.getTime();;
                     long diffDays = diff / (24 * 60 * 60 * 1000);
                     if(diffDays<=DEFAULT_TOKEN_VALIDITY_DAYS){
                    	 return new ResponseEntity<>(new ResponseMessage("Valid User ",existUuid),status.FOUND);
                     }
                     else{
                    	 
                    	  uuid1=UUID.randomUUID();
              			 uuid=uuid1.toString();
              			 existLogin.setExpirydays(DEFAULT_TOKEN_VALIDITY_DAYS);
              			 existLogin.setUuid(uuid);
              			 existLogin.setDate(presentlogin);
              			 loginRepository.save(existLogin);
                    	 return new ResponseEntity<>(new ResponseMessage("Valid User ",uuid),status.FOUND);

                     }
                   }
                }
    		
    		
    		else{
	        	  return new ResponseEntity<>(new ResponseMessage1("Password Invalid"), HttpStatus.UNAUTHORIZED); 
                 }
         }
    		
   else{
      	  return new ResponseEntity<>(new ResponseMessage1("No User exists with the login credentials,Provide login values entered at registration time"), HttpStatus.NOT_FOUND); 
     }
   }
 }
    	


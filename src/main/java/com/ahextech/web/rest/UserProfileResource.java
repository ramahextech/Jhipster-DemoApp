package com.ahextech.web.rest;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahextech.domain.Login;
import com.ahextech.domain.UserProfile;
import com.ahextech.repository.LoginRepository;
import com.ahextech.repository.UserProfileRepository;
import com.ahextech.security.AuthoritiesConstants;
import com.ahextech.security.SecurityUtils;
import com.ahextech.web.rest.errors.TokenException;
import com.ahextech.web.rest.util.CustomMessages;
import com.ahextech.web.rest.util.ResponseMessage1;



@RestController
@RequestMapping("/api/profile")
public class UserProfileResource {
	@Autowired
	UserProfileRepository userprofilerepo;
	@Autowired
    private LoginRepository loginRepository;
	
   
	private com.ahextech.domain.Login login;


	UserProfile profile1;
	
	@PostMapping
	@Secured({ AuthoritiesConstants.USER })
	 public ResponseEntity<?> post(@Validated(UserProfile.New.class) @RequestBody UserProfile profile,@RequestHeader(value="token") String token,HttpServletRequest request) {
	
		if (SecurityUtils.isCurrentUserInRole(AuthoritiesConstants.USER)){    
	    if(token!=null){
	      Login existlogin=loginRepository.findByUuid(token);
	      if(existlogin==null){
	         return new ResponseEntity<>(new ResponseMessage1("Invalid Token"), HttpStatus.FORBIDDEN); 
	      } else{
	    		int id1=existlogin.getId();
	    		System.out.println("Checking record in database with existed login id"+id1);
	    		Optional<UserProfile> opt= userprofilerepo.findById(id1);
	    		  //  int id=prof.getId();
	    		boolean b=opt.isPresent();
	    		System.out.println("Empty or not empty?");
	    		if(b==false){
	                      System.out.println("empty, so Entered into saving record");
	                      System.out.println("Profile from client side"+profile);
                          int id=profile.getId();
	                      id=id1;
	                      profile1.setId(id);
	                      System.out.println("Profile from updated server side"+profile);
	           	          UserProfile newprofile=userprofilerepo.save(profile1);
	                      System.out.println("Saved record");
	           	          return new ResponseEntity<>(new ResponseMessage1("Profile is saved into database"), HttpStatus.FOUND);
		         }else{
	                 return new ResponseEntity<>(new ResponseMessage1("Profile Already exists"), HttpStatus.FOUND);     
	              }
	        }
	     
	    }else{
	         return new ResponseEntity<>(new ResponseMessage1("No token, provide token"), HttpStatus.NOT_FOUND);
	     }
	  
	}else{
		return new ResponseEntity<>(new ResponseMessage1("User has no access to this resource"), HttpStatus.UNAUTHORIZED);
	 }	 
	
  }
	
	@GetMapping
	@Secured({ AuthoritiesConstants.USER })
	public ResponseEntity<?> get(@RequestHeader(value="token") String token,HttpServletRequest request) throws TokenException {
	if (SecurityUtils.isCurrentUserInRole(AuthoritiesConstants.USER)){            
	    	//String token=headers.getFirst("token");
		
	      if(token!=null){
	          Login existlogin=loginRepository.findByUuid(token);
	          if(existlogin==null){
	            return new ResponseEntity<>(new ResponseMessage1("Invalid Token"), HttpStatus.NOT_FOUND); 
	          }
	       int id1=existlogin.getId();
	       Optional<UserProfile> opt= userprofilerepo.findById(id1);
	       boolean b=opt.isPresent();	    		    
	     
	          if(b==false){
	            return new ResponseEntity<>(new ResponseMessage1(CustomMessages.PROFILE_NOT_FOUND), HttpStatus.NOT_FOUND); 
              }else{ 
	            //System.out.println("entered into reading mode");
	             UserProfile readprof=opt.get();
	             //System.out.println("Profile read"+readprof);
	  	         return new ResponseEntity<>(readprof, HttpStatus.OK);
	           }
           }else{
	    		return new ResponseEntity<>(new ResponseMessage1("No token, provide token"), HttpStatus.NOT_FOUND);
	    	 }
    }else{
		  return new ResponseEntity<>(new ResponseMessage1("User has no access to this resource"), HttpStatus.UNAUTHORIZED);
     }	    
  }
	

	
	
	
	@PutMapping
	@Secured({ AuthoritiesConstants.USER })
	 public ResponseEntity<?> update(@Validated(UserProfile.Existing.class) @RequestBody UserProfile profile,@RequestHeader(value="token") String token,HttpServletRequest request) throws TokenException {
		if (SecurityUtils.isCurrentUserInRole(AuthoritiesConstants.USER)){           
	    	//String token=headers.getFirst("token");
	    UserProfile readprofile;
	        if(token!=null){
	    	  Login existlogin=loginRepository.findByUuid(token);
	    	  if(existlogin==null){
	    		 return new ResponseEntity<>(new ResponseMessage1("Invalid token"), HttpStatus.NOT_FOUND); 
	    	  }
	    	  int id1=existlogin.getId();
	    	  Optional<UserProfile> opt= userprofilerepo.findById(id1);
	          boolean b=opt.isPresent();	
	             if(b==true){
	            	 readprofile=userprofilerepo.findById(id1).get(); 
	                 profile.setId(id1);
	                	if(profile.getFirstname()!=null &&profile.getLastname()!=null && profile.getAddress()!=null&&profile.getCity()!=null&&profile.getCountry()!=null )
	                	{    userprofilerepo.save(profile);
	                	 return new ResponseEntity<>(new ResponseMessage1(CustomMessages.USER_PROFILE_UPDATED_SUCCESSFULLY_MSG), HttpStatus.OK);
	            	    } else{ 
	            		     profile.setId(id1);
	            		      if(profile.getFirstname()==null ){
	            		    	   profile.setFirstname(readprofile.getFirstname());
	            		      }
	            		      if(profile.getLastname()==null){
	            		    	  profile.setLastname(readprofile.getLastname());
	            		      }
	            		      if(profile.getAddress()==null){
	            		          profile.setAddress(readprofile.getAddress());
	            	          }
	            		      if(profile.getCity()==null){
	            		    	  profile.setAddress(readprofile.getCity());
	            		      }
	            		      if(profile.getCountry()==null){
	            		    	  profile.setCountry(readprofile.getCountry());
	            		      }
	            		      /*if(profile.getMobnumber()==null){
	            		    	   profile.setMobnumber(readprofile.getMobnumber());
	            		      }*/
	            		      userprofilerepo.save(profile);
	            		       return new ResponseEntity<>(new ResponseMessage1(CustomMessages.USER_PROFILE_UPDATED_SUCCESSFULLY_MSG), HttpStatus.OK);
	                      }
	              
	            }else{
	                 return new ResponseEntity<>(new ResponseMessage1(CustomMessages.PROFILE_NOT_FOUND), HttpStatus.NOT_FOUND);               
	            	 }
	       }else{
	    		 return new ResponseEntity<>(new ResponseMessage1("No token, provide token"), HttpStatus.NOT_FOUND);
	    	  }
	    }else{
		    return new ResponseEntity<>(new ResponseMessage1("User has no access to this resource"), HttpStatus.UNAUTHORIZED);
	     }	
	}
	
}
	
	
	
	
	
	
	

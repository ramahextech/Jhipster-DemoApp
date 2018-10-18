package com.ahextech.web.rest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Optional;

import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.IOUtils;
//import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ahextech.domain.Login;
import com.ahextech.domain.UserProfile;
import com.ahextech.repository.LoginRepository;
import com.ahextech.repository.UserProfileRepository;
import com.ahextech.web.rest.util.ResponseMessage1;

@RestController
@RequestMapping("/api/image")
public class ImageResource {

	
	UserProfile existProfile;
	@Autowired
    private LoginRepository loginRepository;
	@Autowired
	UserProfileRepository userProfileRepository;
	byte[] bytes;
	Byte[] byteObject;
	String encodedString;
	@PostMapping(consumes={"multipart/form-data"})
    public ResponseEntity<?> post(@RequestPart (value="image") MultipartFile image,@RequestHeader(value="token") String token) throws SerialException, SQLException {
		   
		 
     if(token!=null){
		Login existlogin=loginRepository.findByUuid(token);
		 if(existlogin==null){
		     return new ResponseEntity<>(new ResponseMessage1("Invalid Token"), HttpStatus.UNAUTHORIZED); 
	     }
		   else{
		         int id=existlogin.getId();
		         Optional<UserProfile> optional= userProfileRepository.findById(id);
		     	 boolean exists=optional.isPresent();
		     	 if(exists==true){
		         try {  
		        	 
		        	 if (!image.isEmpty()) {
		        	             existProfile=optional.get();
		        		         byte[] bytes = IOUtils.toByteArray(image.getInputStream());
		        				 encodedString=Base64.getEncoder().encodeToString(bytes);
		        				 int i=0; 
		        				 /*byteObject=new Byte[bytes.length];*/
		        				//Associating Byte array values with bytes. (byte[] to Byte[])
		        				/*for(byte b: bytes)
		        				{   
		        					byteObject[i++] = b;  // Autoboxing.
		        				}
		        				 System.out.println("Image data in byte object"+byteObject.toString());
		        				*/
		               }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		           existProfile.setEncodedImageFile(encodedString);
		           userProfileRepository.save(existProfile);
		           return new ResponseEntity<>(new ResponseMessage1("Image is Saved"), HttpStatus.CREATED); 		        	      
		         }
		            else{
		        		 return new ResponseEntity<>(new ResponseMessage1("Profile data is not available"), HttpStatus.NOT_FOUND);
		                }
		        	  
		        }
	 }
	    else{
			 return new ResponseEntity<>(new ResponseMessage1("No token, provide token"), HttpStatus.NOT_FOUND); 
		    }
		  
	}
}

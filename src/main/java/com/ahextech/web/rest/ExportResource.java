package com.ahextech.web.rest;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ahextech.domain.Login;
import com.ahextech.repository.LoginRepository;
import com.ahextech.web.rest.util.ResponseMessage1;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@RestController
@RequestMapping("/api")
public class ExportResource {

	@Autowired
    private LoginRepository loginRepository;

	
	
	@PostMapping(value="/reportgeneration",consumes={"multipart/form-data"})
	
	 public ResponseEntity<?> convertToPdf(@RequestParam("file") MultipartFile file,@RequestHeader(value="token") String token) throws IOException, DocumentException{
		   // byte[] fileData=file.getBytes(); 
		    if(token!=null){
			  Login existlogin=loginRepository.findByUuid(token);
	          if(existlogin==null){
	        	 return new ResponseEntity<>(new ResponseMessage1("Invalid Token"), HttpStatus.NOT_FOUND); 
		      }
		    InputStream inStream=file.getInputStream();
		    Document pdfDoc = new Document(PageSize.A4);
			PdfWriter.getInstance(pdfDoc, new FileOutputStream("e:/FirstPdf.pdf"))
					.setPdfVersion(PdfWriter.PDF_VERSION_1_7);
			pdfDoc.open();
			
			Font myfont = new Font();
			myfont.setStyle(Font.NORMAL);
			myfont.setSize(11);
			pdfDoc.add(new Paragraph("\n"));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(inStream));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				Paragraph para = new Paragraph(strLine + "\n", myfont);
				para.setAlignment(Element.ALIGN_JUSTIFIED);
				pdfDoc.add(para);
			}
			
			pdfDoc.close();
			br.close();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline"); 
			//headers.setContentType(MediaType.APPLICATION_PDF);
			 return new ResponseEntity<>(pdfDoc,headers, HttpStatus.OK);
		 
	 }else{
		 return new ResponseEntity<>(new ResponseMessage1("Token is unavailable, provide token"), HttpStatus.NOT_FOUND); 
	 }
}
}
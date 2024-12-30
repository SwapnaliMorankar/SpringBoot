package com.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.Helpers.FileUploadHelper;

@RestController
@RequestMapping("/api")
public class FileController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/uploadfile")
	public ResponseEntity<String> uploadFile(@RequestParam("myfile") MultipartFile File){
		
		//General details
		System.out.println(File.getOriginalFilename());
		System.out.println(File.getContentType());
		
		try {
			
			//Validation
			if(File.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File is Empty");
			}
			
			//Content Type
			if(!File.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG type allowed");
			}
			
			//Upload
			boolean res = fileUploadHelper.uploadFile(File);
			if(res) {
				return ResponseEntity.ok("File Uploaded Successfully");
			} 
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!");
		
	}

}

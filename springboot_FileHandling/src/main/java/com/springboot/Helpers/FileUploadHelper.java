package com.springboot.Helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ClassPathResource;

@Component
public class FileUploadHelper {
	
//	public final String 
//	UPLOAD_LOC="C:\\Users\\snmor\\eclipse-workspace\\springboot_FileHandling\\src\\main\\resources\\static\\images";

	public final String 
	UPLOAD_LOC= new ClassPathResource("/static/images").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException{
		
	}
	
	public boolean uploadFile(MultipartFile file) {
		
		boolean f = false;
		
		try {
			Path path = Paths.get(UPLOAD_LOC+File.separator+file.getOriginalFilename());
			Files.copy(file.getInputStream(), path, 
					StandardCopyOption.REPLACE_EXISTING);
			f=true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return f;
	}
	
}

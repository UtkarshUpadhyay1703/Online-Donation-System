package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Donor;
import com.app.pojos.Employee;

//@Service
public interface ImageService {
	String uploadImageDonor(String type,String path, MultipartFile file,Donor donor) throws IOException;
	
	String uploadImageEmployee(Long imgId,String path, MultipartFile file,Employee employee) throws IOException;

	byte[] serveImageEmployee(Long conId) throws IOException;
	
	
	byte[] serveImageDonor(Long conId) throws IOException ;
}

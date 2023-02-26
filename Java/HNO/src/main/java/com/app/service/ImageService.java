package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Donor;

//@Service
public interface ImageService {
	String uploadImage(String type,String path, MultipartFile file,Donor donor) throws IOException;

}

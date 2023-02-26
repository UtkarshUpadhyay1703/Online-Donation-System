package com.app.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//@Service
public interface ImageService {
	String uploadImage(String path,MultipartFile file)throws IOException;
	

}

package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.extra.ImageResponse;
import com.app.service.ImageService;


@RestController
@RequestMapping("/file")
public class ImageController {
     
	@Autowired
	private ImageService imageService;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/upload")
    public ResponseEntity<ImageResponse> imageUpload(
    		@RequestParam("Image") MultipartFile image)
    {String imageName=null;
		try {
			imageName=this.imageService.uploadImage(path, image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(new ImageResponse(null, "Image not uploaded successfully"),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<>(new ImageResponse(imageName,"Image is successfully uploaded"),HttpStatus.OK);
    }
	
	
	
}

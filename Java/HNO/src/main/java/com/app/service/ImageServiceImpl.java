package com.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		String name=file.getOriginalFilename();
		
		String filepath=path+File.separator+name;
		File f=new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}
		
		Files.copy(file.getInputStream(),Paths.get(filepath));
		return name;
	}
	

}

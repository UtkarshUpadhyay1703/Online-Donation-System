package com.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Donor;
import com.app.pojos.ItemDonation;
import com.app.repository.ItemDonationRepository;

@Service
public class ImageServiceImpl implements ImageService {
//	@Autowired
//	private ModelMapper mapper;
	
	@Autowired
	ItemDonationRepository donationRepo;

	@Override
	public String uploadImage(String type,String path, MultipartFile file,Donor donor) throws IOException {
		// TODO Auto-generated method stub
		String name = file.getOriginalFilename();

		String filepath = path + File.separator + name;
		File f = new File(path);
		if (!f.exists()) {
			f.mkdir();
		}
		System.out.println("path = "+path);
System.out.println("Paths.get(filepath) = "+Paths.get(filepath));
		Files.copy(file.getInputStream(), Paths.get(filepath));
		ItemDonation item =new ItemDonation(type, filepath, false, donor);
		donationRepo.save(item);
		return name;
	}

}

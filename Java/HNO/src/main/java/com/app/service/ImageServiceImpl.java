package com.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.pojos.Donor;
import com.app.pojos.Employee;
import com.app.pojos.ItemDonation;
import com.app.repository.ItemDonationRepository;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {
//	@Autowired
//	private ModelMapper mapper;
//	private Donor itemDonor;
	
//	@Autowired
//	private Employee itemEmployee;
	
	@Autowired
	ItemDonationRepository donationRepo;

	@Override
	public String uploadImageDonor(String type,String path, MultipartFile file,Donor itemDonor) throws IOException {
		System.out.println(itemDonor);
		String name = file.getOriginalFilename();

		String filepath = path + File.separator + name;
		File f = new File(path);
		if (!f.exists()) {
			f.mkdir();
		}
		System.out.println("path = "+path);
System.out.println("Paths.get(filepath) = "+Paths.get(filepath));
		Files.copy(file.getInputStream(), Paths.get(filepath));
		System.out.println(itemDonor.getId()+" "+itemDonor);
		ItemDonation item =new ItemDonation(type, filepath, false, itemDonor);
		System.out.println(item);
//		donationRepo.save(item);
		itemDonor.addItemDonor(item);
		donationRepo.save(item);
		return name;
	}
	
	
	@Override
	public String uploadImageEmployee(Long imgId,String path, MultipartFile file,Employee itemEmployee) throws IOException {
		System.out.println(itemEmployee);
		String name = file.getOriginalFilename();

		String filepath = path + File.separator + name;
		File f = new File(path);
		if (!f.exists()) {
			f.mkdir();
		}
		System.out.println("path = "+path);
System.out.println("Paths.get(filepath) = "+Paths.get(filepath));
		Files.copy(file.getInputStream(), Paths.get(filepath));
		System.out.println(itemEmployee.getId()+" "+itemEmployee);
		ItemDonation item=donationRepo.getById(imgId);
		System.out.println("before setting items"+item);
		//ItemDonation(String itemPicViaEmployee, boolean itemStatusDonation, Employee itemEmployee)
		item.setItemPicViaEmployee(filepath);
		item.setItemStatusDonation(true);
		item.setItemEmployee(itemEmployee);
//		ItemDonation item1 =new ItemDonation(filepath, true, itemEmployee);
		System.out.println(item);
//		donationRepo.save(item);
		itemEmployee.addItemDonation(item);
		donationRepo.save(item);
		return name;
	}
	
	
	@Override
	public byte[] serveImageDonor(Long conId) throws IOException {
		ItemDonation content = donationRepo.findById(conId).orElseThrow(() -> new ResourceNotFoundException("Invalid Content Id : Image Download failed!!!!!!!!"));
		String path = content.getItemPicViaDonator();
		if (path == null)
			throw new ResourceNotFoundException("Image does not exist !!!!!");
		//OR to lift it from DB emp.getContents() --> byte[]
		return Files.readAllBytes(Paths.get(path));
	}
	
	
	@Override
	public byte[] serveImageEmployee(Long conId) throws IOException {
		ItemDonation content = donationRepo.findById(conId).orElseThrow(() -> new ResourceNotFoundException("Invalid Content Id : Image Download failed!!!!!!!!"));
		String path = content.getItemPicViaEmployee();
		if (path == null)
			throw new ResourceNotFoundException("Image does not exist !!!!!");
		//OR to lift it from DB emp.getContents() --> byte[]
		return Files.readAllBytes(Paths.get(path));
	}

}

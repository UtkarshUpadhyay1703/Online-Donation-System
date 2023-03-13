package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.extra.ImageResponse;
import com.app.pojos.Donor;
import com.app.pojos.Employee;
import com.app.repository.DonorRepository;
import com.app.repository.EmployeeRepository;
import com.app.service.ImageService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/file")
public class ImageController {

	@Autowired
	private ImageService imageService;

	@Autowired
	private DonorRepository donRepo;
	
	@Autowired
	private EmployeeRepository empRepo;
	

	@Value("${project.image}")
	private String path;

	@PostMapping(value = "/upload/donor/{donId}",consumes = "multipart/form-data")
	// public ResponseEntity<ImageResponse> imageUploadDonor(@RequestParam("type")
	// String itemType,@RequestParam("image") MultipartFile image,@RequestBody Donor
	// donor)
	// will happen with jwt or session
	public ResponseEntity<ImageResponse> imageUploadDonor(@PathVariable Long donId,
			@RequestParam("type") String itemType, @RequestParam("image") MultipartFile image) {
		String imageName = null;
		Donor donor = donRepo.findById(donId).orElseThrow(() -> new ResourceNotFoundException("Invalid id"));
		System.out.println(donor);
		try {
			imageName = this.imageService.uploadImageDonor(itemType, path, image, donor);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(new ImageResponse(null, "Image not uploaded successfully"),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
//		ItemDonation item=new ItemDonation();

		return new ResponseEntity<>(new ImageResponse(imageName, "Image is successfully uploaded"), HttpStatus.OK);
	}


	
	
	
	@PostMapping(value = "/upload/employee/{empId}/{imgId}",consumes = "multipart/form-data")
	// public ResponseEntity<ImageResponse> imageUploadDonor(@RequestParam("type")
	// String itemType,@RequestParam("image") MultipartFile image,@RequestBody Donor
	// donor)
	// will happen with jwt or session
	public ResponseEntity<ImageResponse> imageUploadEmployee(@PathVariable Long empId,@PathVariable Long imgId,
			@RequestParam("image") MultipartFile image) {
		String imageName = null;
		Employee employee = empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Invalid id"));
		System.out.println(employee);
		try {
			imageName = this.imageService.uploadImageEmployee(imgId,path, image, employee);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(new ImageResponse(null, "Image not uploaded successfully"),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
//		ItemDonation item=new ItemDonation();

		return new ResponseEntity<>(new ImageResponse(imageName, "Image is successfully uploaded"), HttpStatus.OK);
	}
	
	
	
	
	@GetMapping(value = "/download/employee/{empId}", produces = { MediaType.IMAGE_GIF_VALUE, 
			MediaType.IMAGE_JPEG_VALUE,
			MediaType.IMAGE_PNG_VALUE })
	public ResponseEntity<?> serveImageFromServerSideFolderEmployee(@PathVariable Long empId) throws IOException {
		
		return new ResponseEntity<>(imageService.serveImageEmployee(empId), HttpStatus.OK);
	}
	

	@GetMapping(value = "/download/donor/{donId}", produces = { MediaType.IMAGE_GIF_VALUE, 
			MediaType.IMAGE_JPEG_VALUE,
			MediaType.IMAGE_PNG_VALUE })
	public ResponseEntity<?> serveImageFromServerSideFolderDonor(@PathVariable Long donId) throws IOException {
		
		return new ResponseEntity<>(imageService.serveImageDonor(donId), HttpStatus.OK);
	}
	
	
	
	//	@PostMapping("/upload/employee")
//    public ResponseEntity<ImageResponse> imageUploadEmployee(@RequestParam("Image") MultipartFile image)
//    {
//		String imageName=null;
//		try {
//			imageName=this.imageService.uploadImage(path, image);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return new ResponseEntity<>(new ImageResponse(null, "Image not uploaded successfully"),HttpStatus.INTERNAL_SERVER_ERROR);
//			
//		}
////		ItemDonation item=new ItemDonation();
//		
//		return new ResponseEntity<>(new ImageResponse(imageName,"Image is successfully uploaded"),HttpStatus.OK);
//    }

}

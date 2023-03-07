package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.extra.ImageResponse;
import com.app.pojos.Donor;
import com.app.repository.DonorRepository;
import com.app.service.ImageService;

@RestController
@RequestMapping("/file")
public class ImageController {

	@Autowired
	private ImageService imageService;

	@Autowired
	private DonorRepository donRepo;

	@Value("${project.image}")
	private String path;

	@PostMapping(value = "/upload/{donId}/donor",consumes = "multipart/form-data")
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
			imageName = this.imageService.uploadImage(itemType, path, image, donor);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(new ImageResponse(null, "Image not uploaded successfully"),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
//		ItemDonation item=new ItemDonation();

		return new ResponseEntity<>(new ImageResponse(imageName, "Image is successfully uploaded"), HttpStatus.OK);
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

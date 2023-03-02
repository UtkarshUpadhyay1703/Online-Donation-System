package com.app.extra;

public class ImageResponse {

	private String imageName;
	private String message;
	public ImageResponse(String imageName, String message) {
		super();
		this.imageName = imageName;
		this.message = message;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}

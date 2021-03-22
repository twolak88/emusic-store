package com.twolak.emusicstore.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
	String saveProductImage(MultipartFile productImage, String rootPath, String imagePath);
	void deleteProductImage(String rootPath, String imagePath);
}

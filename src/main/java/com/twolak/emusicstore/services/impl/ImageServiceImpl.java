package com.twolak.emusicstore.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.twolak.emusicstore.services.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	@Override
	public String saveProductImage(MultipartFile productImage, String rootPath) {
		
		String extension = FilenameUtils.getExtension(productImage.getOriginalFilename());
		String pathToReturn = null;
		Path path = null;
		
		do {
			pathToReturn = "//resources//images//" + UUID.randomUUID().toString() + "." + extension;
			path = Paths.get(rootPath + "//WEB-INF" + pathToReturn);
		} while(Files.exists(path));
		
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(path);
				return pathToReturn;
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed", e);
			}
		}
		return null;
	}

	@Override
	public void deleteProductImage(String rootPath, String imagePath) {
		Path path = Paths.get(rootPath + "//WEB-INF" + imagePath);

		try {
			Files.deleteIfExists(path);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Product image deleting failed", e);
		}
	}
}

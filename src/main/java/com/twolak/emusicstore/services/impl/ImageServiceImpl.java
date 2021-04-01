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
	public String saveProductImage(MultipartFile productImage, String rootPath, String imagePath) {
		String pathToReturn = imagePath;
		Path path = null;
		Path oldPath = null;
		
		if (productImage != null && !productImage.isEmpty()) {
			if (imagePath == null || imagePath.isBlank()) {
				do {
					String extension = FilenameUtils.getExtension(productImage.getOriginalFilename());
					pathToReturn = "/resources/images/" + UUID.randomUUID().toString() + "." + extension;
					path = Paths.get(rootPath + "/WEB-INF" + pathToReturn);
				} while(Files.exists(path));
			} else {
				String extension = FilenameUtils.getExtension(productImage.getOriginalFilename());
				
				oldPath = Paths.get(rootPath + "/WEB-INF" + pathToReturn);
				
				if (!FilenameUtils.isExtension(imagePath, extension)) {
					imagePath = FilenameUtils.removeExtension(imagePath);
					imagePath = imagePath + "." + extension;
				}
				pathToReturn = imagePath;
				path = Paths.get(rootPath + "/WEB-INF" + pathToReturn);
			}
			try {
				if (oldPath != null) {
					Files.deleteIfExists(oldPath);
				}
				productImage.transferTo(path);
				return pathToReturn;
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed", e);
			}
		}
		return pathToReturn;
	}

	@Override
	public void deleteProductImage(String rootPath, String imagePath) {
		Path path = Paths.get(rootPath + "/WEB-INF" + imagePath);

		try {
			Files.deleteIfExists(path);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Product image deleting failed", e);
		}
	}
}

package com.LinkedIn_CloneProject.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.LinkedIn_CloneProject.DAO.Service;
import com.LinkedIn_CloneProject.DTO.Photo_Posting;
import com.LinkedIn_CloneProject.DTO.Users;
import com.LinkedIn_CloneProject.repository.Pro_Repository;


import jakarta.servlet.http.HttpSession;

@RestController
public class Pro_Controller 
{
	@Autowired
	private Service service;
	
	//User Registration
	@CrossOrigin
	@PostMapping("/Registration")
	public Users Register(@RequestBody Users u)
	{
		Users user1 =  service.addUser(u);
		return user1;
	}
	
	//Photo post uploading
	@CrossOrigin
	@PostMapping("/imageUpload")
	public Photo_Posting imageUpload(@RequestParam MultipartFile img, HttpSession session)
	{
		Photo_Posting p = new Photo_Posting();
		p.setImageName(img.getOriginalFilename());
		Photo_Posting uploadImg = service.savePhoto(p);
		if(uploadImg != null)
		{
			try
			{
			  File saveFile =	new ClassPathResource("static/images").getFile();
			  Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+img.getOriginalFilename());
			  Files.copy(img.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
			  
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		//session.setAttribute("msg", "Images Upload Successfully...");
		return uploadImg;
	}
}

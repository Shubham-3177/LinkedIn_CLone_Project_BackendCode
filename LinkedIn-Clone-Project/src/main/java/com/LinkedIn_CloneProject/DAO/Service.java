package com.LinkedIn_CloneProject.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LinkedIn_CloneProject.DTO.Photo_Posting;
import com.LinkedIn_CloneProject.DTO.Users;
import com.LinkedIn_CloneProject.repository.Photo_Repository;
import com.LinkedIn_CloneProject.repository.Pro_Repository;

@Repository
public class Service 
{
	@Autowired
	private Pro_Repository repository;
	
	@Autowired
	private Photo_Repository repo;
	
	//User Registration
	public Users addUser(Users u) 
	{
		Users user1 = repository.save(u);
		return user1;
	}

	//Photo Posting
	public Photo_Posting savePhoto(Photo_Posting p) 
	{
		Photo_Posting photo = repo.save(p);
		return photo;
	}

	
}

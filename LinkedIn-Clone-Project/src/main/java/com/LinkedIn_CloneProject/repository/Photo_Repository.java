package com.LinkedIn_CloneProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LinkedIn_CloneProject.DTO.Photo_Posting;

public interface Photo_Repository extends JpaRepository<Photo_Posting, Integer>
{

}

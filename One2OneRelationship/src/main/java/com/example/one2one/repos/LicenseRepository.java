package com.example.one2one.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.one2one.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
	
	List<License> findAll();
}

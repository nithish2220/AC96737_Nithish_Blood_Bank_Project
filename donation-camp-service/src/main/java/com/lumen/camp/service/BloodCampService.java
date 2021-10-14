package com.lumen.camp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lumen.camp.pojo.Camp;
import com.lumen.camp.repo.BloodCampRepo;

@Service
public class BloodCampService {
	
	@Autowired
	private BloodCampRepo repo;
	
	public List<Camp> findAll(){
		return repo.findAll();
	}
	
	public List<Camp> findByLocation(String location) {
		return repo.findByCampLocation(location);
	}

	public Camp addCamp(Camp location) {
		
		return repo.save(location);
	}

	public Camp update(Camp camp) {
		repo.update(camp.getCampId(), camp.getCampLocation(), camp.getCampDate());
		Camp findById = repo.findById(camp.getCampId()).orElseThrow(()->new RuntimeException("No Camp Found"));
		return findById; 
	}
}

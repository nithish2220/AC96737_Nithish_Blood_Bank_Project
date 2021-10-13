package com.lumen.camp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lumen.camp.pojo.Camp;
import com.lumen.camp.service.BloodCampService;

@RestController
@RequestMapping("/api/v1/camps")
public class BloodCampController {
	
	@Autowired
	private BloodCampService service;
	
	@GetMapping
	public List<Camp> getAll(){
		return service.findAll();
	}
	
	@PutMapping("/update/camp")
	public Camp update(@RequestBody Camp camp) {
		return service.update(camp);
	}
	@GetMapping("/{location}")
	public List<Camp> getByLocation(@PathVariable("location") String location){
		return service.findByLocation(location);
	}
	
	@PostMapping
	public Camp addCampAtLocation(@RequestBody Camp camp) {
		return service.addCamp(camp);
	}
	
}

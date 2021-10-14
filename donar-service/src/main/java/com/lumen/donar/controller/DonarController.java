package com.lumen.donar.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lumen.donar.pojo.Donar;
import com.lumen.donar.repo.DonarServiceRepo;
import com.lumen.donar.service.DonarService;

@RestController
@RequestMapping("/api/v1/donars")
public class DonarController {
	
	@Autowired
	private DonarService service;
	
	@GetMapping
	public List<Donar> findAll(){
		return service.findAll();
	}
	
	@GetMapping("id/{donarId}")
	public Donar getDonarById(@PathVariable("donarId") int donarId) {
		return service.findById(donarId);
	}
	@PostMapping
	public ResponseEntity<Donar> addDonar(@RequestBody Donar donar) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addDonar(donar));
	}
	
	
	@GetMapping("/{group}")
	public List<Donar> findByGroup(@PathVariable("group") String bloodGroup){
		return service.findByGroup(bloodGroup);
	}
	
	@GetMapping("byDate/{group}")
	public List<Donar> findByDate(@PathVariable("group") String bloodGroup){
		return service.findByDate(bloodGroup);
	}
	
	@PutMapping("/update")
	public Donar updateDetails(@RequestBody Donar donar) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Donar> requestBody = new HttpEntity<>(donar,headers);
		
		service.update(donar);
		Donar res = service.findById(donar.getDonarId());
		System.out.println(res);
		return res;
	}
	
	@GetMapping("location/{location}")
	public List<Donar> findByLocation(@PathVariable("location") String donarLocation){
		return service.findByDonarLocation(donarLocation);
	}
	
	@Autowired
	private DonarServiceRepo repo;
	
	@DeleteMapping("/delete/{donarId}")
	public String deleteById(@PathVariable("donarId") int donarId) {
		Donar d = service.findById(donarId);
		repo.delete(d);
		return "success";
		
	} 
}

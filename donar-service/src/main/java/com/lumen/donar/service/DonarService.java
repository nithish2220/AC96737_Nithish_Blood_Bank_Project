package com.lumen.donar.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.lumen.donar.pojo.Camp;
import com.lumen.donar.pojo.Donar;
import com.lumen.donar.repo.DonarServiceRepo;

@Service
public class DonarService {
	
	@Autowired
	private DonarServiceRepo repo;
	
	public List<Donar> findAll(){
		return repo.findAll();
	}
	
	public Donar findById(int donarId) {
		return repo.findById(donarId).orElseThrow(()->new RuntimeException("No records Found"));
	}
	
	public Donar addDonar(Donar donar) {
	
		return repo.save(donar);
	}

	public List<Donar> findByGroup(String bloodGroup) {
		return repo.findByBloodGroup(bloodGroup);
	}

	public List<Donar> findByDate(String bloodGroup) {
		List<Donar> findByDate = repo.findByBloodGroup(bloodGroup);
		List<Donar> res = new ArrayList<>();
		for(Donar d:findByDate) {
			List<Camp> camp = d.getCamps();
			for(Camp camps:camp) {
				LocalDate sixmonthsBack = camps.getCampDate().minusMonths(6);
				LocalDate currDate = LocalDate.now();
				if(sixmonthsBack.isBefore(currDate))
					res.add(d);
			}
		}
		return res;
	}

	public int update(Donar donar) {
		return repo.update(donar.getDonarName(),
				donar.getAge(),donar.getBloodGroup(),donar.getDonarLocation(),
				donar.getEmailId(),donar.getPhoneNumber(),donar.getDonarId());
		
	}
	
	public Donar addCamp(Donar donar) {
		Donar temp = repo.findById(donar.getDonarId()).orElseThrow(()->new RuntimeException("No Records Found!"));
		temp.setCamps(donar.getCamps());
		repo.save(temp);
		return temp;
		
	}
	public List<Donar> findByDonarLocation(String donarLocation) {
		return repo.findByDonarLocation(donarLocation);
	}

	
}

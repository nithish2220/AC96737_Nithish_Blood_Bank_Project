package com.lumen.camp.repo;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lumen.camp.pojo.Camp;

@Repository
public interface BloodCampRepo extends JpaRepository<Camp, Integer>{

	List<Camp> findByCampLocation(String campLocation);

	@Query(nativeQuery = true, value = "update camp set camp_location=:campLocation, camp_date=:campDate where camp_id=:campId")
	@Modifying
	@Transactional
	int update(@Param("campId") int campId, @Param("campLocation") String campLocation, @Param("campDate") LocalDate  campDate);
}

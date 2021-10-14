package com.lumen.donar.repo;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lumen.donar.pojo.Donar;

@Repository
public interface DonarServiceRepo extends JpaRepository<Donar, Integer>{
	
	public List<Donar> findByBloodGroup(String bloodGroup);
	
	public List<Donar> findByDonarLocation(String donarLocation);

	
	@Query(nativeQuery = true, value = "update donar set age=:age, blood_group=:bloodGroup, donar_location=:donarLocation, donar_name=:donarName, email_id=:emailId, phone_number=:phoneNumber, donation_date=:donationDate where donar_id=:donarId")
	@Modifying
	@Transactional
	public int update(@Param("donarName") String donarName, @Param("age") int age, @Param("bloodGroup") String bloodGroup, @Param("donarLocation") String donarLocation, @Param("emailId") String emailId,
			@Param("phoneNumber") String phoneNumber, @Param("donarId") int donarId, @Param("donationDate") LocalDate donationDate);
	
	
	

	

	
}

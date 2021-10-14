package com.lumen.mvc.pojo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donar {
	@NotNull(message = "Enter Donar ID!")
	
	@Range(min= 1000000000, message = "Please enter a valid Id")
	int donarId;

	@NotNull(message = "Enter Donar Name!")
	String donarName;

	@NotNull(message = "Please, Enter age")
	@Range(min = 15, max = 70, message = "Enter age between 15 to 70 Only")
	int age;

	
	@NotNull(message = "Enter the Blood Group")
	@Length(min = 2, max = 4, message = "Please enter blood group correctly")
	String bloodGroup;

	@NotNull(message = "Please Enter the Location")
	String donarLocation;

	@NotNull(message = "Please enter email")
	@Email(message = "Please Enter email Correctly!")
	String emailId;

	@NotNull(message = "Please enter the Phone Number")
	@Pattern(regexp = "^[1-9]{10}$", message = "Please check the Phone Number. Contains only Digits of length 10")
	String phoneNumber;
	
	@DateTimeFormat(iso = ISO.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy", shape=JsonFormat.Shape.STRING)
	LocalDate donationDate;
	
	
	List<Camp> camps;
}
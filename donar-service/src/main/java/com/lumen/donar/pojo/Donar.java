package com.lumen.donar.pojo;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Donar")
@Entity
public class Donar {
	@Id
	@NotNull(message = "Enter Donar ID!")
	@Column(length = 10)
	@SequenceGenerator(name = "seq", initialValue = 1000000001)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
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
	@Column(unique = true)
	String emailId;

	@NotNull(message = "Please enter the Phone Number")
	@Pattern(regexp = "^[1-9]{10}$", message = "Please check the Phone Number. Contains only Digits of length 10")
	String phoneNumber;
	
	@DateTimeFormat(iso = ISO.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy", shape=JsonFormat.Shape.STRING)
	LocalDate donationDate;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "DonarCamps",
	joinColumns = {
			@JoinColumn(name = "donar_id", referencedColumnName = "donarId", nullable = false, updatable = false ) },
	inverseJoinColumns = {
			@JoinColumn(name = "camp_id", referencedColumnName = "campId", nullable = false, updatable = false) })
	List<Camp> camps;
}
package com.lumen.mvc.pojo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Camp {

	@NotNull(message = "Enter Donar ID!")
	int campId;

	@NotNull(message = "Enter camp location")
	@Size(max = 25)
	String campLocation;

	@NotNull(message = "Enter Camp Date")
	@DateTimeFormat(iso = ISO.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy", shape=JsonFormat.Shape.STRING)
	LocalDate campDate;
	
	
	List<Donar> donars;
}

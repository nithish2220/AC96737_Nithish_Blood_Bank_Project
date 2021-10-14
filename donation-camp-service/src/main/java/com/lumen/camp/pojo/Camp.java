package com.lumen.camp.pojo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Camp")
public class Camp {

	@Id
	@NotNull(message = "Enter Donar ID!")
	int campId;

	@NotNull(message = "Enter camp location")
	@Size(max = 25)
	String campLocation;

	@NotNull(message = "Enter Camp Date")
	@DateTimeFormat(iso = ISO.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy", shape=JsonFormat.Shape.STRING)
	LocalDate campDate;
	
	
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "DonarCamps",
	joinColumns = {
			@JoinColumn(name = "camp_id", referencedColumnName = "campId", nullable = false, updatable = false ) },
	inverseJoinColumns = {
			@JoinColumn(name = "donar_id", referencedColumnName = "donarId", nullable = false, updatable = false) })
	List<Donar> donars;
}

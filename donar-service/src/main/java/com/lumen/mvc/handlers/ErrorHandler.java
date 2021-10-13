package com.lumen.mvc.handlers;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorHandler {
	private LocalDateTime currentTime;
	private String message;
	private String description;
}

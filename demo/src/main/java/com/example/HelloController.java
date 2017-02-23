package com.example;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.utils.adjusters.WorkingDaysAdjuster;

@RestController
public class HelloController {

	@GetMapping
	public String hello() {
		String salute = new String();
		LocalDate now = LocalDate.now();
		LocalDate date = now.with( WorkingDaysAdjuster.addWorkingDays(15) );

		salute = "From " + now + " to " + date;
		return salute;
	}

	@RequestMapping(value = "/world", method = RequestMethod.GET)
	public String home() {
		return "Hello World!";
	}


	

}
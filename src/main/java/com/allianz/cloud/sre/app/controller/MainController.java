package com.allianz.cloud.sre.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

	@GetMapping("/")
	public String index() {
		return "Hey, what's up!";
	}

}
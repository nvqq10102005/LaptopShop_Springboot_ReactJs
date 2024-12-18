package com.example.LaptopShop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaptopshopHelloword {
        	@GetMapping("/")
	public String index() {
		return "I love you !";
	}
}

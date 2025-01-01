package vn.com.LaptopShop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaptopshopHelloword {

	@GetMapping("/user")
	public String userPage() {
		return "this is user";
	}
}

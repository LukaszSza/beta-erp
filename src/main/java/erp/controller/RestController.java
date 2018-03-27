package erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import erp.service.OrderService;

@RestController
public class RestController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping("/hello")
	public String hello(){
		return "Hello World!!!";
	}
}

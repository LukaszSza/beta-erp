package erp.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import erp.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import erp.service.OrderService;

@Controller
public class MainController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("/all-orders")
	public String allOrders(HttpServletRequest request){
		request.setAttribute("orders", orderService.findAll());
		request.setAttribute("mode", "MODE_ORDERS");
		return "index";
	}
	
	@GetMapping("/new-order")
	public String newOrder(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	@PostMapping("/save-order")
	public String saveOrder(@ModelAttribute Order order, BindingResult bindingResult, HttpServletRequest request){
		order.setDate(new Date());
		orderService.save(order);
		request.setAttribute("orders", orderService.findAll());
		request.setAttribute("mode", "MODE_ORDERS");
		return "index";
	}
	
	@GetMapping("/update-order")
	public String updateOrders(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("order", orderService.findOrder(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/delete-order")
	public String deleteOrder(@RequestParam int id, HttpServletRequest request){
		orderService.delete(id);
		request.setAttribute("orders", orderService.findAll());
		request.setAttribute("mode", "MODE_ORDERS");
		return "index";
	}
}

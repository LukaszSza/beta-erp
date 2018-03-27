package erp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import erp.model.Order;
import org.springframework.stereotype.Service;

import erp.dao.OrderRepository;

@Service
@Transactional
public class OrderService {

	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public List<Order> findAll(){
		List<Order> orders = new ArrayList<>();
		for(Order order : orderRepository.findAll()){
			orders.add(order);
		}
		return orders;
	}
	
	public Order findOrder(int id){
		return orderRepository.findOne(id);
	}
	
	public void save(Order order){
		orderRepository.save(order);
	}
	
	public void delete(int id){
		orderRepository.delete(id);
	}
}

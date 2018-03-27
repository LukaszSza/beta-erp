package erp.dao;

import org.springframework.data.repository.CrudRepository;

import erp.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{

}

package service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import model.OrderDetails;

@Service
public interface IOrderService {
	public OrderDetails addOrder(OrderDetails od);
	public OrderDetails updateOrder(OrderDetails od,Long id);
	public ResponseEntity<OrderDetails> removeOrder(Long id);
	public OrderDetails viewOrderById(Long id);
	public List<OrderDetails> viewAllOrders();

}

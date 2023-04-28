package ibf2022.assessment.paf.batch3.repositories;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import ibf2022.assessment.paf.batch3.models.Order;

@Repository
public class OrderRepository {
	// TODO: Task 5
	public String insertOrder(Order order) {
		
		

		return order.getOrderId();
	}

	
	

	
}

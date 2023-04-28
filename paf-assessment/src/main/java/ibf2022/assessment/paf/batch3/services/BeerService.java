package ibf2022.assessment.paf.batch3.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.BeerQuan;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Order;
import ibf2022.assessment.paf.batch3.models.Style;
import ibf2022.assessment.paf.batch3.repositories.BeerRepository;
import ibf2022.assessment.paf.batch3.repositories.OrderRepository;

@Service
public class BeerService {

	@Autowired
	private BeerRepository beerRepository;

	@Autowired
	private OrderRepository orderRepository;

	public List<Style> getStyles(){
		return this.beerRepository.getStyles();
	}

	public List<Beer> getBreweriesByBeers(int id){
		return this.beerRepository.getBreweriesByBeer(id);
	}

	public Optional<Brewery> getBeersFromBrewery(int id){
		return this.beerRepository.getBeersFromBrewery(id);
	}


	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public String placeOrder(Order order) {
		// TODO: Task 5 
		String userId = UUID.randomUUID().toString().substring(0, 8);
		String date = LocalDate.now().toString();
		String brewerId = String.valueOf(order.getBrewerId());
		List<BeerQuan> bqs = order.getOrders();
		for (BeerQuan bq:bqs){
			System.out.println("Beer Name --->"+bq.getBeerName());
			System.out.println("Beer Quantity --->"+bq.getQuantity());
		}

		return "";
	}

}

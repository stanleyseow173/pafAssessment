package ibf2022.assessment.paf.batch3.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.BeerQuan;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Order;
import ibf2022.assessment.paf.batch3.models.Style;
import ibf2022.assessment.paf.batch3.services.BeerService;
import jakarta.validation.Valid;

@Controller
//@RequestMapping(path="/")
public class BeerController {

	@Autowired
	private BeerService beerService;
	//TODO Task 2 - view 0
	
	@GetMapping(path="/")
	public String getStyles(Model model){
		List<Style> styles = this.beerService.getStyles();
		model.addAttribute("styles",styles);
		return "view0";
	}
	
	
	//TODO Task 3 - view 1
	@GetMapping(path="/beer/style/{id}")
	public String getBrewery(@PathVariable int id, Model model, @RequestParam(required=false) String styleName){
		// System.out.println("went in here ------------------------->");
		List<Beer> beers = this.beerService.getBreweriesByBeers(id);
		model.addAttribute("beers",beers);
		model.addAttribute("style",styleName);
		// System.out.println("Beers ------------->"+ beers.toString());
		// for (Beer beer: beers){
		// 	System.out.println("Beer ------------>"+ beer.getBeerName());
		// }
		return "view1";
	}

	//TODO Task 4 - view 2
	@GetMapping(path="/brewery/{id}")
	public String getBreweryById(@PathVariable int id, Model model){
		
		Optional<Brewery> breweryOptional = this.beerService.getBeersFromBrewery(id);
		Brewery brewery = breweryOptional.get();
		model.addAttribute("brewery",brewery);
		Order order = new Order();
		order = Order.fillFromBrewery(brewery);
		//List<BeerQuan> bqs = Order.fillFromBrewery(brewery);
		// System.out.println("Orders ------------->"+ bqs.toString());
		// for (BeerQuan bq: bqs){
		// 	System.out.println("Orders ------------>"+ bq.getBeerName());
		// }
		model.addAttribute("order", order);
		//model.addAttribute("orders", bqs);
		//model.addAttribute("style",styleName);
		//System.out.println("Orders ------------>"+ bqs.toString());

		
		return "view2";
	}

	//TODO Task 5 - view 2, place order
	@PostMapping(path="/brewery/{id}/order")
	public String postOrder(@PathVariable int id, Model model, @ModelAttribute("order") @Valid Order orderForm, BindingResult bindingResult){

		//List<BeerQuan> bqs = orders;

		// for(BeerQuan bq: bqs){
		// 	System.out.println("beerID---------->"+ String.valueOf(bq.getBeerId()));
		// 	System.out.println("beerQuantity---------->"+ String.valueOf(bq.getQuantity()));
		// }
		//Order newOrder = (Order)model.getAttribute("order");
		//System.out.println("OrderForm AT FIRST is --->"+newOrder.getOrders().toString());
		//System.out.println("OrderForm is --->"+orderForm.getOrders().toString());
		
		
		try{
			String orderId = this.beerService.placeOrder(orderForm);
		}catch (Exception e){

		}
		return "view3";
	}



}

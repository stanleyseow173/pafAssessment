package ibf2022.assessment.paf.batch3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Style;
import ibf2022.assessment.paf.batch3.repositories.BeerRepository;

@Service
public class BeerService {

	@Autowired
	private BeerRepository beerRepository;

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
	public String placeOrder(/* You can add any number parameters here */) {
		// TODO: Task 5 
		
		return "";
	}

}

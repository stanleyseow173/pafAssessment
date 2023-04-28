package ibf2022.assessment.paf.batch3.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Style;

import static ibf2022.assessment.paf.batch3.repositories.DBQueries.*;

@Repository
public class BeerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate; 

	// select s.id, style_name, count(b.id) as beer_count
	// from styles s left join beers b 
	// on s.id = b.style_id
	// group by s.id
	// order by beer_count DESC, style_name;

	// DO NOT CHANGE THE SIGNATURE OF THIS METHOD
	public List<Style> getStyles() {
		// TODO: Task 2

		List<Style> styles = new ArrayList<Style>();
		styles = jdbcTemplate.query(GET_STYLES, new StyleRowMapper());
		
		return styles;
	}
		

	// select b.name as beer_name, b.descript as description, w.name
	// from beers b LEFT JOIN breweries w
	// ON b.brewery_id = w.id
	// where b.style_id = 31
	// order by beer_name ASC;
	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public List<Beer> getBreweriesByBeer(int id) {
		// TODO: Task 3
		List<Beer> beers = new ArrayList<Beer>();
		beers = jdbcTemplate.query(GET_BREWERIES, new BeerRowMapper(), new Object[]{id});
		return beers;
	}

	// SELECT b.id, b.name, b.descript FROM beers b, breweries w where w.id = b.brewery_id and w.id = 2 order by b.name ASC;
	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery(int id) {
		// TODO: Task 4
		List<Beer> beers = new ArrayList<Beer>();
		beers = jdbcTemplate.query(GET_BEERS, new BeerRowMapper(), new Object[]{id});
		Brewery brewery = new Brewery();
		brewery = jdbcTemplate.queryForObject(GET_BREWERY_BY_ID,new BreweryRowMapper(),new Object[]{id});
		brewery.setBeers(beers);

		return Optional.of(brewery);
	}
}

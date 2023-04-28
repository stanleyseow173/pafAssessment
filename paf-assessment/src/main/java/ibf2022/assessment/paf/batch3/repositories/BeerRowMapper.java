package ibf2022.assessment.paf.batch3.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ibf2022.assessment.paf.batch3.models.Beer;

public class BeerRowMapper implements RowMapper<Beer> {

    @Override
    public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        Beer beer = new Beer();
        beer.setBeerId(rs.getInt("beer_id"));
        beer.setBeerName(rs.getString("beer_name"));
        beer.setBeerDescription(rs.getString("description"));
        beer.setBreweryId(rs.getInt("brewery_id"));
        beer.setBreweryName(rs.getString("brewery_name"));
        return beer;
    }
    
}

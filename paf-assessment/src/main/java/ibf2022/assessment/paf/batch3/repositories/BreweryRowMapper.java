package ibf2022.assessment.paf.batch3.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ibf2022.assessment.paf.batch3.models.Brewery;

public class BreweryRowMapper implements RowMapper<Brewery>{

    @Override
    public Brewery mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        Brewery brewery = new Brewery();
        brewery.setBreweryId(rs.getInt("id"));
        brewery.setName(rs.getString("name"));
        brewery.setDescription(rs.getString("descript"));
        brewery.setAddress1(rs.getString("address1"));
        brewery.setPhone(rs.getString("phone"));
        brewery.setWebsite(rs.getString("website"));
        return brewery;
    }
    
}

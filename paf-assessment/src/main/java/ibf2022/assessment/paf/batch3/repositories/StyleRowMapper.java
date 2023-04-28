package ibf2022.assessment.paf.batch3.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ibf2022.assessment.paf.batch3.models.Style;

public class StyleRowMapper implements RowMapper<Style> {

    @Override
    public Style mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        Style style = new Style();
        style.setStyleId(rs.getInt("id"));
        style.setName(rs.getString("style_name"));
        style.setBeerCount(rs.getInt("beer_count"));
        return style;
    }
    
}

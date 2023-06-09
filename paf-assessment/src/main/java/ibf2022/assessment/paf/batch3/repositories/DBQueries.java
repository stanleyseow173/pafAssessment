package ibf2022.assessment.paf.batch3.repositories;

public class DBQueries {
    public static final String GET_STYLES = "select s.id, style_name, count(b.id) as beer_count from styles s left join beers b on s.id = b.style_id group by s.id order by beer_count DESC, style_name;";

    public static final String GET_BREWERIES = "select b.id as beer_id, b.name as beer_name, b.descript as description, w.id as brewery_id, w.name as brewery_name from beers b LEFT JOIN breweries w ON b.brewery_id = w.id where b.style_id = ? order by beer_name ASC;";

    public static final String GET_BEERS = "SELECT b.id as beer_id, b.name as beer_name, b.descript as description, w.id as brewery_id, w.name as brewery_name FROM beers b, breweries w where w.id = b.brewery_id and w.id = ? order by b.name ASC;";

    public static final String GET_BREWERY_BY_ID = "select id, name, descript, address1,  phone, website from breweries b where b.id =?;";
}   

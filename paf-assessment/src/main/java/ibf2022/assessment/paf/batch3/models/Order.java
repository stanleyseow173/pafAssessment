package ibf2022.assessment.paf.batch3.models;

import java.util.LinkedList;
import java.util.List;

public class Order {
    private String orderId;
    private String date;
    private int brewerId;
    private List<BeerQuan> orders;

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getBrewerId() {
        return brewerId;
    }
    public void setBrewerId(int brewerId) {
        this.brewerId = brewerId;
    }
    public List<BeerQuan> getOrders() {
        return orders;
    }
    public void setOrders(List<BeerQuan> orders) {
        this.orders = orders;
    }

    public static Order fillFromBrewery(Brewery brewery) {
        Order order =  new Order();
        order.setBrewerId(brewery.getBreweryId());
        List<Beer> beers = brewery.getBeers();
        List<BeerQuan> bqs = new LinkedList<BeerQuan>();
        for(Beer beer: beers){
            BeerQuan bq = new BeerQuan();
            bq.setBeerId(beer.getBeerId());
            bq.setBeerName(beer.getBeerName());
            bq.setBeerDescription(beer.getBeerDescription());
            bqs.add(bq);
        }
        order.setOrders(bqs);
        return order;
    }

    
}

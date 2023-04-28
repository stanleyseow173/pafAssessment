package ibf2022.assessment.paf.batch3.models;

public class BeerQuan {
    private int beerId;
    private int quantity;
    private String beerName;
    private String beerDescription;

    public int getBeerId() {
        return beerId;
    }
    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    public String getBeerName() {
        return beerName;
    }
    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }
    public String getBeerDescription() {
        return beerDescription;
    }
    public void setBeerDescription(String beerDescription) {
        this.beerDescription = beerDescription;
    }



    @Override
    public String toString() {
        return "BeerQuan [beerId=" + beerId + ", quantity=" + quantity + ", beerName=" + beerName + ", beerDescription="
                + beerDescription + "]";
    }

    
    
}


/**
 * A classe HotelDiscount 
 * 
 * @celia
 * @version 1.0
 */
public class HotelDiscount extends HotelEpoca implements Comparable<Hotel>{
    
    private int ocupacao; 
    
    public HotelDiscount(){
        super();
    }
    
    public HotelDiscount (HotelDiscount hd ){
        super(hd);
    }
    
    public double precoQuartoNoite(){
        float perc = 1-(super.getNumeroQuartos()-ocupacao/(super.getNumeroQuartos())); 
        double pb = super.precoQuartoNoite();
        return pb*0.5 + (perc>0.5 ? pb+0.8*(perc-0.5): 0); 
    
    }
    
    public HotelDiscount clone(){
        return new HotelDiscount(this); 
    }
    
}

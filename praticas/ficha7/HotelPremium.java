import java.util.List; 
import java.util.Set; 
import java.util.Map; 
/**
 * a classe HotelPremium 
 * 
 * @celia
 * @version 1.0
 */
public class HotelPremium extends Hotel implements Comparable<Hotel>{
    
    private double taxaLuxo; 
    private Map <String,Hotel> hoteis; //codigo hotel -> hotel 
    
    /**
     * Construtor vazio
     */
    
    public HotelPremium(){
         super();
         this.taxaLuxo= 0; 
    }
    
    /**
     * Construtor parametrizado
     */
    public HotelPremium (HotelPremium hp){
        super(hp); 
        this.taxaLuxo= hp.getTaxaLuxo(); 
    
    }
    
    public double getTaxaLuxo(){
        return this.taxaLuxo; 
    
    }
    
    /**
     * Verificar a existencia de um hotel, dado o seu código
     */
    public boolean existeHotel(String cod){
       return this.hoteis.containsKey(cod); 
    
    }
    
    /**
     * Devolver a quantidade de hoteis existentes na cadeia
     */
    public int quantos(){
    
    }
    
    /**
     * Devolver a quantidade de hóteis de uma dada localidade
     */
    
    public int quantos (String loc){
    
    }
    
    /**
     * Devolver a quantidade de hóteis de um dado tipo (Standard, Premium)
     */
    
    public int quantosT(String tipo){
        
    
    }
    
    /**
     * Devolver a ficha de um hotel, dado o seu código
     */
    
    public Hotel getHotel (String cod){
    
    }
    
    /**
     * Adicionar a informação de um novo hotel 
     */
    
    public void adiciona (Hotel h){
    
    }
    
    /**
     * Devolver uma lista contendo a cópia de todos os hóteis no sistema
     */
    
    public List<Hotel> getHoteis (){
    
    }
    /**
     * Adicionar a informação de um conjunto de hóteis
     */
    public void adiciona (Set <Hotel> hs){
    
    }
    
    /**
     * Alterar o estado da época de todos os HotelStandard
     */
    
    public void mudaPara (String epoca){}
    
    public HotelPremium clone(){
        return new HotelPremium (this);
    
    }
   
}

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set; 
import java.util.ArrayList; 
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toList;
/**
 * Escreva a descrição da classe HotelInc aqui.
 * 
 * @celia 
 * @version 1.0
 */
public class HotelInc{
    //varivais de instância 
    private String nome; 
    private Map<String,Hotel> hoteis; //codigo hotel -> hotel 
     /**
      * construtor vazio
      */
    public HotelInc(){
        this.nome = "n/a";
        this.hoteis = new HashMap<>(); 
        
    }
    
    public HotelInc (String nome){
        this.nome = nome; 
        this.hoteis = new HashMap<>(); 
    
    }
    
    public HotelInc(HotelInc hi){
        this.nome=hi.getNome();
        //this.hoteis=hi.getHoteisMap();
    }
    
    public HotelInc(String nome, Map<String,Hotel> hoteis){
        this.nome= nome; 
        this.hoteis = hoteis.entrySet().stream()
                                       .collect(toMap(e -> e.getKey(), 
                                                      e -> e.getValue().clone()));
    }
    
    public String getNome(){
        return  this.nome; 
    }
    
    
    /**
     * Verificar a existência de um hotel, dado o seu código.
     */
    public boolean existeHotel(String cod){
        return this.hoteis.containsKey(cod); 
    }
    
    
    /**
     * Devolver a quantidade de hotéis existentes na cadeia.
     */
    public int quantos(){
        return this.hoteis.size(); 
  }
    
    /**
     * Devolver o número total de hotéis de uma dada localidade.
     */
    public long quantos(String loc){
        return this.hoteis.values()
                          .stream()
                          .filter(h->h.getLocalidade().equals(loc))
                          .count();
    }
    
    
    /**
     * Devolver a chave de um hotel, dado o seu código (CÓDIGOS EXISTENTES)
     */
    
    public Hotel getHotel(String cod){
        return this.hoteis.get(cod).clone();
        
    }
    
    /**
     * Adicionar a informação de um novo hotel.
     * @ param cod tem de ser um código que exista 
     */
    public void adiciona(Hotel h){
        this.hoteis.put(h.getCodigo(), h.clone());
    
    }
    
    
    /**
     * ©
     * (deve devolver uma lista dos hoteis)
     */

    public List<Hotel> getHoteis(){
         return this.hoteis.values()
                          .stream()
                          .map(Hotel :: clone)
                          .collect(toList()); 
    }
    
    
    public List<Hotel> getHoteisAlt(){
            List<Hotel> res = new ArrayList<>();
            for(Hotel h : this.hoteis.values()){
                res.add(h.clone());
            }
         return res; 
    }
    
    /**
     * Adicionar a informação de um conjunto de hotéis.
     */
    public void adiciona(Set <Hotel> hs){
        hs.forEach(h-> this.adiciona(hs)); //pego num conjunto de hoteis e adiciona
    }
    
    
    public Map<String, Hotel> getHoteisMap(){
        return this.hoteis.values().stream().collect(toMap(h->h.getCodigo(), h->h.clone())); 
    }
    
}

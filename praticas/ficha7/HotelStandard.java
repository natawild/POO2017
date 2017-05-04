import java.util.List; 
import java.util.Map; 
import java.util.ArrayList; 
/**
 * A classe HotelStandard 
 * 
 * @celia
 * @version 1.0
 */
public class HotelStandard extends HotelEpoca implements CartaoPontos {
    private Map <String,Hotel> hoteis;
    private int pontos; 
    private static final int VALOR_EA = 20; 
    //variáveis de instância 
    private static double precoBase; 
    private boolean epocaAlta; 
    
    public HotelStandard(){
        super();
        this.epocaAlta = false; 
        this.pontos=pontos; 
    
    }
    
    public HotelStandard (HotelStandard hs ){
        super(hs);
        this.epocaAlta = hs.getEpocaAlta();
        this.pontos=hs.getPontos(); 
    
    }
    
    public HotelStandard(int pontos, double precoBase, boolean epocaAlta){
        this.pontos= pontos; 
        this.precoBase= precoBase;
        this.epocaAlta=epocaAlta; 
    
    }
    
    public double getPrecoBaseQuarto(){
        return HotelStandard.precoBase; 
    
    }
    
    public int getPontos(){
        return this.pontos; 
    
    }
    
    public boolean getEpocaAlta(){
        return this.epocaAlta; 
    }
    
    /*
    public HotelStandard(String codigo, String nome, String localidade, double precoBaseQuarto, 
                            int numQuartos, int estrelas, boolean epocaAlta, int pontos){
                                super(codigo,nome,localidade, precoBaseQuarto, numQuartos, estrelas, pontos);
                                this.epocaAlta = epocaAlta; 
                                this.pontos = pontos; 
    }
    */
    

    
    public void setEpocaAlta (boolean epocaAlta){
        this.epocaAlta=epocaAlta; 
    
    }
    
    public void setPontos(int pontos){
        this.pontos=pontos; 
    
    }
    
    public double precoQuarto(){
        return super.getPrecoBaseQuarto() + (epocaAlta?20 :0);
    }
    
    public boolean equals (Object obj){
        
        if(obj == this) {
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        HotelStandard o = (HotelStandard) obj;
        return super.equals(o) && this.epocaAlta == o.getEpocaAlta();
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder("Hotel Standard ");
        sb.append(super.toString()); 
        sb.append("Epoca Alta '").append(epocaAlta).append("'\n");
        return sb.toString(); 
    }
    
    public int compareTo (HotelStandard hs){
       int r= super.compareTo(hs); 
         if(r==0 && this.epocaAlta!=hs.getEpocaAlta()){
             r=this.epocaAlta ? +1 : -1; 
             
            }
         return r; 
      }
      
      /**
       * obter o preço por quarto por noite 
       * (fazer este método direito)
       */
      
      public double precoQuartoNoite(){
          return 10; 
        
        }
        
   public void adicionaHotel(Hotel h){
       if(!hoteis.containsKey(h.getCodigo())){
            this.hoteis.put(h.getCodigo(),h.clone()); 
        }
    }
        
   public Hotel getHotel(String cod) throws HotelNaoExisteException{
       try{
           return this.hoteis.get(cod).clone(); 
        }
        
       catch (NullPointerException e){
           throw new HotelNaoExisteException("Hotel não existe"); 
        }
    }
    
        
        /***
         * 
         */
    public List<CartaoPontos> daoPontos (){
        List <CartaoPontos> res = new ArrayList<>(); 
        this.hoteis.values().forEach(h -> {
                                    if (h instanceof CartaoPontos){
                                                res.add((CartaoPontos)h.clone()); 
                                            }
                                        });                           
          return res;                                   
    
      }
           
                
    public HotelStandard clone(){
        return new HotelStandard(this);
    
    }
   
}

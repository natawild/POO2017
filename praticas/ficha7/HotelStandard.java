
/**
 * A classe HotelStandard 
 * 
 * @celia
 * @version 1.0
 */
public class HotelStandard extends Hotel implements Comparable<Hotel> {
    private static final int VALOR_EA = 20; 
    //variáveis de instância 
    private static double precoBase; 
    private boolean epocaAlta; 
    
    public HotelStandard(){
        super();
        this.epocaAlta = false; 
    
    }
    
    public HotelStandard (HotelStandard hs ){
        super(hs);
        this.epocaAlta = hs.getEpocaAlta(); 
    
    }
    
    public double getPrecoBaseQuarto(){
        return HotelStandard.precoBase; 
    
    }
    
    public boolean getEpocaAlta(){
        return this.epocaAlta; 
    }
    
    public HotelStandard(String codigo, String nome, String localidade, double precoBaseQuarto, 
                            int numQuartos, int estrelas, boolean epocaAlta){
                                super(codigo,nome,localidade, precoBaseQuarto, numQuartos, estrelas);
                                this.epocaAlta = epocaAlta; 
    }
    

    
    public void setEpocaAlta (boolean epocaAlta){
        this.epocaAlta=epocaAlta; 
    
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
    
    public HotelStandard clone(){
        return new HotelStandard(this);
    
    }
   
}

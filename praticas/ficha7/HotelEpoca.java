
/**
 * Escreva a descrição da classe HotelEpoca aqui.
 * 
 * @celia
 * @version (número de versão ou data)
 */
public class HotelEpoca extends Hotel{
    private int pontos; 
    private static final int VALOR_EA = 20; 
    //variáveis de instância 
    private static double precoBase; 
    private boolean epocaAlta; 
    
    public HotelEpoca(){
        super();
        this.epocaAlta = false; 
        this.pontos=pontos; 
    
    }
    
    public HotelEpoca (HotelEpoca hs ){
        super(hs);
        this.epocaAlta = hs.getEpocaAlta();
        this.pontos=hs.getPontos(); 
    
    }
    
    public double getPrecoBaseQuarto(){
        return HotelEpoca.precoBase; 
    
    }
    
    public int getPontos(){
        return this.pontos; 
    
    }
    
    public boolean getEpocaAlta(){
        return this.epocaAlta; 
    }
    
    public HotelEpoca(String codigo, String nome, String localidade, double precoBaseQuarto, 
                            int numQuartos, int estrelas, boolean epocaAlta, int pontos){
                                super(codigo,nome,localidade, precoBaseQuarto, numQuartos, estrelas);
                                this.epocaAlta = epocaAlta; 
                                this.pontos = pontos; 
    }
    

    
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
        HotelEpoca o = (HotelEpoca) obj;
        return super.equals(o) && this.epocaAlta == o.getEpocaAlta();
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder("Hotel Standard ");
        sb.append(super.toString()); 
        sb.append("Epoca Alta '").append(epocaAlta).append("'\n");
        return sb.toString(); 
    }
    
    public int compareTo (HotelEpoca hs){
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
        
        
    
    
    public HotelEpoca clone(){
        return new HotelEpoca(this);
    
    }
   
}


import java.time.LocalDateTime; 
/**
 * A classe HistoricoAtor 
 * 
 * @celia 
 * @version 1.0
 */
public abstract class HistoricoAtor {
    private LocalDateTime dataDeInicioDeServico;
    private float tempo; 
    private float valorCobrado; 
    //private AtorInterface cliente; 
    //private AtorInterface motorista; 
    
    /**
     * construtor vazio
     */
    
    public HistoricoAtor(){
        dataDeInicioDeServico= null; 
        tempo= 0.0f;
        valorCobrado=0.0f;
    }
    
    /**
     * cosntrutor parametrizado
     * @param dataDeInicioDeServico
     * @param tempo 
     * @param valorCobrado
     */
    
    public HistoricoAtor(LocalDateTime dataDeInicioDeServico, float tempo, float valorCobrado){
        this.dataDeInicioDeServico= dataDeInicioDeServico; 
        this.tempo= tempo; 
        this.valorCobrado= valorCobrado;    
    }
    
    /**
     * construtor de cópia
     */
    
    public HistoricoAtor(HistoricoAtor h){
       this.dataDeInicioDeServico= h.getDataDeInicioDeServico(); 
        this.tempo= h.getTempo(); 
        this.valorCobrado= h.getValorCobrado();
    }
    
    /**
     * Gets
     */
    
    public LocalDateTime getDataDeInicioDeServico(){
        return this.dataDeInicioDeServico; 
    }
    
    public float getTempo(){
        return this.tempo; 
    }
    
    public float getValorCobrado(){
        return this.valorCobrado;
    }
    
    
    /**
     * set 
     */
    
    public void setDataDeInicioDeServico (LocalDateTime dataDeInicioDeServico){
       this.dataDeInicioDeServico= dataDeInicioDeServico; 
    }
    
    public void setTempo(float tempo){
       this.tempo=tempo; 
    }
    
    public void setValorCobrado( float valorCobrado){
        this.valorCobrado= valorCobrado; 
    }
    
    
    /**
     * Equals 
     */
    public boolean equals (Object o){
       if(this==o) 
            return true;
       if((o == null) || (this.getClass()!=o.getClass()))
            return false;
            
       HistoricoAtor h = (HistoricoAtor) o; 
       return (this.dataDeInicioDeServico.equals(h.getDataDeInicioDeServico()) && this.tempo==h.getTempo() &&
       this.valorCobrado==h.getValorCobrado()); 

    }
    
    /**
     * toString
     */
      public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Data da viagem " +this.getDataDeInicioDeServico() + "\n"); 
        sb.append("Tempo da Vigem: " +this.getTempo() + "\n"); 
        sb.append("Valor Cobrado: " +this.getValorCobrado() + "\n");
        return sb.toString(); 
    }
    

    
    
    
}

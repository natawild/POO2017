import java.time.LocalDateTime; 
/**
 * A classe HistoricoAtor 
 * 
 * @celia 
 * @version 1.0
 */
public abstract class HistoricoAtor {
    private LocalDateTime dataDeInicioDeServico;
    private float tempoEstimado; 
    private float tempoReal; 
    private float valorCobrado; 
    private String estadoTempo; 
    
    //private AtorInterface cliente; 
    //private AtorInterface motorista; 
    
    /**
     * construtor vazio
     */
    
    public HistoricoAtor(){
        dataDeInicioDeServico= null; 
        tempoEstimado= 0.0f;
        tempoReal= -1.0f;
        valorCobrado=0.0f;
        estadoTempo=""; 
    }
    
    /**
     * cosntrutor parametrizado
     * @param dataDeInicioDeServico
     * @param tempo 
     * @param valorCobrado
     */
    
    public HistoricoAtor(LocalDateTime dataDeInicioDeServico, float tempoEstimado, float tempoReal, float valorCobrado, String estadoTempo){
        this.dataDeInicioDeServico= dataDeInicioDeServico; 
        this.tempoEstimado= tempoEstimado;
        this.tempoReal = tempoReal;
        this.valorCobrado= valorCobrado;  
        this.estadoTempo= estadoTempo; 
    }
    
    /**
     * construtor de cópia
     */
    
    public HistoricoAtor(HistoricoAtor h){
       this.dataDeInicioDeServico= h.getDataDeInicioDeServico(); 
       this.tempoEstimado= h.getTempoEstimado();
       this.tempoReal = h.getTempoEstimado();
       this.valorCobrado= h.getValorCobrado();
       this.estadoTempo= h.getEstadoTempo();
    }
    
    /**
     * Gets
     */
    
    public LocalDateTime getDataDeInicioDeServico(){
        return this.dataDeInicioDeServico; 
    }
    
    public float getTempoEstimado(){
        return this.tempoEstimado; 
    }
    
    public float getTempoReal(){
        return this.tempoReal; 
    }
    
    public float getValorCobrado(){
        return this.valorCobrado;
    }
    
    public String getEstadoTempo(){
        return this.estadoTempo; 
    }
    
    
    /**
     * set 
     */
    
    public void setDataDeInicioDeServico (LocalDateTime dataDeInicioDeServico){
       this.dataDeInicioDeServico= dataDeInicioDeServico; 
    }
    
    public void setTempoEstimado(float tempoEstimado){
       this.tempoEstimado=tempoEstimado; 
    }
    
    public void setTempoReal(float tempoReal){
       this.tempoReal=tempoReal; 
    }
    
    public void setValorCobrado( float valorCobrado){
        this.valorCobrado= valorCobrado; 
    }
    
    public void setEstadoTempo(String estadoTempo){
        this.estadoTempo= estadoTempo; 
    
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
       return (this.dataDeInicioDeServico.equals(h.getDataDeInicioDeServico()) && this.tempoEstimado==h.getTempoEstimado() &&
       this.valorCobrado==h.getValorCobrado() && this.tempoReal == h.getTempoReal() && this.estadoTempo.equals(h.getEstadoTempo())); 

    }
    
    /**
     * toString
     */
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Data da viagem " +this.getDataDeInicioDeServico() + "\n"); 
        sb.append("Tempo da Vigem estimado: " +this.getTempoEstimado() + "\n");
        sb.append("Tempo da Vigem real: " +this.getTempoReal() + "\n");
        sb.append("Valor Cobrado: " +this.getValorCobrado() + "\n");
         sb.append("Estado do tempo: " +this.getEstadoTempo() + "\n");
        return sb.toString(); 
    }
    
}

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
    private float valorEstimado; 
    private float valorCobrado; 
    private String estadoTempo;
    private String estadoTransito; 
    private boolean terminada; 
    
    //private AtorInterface cliente; 
    //private AtorInterface motorista; 
    
    /**
     * construtor vazio
     */
    
    public HistoricoAtor(){
        dataDeInicioDeServico= null; 
        tempoEstimado= 0.0f;
        valorEstimado=0.0f;
        tempoReal= -1.0f;
        valorCobrado=0.0f;
        estadoTempo=""; 
        estadoTransito=""; 
        terminada=false; 
    }
    
    /**
     * cosntrutor parametrizado
     * @param dataDeInicioDeServico
     * @param tempo 
     * @param valorCobrado
     */
    
    public HistoricoAtor(LocalDateTime dataDeInicioDeServico, float tempoEstimado, float tempoReal,float valorEstimado, float valorCobrado, 
    String estadoTempo, String estadoTransito, boolean terminada){
        this.dataDeInicioDeServico= dataDeInicioDeServico; 
        this.tempoReal= tempoReal; 
        this.tempoEstimado= tempoEstimado;
        this.tempoReal = tempoReal;
        this.valorEstimado=valorEstimado; 
        this.valorCobrado= valorCobrado;  
        this.estadoTempo= estadoTempo; 
        this.estadoTransito= estadoTransito; 
        this.terminada=terminada; 
        
    }
    
    /**
     * construtor de cópia
     */
    
    public HistoricoAtor(HistoricoAtor h){
       this.dataDeInicioDeServico= h.getDataDeInicioDeServico(); 
       this.tempoEstimado= h.getTempoEstimado();
       this.tempoReal = h.getTempoEstimado();
       this.valorEstimado=h.getValorEstimado(); 
       this.valorCobrado= h.getValorCobrado();
       this.estadoTempo= h.getEstadoTempo();
       this.estadoTransito=h.getEstadoTransito(); 
       this.terminada=h.getTerminada(); 
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
    
    public float getValorEstimado(){
        return this.valorEstimado;
    }
    
    public String getEstadoTempo(){
        return this.estadoTempo; 
    }
    
    public String getEstadoTransito(){
        return this.estadoTransito; 
    }
    
    
    public boolean getTerminada(){
        return this.terminada; 
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
    
    public void setValorEstimado( float valorEstimado){
        this.valorEstimado= valorEstimado; 
    }
    
    
    public void setEstadoTempo(String estadoTempo){
        this.estadoTempo= estadoTempo; 
    
    }
    
    public void setEstadoTransito(String estadoTransito){
        this.estadoTransito= estadoTransito; 
    
    }
    
    public void setTerminada(boolean terminada){
        this.terminada= terminada; 
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
       this.valorCobrado==h.getValorCobrado() &&this.valorEstimado==h.getValorEstimado() && this.tempoReal == h.getTempoReal() && 
       this.estadoTempo.equals(h.getEstadoTempo()) && this.estadoTransito.equals(h.getEstadoTransito()) && this.terminada==h.getTerminada()); 

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
        sb.append("Valor Estimado: " +this.getValorEstimado() + "\n");
        sb.append("Estado do tempo: " +this.getEstadoTempo() + "\n");
        sb.append("Estado do transito: " +this.getEstadoTransito() + "\n");
        return sb.toString(); 
    }
    
}

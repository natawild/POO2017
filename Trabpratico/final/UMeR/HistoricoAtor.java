import java.time.LocalDateTime; 
import java.io.Serializable;
/**
 * A classe HistoricoAtor 
 * 
 * @celia 
 * @version 1.0
 */
public abstract class HistoricoAtor implements Serializable{
    private LocalDateTime dataDeInicioDeServico;
    private double distancia;
    private double tempoEstimado; 
    private double tempoReal;
    private double valorEstimado; 
    private double valorCobrado; 
    private String estadoTempo;
    private String estadoTransito; 
    private boolean terminado; 
    private Coordenadas origem;
    private Coordenadas destino;
    private int classificacao;
    
    //private AtorInterface cliente; 
    //private AtorInterface motorista; 
    
    /**
     * construtor vazio
     */
    
    public HistoricoAtor(){
        distancia = 0.0d;
        dataDeInicioDeServico= LocalDateTime.now(); 
        tempoEstimado= 0.0d;
        valorEstimado=0.0d;
        tempoReal= 0.0d;
        valorCobrado=0.0d;
        estadoTempo=""; 
        estadoTransito=""; 
        terminado=false; 
        origem = null;
        destino = null;
        classificacao = 0;
    }
    
    
    /**
     * cosntrutor parametrizado
     * @param dataDeInicioDeServico
     * @param tempo 
     * @param valorCobrado
     */
    
    public HistoricoAtor(LocalDateTime dataDeInicioDeServico, double distancia, double tempoEstimado, double tempoReal,double valorEstimado, double valorCobrado, 
    String estadoTempo, String estadoTransito, boolean terminado, Coordenadas origem, Coordenadas destino, int classificacao){
        this.dataDeInicioDeServico= dataDeInicioDeServico; 
        this.distancia = distancia;
        this.tempoReal= tempoReal; 
        this.tempoEstimado= tempoEstimado;
        this.tempoReal = tempoReal;
        this.valorEstimado=valorEstimado; 
        this.valorCobrado= valorCobrado;  
        this.estadoTempo= estadoTempo; 
        this.estadoTransito= estadoTransito; 
        this.terminado=terminado; 
        this.origem = origem;
        this.destino = destino;
        this.classificacao = classificacao;
    }
    
    /**
     * construtor de cópia
     */
    public HistoricoAtor(HistoricoAtor h){
       this.dataDeInicioDeServico= h.getDataDeInicioDeServico(); 
       this.distancia = h.getDistancia();
       this.tempoEstimado= h.getTempoEstimado();
       this.tempoReal = h.getTempoEstimado();
       this.valorEstimado=h.getValorEstimado(); 
       this.valorCobrado= h.getValorCobrado();
       this.estadoTempo= h.getEstadoTempo();
       this.estadoTransito=h.getEstadoTransito(); 
       this.terminado=h.getTerminado(); 
       this.origem = h.getOrigem();
       this.destino = h.getDestino();
       this.classificacao = h.getClassificacao();
    }
    
    /**
     * Gets
     */
    
    public LocalDateTime getDataDeInicioDeServico(){
        return this.dataDeInicioDeServico; 
    }
    
    public double getDistancia(){
        return this.distancia; 
    }
    
    public double getTempoEstimado(){
        return this.tempoEstimado; 
    }
    
    public double getTempoReal(){
        return this.tempoReal; 
    }
    
    public double getValorCobrado(){
        return this.valorCobrado;
    }
    
    public double getValorEstimado(){
        return this.valorEstimado;
    }
    
    public String getEstadoTempo(){
        return this.estadoTempo; 
    }
    
    public String getEstadoTransito(){
        return this.estadoTransito; 
    }
    
    
    public boolean getTerminado(){
        return this.terminado; 
    }
    
    public Coordenadas getOrigem(){
        return this.origem.clone(); 
    }
    
    public Coordenadas getDestino(){
        return this.destino.clone(); 
    }
    
    public int getClassificacao(){
        return this.classificacao; 
    }
    
    
    /**
     * set 
     */
    
    public void setDataDeInicioDeServico (LocalDateTime dataDeInicioDeServico){
       this.dataDeInicioDeServico= dataDeInicioDeServico; 
    }
    
    public void setDistancia(double distancia){
       this.distancia=distancia; 
    }
    
    public void setTempoEstimado(double tempoEstimado){
       this.tempoEstimado=tempoEstimado; 
    }
    
    public void setTempoReal(double tempoReal){
       this.tempoReal=tempoReal; 
    }
    
    public void setValorCobrado( double valorCobrado){
        this.valorCobrado= valorCobrado; 
    }
    
    public void setValorEstimado( double valorEstimado){
        this.valorEstimado= valorEstimado; 
    }
    
    
    public void setEstadoTempo(String estadoTempo){
        this.estadoTempo= estadoTempo; 
    
    }
    
    public void setEstadoTransito(String estadoTransito){
        this.estadoTransito= estadoTransito; 
    
    }
    
    public void setTerminado(boolean terminado){
        this.terminado= terminado; 
    }
    
    public void setOrigem(Coordenadas origem){
        this.origem=origem.clone(); 
    }
    
     
    public void setDestino(Coordenadas destino){
        this.destino=destino.clone(); 
    }
    
    public void setClassificacao(int classificacao){
        this.classificacao = classificacao; 
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
       return (this.dataDeInicioDeServico.equals(h.getDataDeInicioDeServico()) && this.distancia==h.getDistancia() && this.tempoEstimado==h.getTempoEstimado() &&
       this.valorCobrado==h.getValorCobrado() &&this.valorEstimado==h.getValorEstimado() && this.tempoReal == h.getTempoReal() && 
       this.estadoTempo.equals(h.getEstadoTempo()) && this.estadoTransito.equals(h.getEstadoTransito()) && this.terminado==h.getTerminado() && this.destino.equals(h.getDestino()) 
       && this.origem.equals(h.getOrigem()) && this.classificacao == h.getClassificacao()); 
    }
     
    /**
     * toString
     */
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Data da viagem " +this.getDataDeInicioDeServico() + "\n");
        sb.append("Distancia percorrida: " +this.getDistancia() + "\n");
        sb.append("Tempo da Vigem estimado: " +this.getTempoEstimado() + "\n");
        sb.append("Tempo da Vigem real: " +this.getTempoReal() + "\n");
        sb.append("Valor Cobrado: " +this.getValorCobrado() + "\n");
        sb.append("Valor Estimado: " +this.getValorEstimado() + "\n");
        sb.append("Estado do tempo: " +this.getEstadoTempo() + "\n");
        sb.append("Estado do transito: " +this.getEstadoTransito() + "\n");
        sb.append("Classificacao: " +this.getClassificacao() + "\n");
        sb.append("Origem: " + this.getOrigem() + "\n");
        sb.append("Destino: " + this.getDestino() + "\n");
        return sb.toString(); 
    }
    
}

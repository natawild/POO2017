import java.time.LocalDateTime; 
import java.io.Serializable;
/**
 * Escreva a descrição da classe Historico aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Historico implements HistoricoInterface, Serializable, Comparable<Historico>{
    private String emailCliente; 
    private String emailMotorista; 
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
    
    public Historico(){
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
        this.emailCliente = null;
        this.emailMotorista = null;
    }
    
    
    public Historico (String emailCliente, String emailMotorista){
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
        this.emailCliente = emailCliente;
        this.emailMotorista = emailMotorista;
    }
    
    public Historico(String emailCliente, String emailMotorista, LocalDateTime dataDeInicioDeServico, double distancia, double tempoEstimado, double tempoReal,double valorEstimado, double valorCobrado, 
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
        this.emailCliente = emailCliente;
        this.emailMotorista = emailMotorista;
    }
    
    
     public Historico(Historico h){
       this.dataDeInicioDeServico= h.getDataDeInicioDeServico(); 
       this.distancia = h.getDistancia();
       this.tempoEstimado= h.getTempoEstimado();
       this.tempoReal = h.getTempoReal();
       this.valorEstimado=h.getValorEstimado(); 
       this.valorCobrado= h.getValorCobrado();
       this.estadoTempo= h.getEstadoTempo();
       this.estadoTransito=h.getEstadoTransito(); 
       this.terminado=h.getTerminado(); 
       this.origem = h.getOrigem();
       this.destino = h.getDestino();
       this.classificacao = h.getClassificacao();
       this.emailCliente = h.getEmailCliente();
       this.emailMotorista = h.getEmailMotorista();
    }
    
    public String getEmailCliente(){
        return this.emailCliente;
    }
    
    public String getEmailMotorista(){
        return this.emailMotorista;
    }
    
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
    
    
    public void setEmailCliente(String cliente){
        this.emailCliente = cliente;
    }
    
    public void setEmailMotorista(String motorista){
        this.emailMotorista = motorista;
    }
    
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
     * Métdo equals 
     */
    public boolean equals (Object hist){
        if(this == hist) 
            return true; 
            
        if((hist == null) || (this.getClass()!= hist.getClass()))
        return false; 
        
        Historico h = (Historico) hist; 
        return  this.emailCliente.equals(h.getEmailCliente()) && this.emailMotorista.equals(h.getEmailMotorista()) && this.dataDeInicioDeServico.equals(h.getDataDeInicioDeServico()) && this.distancia==h.getDistancia() && this.tempoEstimado==h.getTempoEstimado() &&
       this.valorCobrado==h.getValorCobrado() &&this.valorEstimado==h.getValorEstimado() && this.tempoReal == h.getTempoReal() && 
       this.estadoTempo.equals(h.getEstadoTempo()) && this.estadoTransito.equals(h.getEstadoTransito()) && this.terminado==h.getTerminado() && this.destino.equals(h.getDestino()) 
       && this.origem.equals(h.getOrigem()) && this.classificacao == h.getClassificacao(); 
    }
    
    
    /**
     * método toString 
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
        sb.append("Viagem terminada: " + this.terminado + "\n");
        sb.append("Cliente email: " + this.emailCliente);
        sb.append("Motorista email: " + this.emailMotorista);
        return sb.toString();  
    }
    
    
    public int calculaGrauDeCumprimento(){
        int grauDeCumprimento = 0;
        if(this.tempoReal < this.tempoEstimado){
            grauDeCumprimento = 100;
        }
        else {
            grauDeCumprimento = (int) ((this.tempoEstimado / this.tempoReal)*100);
        }
        return grauDeCumprimento;
    }
    //clone
    public Historico clone (){
        return new Historico(this);    
    }
    
    
    public int compareTo(Historico h){
        if(this.getDataDeInicioDeServico().isBefore(h.getDataDeInicioDeServico())){
            return 1;
        }
        else if (this.getDataDeInicioDeServico().isAfter(h.getDataDeInicioDeServico())){
            return -1;
        }
        return 0;
    }
    /**
     * 
     */
   public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.emailCliente.hashCode();
        hash = 53 * hash + this.emailMotorista.hashCode();
        hash = 53 * hash + this.dataDeInicioDeServico.hashCode();
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.distancia) ^ (Double.doubleToLongBits(this.distancia) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.tempoEstimado) ^ (Double.doubleToLongBits(this.tempoEstimado) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.tempoReal) ^ (Double.doubleToLongBits(this.tempoReal) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.valorEstimado) ^ (Double.doubleToLongBits(this.valorEstimado) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.valorCobrado) ^ (Double.doubleToLongBits(this.valorCobrado) >>> 32));
        hash = 53 * hash + this.estadoTempo.hashCode();
        hash = 53 * hash + this.estadoTransito.hashCode();
        hash = 53 * hash + (this.terminado ? 1 : 0);
        hash = 53 * hash + this.origem.hashCode();
        hash = 53 * hash + this.destino.hashCode();
        hash = 53 * hash + this.classificacao;
        return hash;
    }
    
    
    public String apresentaHistoricoMotoristaMenu(){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Cliente email: " + this.emailCliente);
        sb.append("Histórico: " + super.toString());
        return sb.toString();  
    }
    
    public String imprimeHistoricoAdminLinha (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Cliente email:  " + this.emailCliente+" | ");
        sb.append("Motorista email:  " + this.emailMotorista);
        sb.append(imprimeHistoricoLinha());
        return sb.toString(); 
    }
    
    public String imprimeHistoricoMotoristaLinha (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Cliente email:  " + this.emailCliente);
        sb.append(imprimeHistoricoLinha());
        return sb.toString(); 
    }
    
    public String imprimeHistoricoClienteLinha (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Motorista:  " + this.emailMotorista);
        sb.append(imprimeHistoricoLinha());
        return sb.toString(); 
    }
   
    private String imprimeHistoricoLinha (){
        StringBuilder sb = new StringBuilder(); 
        sb.append(" | Data da viagem:  " +this.dataDeInicioDeServico);
        sb.append(" | Distancia: " +this.distancia);
        sb.append(" | Tempo da Viagem estimado: " +this.tempoEstimado);
        sb.append(" | Tempo da Viagem real: " +this.tempoReal);
        sb.append(" | Valor Cobrado: " + this.valorCobrado);
        sb.append(" | Valor Estimado: " + this.valorEstimado);
        sb.append(" | Estado do tempo: " + this.estadoTempo);
        sb.append(" | Estado do transito: " + this.estadoTransito);
        sb.append(" | Classificacao: " + this.classificacao);
        sb.append(" | Origem: " + this.origem);
        sb.append(" | Destino: " + this.destino);
        return sb.toString(); 
    }
    
}

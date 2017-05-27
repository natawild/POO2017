import java.time.LocalDateTime; 
import java.io.Serializable;
/**
 * A classe HistoricoMotorista 
 * 
 * @celia 
 * @version 1.0
 */
public class HistoricoMotorista extends HistoricoAtor implements HistoricoInterface,Serializable{
    // variáveis de instância  
    
    private Cliente cliente; 
    /**
     * Construtor vazio
     */
    public HistoricoMotorista (){
        super(); 
        this.cliente = null; 
    }
    
    /**
     * Construtor parametrizado 
     * @param dataDeInicioDeServico 
     * @param tempo
     * @param valorCobrado
     * @param cliente
     */
    
    public HistoricoMotorista (LocalDateTime dataDeInicioDeServico, float tempoEstimado, float tempoReal, float valorEstimado,
    float valorCobrado, Cliente cliente, String estadoTempo, String estadoTransito, boolean terminada){

        super(dataDeInicioDeServico,tempoEstimado, tempoReal,valorEstimado, valorCobrado, estadoTempo, estadoTransito, terminada); 
        this.cliente= cliente; 
    }
    
      
    /**
     * Construtor de cópia 
     * @param c (HistoricoCliente)
     */
    
    public HistoricoMotorista (HistoricoMotorista c){
        super(c);
        this.cliente = c.getCliente(); 
    }
    
    
    /**
     * getMotorista
     */
    
    public Cliente getCliente(){
        return this.cliente.clone(); 
    }
    
    
    /**
     * setMotorista
     */
    
    public void setCliente (Cliente cliente){
        this.cliente = cliente.clone(); 
    }
    
  
    /**
     * Métdo equals 
     */
    public boolean equals (Object cli){
        if(this == cli) 
            return true; 
            
        if((cli == null) || (this.getClass()!= cli.getClass()))
        return false; 
        
        HistoricoMotorista historicoMotorista = (HistoricoMotorista) cli; 
        return super.equals(historicoMotorista) && this.cliente.equals(historicoMotorista.getCliente()); 
    }
    
    /**
     * método toString 
     */
    
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Histórico Motorista: " + super.toString());
        sb.append("Cliente: " + this.getCliente() +"\n"); 
        return sb.toString();  
    }
    
    //clone
    public HistoricoMotorista clone (){
        return new HistoricoMotorista(this);    
    }
    
    
    
}

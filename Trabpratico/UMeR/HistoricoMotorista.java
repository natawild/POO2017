import java.time.LocalDateTime; 
/**
 * A classe HistoricoMotorista 
 * 
 * @celia 
 * @version 1.0
 */
public class HistoricoMotorista extends HistoricoAtor implements HistoricoInterface{
    // variáveis de instância  
    
    
    /**
     * Construtor vazio
     */
    public HistoricoMotorista (){
        super(); 
    }
    
    /**
     * Construtor parametrizado 
     * @param dataDeInicioDeServico 
     * @param tempo
     * @param valorCobrado
     */
    
    public HistoricoMotorista (LocalDateTime dataDeInicioDeServico, float tempoEstimado, float tempoReal, float valorCobrado){
        super(dataDeInicioDeServico,tempoEstimado, tempoReal, valorCobrado); 
    }
    
      
    /**
     * Construtor de cópia 
     * @param c (HistoricoCliente)
     */
    
    public HistoricoMotorista (HistoricoMotorista c){
        super(c);
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
        return super.equals(historicoMotorista); 
    }
    
    /**
     * método toString 
     */
    
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Histórico Motorista: " + super.toString());
        return sb.toString();  
    }
    
    //clone
    public HistoricoMotorista clone (){
        return new HistoricoMotorista(this);    
    }
    
    
    
}

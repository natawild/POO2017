import java.time.LocalDateTime;
/**
 * A classe HistoricoCliente 
 * 
 * @celia
 * @marcia
 * @carlos
 * @version 1.0
 */
public class HistoricoCliente extends HistoricoAtor {
    // variáveis de instância 
    /**
     * Construtor vazio
     */
    public HistoricoCliente (){
        super(); 
    }
    
    /**
     * Construtor parametrizado 
     * @param dataDeInicioDeServico 
     * @param tempo
     * @param valorCobrado
     */
    
    public HistoricoCliente (LocalDateTime dataDeInicioDeServico, float tempo, float valorCobrado){
        super(dataDeInicioDeServico,tempo, valorCobrado); 
    }
    
      
    /**
     * Construtor de cópia 
     * @param c (HistoricoCliente)
     */
    
    public HistoricoCliente (HistoricoCliente c){
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
        
        HistoricoCliente historicoCliente = (HistoricoCliente) cli; 
        return super.equals(historicoCliente); 
    }
    
    /**
     * método toString 
     */
    
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Histórico Cliente: " + super.toString());
        return sb.toString();  
    }
    
    //clone
    public HistoricoCliente clone (){
        return new HistoricoCliente(this);    
    }
    
    
    
    
}


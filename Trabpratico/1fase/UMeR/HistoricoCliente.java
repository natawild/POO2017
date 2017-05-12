import java.time.LocalDateTime;
/**
 * A classe HistoricoCliente 
 * 
 * @celia
 * @marcia
 * @carlos
 * @version 1.0
 */
public class HistoricoCliente extends HistoricoAtor implements HistoricoInterface{
    // variáveis de instância 
    private Motorista motorista; 
    /**
     * Construtor vazio
     */
    public HistoricoCliente (){
        super(); 
        this.motorista=null; 
    }
    
    /**
     * Construtor parametrizado 
     * @param dataDeInicioDeServico 
     * @param tempo
     * @param valorCobrado
     * @param motorista
     */
    
    public HistoricoCliente (LocalDateTime dataDeInicioDeServico, float tempoEstimado, float tempoReal, float valorCobrado, Motorista motorista){
        super(dataDeInicioDeServico,tempoEstimado, tempoReal, valorCobrado);
        this.motorista=motorista; 
    }
    
      
    /**
     * Construtor de cópia 
     * @param c (HistoricoCliente)
     */
    
    public HistoricoCliente (HistoricoCliente c){
        super(c);
        this.motorista= c.getMotorista(); 
    }
    
    /**
     * getMotorista
     */
    
    public Motorista getMotorista(){
        return this.motorista.clone(); 
    }
    
    
    /**
     * setMotorista
     */
    
    public void setMotorista(Motorista motorista){
        this.motorista = motorista.clone(); 
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
        return super.equals(historicoCliente) && this.motorista.equals(historicoCliente.getMotorista()); 
    }
    
    /**
     * método toString 
     */
    
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Histórico Cliente: " + super.toString());
        sb.append("Motorista: " +this.getMotorista() +"\n"); 
        return sb.toString();  
    }
    
    //clone
    public HistoricoCliente clone (){
        return new HistoricoCliente(this);    
    }
    

}


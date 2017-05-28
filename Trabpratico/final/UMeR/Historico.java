import java.io.Serializable;
/**
 * Escreva a descrição da classe Historico aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Historico extends HistoricoAtor implements HistoricoInterface, Serializable, Comparable<Historico>{
    private AtorInterface cliente; 
    private AtorInterface motorista; 
    
    public Historico(){
        super();
        this.cliente = null;
        this.motorista = null;
    }
    
    public Historico(AtorInterface cliente, AtorInterface motorista){
        super();
        this.cliente = cliente;
        this.motorista = motorista;
    }
    
    
     public Historico(Historico h){
        super(h);
        this.cliente = h.getCliente();
        this.motorista = h.getMotorista();
    }
    
    public AtorInterface getCliente(){
        return this.cliente.clone();
    }
    
    public AtorInterface getMotorista(){
        return this.motorista.clone();
    }
    
    public void setCliente(AtorInterface cliente){
        this.cliente = cliente.clone();
    }
    
    public void setMotorista(AtorInterface motorista){
        this.motorista = motorista.clone();
    }
    
    /**
     * Métdo equals 
     */
    public boolean equals (Object hist){
        if(this == hist) 
            return true; 
            
        if((hist == null) || (this.getClass()!= hist.getClass()))
        return false; 
        
        Historico historico = (Historico) hist; 
        return  equalsCliente(historico.getCliente()) && equalsMotorista(historico.getMotorista()) && super.equals(historico); 
    }
    
    private boolean equalsCliente (AtorInterface cliente){
        return this.cliente.equals(cliente);
    }
    
    private boolean equalsMotorista (AtorInterface motorista){
        return this.motorista.equals(motorista);
    }
    
    /**
     * método toString 
     */
    
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Histórico: " + super.toString());
        sb.append("Cliente: " + this.cliente);
        sb.append("Motorista: " + this.motorista);
        return sb.toString();  
    }
    
    //clone
    public Historico clone (){
        return new Historico(this);    
    }
    
    
    public int compareTo(Historico h){
        if(this.getDataDeInicioDeServico().isBefore(h.getDataDeInicioDeServico())){
            return -1;
        }
        else if (this.getDataDeInicioDeServico().isAfter(h.getDataDeInicioDeServico())){
            return 1;
        }
        return 0;
  
    }
   
}

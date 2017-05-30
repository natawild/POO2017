import java.io.Serializable;
/**
 * Escreva a descrição da classe Historico aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Historico extends HistoricoAtor implements HistoricoInterface, Serializable, Comparable<Historico>{
    private String emailCliente; 
    private String emailMotorista; 
    
    public Historico(){
        super();
        this.emailCliente = null;
        this.emailMotorista = null;
    }
    
    public Historico(String emailCliente, String emailMotorista){
        super();
        this.emailCliente = emailCliente;
        this.emailMotorista = emailMotorista;
    }
    
    
     public Historico(Historico h){
        super(h);
        this.emailCliente = h.getEmailCliente();
        this.emailMotorista = h.getEmailMotorista();
    }
    
    public String getEmailCliente(){
        return this.emailCliente;
    }
    
    public String getEmailMotorista(){
        return this.emailMotorista;
    }
    
    public void setCliente(String cliente){
        this.emailCliente = cliente;
    }
    
    public void setMotorista(String motorista){
        this.emailMotorista = motorista;
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
        return  this.emailCliente.equals(historico.getEmailCliente()) && this.emailMotorista.equals(historico.getEmailMotorista()) && super.equals(historico); 
    }
    
    /**
     * método toString 
     */
    
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Histórico: " + super.toString());
        sb.append("Cliente email: " + this.emailCliente);
        sb.append("Motorista email: " + this.emailMotorista);
        return sb.toString();  
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
        hash = 53 * hash + super.hashCode();
        return hash;
    }
    
    
    public String apresentaHistoricoMotoristaMenu(){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Cliente email: " + this.emailCliente);
        sb.append("Histórico: " + super.toString());
        return sb.toString();  
    }
    
    public String imprimeHistoricoMotoristaLinha (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Cliente email:  " + this.emailCliente);
        sb.append(super.imprimeHistoricoLinha());
        return sb.toString(); 
    }
    
    public String imprimeHistoricoClienteLinha (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Motorista:  " + this.emailMotorista);
        sb.append(super.imprimeHistoricoLinha());
        return sb.toString(); 
    }
   
}

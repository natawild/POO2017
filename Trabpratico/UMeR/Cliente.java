import java.time.LocalDate; 
/**
 * A classe Cliente terá todas as informações do utilizador da UMeR, tais como todas as presentes na classe 
 * Ator, a localização. 
 * 
 * @celia
 * @version 1.0
 */
public class Cliente extends Ator implements AtorInterface{
    private Coordenadas loc;
    private HistoricoCliente histClie; 
    /**
     * Construtor vazio
     */
    
    public Cliente (){
        super(); 
        this.loc= new Coordenadas(); // localização do cliente
    }
    
    /**
     * Construtor parametrizado 
     * @param email
     * @param nome
     * @param password
     * @param morada
     * @param dataNascimento
     * @param loc
     * 
     */
    
    public Cliente (String email,String nome, String password, String morada, LocalDate dataNascimento, 
    Coordenadas loc){
       super(email, nome, password, morada, dataNascimento); 
       this.loc = loc; 
    }
    
    /**
     * Construtor de cópia 
     * @param c (Cliente)
     */
    
    public Cliente (Cliente c){
        super(c); 
        this.loc=c.getLoc(); 
        
    }
    
    //getters 
    public Coordenadas getLoc(){
        return this.loc.clone(); 
    
    }
    
    //setters
    
    public void setLoc(Coordenadas localizacao){
        loc=localizacao.clone();
    }
    
    /**
     * Métdo equals 
     */
    public boolean equals (Object cli){
        if(this == cli) 
            return true; 
            
        if((cli == null) || (this.getClass()!= cli.getClass()))
        return false; 
        
        Cliente c = (Cliente) cli; 
        return super.equals(c) && this.loc.equals(c.getLoc()); 
    }
    
    /**
     * método toString 
     */
    
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Cliente\n");
        sb.append("Clientes dados: " + super.toString());
        sb.append("Cliente localização: " + loc.toString());
        return sb.toString();  
    }
    
    
    //clone
    public Cliente clone (){
        return new Cliente(this);    
    }
    
}

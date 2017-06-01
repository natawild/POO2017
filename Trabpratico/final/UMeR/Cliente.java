import java.time.LocalDate; 
import java.io.Serializable;
/**
 * A classe Cliente terá todas as informações do utilizador da UMeR, tais como todas as presentes na classe 
 * Ator, a localização e um histórico 
 * 
 * @celia
 * @version 1.0
 */
public class Cliente extends Ator implements AtorInterface, Serializable{
    private Coordenadas loc;
    private boolean emViagem;
    /**
     * Construtor vazio
     */
    
    public Cliente (){
        super(); 
        this.loc= new Coordenadas(); // localização do cliente
        this.emViagem = false;
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
    Coordenadas loc, boolean emViagem){
       super(email, nome, password, morada, dataNascimento); 
       this.loc = loc; 
       this.emViagem = emViagem;
    }
    
    /**
     * Construtor de cópia 
     * @param c (Cliente)
     */
    
    public Cliente (Cliente c){
        super(c); 
        this.loc=c.getLoc(); 
        this.emViagem  =  c.getEmViagem();
    }
    
    //getters 
    public Coordenadas getLoc(){
        return this.loc.clone(); 
    
    }
    
    public boolean getEmViagem(){
         return this.emViagem;  
    }
    
    //setters
    
    public void setLoc(Coordenadas localizacao){
        loc=localizacao.clone();
    }
    
    
    public void setEmViagem(boolean emViagem){
        this.emViagem=emViagem;
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
        return super.equals(c) && this.loc.equals(c.getLoc()) && emViagem == c.getEmViagem(); 
    }
    
    /**
     * HashCode
     */
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.loc.hashCode();
        hash = 59 * hash + (this.emViagem ? 1 : 0);
        hash = 59 * hash + super.hashCode();
        return hash;
    }
    
    /**
     * método toString 
     */
    
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append(super.toString());
        sb.append("Localização: \n " + loc.toString());
        sb.append("\nEm viagem: " + this.emViagem);
        return sb.toString();  
    }
    
    //clone
    public Cliente clone (){
        return new Cliente(this);    
    }
    
    public String apresentaDadosPessoais(){ 
        return this.toString();
    }
    
}

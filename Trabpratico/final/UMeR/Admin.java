import java.time.LocalDate; 
import java.io.Serializable;
/**
 * A classe Admin 
 * 
 * @celia
 * @version 1.0
 */
public class Admin extends Ator implements AtorInterface, Serializable{
    
    public  Admin (){
        super(); 
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
    
    public Admin (String email,String nome, String password, String morada, LocalDate dataNascimento, 
    Coordenadas loc){
       super(email, nome, password, morada, dataNascimento); 
    
    }
    
    public Admin (Admin a){
        super(a); 
    }
    
    public boolean equals (Object adm){
        if(this == adm) 
            return true; 
            
        if((adm == null) || (this.getClass()!= adm.getClass()))
        return false; 
        
        Admin c = (Admin) adm; 
        return super.equals(c); 
    }
    
    
    /**
     * Método toString
     */
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append(super.toString());
        return sb.toString();  
    }
    
    
    //clone
    public Admin clone (){
        return new Admin(this);    
    }
    
    
}

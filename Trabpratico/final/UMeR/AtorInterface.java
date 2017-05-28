import java.time.LocalDate; 
/**
 * A AtorInterface tem a declaração de todos os métodos necessários para a criação de um Ator 
 * 
 * @celia
 * @version 1.0
 */

public interface AtorInterface{
    
    public String getEmail (); 
    
    public String getPassword(); 
    
    public String getNome (); 
    
    public String getMorada ();
    
    public LocalDate getDataNascimento (); 
    
    public void setEmail(String e); 
    
    public void setNome(String n) ;
    
    public void setPassword(String p) ;
   
    public void setMorada(String m) ;
      
    public void setDataNascimento( LocalDate d) ;
    
    public AtorInterface clone(); 
    
    public String apresentaDadosPessoais();
    
}

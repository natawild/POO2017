import java.time.LocalDate; 
/**
 * A AtorInterface 
 * 
 * @celia
 * @version (número da versão ou data)
 */

public interface AtorInterface{
    
    public String getEmail (); 
    
    public String getNome (); 
    
    public String getMorada ();
    
    public LocalDate getDataNascimento (); 
    
    
    public void setEmail(String e); 

    
    public void setNome(String n) ;
    
    public void setPassword(String p) ;
   
    public void setMorada(String m) ;
      
    public void setDataNascimento( LocalDate d) ;
    
    public AtorInterface clone(); 
    
   
}

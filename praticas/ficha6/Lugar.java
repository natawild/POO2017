
/**
 * Escreva a descrição da classe Lugar aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Lugar implements Comparable <Lugar>{
    
    /** Matricula do veiculo alocado */
    private String matricula ;
    
    /** Nome do proprietario */
    private String nome ;
    
    /** Tempo atribuido ao lugar , em minutos */
    private int minutos ;
    
    /** Indica se lugar é permanente , ou de aluguer*/
    private boolean permanente ;

    /**
     * Construtor vazio
     */
      public Lugar(){
          //this("n/d", "n/d", 0, false); 
          this.matricula = "n/d"; 
          this.nome = "n/d"; 
          this.minutos=0;
          this.permanente = false; 
        }


   public Lugar(String matricula,String nome,int minutos,boolean permanente){
    this.matricula = matricula;
    this.nome = nome; 
    this.minutos = minutos; 
    this.permanente = permanente; 
   }
   
   public String getMatricula(){
       return matricula; 
    }
    
    public String getNome(){
        return nome; 
    }
    
     public int getMinutos(){
        return this.minutos; 
    }
    
     public boolean getPermanente(){
        return permanente; 
    }
    
    
      public void setMinutos(int m){
  
        m=minutos; 
    }
    
    
    /**
     * construtor de copia
     */
    
    public Lugar (Lugar l){
        this(l.getMatricula(), l.getNome(), l.getMinutos(), l.getPermanente()); 
    }
    
    public Lugar clone(){
        
        return new Lugar(this); 
    
    }
    
    public int compareTo(Lugar l){
    if (this.minutos > l.getMinutos())
        return -1; 
    else if(this.minutos < l.getMinutos())
        return 1; 
    else return 0; 
    }
    
    public String toString(){
    return ("lugar(" +matricula+ "," ); 
    }
    
    
     public boolean equals(Object o){
        if(o== this) return true; 
        if((o== null) || (o.getClass()!=this.getClass()))
        return false; 
        Lugar l = (Lugar) o; 
        return this.nome.equals(l.getNome()) && 
        this.matricula.equals(l.getMatricula()) &&
        this.minutos == l.getMinutos() &&
        this.permanente == l.getPermanente();
    }
    
  
  
    
   
}

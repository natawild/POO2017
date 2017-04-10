
/**
 * Escreva a descrição da classe Veiculo aqui.
 * 
 * @celia
 * @version 1.0
 */
public class Veiculo{
    
    private String matricula; 
    
    /**
     * construtor vazio
     */
    
    public Veiculo(){
        this.matricula=""; 
    }
    
    public Veiculo (String matricula){
        this.matricula=matricula; 
    }
   
    public Veiculo (Veiculo v){
        this.matricula=v.getMatricula(); 
    
    }
    
    //getters
    
    public String getMatricula (){
        return this.matricula; 
    
    }
    
    //setters
    
    public void setMatricula (String matr){
        this.matricula=matr;   
    }
    
    public Veiculo clone(){ // de-me um novo objeto igual a mim 
    return new Veiculo(this); 
    }
    
    
    public boolean equals(Object o){
        
        if(o==this) return true; //se o objeto for igual ao meu objeto retorna verdade
        
        if((o==null) || (this.getClass()!=o.getClass()))
        return false;
        
        Veiculo v = (Veiculo) o; 
        return this.matricula.equals(v.getMatricula());
    
    }

    
}

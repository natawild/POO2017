import java.util.Comparator; 
import java.io.Serializable;
/**
 * Classe abstrata Veiculo 
 * 
 * @celia
 * @version 1.0
 */
public abstract class Veiculo implements Serializable{
    
    /*implements Comparator<Motorista>*/
    
    private String matricula; 
    private String marca; //Adicionei a variável de instância marca, para um cliente poder escolher um carro com base na marca do veiculo
     
     
    private float fiabilidade;//0 a 2 randon()
    private Coordenadas loc;
    
    /**
     * construtor vazio
     */
    
    public Veiculo(){
        this.matricula=""; 
        this.marca=""; 
        this.fiabilidade=0f;
        this.loc=new Coordenadas();
    }
    
    /**
     * construtor com argumentos
     * @param matricula
     * @param marca

     * @param fiabilidade
     */
    
    public Veiculo (String matricula,String marca, float fiabilidade, Coordenadas coord){
        this.matricula=matricula;
        this.marca=marca; 
        
        this.fiabilidade=fiabilidade;
        this.loc=coord;
    }
   
    /**
     * contrutor por cópia
     */
    public Veiculo (Veiculo v){
        this.matricula=v.getMatricula();
        this.marca=v.getMarca(); 
       
        this.fiabilidade=v.getFiabilidade();
        this.loc=v.getLoc();
    
    }
    
    //getters
    /**
     * @return matricula do veiculo
     */
    
    public String getMatricula (){
        return this.matricula; 
    
    }
    
    /**
     * @return marca do veiculo
     */
    
    public String getMarca (){
        return this.marca; 
    
    }
    
    
    
    /**
     * @return fiabilidade do veiculo (determina a capacidade da viatura cumprir o tempo acordado
     * com o cliente)
     */
    
    public float getFiabilidade(){
        return this.fiabilidade;
    
    }
    
    public Coordenadas getLoc(){
        return loc.clone();
    }
    
    //setters
    
    public void setMatricula (String matr){
        this.matricula=matr;   
    }
    
     public void setMarca (String marc){
        this.marca=marc;   
    }
    
    public void setLoc(Coordenadas coord){
        this.loc=coord.clone(); 
    }
    
   

    /**
     * equals recebe um objet veic e verifica se é igual a um Veiculo 
     */
    
    public boolean equals(Object veic){
        
        if(veic==this) return true; //se o objeto for igual ao meu objeto retorna verdade
        
        if((veic==null) || (this.getClass()!=veic.getClass()))
        return false;
        
        Veiculo v = (Veiculo) veic; 
        return this.matricula.equals(v.getMatricula()) && this.marca.equals(v.getMarca()) 
          && this.loc.equals(v.getLoc()); 
    
    }
    
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Matricula: " +this.getMatricula() + "\n"); 
        sb.append("Marca: " +this.getMarca() + "\n"); 
       
        sb.append("Fiabilidade do veiculo: " +this.getFiabilidade() +"\n");
        sb.append("Localização do veiculo: " +this.getLoc().toString() +"\n"); 
        return sb.toString(); 
    }

    /*
     * metodo que permite ordenar collections de veiculos
     */
    
    /*compare*/
    /*
    
    public int compareTo(Veiculo c){
        if(this.preco < c.getPreco()) return -1;
        if(this.preco == c.getPreco()) return 0;
        else return 1;
    }
    */

    
}



/**
 * classe CarroFilaEspera 
 * 
 * @celia
 * @version (número de versão ou data)
 */
public class CarroFilaEspera extends CarroLig implements FilaEsperaInterface{
    
    private boolean filaEspera; 
    
    /**
     * Construtor vazio 
     */
    
    public CarroFilaEspera (){
        super(); 
        this.filaEspera= false; 
    }
    
    /**
     * Construtor parametrizado 
     * @param matricula
     * @param marca
     * @param vm
     * @param preco
     * @param fiabilidade
     * @param coord
     * @param filaEspera
     * 
     */
    
    public CarroFilaEspera(String matricula,String marca, double vm, double preco, int fiabilidade, 
    Coordenadas coord, boolean filaEspera){
        super(matricula,marca,vm,preco,fiabilidade, coord);
        this.filaEspera= filaEspera; 
    }
    
    
    /**
     * Construtor de cópia 
     * @param mfe
     */
    
    public CarroFilaEspera (CarroFilaEspera mfe){
        super(mfe); 
        this.filaEspera= mfe.getFilaEspera();   
    }
    
    /**
     * get 
     */
    
    public boolean getFilaEspera(){
        return this.filaEspera; 
    }
    
    /**
     * set
     */
    
    public void setFilaEspera (boolean filaEspera){
        this.filaEspera=filaEspera; 
    
    }
    
     public boolean equals (Object carroFilaEsp){
        if(this == carroFilaEsp) 
            return true; 
            
        if((carroFilaEsp == null) || (this.getClass()!= carroFilaEsp.getClass()))
        return false; 
        
        CarroFilaEspera c = (CarroFilaEspera) carroFilaEsp; 
        return super.equals(c) && this.filaEspera == c.getFilaEspera(); 
    }
    
    /**
     * método toString 
     */
    
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Carro com fila de espera\n");
        sb.append("Carro dados: " + super.toString());
        sb.append("Fila de espera?: " + this.getFilaEspera());
        return sb.toString();  
    }
    
    
    //clone
    public CarroFilaEspera clone (){
        return new CarroFilaEspera(this);    
    }
}

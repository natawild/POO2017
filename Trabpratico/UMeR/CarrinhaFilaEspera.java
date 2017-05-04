
/**
 * A classe CarrinhaFilaEspera 
 * 
 * @celia
 * @version (número de versão ou data)
 */
public class CarrinhaFilaEspera extends CarroLig implements FilaEsperaInterface {
    
    private boolean filaEspera; 
    
    /**
     * Construtor vazio 
     */
    
    public CarrinhaFilaEspera (){
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
    
    public CarrinhaFilaEspera(String matricula,String marca, double vm, double preco, int fiabilidade, 
    Coordenadas coord, boolean filaEspera){
        super(matricula,marca,vm,preco,fiabilidade, coord);
        this.filaEspera= filaEspera; 
    }
    
    
    /**
     * Construtor de cópia 
     * @param mfe
     */
    
    public CarrinhaFilaEspera (CarrinhaFilaEspera mfe){
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
    
     public boolean equals (Object carrinhaFilaEsp){
        if(this == carrinhaFilaEsp) 
            return true; 
            
        if((carrinhaFilaEsp == null) || (this.getClass()!= carrinhaFilaEsp.getClass()))
        return false; 
        
        CarrinhaFilaEspera c = (CarrinhaFilaEspera) carrinhaFilaEsp; 
        return super.equals(c) && this.filaEspera == c.getFilaEspera(); 
    }
    
    /**
     * método toString 
     */
    
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Carrinha com fila de espera\n");
        sb.append("Carrinha dados: " + super.toString());
        sb.append("Fila de espera?: " + this.getFilaEspera());
        return sb.toString();  
    }
    
    
    //clone
    public CarrinhaFilaEspera clone (){
        return new CarrinhaFilaEspera(this);    
    }
}

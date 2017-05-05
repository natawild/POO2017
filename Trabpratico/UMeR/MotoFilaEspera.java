
/**
 * A classe MotoFilaEspera 
 * 
 * @celia
 * @version 1.0
 */
public class MotoFilaEspera extends Moto implements FilaEsperaInterface{
    private List<CLiente> filaClientes;
    //TODO: implements gets e sets. IMplementar metodo da interface.
    // FAzer o mesmo para Carro/CarrLig con filas
    
    /**
     * Construtor vazio 
     */
    
    public MotoFilaEspera (){
        super(); 
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
    
    public MotoFilaEspera(String matricula,String marca, double vm, double preco, int fiabilidade, 
    Coordenadas coord, boolean filaEspera){
        super(matricula,marca,vm,preco,fiabilidade, coord);
        this.filaEspera= filaEspera; 
    }
    
    
    /**
     * Construtor de cópia 
     * @param mfe
     */
    
    public MotoFilaEspera (MotoFilaEspera mfe){
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
    
     public boolean equals (Object motoFilaEsp){
        if(this == motoFilaEsp) 
            return true; 
            
        if((motoFilaEsp == null) || (this.getClass()!= motoFilaEsp.getClass()))
        return false; 
        
        MotoFilaEspera c = (MotoFilaEspera) motoFilaEsp; 
        return super.equals(c) && this.filaEspera == c.getFilaEspera(); 
    }
    
    /**
     * método toString 
     */
    
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Moto com fila de espera\n");
        sb.append("Moto dados: " + super.toString());
        sb.append("Fila de espera?: " + this.getFilaEspera());
        return sb.toString();  
    }
    
    
    //clone
    public MotoFilaEspera clone (){
        return new MotoFilaEspera(this);    
    }
    
    
    
    
}

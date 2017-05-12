
/**
 * Moto será uma sublclasse de Veiculo 
 * 
 * @celia
 * @version 1.0
 */
public class Moto extends Veiculo implements VeiculoInterface{
    //variável da classe
    private static final int lugaresLivres = 1;
    
     /**
     * Construtor vazio. Como se trata de uma subclasse de Veiculo, utilizamos o construtor super 
     * para a reaproveitação de código e para utilizarmos herança.
     */
    public Moto(){
        super();
    }
    
     /**
     * Construtor parametrizado, ou seja, recebe a matricula, as coordenadas, a velocidade média, o preco base por km
     * e o fator de fiabilidade
     * @param matricula
     * @param marca
     * @param vm
     * @param preco
     * @param fiabilidade De 1-5, descreve a fiabilidade do Veiculo
     * @param coord
     */
    
    public Moto(String matricula,String marca, double vm, double preco, int fiabilidade, Coordenadas coord){
        super(matricula,marca, vm,preco,fiabilidade, coord);
    }
    
    /**
     * Construtor de cópia 
     * @param m Moto
     */
    public Moto (Moto m){
        super(m); 
    }
    
    public int getLugaresLivres (){
        return this.lugaresLivres; 
    }
    
    
    
    /**
     * equals recebe um Object m e verifica se é igual a uma Moto
     */
        public boolean equals(Object m){
        
        if(m==this) return true; //se o objeto for igual ao meu objeto retorna verdade
        
        if((m==null) || (this.getClass()!=m.getClass()))
        return false;
        
        Moto moto = (Moto) m; 
        return super.equals(moto) && this.lugaresLivres== moto.getLugaresLivres();  
    
    }
    
    /**
     * método toString
     * 
     */
    public String toString (){
        StringBuilder sb = new StringBuilder("Motociclo: \n"); 
        sb.append("Dados do Veiculo: " + super.toString());
        sb.append("Lugares disponiveis: " +this.getLugaresLivres() + "\n");  
        return sb.toString(); 
    }
    
 
    /**
     * método clone
     */
    
    public Moto clone(){
        return new Moto (this); 
    
    } 
     
}

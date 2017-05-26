import java.io.Serializable;
import java.util.Random;
/**
 * Moto será uma sublclasse de Veiculo 
 * 
 * @celia
 * @version 1.0
 */
public class Moto extends Veiculo implements VeiculoInterface,Serializable{
    //variável da classe
    private static final int lugaresLivres = 1;
    private static final double vm = 40.5; 
    private static final double precoPorKm = 3.1;
    
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
     * @param fiabilidade, descreve a fiabilidade do Veiculo cumprir horário estimado com o cliente
     * @param coord
     */
    
    public Moto(String matricula,String marca, float fiabilidade, Coordenadas coord){
        super(matricula, marca, fiabilidade, coord);
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
    
    public double getVm(){
        return this.vm; 
    }
    
    public double getPrecoPorKm(){
        return this.precoPorKm; 
    }
    
    /**
     * Determina a capacidade de a viatura cumprir o tempo acordado com o cliente 
     * varia de 0.9 a 1.2, pois se fizer 1 cumpre o tempo mais do que isso não cumpre e menos é mais rápido 
     */
    public float getFiabilidade(){
        float minX = 0.9f;
        float maxX = 1.2f;
        Random rand = new Random();
        float finalX = rand.nextFloat() * (maxX - minX) + minX;

        return finalX;  
    }
    
    
    
    /**
     * equals recebe um Object m e verifica se é igual a uma Moto
     */
        public boolean equals(Object m){
        
        if(m==this) return true; //se o objeto for igual ao meu objeto retorna verdade
        
        if((m==null) || (this.getClass()!=m.getClass()))
        return false;
        
        Moto moto = (Moto) m; 
        return super.equals(moto) && this.lugaresLivres== moto.getLugaresLivres() && this.vm==moto.getVm()
        && this.precoPorKm==moto.getPrecoPorKm();  
    
    }
    
    /**
     * método toString
     * 
     */
    public String toString (){
        StringBuilder sb = new StringBuilder("Motociclo: \n"); 
        sb.append(super.toString());
        sb.append("Lugares disponiveis: " +this.getLugaresLivres() + "\n");  
        sb.append("Velocidade Média: " +this.getVm() + "\n");
        sb.append("Preço por Km: " +this.getPrecoPorKm() + "\n"); 
        return sb.toString(); 
    }
    
 
    /**
     * método clone
     */
    
    public Moto clone(){
        return new Moto (this); 
    
    } 
     
}

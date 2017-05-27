import java.io.Serializable;
import java.util.Random;
/**
 * A classe Carrinha é uma especialização da classe Veiculo 
 * 
 * @celia
 * @version (número de versão ou data)
 */
public class Carrinha extends Veiculo implements VeiculoInterface,Serializable{
    //variável da classe
    private static int lugaresLivres = 8;
    private static final double vm = 55;
    private static final double precoPorKm = 5.1;
     /**
     * Construtor vazio. Como se trata de uma subclasse de Veiculo, utilizamos o construtor super 
     * para a reaproveitação de código e para utilizarmos herança.
     */
    public Carrinha(){
        super();
    }
    
     /**
     * Construtor parametrizado, ou seja, recebe a matricula, as coordenadas, a velocidade média, o preco base por km
     * e o fator de fiabilidade
     * @param matricula
     * @param vm
     * @param preco
     * @param fiabilidade De 1-5, descreve a fiabilidade do Veiculo
     * @param coord
     */
    public Carrinha(String matricula,String marca, float fiabilidade, Coordenadas coord){
        super(matricula,marca,fiabilidade, coord);
    }
    
      /**
     * construtor de cópia 
     */
    public Carrinha(Carrinha c){
        super(c.getMatricula(), c.getMarca(), c.getFiabilidade(), c.getLoc()); 
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
     * varia de 0.9 a 1.8, pois se fizer 1 cumpre o tempo mais do que isso não cumpre e menos é mais rápido 
     * 
     * @return finalX valor da fiabilidade do veiculo 
     */
    public static float calcFiabilidade(){
        float minX = 0.9f;
        float maxX = 1.8f;
        Random rand = new Random();
        float finalX = rand.nextFloat() * (maxX - minX) + minX;

        return finalX;  
    }
    
    
     /**
     * equals recebe um Object o e verifica se é igual a um Carrinha
     */
        public boolean equals(Object o){
        
        if(o==this) return true; //se o objeto for igual ao meu objeto retorna verdade
        
        if((o==null) || (this.getClass()!=o.getClass()))
        return false;
        
        Carrinha carrinha = (Carrinha) o; 
        return super.equals(carrinha) && this.lugaresLivres== carrinha.getLugaresLivres();  
    
    }
    
    /**
     * método toString
     * 
     */
    public String toString (){
        StringBuilder sb = new StringBuilder("Carrinha: \n"); 
        sb.append(super.toString());
        sb.append("Lugares disponiveis: " +this.getLugaresLivres() + "\n"); 
        sb.append("Velocidade Média: " +this.getVm() + "\n"); 
        sb.append("Preço por Km: " +this.getPrecoPorKm() + "\n"); 
        return sb.toString(); 
    }
    
    
    //clone
    public Carrinha clone(){
        return new Carrinha (this); 
    
    } 
 
}

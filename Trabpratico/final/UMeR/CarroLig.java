import java.io.Serializable;
import java.util.Random;
/**
 * A classe CarroLig será uma especialização da classe Veiculo, aqui serão tratrados os veiculos designados 
 * por Carro Ligeiro. Um carro ligeiro possui 5 lugares, porém apenas pode levar 4 clientes no máximo
 * 
 * @celia
 * @version 1.0
 */

public class CarroLig extends Veiculo implements VeiculoInterface,Serializable{
    //variável da classe
    private static final int lugaresLivres = 4;
    private static final double vm = 65; 
    private static final double precoPorKm = 4.1;
    
     /**
     * Construtor vazio. Como se trata de uma subclasse de Veiculo, utilizamos o construtor super 
     * para a reaproveitação de código e para utilizarmos herança.
     */
    public CarroLig(){
        super();
    }
    
     /**
     * Construtor parametrizado, ou seja, recebe a matricula, as coordenadas, a velocidade média, o preco base por km
     * e o fator de fiabilidade
     * @param matricula
     * @param preco
     * @param fiabilidade De 1-5, descreve a fiabilidade do Veiculo
     * @param coord
     */
    
    public CarroLig(String matricula,String marca, float fiabilidade, Coordenadas coord){
        super(matricula,marca,fiabilidade, coord);
    }
    
    /**
     * construtor de cópia 
     */
    public CarroLig(CarroLig c){
        super(c.getMatricula(),c.getMarca(), c.getFiabilidade(), c.getLoc()); 
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
     * varia de 0.9 a 1.5, pois se fizer 1 cumpre o tempo mais do que isso não cumpre e menos é mais rápido 
     * 
     * @return finalX valor da fiabilidade do veiculo 
     */
    
    public static float calcFiabilidade(){
        float minX = 0.9f;
        float maxX = 1.5f;
        Random rand = new Random();
        float finalX = rand.nextFloat() * (maxX - minX) + minX;

        return finalX;  
    }
    
     /**
     * equals recebe um Object o e verifica se é igual a um CarroLig
     */
        public boolean equals(Object o){
        
        if(o==this) return true; //se o objeto for igual ao meu objeto retorna verdade
        
        if((o==null) || (this.getClass()!=o.getClass()))
        return false;
        
        CarroLig carro = (CarroLig) o; 
        return super.equals(carro) && this.lugaresLivres== carro.getLugaresLivres() && this.vm==carro.getVm()
        && this.vm==carro.getPrecoPorKm();  
    
    }
    
    /**
     * método toString
     * 
     */
    public String toString (){
        StringBuilder sb = new StringBuilder("Carro Ligeiro: \n"); 
        sb.append(super.toString());
        sb.append("Lugares disponiveis: " +this.getLugaresLivres() + "\n");  
        sb.append("Velocidade média:" +this.getVm() +"\n"); 
        sb.append("Preço por Km: " +this.getPrecoPorKm() + "\n"); 
        return sb.toString(); 
    }
    
    
    
    public CarroLig clone(){
        return new CarroLig (this); 
    
    } 
    
     
}

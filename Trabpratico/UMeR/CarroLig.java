
/**
 * A classe CarroLig será uma especialização da classe Veiculo, aqui serão tratrados os veiculos designados 
 * por Carro Ligeiro. Um carro ligeiro possui 5 lugares, porém apenas pode levar 4 clientes no máximo
 * 
 * @celia
 * @version 1.0
 */

public class CarroLig extends Veiculo implements VeiculoInterface{
    //variável da classe
    private static int lugaresLivres = 4;
    
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
     * @param vm
     * @param preco
     * @param fiabilidade De 1-5, descreve a fiabilidade do Veiculo
     * @param coord
     */
    
    public CarroLig(String matricula, double vm, double preco, float fiabilidade, Coordenadas coord){
        super(matricula,vm,preco,fiabilidade, coord);
    }
    
    /**
     * construtor de cópia 
     */
    public CarroLig(CarroLig c){
        super(c.getMatricula(), c.getVm(), c.getPreco(), c.getFiabilidade(), c.getLoc()); 
    }
    
    public int getLugaresLivres (){
        return this.lugaresLivres; 
    }
    
     /**
     * equals recebe um Object o e verifica se é igual a um CarroLig
     */
        public boolean equals(Object o){
        
        if(o==this) return true; //se o objeto for igual ao meu objeto retorna verdade
        
        if((o==null) || (this.getClass()!=o.getClass()))
        return false;
        
        CarroLig carro = (CarroLig) o; 
        return super.equals(carro) && this.lugaresLivres== carro.getLugaresLivres();  
    
    }
    
    /**
     * método toString
     * 
     */
    public String toString (){
        StringBuilder sb = new StringBuilder("Carro Ligeiro: \n"); 
        sb.append("Dados do Veiculo: " + super.toString());
        sb.append("Lugares disponiveis" +this.getLugaresLivres() + "\n");  
        return sb.toString(); 
    }
    
    
    
    public CarroLig clone(){
        return new CarroLig (this); 
    
    } 
    
     
}

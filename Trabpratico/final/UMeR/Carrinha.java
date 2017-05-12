import java.io.Serializable;
/**
 * A classe Carrinha é uma especialização da classe Veiculo 
 * 
 * @celia
 * @version (número de versão ou data)
 */
public class Carrinha extends Veiculo implements VeiculoInterface,Serializable{
    //variável da classe
    private static int lugaresLivres = 8;
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
    public Carrinha(String matricula,String marca, double vm, double preco, float fiabilidade, Coordenadas coord){
        super(matricula,marca,vm,preco,fiabilidade, coord);
    }
    
      /**
     * construtor de cópia 
     */
    public Carrinha(Carrinha c){
        super(c.getMatricula(), c.getMarca(), c.getVm(), c.getPreco(), c.getFiabilidade(), c.getLoc()); 
    }
    
    public int getLugaresLivres (){
        return this.lugaresLivres; 
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
        sb.append("Dados do Veiculo: " + super.toString());
        sb.append("Lugares disponiveis: " +this.getLugaresLivres() + "\n");  
        return sb.toString(); 
    }
    
    
    //clone
    public Carrinha clone(){
        return new Carrinha (this); 
    
    } 
 
}

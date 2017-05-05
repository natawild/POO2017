
/**
 * A interface VeiculoIntereface tem os métodos a implementar em cada subclasse, assim será mais fácil quando for necessário
 * acrescentar um novo tipo de veiculo 
 * 
 * @celia 
 * @version 1.0
 */

public interface VeiculoInterface {
    
    public String getMarca ();
    
    public double getVm(); 

    public double getPreco(); 
    
    public float getFiabilidade(); 
    
    public VeiculoInterface clone(); 
}

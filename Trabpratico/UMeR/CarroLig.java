
/**
 * Escreva a descrição da classe CarroLig aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CarroLig extends Veiculo{
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
    
    public CarroLig(String matricula, double vm, double preco,  int fiabilidade, Coordenadas coord){
        super(matricula,vm,preco,fiabilidade, coord);
    }
  
}

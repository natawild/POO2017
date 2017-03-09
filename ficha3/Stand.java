import java.util.Arrays; 
/**
 * Classe que representa um Stand de automóveis
 * 
 * @author anr
 * @version 2014.03.16  
 * @version 2017.03.03
 */

public class Stand {
  //variáveis de instância
  private String nomeStand;
  private Veiculo[] carros;
  private int nveiculos;   //número veículos no stand
  
  //capacidade do stand (em número de veículos)
  private int capacidade;
  
  //capacidade inicial do Stand: valor por omissão
  public static final int capacidade_inicial = 10;
  
  //construtores
  public Stand() {
    this.nomeStand = new String();
    this.carros = new Veiculo[capacidade_inicial];
    this.capacidade = capacidade_inicial;
    this.nveiculos = 0;
  }
  
  public Stand(String nome, int capacidade) {
    this.nomeStand = nome;
    this.carros = new Veiculo[capacidade];
    this.capacidade = capacidade;
    this.nveiculos = 0;
  }
  
  public Stand(Stand umStand) {
    this.nomeStand  = umStand.getNomeStand();
    this.carros     = umStand.getCarros();
    this.capacidade = umStand.getCapacidade();
    this.nveiculos  = umStand.getNVeiculos();
  }
  
  //métodos de instância
  
  //gets e sets: fazer!
  
  public String getNomeStand(){
      return nomeStand; 
    }
  
 public Veiculo [] getCarros(){
     Veiculo [] aux = new Veiculo [carros.length];
     
     for(int i= 0; i<carros.length; i++){
         if(i<nveiculos){
         aux[i]= carros[i].clone(); }
         else{
             aux[i]= carros[i];
            
            }
        
        
        }
        
        return aux; 
    }
    
 public int getCapacidade(){
     return capacidade; 
    
    }
    
public int getNVeiculos(){
    return nveiculos; 

}
    
    
 public void setNomeStand(String nomeStand){
    this.nomeStand = nomeStand; 
    }
    


  
  //outros métodos
  
  /**
   * Método que insere um veículo no stand
   * 
   */
   public void insereVeiculo(Veiculo v) {
       if(nveiculos < carros.length && !existeVeiculo(v))
       carros[nveiculos++]=v.clone(); 

    }
   
   
   /**
    * Método que verifica se um determinado veículo está no
    * stand.
    */
    public boolean existeVeiculo(Veiculo v) {
    boolean encontrou=false; 
    for(int i=0; i<nveiculos && !encontrou; i++){
        encontrou=(carros[i].equals(v));
    }
    return encontrou; 
    }
    
    
    /**
     * Método que verifica se um veículo, cuja matrícula é conhecida, 
     * está no stand.
     */
    public boolean existeVeiculoPorMatricula(String matricula) {
        boolean existe = false; 
        for(int i=0; i<nveiculos && !existe; i++){
        existe=(Veiculo.getMatricula());
         }
     return existe; 
    }
    
    
    /** 
     * Método que devolve o veículo com mais kms.
     * 
     */
    public Veiculo veiculoComMaisKms() {
    
    
    }
    
    /**
     * Método que devolve o veículo mais gastador (em termos de
     * combustível).
     */
    public Veiculo veiculoMaisGastador() {
    
    }
    
    /**
     * Método que determina o número de kms de todos os veículos
     * da garagem.
     * 
     */
    public double totalKmsTodosVeiculos() {
    
    }
    
    public void remove(Veiculo v){
    
    
    }
    
    public Veiculo vender (String matricula){
    
    
    }
    
    
    /**
     * equals
     * 
     */
    public boolean equals(Object o) {
         if(o==this) return true; //se o objeto for igual ao meu objeto retorna verdade
        
        if((o==null) || (this.getClass()!=o.getClass())) //se o 'o' for nulo ou de uma classe diferente da minha
        return false;
        
        Stand s = (Stand) o ; 
        return (nomeStand.equals(s.getNomeStand())&& 
        Arrays.equals(carros, s.getCarros()) && 
        nveiculos == s.getNVeiculos()); 
    
    }
    
    /**
     * toString
     */

    public String toString() {
       
    
    }
    
    /**
     * clone
     */
    public Stand clone() {
        return new Stand(this); 
    
    }
    
}

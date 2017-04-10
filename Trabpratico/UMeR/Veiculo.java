
/**
 * A classe Veiculo contem matricula, velocidade média por km, preço base por km, factor de fiabilidade
 * 
 * Um veiculo sabe sempre as coordenadas onde está (x,y)
 * 
 * @celia
 * @version 1.0
 */
public class Veiculo{
    
    private String matricula; 
    private double vm; 
    private double preco; 
    private int fiabilidade;
    private Coordenadas coord;
    
    /**
     * construtor vazio
     */
    
    public Veiculo(){
        this.matricula=""; 
        this.vm=0.0;
        this.preco=0.0;
        this.fiabilidade=0;
        this.coord=new Coordenadas();
    }
    
    /**
     * construtor com argumentos
     * @param matricula
     * @param vm
     * @param preco
     * @param fiabilidade
     */
    
    public Veiculo (String matricula, double vm, double preco, int fiabilidade, Coordenadas coord){
        this.matricula=matricula;
        this.vm=vm;
        this.preco=preco;
        this.fiabilidade=fiabilidade;
        this.coord=coord;
    }
   
    public Veiculo (Veiculo v){
        this.matricula=v.getMatricula();
        this.vm=v.getVm();
        this.preco=v.getPreco();
        this.fiabilidade=v.getFiabilidade();
        this.coord=v.getCoordenadas();
    
    }
    
    //getters
    /**
     * @return matricula do veiculo
     */
    
    public String getMatricula (){
        return this.matricula; 
    
    }
    
    /**
     * @return velocidade media do veiculo
     */
    public double getVm(){
        return this.vm;
    }
    
    /**
     * @return preço por viagem
     */
    
    public double getPreco(){
        return this.preco;
    
    }
    
    /**
     * return fiabilidade do veiculo (determina a capacidade da viatura cumprir o tempo acordado
     * com o cliente)
     */
    
    public int getFiabilidade(){
        return this.fiabilidade;
    
    }
    
    public Coordenadas getCoordenadas(){
        return coord.clone();
    }
    
    //setters
    
    public void setMatricula (String matr){
        this.matricula=matr;   
    }
    
    public void setCoordenadas(Coordenadas coord){
        this.coord=coord.clone(); 
    }

    /**
     * equals recebe um obj veic e verifica se é igual a um Veiculo 
     */
    
    public boolean equals(Object veic){
        
        if(veic==this) return true; //se o objeto for igual ao meu objeto retorna verdade
        
        if((veic==null) || (this.getClass()!=veic.getClass()))
        return false;
        
        Veiculo v = (Veiculo) veic; 
        return this.matricula.equals(v.getMatricula()) && 
        this.coord.equals(v.getCoordenadas()) ; //está incompleto 
    
    }

    
        
    public Veiculo clone(){ // de-me um novo objeto igual a mim 
        return new Veiculo(this); 
    }

    
}


/**
 * Classe abstrata Veiculo 
 * 
 * @celia
 * @version 1.0
 */
public abstract class Veiculo {
    
    private String matricula; 
    private double vm; 
    private double preco; 
    private float fiabilidade;//0 a 2
    private Coordenadas loc;
    
    /**
     * construtor vazio
     */
    
    public Veiculo(){
        this.matricula=""; 
        this.vm=0.0;
        this.preco=0.0;
        this.fiabilidade=0f;
        this.loc=new Coordenadas();
    }
    
    /**
     * construtor com argumentos
     * @param matricula
     * @param vm
     * @param preco
     * @param fiabilidade
     */
    
    public Veiculo (String matricula, double vm, double preco, float fiabilidade, Coordenadas coord){
        this.matricula=matricula;
        this.vm=vm;
        this.preco=preco;
        this.fiabilidade=fiabilidade;
        this.loc=coord;
    }
   
    /**
     * contrutor por cópia
     */
    public Veiculo (Veiculo v){
        this.matricula=v.getMatricula();
        this.vm=v.getVm();
        this.preco=v.getPreco();
        this.fiabilidade=v.getFiabilidade();
        this.loc=v.getLoc();
    
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
     * @return fiabilidade do veiculo (determina a capacidade da viatura cumprir o tempo acordado
     * com o cliente)
     */
    
    public float getFiabilidade(){
        return this.fiabilidade;
    
    }
    
    public Coordenadas getLoc(){
        return loc.clone();
    }
    
    //setters
    
    public void setMatricula (String matr){
        this.matricula=matr;   
    }
    
    public void setLoc(Coordenadas coord){
        this.loc=coord.clone(); 
    }
    
   

    /**
     * equals recebe um objet veic e verifica se é igual a um Veiculo 
     */
    
    public boolean equals(Object veic){
        
        if(veic==this) return true; //se o objeto for igual ao meu objeto retorna verdade
        
        if((veic==null) || (this.getClass()!=veic.getClass()))
        return false;
        
        Veiculo v = (Veiculo) veic; 
        return this.matricula.equals(v.getMatricula()) && this.vm == v.getVm() &&
        this.preco == v.getPreco() && this.fiabilidade == v.getFiabilidade() &&
        this.loc.equals(v.getLoc()); 
    
    }
    
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Matricula: " +this.getMatricula() + "\n"); 
        sb.append("Velocidade Média: " +this.getVm() + "\n"); 
        sb.append("Preço por Km: " +this.getPreco() + "\n"); 
        sb.append("Fiabilidade do veiculo: " +this.getFiabilidade() + "\n");
        sb.append("Localização do veiculo: " +this.getLoc().toString()); 
        return sb.toString(); 
    }


    
}


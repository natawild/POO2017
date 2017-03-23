
/**
 * Escreva a descrição da classe Veiculos aqui.
 * 
 * @celia (seu nome) 
 * @1.0     (09/03/2017)
 */
public class Veiculo{
    
    private String matricula; 
    private int kms; 
    
    double kmsTotal; 
    double kmsParcial; 
    double consumoMedio; 
    int capacidade;
    int conteudo; 
    
    //get 
    
    public int getKms(){
    return kms; 
    }
    
    public String getMatricula(){
      return matricula; 
    }
    
    public Veiculo (Veiculo v){
        matricula = v.getMatricula(); 
        kms = v.getKms(); 
    
    }
    
    public void abastecer(int litros){
    
    
    }
    
    public void resetKms(){
    
    }
    
    public double autonomia(){
        return 0;
    
    }
    
    public void registarViagem(int kms, double consumo){
    
    }
    
    public boolean naReserva(){
        return true; 
    
    }
    
    public double totalCombustivel(double custoLitro){
        return 0; 
    
    }
    
    public double custoMedioKm(double custoLitro){
        return 0; 
    
    }
    
    
    public Veiculo clone(){ // de-me um novo objeto igual a mim 
    return new Veiculo(this); 
    }
    
    
    public boolean equals(Object o){
        
        if(o==this) return true; //se o objeto for igual ao meu objeto retorna verdade
        
        if((o==null) || (this.getClass()!=o.getClass()))
        return false;
        
        Veiculo v = (Veiculo) o; 
        return this.matricula.equals(v.getMatricula());
    
    }
   
}

import java.time.LocalDate; 
/**
 * A classe Motorista terá todas as informações relativas a um motorista, este que é um colaborador 
 * da UMeR. Tem todos os dados presentes na classe Ator, e ainda a acrescentar os seus próprios dados: 
 * .Grau de cumprimento de horário estabelecido com o cliente (0-100);
 * .Classificação do Motorista, calculado com base na classificação do cliente (0-100); 
 * .Histórico das Viagens realizadas; 
 * .Número de kms já realizados na UMeR;
 * .Informação se está disponivel ou não em determinado momento;
 * 
 * @celia  
 * @version 1.0
 */
public class Motorista extends Ator implements AtorInterface{ 
    
    private int grauCumprimentoHorario; //0-100
    private int classificacao; //0-100
    //Histórico das viagens realizadas
    private double totalKms; 
    private boolean disponivel;
    private float destreza; //0 e 2 
    private VeiculoInterface veiculo; 
    private HistoricoMotorista histMoto; 
    
    /**
     * Construtor vazio
     */
    public Motorista(){
        super();
        this.grauCumprimentoHorario = 0; 
        this.classificacao = 0;
        this.totalKms=0;
        this.disponivel = false; 
        this.destreza = 0f; 
        this.veiculo = null;   
    }
    
    /**
     * Construtor parametrizado 
     */
    public Motorista(String email,String nome, String password, String morada, LocalDate dataNascimento
    , int grauCumprimentoHorario, int classificacao, double totalKms, boolean disponivel, float destreza,
    VeiculoInterface veiculo){
        super(email, nome, password, morada, dataNascimento);
        this.grauCumprimentoHorario = grauCumprimentoHorario;
        this.classificacao = classificacao; 
        this.totalKms= totalKms; 
        this.disponivel = disponivel; 
        this.destreza = destreza; 
        this.veiculo = veiculo; 
    }
    
    
    /**
     * Construtor por cópia 
     * @param mt
     */
    
    public Motorista (Motorista mt){
        super(mt);
        this.grauCumprimentoHorario= mt.getGrauCumprimentoHorario();
        this.classificacao = mt.getClassificacao(); 
        this.totalKms=mt.getTotalKms(); 
        this.disponivel= mt.getDisponivel(); 
        this.destreza=mt.getDestreza();
        this.veiculo= mt.getVeiculo(); 
    }

    //getters
    public int getGrauCumprimentoHorario(){
        return this.grauCumprimentoHorario;
    }
    
    public int getClassificacao(){
        return this.classificacao; 
    }
    
    public double getTotalKms(){
        return this.totalKms; 
    }
    
    public boolean getDisponivel(){
    return this.disponivel; 
    }
    
    public float getDestreza(){
        return this.destreza; 
    }
    
    public VeiculoInterface getVeiculo(){
        return this.veiculo.clone(); 
    }
    
    //setters
    /**
     * 
     */
    public void setGrauCumprimentoHorario(int g){
        this.grauCumprimentoHorario= g; 
    }
    
    public void setClassificacao(int c){
        this.classificacao=c; 
    }
    
    public void setTotalKms (double k){
        this.totalKms= k; 
    }
    
    public void setDisponivel(boolean disp){
        this.disponivel = disp; 
    }
    
    public void setDestreza(float destr){
        this.destreza = destr; 
    }
    
    public void setVeiculo (VeiculoInterface v){
        this.veiculo = v.clone(); 
        
    }
    
    
     /**
     * método equals 
     */
    
    public boolean equals (Object moto){
       if(this==moto) 
            return true;
       if((moto == null) || (this.getClass()!=moto.getClass()))
       return false; 
       
       Motorista m = (Motorista) moto; 
       return super.equals(m) &&  this.grauCumprimentoHorario== m.getGrauCumprimentoHorario() &&
              this.classificacao == m.getClassificacao() && this.totalKms == m.getTotalKms() && 
              this.disponivel == m.getDisponivel() && this.destreza == m.getDestreza() &&
              this.veiculo.equals(m.getVeiculo());       
    }
    
    /**
     * método toString
     * 
     */
    public String toString (){
        StringBuilder sb = new StringBuilder("Motorista: \n"); 
        sb.append("Motorista dados: " + super.toString());
        sb.append("Classificação: " +this.getClassificacao() + "\n"); 
        sb.append("Total Kms efetuados: " +this.getTotalKms() + "\n"); 
        sb.append("Disponibilidade: " +this.getDisponivel() + "\n"); 
        sb.append("Destreza: " +this.getDestreza() + "\n"); 
        sb.append("Veiculo conduzido: " +this.getVeiculo() + "\n"); 
        return sb.toString(); 
    }
    
    
    public Motorista clone (){
        return new Motorista(this);    
    }
    
    
}

import java.time.LocalDate; 
import java.io.Serializable;
import java.util.Random;
/**
 * A classe Motorista terá todas as informações relativas a um motorista, este que é um colaborador 
 * da UMeR. Tem todos os dados presentes na classe Ator, e ainda a acrescentar os seus próprios dados: 
 * .Grau de cumprimento de horário estabelecido com o cliente (0-100);
 * .Classificação do Motorista, calculado com base na classificação do cliente (0-100); 
 * .Histórico das Viagens realizadas; 
 * .Número de kms já realizados na UMeR;
 * .Informação se está disponivel ou não em determinado momento;
 * .Informação se está a trabalhar ou não (horarioTrabalho)
 * 
 * @celia  
 * @version 1.0
 */
public class Motorista extends Ator implements AtorInterface,Serializable{ 
    
    private int grauCumprimentoHorario; //0-100
    private int classificacao; //0-100
    //Histórico das viagens realizadas
    private double totalKms; 
    private boolean disponivel;//verifica se está a trabalhar ou não 
    private boolean horarioTrabalho;
    private double destreza; //0 e 2 
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
        this.horarioTrabalho = false; 
        this.destreza = Utils.generateRandom(0.5f, 1.9f); 
        this.veiculo = null;   
    }
    
    /**
     * Construtor parametrizado 
     */
    public Motorista(String email,String nome, String password, String morada, LocalDate dataNascimento
    , int grauCumprimentoHorario, int classificacao, double totalKms, boolean disponivel,boolean horarioTrabalho,
    float destreza, VeiculoInterface veiculo){
        super(email, nome, password, morada, dataNascimento);
        this.grauCumprimentoHorario = grauCumprimentoHorario;
        this.classificacao = classificacao; 
        this.totalKms= totalKms; 
        this.disponivel = disponivel; 
        this.horarioTrabalho=horarioTrabalho; 
        this.destreza = destreza; 
        this.veiculo = veiculo; 
    }
    
        /**
     * Construtor parametrizado 
     */
    public Motorista(String email,String nome, String password, String morada, LocalDate dataNascimento){
        super(email, nome, password, morada, dataNascimento);
        this.grauCumprimentoHorario = 0;
        this.classificacao = 0; 
        this.totalKms= 0; 
        this.disponivel = false; 
        this.horarioTrabalho=false; 
        this.destreza = Utils.generateRandom(0.5f, 1.9f); 
        this.veiculo = null; 
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
        this.horarioTrabalho = mt.getHorarioTrabalho(); 
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
    
    public boolean getHorarioTrabalho(){
        return this.horarioTrabalho; 
    }
    
    /**
     * getDestreza() avalia aleatóreamente a destreza de um condutor este valor poderá ter valores entre 0.5 muito mau 
     * e 1.9 muito bom 
     * @return destreza do condutor 
     * 
     */
    public double getDestreza(){
        return destreza;
    }
    
    public VeiculoInterface getVeiculo(){
        if(veiculo != null) {
            return this.veiculo.clone(); 
        }
        return null;
    }
    
    
    public HistoricoMotorista getHistMoto(){
         return this.histMoto.clone();  
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
    
    public void setHorarioTrabalho(boolean hTrab){
        this.horarioTrabalho = hTrab; 
    }
    
    public void setDestreza (float destr){
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
              this.disponivel == m.getDisponivel() && this.horarioTrabalho == m.getHorarioTrabalho()&& this.destreza == m.getDestreza() &&
              this.veiculo.equals(m.getVeiculo());       
    }
    
    /**
     * método toString
     * 
     */
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append(super.toString());
        sb.append("Classificação: " +this.getClassificacao() + "\n"); 
        sb.append("Total Kms efetuados: " +this.getTotalKms() + "\n"); 
        sb.append("Disponibilidade: " +this.getDisponivel() + "\n");
        sb.append("Horário de Trabalho: " +this.getHorarioTrabalho() + "\n"); 
        sb.append("Destreza: " +this.getDestreza() + "\n"); 
        sb.append("Veiculo conduzido: " +this.getVeiculo() + "\n"); 
        return sb.toString(); 
    }
    
    
    public Motorista clone (){
        return new Motorista(this);    
    }
    
    
}

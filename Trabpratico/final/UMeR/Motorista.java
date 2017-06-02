import java.time.LocalDate; 
import java.io.Serializable;
import java.util.Random;
import java.util.Comparator;
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
public class Motorista extends Ator implements AtorInterface, Serializable, Comparable<Motorista>{ 
    private int grauCumprimentoHorario; //0-100
    private int classificacao; //0-100
    private double totalKms; 
    private boolean disponivel;//verifica se está disponivel ou não 
    private boolean horarioTrabalho; //verificar se está no horário de trabalho
    private double destreza; //valor entre 0,5 e 1.9
    private VeiculoInterface veiculo; 
    private Historico viagemEmProcesso;
    private int totalViagens;
    
    
    /**
     * Construtor vazio
     */
    public Motorista(){
        super();
        this.grauCumprimentoHorario = 0; 
        this.classificacao = 0;
        this.totalKms=0;
        this.disponivel = true; 
        this.horarioTrabalho = false; 
        this.destreza = Utils.generateRandom(0.5f, 1.9f); 
        this.veiculo = null;
        this.viagemEmProcesso = null;
        this.totalViagens = 0;
    }
    
    /**
     * Construtor parametrizado 
     */
    public Motorista(String email,String nome, String password, String morada, LocalDate dataNascimento
    , int grauCumprimentoHorario, int classificacao, double totalKms, boolean disponivel,boolean horarioTrabalho,
    double destreza, VeiculoInterface veiculo, Historico viagemEmProcesso, int totalViagens){
        super(email, nome, password, morada, dataNascimento);
        this.grauCumprimentoHorario = grauCumprimentoHorario;
        this.classificacao = classificacao; 
        this.totalKms= totalKms; 
        this.disponivel = disponivel; 
        this.horarioTrabalho=horarioTrabalho; 
        this.destreza = destreza; 
        this.veiculo = veiculo; 
        this.viagemEmProcesso = viagemEmProcesso;
        this.totalViagens = totalViagens;
    }
    
        /**
     * Construtor parametrizado 
     */
    public Motorista(String email,String nome, String password, String morada, LocalDate dataNascimento){
        super(email, nome, password, morada, dataNascimento);
        this.grauCumprimentoHorario = 0;
        this.classificacao = 0; 
        this.totalKms= 0; 
        this.disponivel = true; 
        this.horarioTrabalho=false; 
        this.destreza = Utils.generateRandom(0.5f, 1.9f); 
        this.veiculo = null; 
        this.viagemEmProcesso = null;
        this.totalViagens = 0;
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
        this.viagemEmProcesso = mt.getViagemEmProcesso();
        this.totalViagens = mt.getTotalViagens();
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
    
    
    public Historico getViagemEmProcesso(){
        if(this.viagemEmProcesso != null){
            return this.viagemEmProcesso.clone();
        }
        return null;
    }
    
    public int getTotalViagens(){
        return totalViagens;
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
    
    public void setDestreza (double destr){
        this.destreza = destr; 
    }
    
    public void setVeiculo (VeiculoInterface v){
        if(v != null){
            this.veiculo = v.clone(); 
        }
        else {
            this.veiculo = null;
        }
        
    }
    
    public void setViagemEmProcesso(Historico historico){
        if(historico != null) {
            this.viagemEmProcesso = historico.clone();  
        }
        else {
            this.viagemEmProcesso = null;
        }
    }
    
    public void setTotalViagens(int totalViagens){
        this.totalViagens = totalViagens;
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
              this.veiculo.equals(m.getVeiculo()) && equalsViagemEmProcesso(m.getViagemEmProcesso()) && this.totalViagens == m.getTotalViagens();       
    }
    
    private boolean equalsViagemEmProcesso (Historico h){
        if(this.viagemEmProcesso == null && h == null){
            return true;
        }
        
        if(this.viagemEmProcesso != null){
            return this.viagemEmProcesso.equals(h);
        }
        return false;
    }
    
    /**
     * hashCode
     */
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.grauCumprimentoHorario;
        hash = 79 * hash + this.classificacao;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.totalKms) ^ (Double.doubleToLongBits(this.totalKms) >>> 32));
        hash = 79 * hash + (this.disponivel ? 1 : 0);
        hash = 79 * hash + (this.horarioTrabalho ? 1 : 0);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.destreza) ^ (Double.doubleToLongBits(this.destreza) >>> 32));
        hash = 79 * hash + this.veiculo.hashCode();
        if(this.viagemEmProcesso != null ){
            hash = 79 * hash + this.viagemEmProcesso.hashCode();
        }
        hash = 79 * hash + this.totalViagens;
        hash = 79 * hash + super.hashCode();
        return hash;
    }
    
    /**
     * método toString
     * 
     */
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append(super.toString());
        sb.append("Classificação: " +this.classificacao + "\n"); 
        sb.append("Grau de cumprimento de Horario: " +this.grauCumprimentoHorario + "\n");
        sb.append("Total Kms efetuados: " + this.totalKms + "\n"); 
        sb.append("Disponibilidade: " +this.disponivel + "\n");
        sb.append("Horário de Trabalho: " +this.horarioTrabalho + "\n"); 
        sb.append("Destreza: " +this.destreza + "\n"); 
        sb.append("Total de viagens: " + this.totalViagens + "\n"); 
        if(this.veiculo != null){
            sb.append("Veiculo conduzido: " +this.veiculo + "\n"); 
        }
        else {
            sb.append("Nao tem veiculo \n"); 
        }
        sb.append("Viagem em processo \n: " + this.viagemEmProcesso + "\n"); 
        return sb.toString(); 
    }
    
    public String apresentaDadosPessoais(){ 
        StringBuilder sb = new StringBuilder(); 
        sb.append(super.toString());
        sb.append("Classificação: " + this.classificacao + "\n"); 
        sb.append("Grau de cumprimento de Horario: " + this.grauCumprimentoHorario + "\n");
        sb.append("Total Kms efetuados: " + this.totalKms + "\n"); 
        sb.append("Disponibilidade: " +this.disponivel + "\n");
        sb.append("Horário de Trabalho: " + this.horarioTrabalho + "\n"); 
        sb.append("Destreza: " + this.destreza + "\n"); 
        sb.append("Total de viagens: " + this.totalViagens + "\n"); 
        sb.append("Veiculo conduzido: " +this.veiculo + "\n"); 
        if(viagemEmProcesso != null){
            sb.append("Viagem em processo \n: " + this.viagemEmProcesso.apresentaHistoricoMotoristaMenu() + "\n"); 
        }
        return sb.toString(); 
    }
    
    public String apresenteDadosParaCliente(){ 
        StringBuilder sb = new StringBuilder(); 
        sb.append(super.apresenteDadosParaCliente());
        sb.append(" | Classificação: " + this.classificacao); 
        sb.append(" | Grau de cumprimento de Horario: " + this.grauCumprimentoHorario);
        sb.append(" | Total Kms efetuados: " + this.totalKms); 
        sb.append(" | Destreza: " + this.destreza); 
        sb.append(" | Total de viagens: " + this.totalViagens); 
        sb.append(this.veiculo.apresentaDadosCliente()); 
        return sb.toString(); 
    }
    
    
    public Motorista clone (){
        return new Motorista(this);    
    }
    
    public void addicionaViagem(){
        this.totalViagens = this.totalViagens +1;
    }
    
    
    public void adicionaKms(double kms){
        this.totalKms = this.totalKms + kms;
    }
    
    public void atualizaPosicaoVeiculo(Coordenadas loc){
        if(veiculo != null) {
            this.veiculo.setLoc(loc.clone());
        }
    }
    
    @Override
    public int compareTo(Motorista o) {
        return getNome().compareTo(o.getNome());
    }
    
    public static class Comparators {
        public static Comparator<Motorista> GrauDeCumprimento = new Comparator<Motorista>() {
            @Override
            public int compare(Motorista o1, Motorista o2) {
                return o2.getGrauCumprimentoHorario() - o1.getGrauCumprimentoHorario() ;
            }
        };  
    }
    

}

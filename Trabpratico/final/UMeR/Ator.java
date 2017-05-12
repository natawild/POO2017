import java.time.LocalDate; 
import java.util.Arrays; 
/**
 * Classe abstrata Ator - Apenas estarão declaradas as variáveis comuns a qualquer Ator do sistema: email
 * (que identifica o Ator), nome, password, morada, data de Nascimento
 * 
 * @celia
 * @version 1.0
 */
public abstract class Ator{
    
    private String email; 
    private String nome; 
    private String password; 
    private String morada; 
    private LocalDate dataNascimento; 
    
    /**
     * Construtor vazio
     */
    public Ator(){
        this.email="";
        this.nome="";
        this.password="";
        this.morada = ""; 
        LocalDate dataNascimento = null;  
    }
    
    /**
     * Construtor parametrizado
     * @param email  Ator e-mail
     * @param nome  Ator nome
     * @param password  Ator password
     * @param morada  Ator morada
     * @param dataNascimento Ator dataNascimento 
     */
    
    public Ator (String email,String nome, String password, String morada, LocalDate dataNascimento){
        this.email=email;
        this.nome=nome; 
        this.password= password; 
        this.morada= morada; 
        this.dataNascimento= dataNascimento; 
    }
    
    /**
     * Construtor cópia
     */
    
    public Ator (Ator a){
        this.email = a.getEmail();
        this.nome = a.getNome();
        this.password = a.getPassword();
        this.morada = a.getMorada();
        this.dataNascimento = a.getDataNascimento(); 
    }
    
    
     // Getters
    /**
     * Gets e-mail do Ator
     * @return Ator mail
     */
    public String getEmail () {
        return this.email;
    }

    /**
     * Get nome do Ator.
     * @return  nome do Ator 
     */
    public String getNome () {
        return this.nome;
    }

    /**
     * Get password de um Ator.
     * @return password do Ator 
     */
    public String getPassword () {
        return this.password;
    }
    
     /**
     * Get morada de um Ator.
     * @return Ator morada
     */
    public String getMorada () {
        return this.morada;
    }
    
    /**
     * Get dataNascimento do Ator
     * @return dataNascimento
     */
    public LocalDate getDataNascimento (){
        return this.dataNascimento; 
    }
    
    //Setters
    
    public void setEmail(String e) {
        this.email=e;
    }
    
    public void setNome(String n) {
        this.nome = n;
    }
    
    public void setPassword(String p) {
        this.password = p;
    }
   
    public void setMorada(String m) {
        this.morada=m;
    }
      
    public void setDataNascimento( LocalDate d) {
        this.dataNascimento = d;
    }
 
    
    /**
     * método equals 
     */
    
    public boolean equals (Object o){
        if(this == o) {
            return true;
        } else{
            Ator a = (Ator) o; 
            return (this.email.equals(a.getEmail()) && this.nome.equals(a.getNome()) &&
                    this.password.equals(a.getPassword()) && this.morada.equals(a.getMorada()) &&
                    this.dataNascimento.equals(a.getDataNascimento())); 
                }      
    }
    
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Email: " +this.getEmail() + "\n");
        sb.append("Nome: " + this.getNome() + "\n");
        sb.append("Password: " +esconderPassword(getPassword().length(), '*') + "\n" ); //+this.getPassword() + "\n");
        sb.append("Morada: " +this.getMorada() + "\n");
        sb.append("Data de Nascimento: " +this.getDataNascimento() + "\n");  
        return sb.toString(); 
        
    }
    
    /**
     * método que esconde a password substituindo o nr de caracteres da password pelo mesmo numero de * 
     */
   private  String esconderPassword (int tamanho, char caracter) {
       if (tamanho > 0) {
           char[] array = new char[tamanho];
           Arrays.fill(array, caracter);
           return new String(array);
        }
        return "";
    }

}


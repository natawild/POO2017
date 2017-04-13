import java.time.LocalDate; 
/**
 * A classe Ator conterá a seguinte informação: email que identifica cada ator, nome, password, morada 
 * data de nascimento
 * 
 * @celia 
 * @version 1.0
 */
public class Ator{
    private String email; 
    private String nome; 
    private String password; 
    private String morada; 
    private LocalDate dataNascimento; 
    
    /**
     * construtor vazio
     */
    public Ator(){
        this.email="";
        this.nome="";
        this.password="";
        LocalDate dataNascimento = null;  
    }
    
    /**
     * Construtor with arguments
     * @param mail  Ator e-mail
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
    
    
    
    public Ator (Ator a){
        this.email = a.getEmail();
        this.nome = a.getNome();
        this.password = a.getPassword();
        this.morada = a.getMorada();
        this.dataNascimento = a.getDataNascimento(); 
    }
    
    
     // Getters
    /**
     * Gets the Ator's e-mail.
     * @return Ator mail
     */
    public String getEmail () {
        return this.email;
    }

    /**
     * Gets the User's name.
     * @return Ator name
     */
    public String getNome () {
        return this.nome;
    }

    /**
     * Get the encrypted password of an Ator.
     * @return Ator encrypted password
     */
    public String getPassword () {
        return this.password;
    }
    
     /**
     * Get adress of an Ator.
     * @return Ator adress
     */
    public String getMorada () {
        return this.morada;
    }
    
    /**
     * Get dataNascimento of Ator
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
     * Método clone
     */
    public Ator clone() {
        return new Ator(this);
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
   
}

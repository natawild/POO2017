package Exceptions;

/**
 *
 * @author celia
 */
public class ViaturaExistenteException extends Exception{
    
    /**
     * Construtor vazio, ou seja, apenas invoca o construtor da superclasse.
     */
    public ViaturaExistenteException(){
        super();
    }
    
    /**
     * Construtor parametrizado, ou seja, recebe uma String como parâmetro para informação, que invoca igualmente o construtor da superclasse que aceita uma String por parâmetro.
     */
    public ViaturaExistenteException(String message){
        super(message);
    }
    
    /**
     * A função getMessage imprime o texto de exceção.
     */
    public String getMessage() {
        return "Já existe uma viatura com esses dados\n";
    }
}

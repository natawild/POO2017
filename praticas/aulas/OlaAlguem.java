
/**
 * Escreva a descrição da classe OlaAlguem aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class OlaAlguem
{
 
    public static String geraSaudacao (String nome){
    return "olá "+nome+"!";
    }
    
    public static void main (String[] args){
    String saudacao = OlaAlguem.geraSaudacao("Mundo eu sou linda");
    System.out.println(saudacao);
    }
}
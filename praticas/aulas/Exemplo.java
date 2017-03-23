import java.util.Scanner; 
/**
 * Escreva a descrição da classe Exemplo aqui.
 * 
 * @celia (seu nome) 
 * @version (número de versão ou data)
 */
public class Exemplo
{
     
         
         public static String geraSaudacao(String n, int s){
            return "olá " +n+" o teu saldo é " +s+ ".";
        }
         
            public static void main(String[] args){
         Scanner input = new Scanner(System.in);
         String nome; 
         int saldo; 
         System.out.println("Nome:");
         nome = input.nextLine(); 
         System.out.println("Saldo:");
         saldo=input. nextInt(); 
         
         System.out.println(Exemplo.geraSaudacao(nome,saldo)); //
          
         
        }  
}

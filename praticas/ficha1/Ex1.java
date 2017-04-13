import java.util.Scanner; 
/**
 * Escreva a descrição da classe Exemplo aqui.
 * 
 * @celia 
 * @version (número de versão ou data)
 */
public class Ex1{ 
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
         System.out.println(Ex1.geraSaudacao(nome,saldo)); 
        }  
}


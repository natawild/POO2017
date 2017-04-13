import java.util.Scanner;
import java.lang.Math;
/**
 * Esta classe deverá ler n reias e calcular a sua raiz quadrada
 * @celia
 * @version (número de versão ou data)
 */
public class Ex4{
  
  public static void main(String[] args){
      
      Scanner input = new Scanner (System.in);
      double n, res;
      System.out.println("Escreva um número para calcular a raiz quadrada ");

      while((n=input.nextDouble())!=0d){
          res=0; 
          res=Math.sqrt(n); 
          System.out.println("A raiz quadrada de " +n+ " é " +res);
        }
        
      }
    }
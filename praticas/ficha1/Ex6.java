import java.util.Scanner; 
import java.lang.String;
/**
 * calcular o factorial de um valor inteiro passado como parametro ao programa, o factorial deverá
 * ser calculado num método auxiliar
 * 
 * @celia 
 * @version (número de versão ou data)
 */
public class Ex6{
    
    public static long calculaFactorial (long  n){
        long fat=1;
        long i;
        for(i=n; i>0; i--){
            fat=fat*i;
        }
        return fat;   
    }
    
    public static void main (String [] args){
        if(args.length>0){//verifica que a string não é vazia
         long n =Long.valueOf( args[0]); 
        System.out.println("O fatorial de " +n+ " é: " +Ex6.calculaFactorial(n));
       }
    }
    
}

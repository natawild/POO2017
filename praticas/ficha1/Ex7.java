import java.util.Scanner; 
import java.lang.String;
import java.math.BigInteger;
import java.time.LocalDate; 
import java.time.LocalTime; 
import java.time.Duration; 
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit; 
import java.time.Period; 
import java.time.Instant; 
import java.time.ZoneOffset;  
/**
 * Escreva a descrição da classe Ex7 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Ex7
{
       public static BigInteger calculaFactorial (long  n){
           
        BigInteger fat=  BigInteger.valueOf(1);
        long i;
        for(i=n; i>0; i--){
            fat=fat.multiply(BigInteger.valueOf(i));
        }
        return fat;   
    }
    
    public static void main (String [] args){
        if(args.length>0){//verifica que a string não é vazia
         long n = Long.valueOf(args[0]); 
         LocalDateTime start = LocalDateTime.now();
         //Instant start1 = start.toInstant(ZoneOffset.UTC);
         System.out.println("Começou a processar " +start);
         
         BigInteger result = Ex7.calculaFactorial(n);
         LocalDateTime end = LocalDateTime.now();
         //Instant end1 = end.toInstant(ZoneOffset.UTC);
         System.out.println("Terminou de processar " +end);
         Duration dur = Duration.between(start,end);
       System.out.println("O fatorial de " +n+ " é: " +result+ " e demorou " +dur.toMillis()+ " milisegundos");
       }
    }
    
}


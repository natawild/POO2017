import java.util.Scanner;
/**
 * Escreva a descrição da classe Ex5 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Ex5
{
    public static void main(String[] args){
        Scanner input = new Scanner (System.in);
        int menor = Integer.MAX_VALUE; 
        int maior = Integer.MIN_VALUE; 
        int n; 
        
        do{
            System.out.println("Indique um número [zero para terminar]:");
            n=input.nextInt();
            if(n>maior && n!=0) maior =n;
            if(n<menor && n!=0) menor =n;
        }
        while(n!=0);
        System.out.println("Menor valor lido: " +menor); 
        System.out.println("Maior valor lido: " +maior); 
        
    }
        
        
        
        
        
}

import java.util.Scanner; 
/**
 * Escreva a descrição da classe Ex14 aqui.
 * 
 * nr primo é ter apenas 2 divisores o 1 e ele próprio 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Ex14 {
   
    public static boolean primo (int x){
        int m;
        for(m=2; m<x; m++){ //só a partir do 2 é que é primo, 
            if(x % m == 0){ // se o resto da divisão der resto zero, não é primo 
                return false; 
            }
        }
        return true; 
    }

    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        int n; 
        System.out.println("Insira um número ");
        n=input.nextInt(); 
        int i;
        for (i=n;i>0; i--){
            if(Ex14.primo(i)){
                System.out.println("Os numeros primos inferiores a " +n+ " são: " +i); 
            }
        }

    }

}
   

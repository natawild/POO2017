import java.util.Scanner; 
/**
 * Escreva a descrição da classe Ex3 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Ex3
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int maq5=0;
        int n;
        System.out.println("Escreva 10 inteiros: ");
        
        for(int i=0;i<10;i++){
            if(input.nextInt() > 5)
                maq5++; 
        }
        System.out.println("Li "+maq5+" números maiores do 5." );

   } 
}

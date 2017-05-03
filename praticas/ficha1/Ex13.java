import java.util.Scanner; 
/**
 *  Ex13 fazer a leitura do preço (valor real) de um produto, e de uma sequncia não vazia de 
 *  valores de stock para esse produto (terminada por zero). Calcule o total de stock e o valor desse stock
 *  apresentando o resultado com uma precisão de 4 casas decimais 
 * 
 * @celia
 * @version 1.0
 */
public class Ex13 {
    public static void main(String[] args){
        Scanner input = new Scanner (System.in);
        double stock; 
        int preco; 
        double resultado = 0; 
        double fim = 0; 
        int conta = 0; 
        System.out.println("Introduza o preço do produto em stock:");
        preco = input.nextInt(); 
        
        do{
            System.out.println("Indique uma sequência de números em stock [zero para terminar]:");
            stock = input.nextDouble(); 
            resultado+=stock; 
            conta++; 
            fim=resultado*preco; 
        }
        while((stock=input.nextDouble())!=0d); 
        System.out.println("Existem " +conta+ " itens e tem um valor total de "+fim);
   
    }
}

import java.util.Scanner; 
import java.lang.Math;
/**
 *  Ex12 deverá ler sucessivas vezes a base e altura de um triangulo retangulo (valores reais)
 *  e calcular a area e o perimetro respetivos. usar printf() para apresentae os resultados com uma 
 *  precisão de 5 casas decimais. O programa apenas deverá terminar com a letira de um abase 0.0.
 * 
 * @celia
 * @version 1.0
 */
public class Ex12 {
    
    public static void main (String [] args){
      Scanner input = new Scanner (System.in);
      double base; 
      double altura; 
      
      do{
          System.out.println("Insira a base do triangulo");
          base = input.nextDouble(); 
          System.out.println("Insira a altura do triangulo");
          altura = input.nextDouble(); 
      
          double perimetro=0; 
          double area = 0; 
          
          perimetro = base + altura + (Math.sqrt((base*base)+(altura*altura)));  
          area = (base*altura)/2; 
          
          System.out.println("O perimetro do triangulo é: " +perimetro);
          System.out.println("A área do triangulo é " +area);
          
        }
        while((base=input.nextDouble())!=0d ); 
      
        }
        
    }
   

import java.util.Scanner; 
/**
 * Escreva a descrição da classe Media aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Media{

      public static String geraMedia(float a, float b){
          float media= 0; 
          media= (a+b)/2; 
          return " A média é " +media;
        }
        
        public static float decrescente (float a, float b){
            float r=0;
        if(a>b){
            return r=a;
       }
        else return r=b; 
        
        }
         
            public static void main(String[] args){
         Scanner input = new Scanner(System.in);
         float x; float y; 
         System.out.println("Insira dois números");
         x=input. nextInt(); 
         y=input. nextInt(); 
         input.close(); 
         if(x>y){
         System.out.println("Os números introduzidos foram " +x+ " e " +y+ Media.geraMedia(x,y));
            }
            
         else {
           System.out.println("Os números introduzidos foram "+y+ " e " +x+ Media.geraMedia(x,y));
            
            }
     
        }
}

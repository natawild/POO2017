import java.util.Scanner; 
/**
 * Escreva a descrição da classe Ex3 aqui.
 * 
 * @natawild
 * @version (número de versão ou data)
 */
public class Ex3 {
    
    private static void inserOrd(int []a, int p, int v) {
        int i; 
        for(i=0; i<p && a[i]>v; i++){
           if(i!=p){
               System.arraycopy(a,i,a,i+1,p-i);
           } 
            
            a[i]=v; 
        
        }
        
    
    }
    
     public static int[] lerArray(int n){
        int [] res = new int[n]; 
        int []arr = new int[n]; 
        Scanner in = new Scanner(System.in);
        for(int i=0; i<n; i++){
         System.out.println("Valor [" + i + "/" +n+ "]");
        inserOrd(arr,i,in.nextInt());
        }
        in.close(); 
        return res; 
    }
    
    
    public static int minPos(int[] arr){
        int pos=0; 
        for(int i=0; i<arr.length; i++){
            if(arr[pos]>arr[i]){
                pos=i;
            }
             
         }
         return pos; 
       
        }

    public static void main (String[] args){
        Scanner in = new Scanner (System.in);
        int n, arr[], pos; 
        System.out.println("Quantos valores pretende inserir? "); 
        n=in.nextInt();
        in.close();
        arr=lerArray(n);
        pos=minPos(arr);
        System.out.println("Posição do minimo : " + pos); 
    }
}

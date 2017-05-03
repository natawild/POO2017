import java.util.Scanner; 
/**
 * Escreva a descrição da classe Ex4 aqui.
 * 
 * @celia 
 * @version (número de versão ou data)
 */
public class Ex4{
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
        
    /**
     * Dado um array e dois indices válidos do array, retorna um novo array apenas com os elementos entre esses
     * dois indices
     */ 
    public static int [] subArray(int [] arr, int i, int f){
        int j; 
        int [] aux = new int [f-i]; 
        for(j=i; j<=f; j++){
            System.arraycopy(arr,i,aux,0,f-i);
        }
        return aux; 

    }

    public static void main (String[] args){
        Scanner in = new Scanner (System.in);
        int i,f,j;
        int n, arr[], subarr[], pos; 
        System.out.println("Quantos valores pretende inserir? "); 
        n=in.nextInt();
        
        arr=lerArray(n);
        System.out.println("Diga quais os indices que pretende ter no subarray inicio"); 
        i=in.nextInt();
        System.out.println("Diga quais os indices que pretende ter no subarray fim"); 
        f=in.nextInt(); 
        in.close();
        subarr=subArray(arr,i,f);
        for(j=i; j<=f; j++){
            System.out.println("ver subarray: " +subarr[j]); 
        }
        
        System.out.println("ver subarray " +subarr); 
    }
    
}

import java.util.Random; 
/**
 * A classe Utils deverá simular as condições atmosféricas e as condicionantes de trânsito para cada viagem efetuada.
 * A classe Meteorolgia receberá os possiveis estados de tempo 
 * 
 * A classe Transito receberá os possiveis estados de transito 
 * @celia
 * @version (número de versão ou data)
 */
public class  Utils{
    
    public static double generateRandom(float min, float max){
        Random rand = new Random();
        return (rand.nextInt((int)((max-min)*10+1))+min*10)/10.0;
        
      }
    
    
    public static class Meteorologia {
        
    public static final String sol = "Sol"; 
    public static final String nevoeiro  = "Nevoeiro"; 
    public static final String granizo = "Granizo";
    public static final String chuva = "Chuva";
    public static final String neve = "Neve"; 
    
    public static String getEstadoTempo (){
        Random rand = new Random();
        double estadoTempo = generateRandom(0.89f,1.3f); 
        switch (String.valueOf(estadoTempo)){
            case "0.9" :
                return sol; 
            case "1.0" : 
                return chuva; 
            case "1.1" :
                return nevoeiro; 
            case "1.2" :
                return granizo; 
            case "1.3" :
                return neve; 
            default: return sol; 
        }

    }
    
    public static float getValorTempo(String estado){
        switch (estado){
            case sol :
                return 0.9f; 
            case chuva : 
                return 1.0f; 
            case nevoeiro :
                return 1.1f; 
            case granizo :
                return 1.2f; 
            case neve :
                return 1.3f; 
            default: return 1.0f; 
        
        }
    }
    
    
    
    }
    
    public static class Transito {
        
        public static final String st = "Sem Transito"; 
        public static final String tn = "Transito Normal"; 
        public static final String mt  = "Muito Transito"; 
        
        
        public static String getEstadoTransito (){
        Random rand = new Random();
        double estadoTransito = generateRandom(0.9f,1.1f); 
        switch (String.valueOf(estadoTransito)){
            case "0.9" :
                return st; 
            case "1.0" : 
                return tn; 
            case "1.1" :
                return mt; 
            
            default: return tn; 
        }

    }
    
    
    public static float getValorTransito(String estado){
        switch (estado){
            case st :
                return 0.9f; 
            case tn : 
                return 1.0f; 
            case mt :
                return 1.1f; 
            
            default: return 1.0f; 
        
        }
    } 
        
    }

}

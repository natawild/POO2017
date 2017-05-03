import java.util.ArrayList; 
/**
 * TempMes terá o conjunto dos dias e respetivas temperaturas 
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class TempMes {
    
    private ArrayList<TemperaturaDia> temperaturas; // TemperaturaDia é o tipo da classe que armazena um dia e as respetivas temperaturas
   
    /**
     * construtor vazio
     */
    public TempMes(){
        this.temperaturas = new ArrayList<TemperaturaDia> (); 
    }
    
    //get
    public ArrayList<TemperaturaDia> getTemperaturas (){
        return this.temperaturas; 
    }

    //set
    public void setTemperaturas (ArrayList<TemperaturaDia> lista){
        this.temperaturas = lista; 
    }
 
    
    public void addTempDia (TemperaturaDia dia){
        this.temperaturas.add(dia);
    }
    
    public float [] mediaPorDia (){ 
        float [] mediasPorDia = new float [temperaturas.size()]; 
        int i = 0;
        for(TemperaturaDia tempDia : temperaturas){
            mediasPorDia[i]  =   tempDia.mediaTemp();
            i++; 
        }
        
        return mediasPorDia; 
    }
    
    public int getMaiorVariacao (){
        float [] mediasPorDia = mediaPorDia();
        int i, indice=0 ;
        float variacaoDiaria, variacaoMax=0;
        
        for(i=0; i< mediasPorDia.length -1; i++){
            variacaoDiaria = mediasPorDia[i+1] - mediasPorDia[i];
            if(variacaoDiaria<0 ){
                variacaoDiaria = variacaoDiaria * -1;
            }
            
            if(variacaoDiaria > variacaoMax){
                variacaoMax = variacaoDiaria;
                indice = i;
            }
        }
        
        return indice;
    }
    
    public float variacao (int i){
        float [] mediasPorDia = mediaPorDia(); 
        return mediasPorDia[i+1]-mediasPorDia[i];
    }
    
    
    
    
    
    
    
    
    
    
    
}

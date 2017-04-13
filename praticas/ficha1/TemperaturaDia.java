
import java.util.ArrayList; 
/**
 * Escreva a descrição da classe TemperaturaDia aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class TemperaturaDia{
    
    private Integer diaDoMes; 
    private ArrayList<Integer> temperaturas; 
    
    public TemperaturaDia(){
        this.diaDoMes=null; 
        this.temperaturas= new ArrayList<Integer> (); 
    }
    
    public TemperaturaDia(Integer diaDoMes2, ArrayList<Integer> temperaturas ){
        diaDoMes=diaDoMes2; 
        this.temperaturas= temperaturas; 
    }
    
    public Integer getDiaDoMes (){
        return this.diaDoMes; 
    }
    
    public ArrayList<Integer> getTemperaturas(){
        return this.temperaturas; 
    }
    
    public void setDiaDoMes (Integer diaDoMes){
        this.diaDoMes = diaDoMes; 
    }
    
    public void setTemperaturas( ArrayList <Integer> temperaturas){
        this.temperaturas = temperaturas; 
    }
    
    public float mediaTemp (){
        float soma = 0;
        for(Integer temperatura : this.temperaturas){ //percorre a lista das temperaturas 
            soma += temperatura; 
        }
       return  soma / this.temperaturas.size();
    }
    
    public void addTemp (Integer temp){
        this.temperaturas.add(temp);
        
    
    }
    
}

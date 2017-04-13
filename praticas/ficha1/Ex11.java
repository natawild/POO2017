import java.util.Scanner; 
import java.util.ArrayList; 
import java.lang.Math; 
/**
 * Escreva a descrição da classe Ex11 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Ex11 {
    
    public static void main (String [] args){
        
        //System.out.println("A maior variação registou-se entre os dias " +dia1+ "e" +dia2+", tendo a tempertura descido" +graus);
        ArrayList<Integer> temperaturasDia1 = new ArrayList<Integer>();
        temperaturasDia1.add(20);
        temperaturasDia1.add(21);
        TemperaturaDia dia1 = new TemperaturaDia(1, temperaturasDia1); 
        
        
        
        ArrayList<Integer> temperaturasDia2 = new ArrayList<Integer>();
        temperaturasDia2.add(29);
        temperaturasDia2.add(20);
        temperaturasDia2.add(30);
        temperaturasDia2.add(34);
        TemperaturaDia dia2 = new TemperaturaDia(); 
        dia2.setDiaDoMes(2); 
        dia2.setTemperaturas(temperaturasDia2);

        
       
        ArrayList<Integer> temperaturasDia3 = new ArrayList<Integer>();
        temperaturasDia3.add(27);
        temperaturasDia3.add(28);
        temperaturasDia3.add(30);
        temperaturasDia3.add(31);
        TemperaturaDia dia3 = new TemperaturaDia (3, temperaturasDia3); 
        
        float mediaDia1 = dia1.mediaTemp(); 
        float mediaDia2 = dia2.mediaTemp(); 
        float mediaDia3 = dia3.mediaTemp(); 
        System.out.println("A média é : " +mediaDia1); 
        System.out.println("A média é : " +mediaDia2); 
        System.out.println("A média é : " +mediaDia3); 
        
        
        TempMes mesJan = new TempMes();
        ArrayList<TemperaturaDia> tempsMesJan = new ArrayList<TemperaturaDia>(); 
        tempsMesJan.add(dia1);
        tempsMesJan.add(dia2);
        tempsMesJan.add(dia3);
        mesJan.setTemperaturas(tempsMesJan);
        
        int indice = mesJan.getMaiorVariacao();
        float maiorVariacao = mesJan.variacao(indice); 
        int d = indice+1; 
        if(maiorVariacao > 0) {
            System.out.println("A maior variação ocorreu entre o dia " +d+ " e " +(indice+2)+ " e aumentou " +maiorVariacao); 
        }
        else{
               System.out.println("A maior variação ocorreu entre o dia " +(indice+1)+ " e " +(indice+2)+ " e diminuiu" +Math.abs(maiorVariacao)); 
        
        }

    
    }
    
}

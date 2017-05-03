import java.util.Scanner; 
import java.util.ArrayList; 
import java.lang.Math; 
/**
 * Escreva a descrição da classe Ex11 aqui.
 * 
 * @celia
 * @version (número de versão ou data)
 */
public class Ex11 {
    
    public static void main (String [] args){
        
        ArrayList<Integer> temperaturasDia1 = new ArrayList<Integer>();
        temperaturasDia1.add(30);
        temperaturasDia1.add(31);
        TemperaturaDia dia1 = new TemperaturaDia(1, temperaturasDia1); 
        
        
        ArrayList<Integer> temperaturasDia2 = new ArrayList<Integer>();
        temperaturasDia2.add(29);
        temperaturasDia2.add(30);
        temperaturasDia2.add(30);
        temperaturasDia2.add(30);
        TemperaturaDia dia2 = new TemperaturaDia(2, temperaturasDia2);

        
        ArrayList<Integer> temperaturasDia3 = new ArrayList<Integer>();
        temperaturasDia3.add(20);
        temperaturasDia3.add(19);
        temperaturasDia3.add(20);
        temperaturasDia3.add(20);
        TemperaturaDia dia3 = new TemperaturaDia (3, temperaturasDia3); 
        
        ArrayList<Integer> temperaturasDia4 = new ArrayList<Integer>();
        temperaturasDia4.add(30);
        temperaturasDia4.add(41);
        temperaturasDia4.add(30);
        temperaturasDia4.add(31);
        TemperaturaDia dia4 = new TemperaturaDia (4, temperaturasDia4); 
        
        
        
        float mediaDia1 = dia1.mediaTemp(); 
        float mediaDia2 = dia2.mediaTemp(); 
        float mediaDia3 = dia3.mediaTemp(); 
        float mediaDia4 = dia4.mediaTemp();
        System.out.println("A média é : " +mediaDia1); 
        System.out.println("A média é : " +mediaDia2); 
        System.out.println("A média é : " +mediaDia3); 
        System.out.println("A média é : " +mediaDia4); 
        
        
        TempMes mesJan = new TempMes();
        ArrayList<TemperaturaDia> tempsMesJan = new ArrayList<TemperaturaDia>(); 
        tempsMesJan.add(dia1);
        tempsMesJan.add(dia2);
        tempsMesJan.add(dia3);
        tempsMesJan.add(dia4);
        mesJan.setTemperaturas(tempsMesJan);
        
        int indice = mesJan.getMaiorVariacao();
        float maiorVariacao = mesJan.variacao(indice); 
        int d = indice+1; 
        if(maiorVariacao > 0) {
            System.out.println("A maior variação ocorreu entre o dia " +d+ " e " +(indice+2)+ " e aumentou " +maiorVariacao+ " graus."); 
        }
        else{
               System.out.println("A maior variação ocorreu entre o dia " +(indice+1)+ " e " +(indice+2)+ " e diminuiu " +Math.abs(maiorVariacao)+ " graus."); 
        
        }

    
    }
    
}

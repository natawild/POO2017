import java.util.Scanner;
/**
 * Escreva a descrição da classe Ex8 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Ex8
{
    
    private int leNumLim (String nome, int min, int max){
        int aux;
        do{
            System.outprint(nome+ "["+min+" .."+max+"]: ");
            aux=input.nextInt();
        }while(aux<min || aux > max);
        return aux; 
    }
            
    
    
    public static void main(String[] args){
    Scanner input = new Scanner (System.in);
    int dia, mes, ano; 
    
    dia=leNumLim("Dia", 1,31);
    mes=leNumLim("Mês", 1,12); 
    ano=leNumLim("Ano", 1901, 2100); 
    
    dsemana =(ano-1900)*365+(ano-1900)/4; 
    if ((ano-1900)%4==0 && mes <=2) sdemana--;
    dsemana +=dia; 
    switch (mes) {
        
        case 12: dsenama +=30;
        case 11: dsemana +=29;
        case 10: dsemana +=30; 
        case 9: dsemana +=29; 
        case 8: dsemana +=30; 
        case 7: dsemana +=30; 
        case 6: dsemana +=29; 
        case 5: dsemana +=30; 
        case 4: dsemana +=29; 
        case 3: dsemana +=30; 
        case 2: dsemana +=29; 
        case 1: dsemana +=30; 
        
    }
    
    dsemana %7==0; 
    
    do{
        System.outprint("Dia [1..31]: ");
        dia = imput.nextInt(); 
    
    }while(dia<1 || dia>31); 
}

import java.time.LocalDate;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;
import java.time.Period; 
import java.util.Scanner; 
import java.time.Duration;
/**
 *  Ex17 escrever um programa que leia o ano, mes e dia de nascimento de um apessoa e calcule a sua idade atual 
 *  em horas, assim como a a data e hora em que esse cálculo foi efetuado 
 * 
 * @celia 
 * @version 1.0
 */
public class Ex17 {
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
    
    public Period calcularIdade(LocalDate aniversario){
            LocalDate hoje = LocalDate.now();
            return Period.between(aniversario,hoje); 
        }
        
    public LocalDate pedeDataNas(){
        Scanner ani = new Scanner (System.in); 
        LocalDate aniversario; 
          while(true){
                System.out.println("Por favor insira a sua data de nascimento " 
                +" neste formato yyyy-MM-dd ");
                String input = ani.nextLine();
                    aniversario = LocalDate.parse(input,formatter);
                    return aniversario; 
            }
    }
    
    public static void main (String [] args){
        LocalDateTime hoje = LocalDateTime.now();
        Ex17 aniversario = new Ex17();
        LocalDate btd = aniversario.pedeDataNas();
        Period age = aniversario.calcularIdade(btd);
        //Duration dur = Duration.between(btd,hoje);
        System.out.printf("Você tem " +age.getYears()+" anos (" +hoje+ ")");
       // System.out.printf("Você tem " +age.getYears()+" anos, isto em horas são atualmente"+dur.toHours()+"dados recolhidos nesta data e hora:" +hoje); 
        
    }
    
    
}

import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Escrever um programa que apresente ao utilizador as seguintes opções:
 * 1-Login
 * 2-Registo
 * 3-Informações
 * 0-Sair
 * 
 * @celia
 * @version 1.0
 */
public class Ex15 {
    
    public static void menu(){
        System.out.println("\t --------Um menu para experiencia -------");
        System.out.println("1-Login");
        System.out.println("2-Registo");
        System.out.println("3-Informações");
        System.out.println("0-Sair");
    }

    public static void login(){
        System.out.println("Entrou na opção login");
    }
    
    public static void registo(){
        System.out.println("Entrou na opção para se Registar");
    }
    
    public static void informacoes(){
        System.out.println("Entrou na opção das informações");
    }
    
    
    public static void main(String[] args) {
        int opcao;
        Scanner entrada = new Scanner(System.in);
        do{
            menu();
            opcao = entrada.nextInt();
            switch(opcao){
            case 1:
                login();
                break;
                
            case 2:
                registo();
                break;
                
            case 3:
                informacoes();
                break;
       
            default:
                System.out.println ("Opção inválida.");
            }

        } while(opcao != 0);
    }
}

      

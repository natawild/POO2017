
/**
 * Exemplo de aplicação com menu em modo texto.

 * 
 * @author José Creissac Campos
 * @version 1.0
 */

import java.io.*;
import java.util.Scanner;

public class HoteisIncApp {

    // A classe MyLog tem a 'lógica de negócio'.
    private HoteisInc logNegocio;
    // Menus da aplicação
    private Menu menuPrincipal;
    private Menu menuHoteis;
    
    /**
     * O método main cria a aplicação e invoca o método run()
     */
    public static void main(String[] args) {
        new HoteisIncApp().run();
    }
    
    /**
     * Construtor.
     * 
     * Cria os menus e a camada de negócio.
     */
    
    private HoteisIncApp() {
        // Criar o menu 
        String[] opcoes = {"Adicionar hotel ",
                         "Consultar hotel"};
       String[] opcoesHoteis = {"Criar Hotel Standard ",
                                "Criar Hotel Discount ",
                                "Criar Hotel Premium "};
        this.menuPrincipal = new Menu(opcoes);
        // Criar a lógica de negócio
        try{
            this.logNegocio = HoteisInc.carregaEstado("estado.obj"); 
        }
        catch (FileNotFoundException e ){
             System.out.println("Parece que é a primeira utilização..."); 
             this.logNegocio = new HoteisInc();
          // Aqui poder-se-iam ler os dados de ficheiro.
        }
        catch (IOException e ){
             System.out.println("Erro de leitura!"); 
             this.logNegocio = new HoteisInc();
        
        }
        catch (ClassNotFoundException e ){
            System.out.println("Ops! Formato de ficheiro de dados erado"); 
            this.logNegocio = new HoteisInc();
        
        }
    
    }

    /**
     * Executa o menu principal e invoca o método correspondente à opção seleccionada.
     */
    private void run() {
        do {
            menuPrincipal.executa();
            switch (menuPrincipal.getOpcao()) {
                case 1: System.out.println("Escolheu Adicionar");
                        break;
                case 2: System.out.println("Escolheu Consultar");
                        break;
            }
        } while (menuPrincipal.getOpcao()!=0); // A opção 0 é usada para sair do menu.
        // Aqui poder-se-iam gravar os dados em ficheiro...
        try{
        this.logNegocio.guardaEstado("etado.obj"); 
        }
        catch (IOException e ){
            System.out.println("Ops! Não consegui gravar os dados!");
        
        }
        
        System.out.println("Até breve!...");     
    }
    
    // Métodos auxiliares
    
    /**
     * Exemplo de método com input
     
    private void trataRegistarValor() {
        int i;
        Scanner scin = new Scanner(System.in);
        
        System.out.print("Valor: ");
        i = scin.nextInt();
        logNegocio.registaValor(i);
        scin.close();
    }
    */
    
    /*
     * Exemplo de método com output
     
    private void trataConsultarUltValor() {
        System.out.println("Último valor: "+logNegocio.getUltValor());
    }
    
    
    private void trataListarLog() {
        System.out.println(logNegocio.getValores());
    }
    */
    
    
    private void trataConsultaHotel(){
        Scanner in = new Scanner (System.in); 
        System.out.println("Código a consultar: ");
        String cod = in.nextLine(); 
        try{
        System.out.println(this.logNegocio.getHotel(cod).toString());
       }
       catch(HotelInexistenteException e){
         System.out.println(e.getMessage());
        }
    }
    
}



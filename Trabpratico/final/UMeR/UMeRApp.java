import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.TreeMap;
import java.util.Set;
import java.util.HashSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner; 
import Exceptions.*;

/**
 * Escreva a descrição da classe UMeRApp aqui.
 * 
 * @author celia
 * @version (número de versão ou data)
 */
public class UMeRApp{

    
    private static UMeR umer;
    private static UMeRMenu menu_principal,menu_registo,menu_motorista,
                   menu_cliente, menu_logado, menu_cliente_efetuarViagem, menu_admin;
                   
    private UMeRApp() {}
    
    /**
     * Função que faz executar toda a aplicação ImoobliáriaApp.
     */
    public static void main(String[] args) {
        String file_name = "UMeR_estado.obj";
        carregarMenus();
        initApp(file_name);
        apresentarMenu();
        atualizarApp(file_name);
        System.out.println("Volte sempre!");
    }

    /**
     * Apresenta o menu principal.
     */
    private static void apresentarMenu(){
        int running = 1;

        do {
            if(umer.getBaseDeDados() != null){
                menu_logado.executa();
                switch(menu_logado.getOpcao()){
                    case 1: menu();
                            break;
                    case 2: fecharSessao();
                            break;
                    case 0: running = 0;
                }

            }
            //TODO: apagar este else
            else{
                menu_principal.executa();
                switch (menu_principal.getOpcao()) {
                    case 1: registo();
                            break;
                    case 2: iniciarSessao();
                            break;
                    case 3: menu();
                            break;
                    case 0: running = 0;
                }
            }
        } while (running!=0);

    }

    /**
     * Apresenta o Menu consoante o tipo de utilizador com sessão iniciada.
     */
    private static void menu(){
        /*

        if(umer.getBaseDeDados() == null)
            running_menu_cliente();
       
            */
        }
    
    
    /**
     * Carrega todos os menus para apresentar.
     */
    private static void carregarMenus() {
        String[] menu0 = {"Menu",
                        "Fechar sessão"};
        String[] menu1 = {"Registar Utilizador",
                        "Iniciar sessão"};
        String [] menu2 = {"Motorista",
                           "Cliente"};
        String [] menu3 = {"Solicitar Viagem",
                           "Consultar listagem de viagems efetuadas"};
        String [] menu4 = {"Lista dos clientes que mais gastam",
                           };
        String [] menu5 = {"Lista de Carros de um dado tipo",
                           };
        String[] menu6 = {"Viagens Efetuadas (entre datas)",
                            "Ver 10 clientes que mais gastam"};
        String[] menu7 = {"Efetuar viagem"};

        menu_logado = new UMeRMenu(menu0);
        menu_registo = new UMeRMenu(menu1);
        menu_cliente = new UMeRMenu(menu3);
        menu_principal = new UMeRMenu(menu1);
        
        menu_motorista = new UMeRMenu(menu4);
        menu_cliente_efetuarViagem = new UMeRMenu(menu5);

    }

    /**
     * Carrega o estado da aplicação da última vez que esta foi fechada.
     * @param fich
     */
    private static void initApp(String fich){
        try {
            BDInterface bd = UMeR.leObj(fich);
            umer = new UMeR (bd);
        }
        catch (IOException e) {
            umer = new UMeR();
            System.out.println("Não consegui ler os dados!\nErro de leitura.");
        }
        catch (ClassNotFoundException e) {
            umer = new UMeR();
            System.out.println("Não consegui ler os dados!\nFicheiro com formato desconhecido.");
        }
        catch (ClassCastException e) {
            umer = new UMeR();
            System.out.println("Não consegui ler os dados!\nErro de formato.");
        }
    }
    
    /**
     * Atualiza o estado da aplicação.
     * @param fich
     */
    private static void atualizarApp(String fich){
        try {
            umer.gravaObj(fich);
            umer.log("log.txt", true);
        }
        catch (IOException e) {
            System.out.println("Não consegui gravar os dados!");
        }
    }

    /**
     * Registo na UMeRApp.
     */
    private static void registo(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        Ator ator;
        Scanner is = new Scanner(System.in);
        String input = is.nextLine();

        menu_registo.executa();
        if(menu_registo.getOpcao() !=0){
            String nome,email,password,morada;  LocalDate dataNascimento;
            int grauCumprimentoHorario, classificacao; 
            double totalKms;
            boolean disponivel, horarioTrabalho;
            float destreza;
            VeiculoInterface veiculo; 
            
            System.out.print("Nome: ");
            nome = is.nextLine();
            System.out.print("Email: ");
            email = is.nextLine();
            System.out.print("Password: ");
            password = is.nextLine();
            System.out.print("Morada: ");
            morada = is.nextLine();
            System.out.print("Data de nascimento: ");
            dataNascimento = LocalDate.parse(input,formatter);
            System.out.print("Grau de cumprimento de horário de motorista: ");
            grauCumprimentoHorario = is.nextInt();
            System.out.print("Classificação de motorista: ");
            classificacao = is.nextInt();
            System.out.print("Total de kms percorridos: ");
            totalKms = is.nextInt();
            System.out.print("Disponibilidade: ");
            disponivel = false; 
            System.out.print("Horário de trabalho: ");
            horarioTrabalho = false;
            System.out.print("Destreza: ");
            destreza = is.nextInt();
            
            
            
      
            switch(menu_registo.getOpcao()){
                case 1: ator = new Cliente(email,nome,password,morada,dataNascimento,null);
                        break;
                case 2: ator = new Motorista(email, nome, password, morada, dataNascimento, grauCumprimentoHorario,
                classificacao, totalKms, disponivel, horarioTrabalho, destreza, null);
                        break;
                default: ator = new Cliente();
            }
            /*
            try{
                umer.registarUtilizador(ator);
            }
            catch(UtilizadorExistenteException e){
                System.out.println("Este utizador já existe!");
            }*/
        }
        else System.out.println("Registo cancelado!");
        is.close();
    }

    /**
     * Inicio de sessão na UMeRApp.
     */
    private static void iniciarSessao(){
        Scanner is = new Scanner(System.in);
        String email,password;
        System.out.print("E-mail: ");
        email = is.nextLine();
        System.out.print("Password: ");
        password = is.nextLine();

        try{
            umer.iniciaSessao(email,password);
        }
        catch(SemAutorizacaoException e){
            System.out.println(e.getMessage());
        }

        is.close();
    }

    /**
     * Fechar sessão na UMeRApp.
     */
    private static void fecharSessao(){
        umer.fechaSessao();
    }
    
    /**
     * Executar o menu para utilizadores não registados na UMeRApp.
     */
    /*
     private static void running_menu_cliente(){
        do{
            menu_cliente.executa();
            switch(menu_cliente.getOpcao()){
                case 1: solicitarViagem();
                        break;
                case 2: habitaveisPreco();
                        break;
                case 3: imoveisVendedores();
                        break;
            }
        }while(menu_cliente.getOpcao()!=0);
    }
    */

    /**
     * Executar menu para vendedores.
     */
    private static void running_menu_admin(){
        do{
            menu_admin.executa();
            switch(menu_admin.getOpcao()){
                case 1: System.out.println("AdicionavEICULO"); //adicionaVeiculo();
                        break;
                case 2: System.out.println("Adiciona MOTORISTA");//adicionaMotorista();
                        break;
            }
        }while(menu_admin.getOpcao()!=0);
    }
    
    
   
    

    
}

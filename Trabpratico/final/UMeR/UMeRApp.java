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
    private static UMeRMenu menu_principal,menu_registar_atores,menu_motorista,
                   menu_cliente, menu_dados_pessoais, menu_cliente_efetuarViagem, menu_admin;
                   
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

        menu_principal.executa();
        switch(menu_principal.getOpcao()){
            case 1: menuRegistarAtor();
                break;
            case 2: menuIniciarSeccao();
                break;
            case 0: break;
            default: menuErro();
                apresentarMenu();
                break;
        }
    }
   
    
    private static void menuRegistarAtor(){
        menu_registar_atores.executa();
        int opcao = menu_registar_atores.getOpcao();
        
        if(opcao != 0){
            menuRegistar(opcao);
        }
        else {
           apresentarMenu();
        }  
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
        String[] menu1 = {"Registar Utilizador",
                        "Iniciar sessão"};
        String [] menu2 = {"Cliente",
                           "Motorista"};
        String [] menu3 = {"Solicitar Viagem",
                           "Consultar listagem de viagems efetuadas", 
                           "Ver Dados Pessoais"};
        String [] menu4 = {"XXXX",
                           };
        String [] menu5 = {"Lista dos clientes que mais gastam",
                           };
        String [] menu6 = {"Lista de Carros de um dado tipo",
                           };
        String[] menu7 = {"Viagens Efetuadas (entre datas)",
                            "Ver 10 clientes que mais gastam"};
        String[] menu8 = {"Efetuar viagem"};
        
        String[] menu9 = {"Editar Dados"};


        menu_principal = new UMeRMenu("Menu Inicial", menu1);
        menu_registar_atores = new UMeRMenu("Escolha o tipo de utilizador a registar", menu2);
        menu_cliente = new UMeRMenu("Menu - cliente", menu3);
        menu_motorista = new UMeRMenu("Menu - Motoristas", menu4);
        menu_admin = new UMeRMenu("Menu - Motoristas", menu5);
        menu_cliente_efetuarViagem = new UMeRMenu(menu5);
        menu_dados_pessoais = new UMeRMenu("Opçoes Dados Pessoais", menu9);
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
    private static void menuRegistar(int opcao){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        AtorInterface ator;
        Scanner is = new Scanner(System.in);

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
        System.out.print("Data de nascimento (YYYY-MM-DD): ");
        dataNascimento = LocalDate.parse(is.nextLine(),formatter);
        
        
        /* Estes dados sao inseridos depois de fazer loggin e outros sao inseridos com base das viagens feitas
        if(opcao == 2){
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
        }
        */
        
        is.close();
        
        switch(opcao){
            case 1: ator = new Cliente(email, nome, password, morada, dataNascimento, new Coordenadas());
                    break;
            case 2: ator = new Motorista(email, nome, password, morada, dataNascimento);
                    break;
            case 3: ator = new Admin(email, nome, password, morada, dataNascimento, new Coordenadas());
                    break;
            default: ator = new Cliente();
        }
        
        
        try{
            umer.registarUtilizador(ator);
            //antes de apresentar o menu apresentar mensagem de sucesso.
            apresentarMenu();     
        }
        catch(AtorExistenteException e){
            System.out.println("Este utizador já existe!");
            //TODO: Apresentar mensagem de erro e depois esperar por um entrar e voltar para o menu principal (inicial);   
            apresentarMenu();
        }
        
    }

    /**
     * Inicio de sessão na UMeRApp.
     */
    private static void menuIniciarSeccao(){
        Scanner is = new Scanner(System.in);
        String email, password;
        System.out.print("E-mail: ");
        email = is.nextLine();
        System.out.print("Password: ");
        password = is.nextLine();
        is.close();

        try{
            umer.iniciaSessao(email,password);
            menuOpcoesAtores();
        }
        catch(SemAutorizacaoException e){
            System.out.println(e.getMessage());
            //TODO: Se falhar deve apresentar uma mensagem para voltar a tentar ou sair.
            menuIniciarSeccao();
        }
    }
    
    
    
    /**
     * Menu por tipo de utilizador.
     */
    private static void menuOpcoesAtores(){
        AtorInterface ator = umer.getAtorLoggado();
        if(ator instanceof Cliente ){
            menuCliente();
        }
        
        if(ator instanceof Motorista){
             //menu_motorista.executa();
        }
        
        if(ator instanceof Admin){
            // menu_admin.executa();
        }
       
    }
    
    private static void menuCliente(){
        menu_cliente.executa();
        switch(menu_cliente.getOpcao()){
            case 1: solicitarViagem();
                break;
            case 2: verHistoricoViagens();
                break;
            case 3: verDadosPessoais();
                break;
            case 0: fecharSessao();
                break;
            default: menuErro();
                menuCliente();
                break;
        }
    }
    
    private static void solicitarViagem(){
    
    }
    
    private static void verHistoricoViagens(){
    
    }
    
    private static void verDadosPessoais(){
        System.out.print("*********** Dados Pessoais ***************");
        System.out.print(umer.getAtorLoggado().toString());
        System.out.print("*********** Dados Pessoais ***************");
        menuEditarDadosPessoais();
    }
    
    private static void menuEditarDadosPessoais(){
        menu_dados_pessoais.executa();
        switch(menu_dados_pessoais.getOpcao()){
            case 1: editarDadosPessoais();
                break;
            case 0: menuCliente();
                break;
            default: menuErro();
                menuEditarDadosPessoais();
                break;
        }
    }
    
    private static void editarDadosPessoais(){
        
    }

    /**
     * Fechar sessão na UMeRApp.
     */
    private static void fecharSessao(){
        umer.fechaSessao();
        apresentarMenu();
    }

    /**
     * Executar menu para vendedores.
     */
    private static void running_menu_admin(){
        do{
            menu_admin.executa();
            switch(menu_admin.getOpcao()){
                case 1: System.out.println("Adiciona Veiculo"); //adicionaVeiculo();
                        break;
                case 2: System.out.println("Adiciona Motorista");//adicionaMotorista();
                        break;
            }
        }while(menu_admin.getOpcao()!=0);
    }
    
    private static void menuErro(){
        System.out.println("Opçao invalida! Volta a tentar");
    }
    
    
   
    

    
}

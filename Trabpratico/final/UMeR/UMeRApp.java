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
 * @author celia @version (número de versão ou data)
 */
public class UMeRApp
{
    private static UMeR umer;
    private static UMeRMenu menu_principal;
    private static UMeRMenu menu_registar_atores;
    private static UMeRMenu menu_motorista;
    private static UMeRMenu menu_cliente;
    private static UMeRMenu menu_dados_pessoais;
    private static UMeRMenu menu_cliente_efetuarViagem;
    private static UMeRMenu menu_admin;

    /**
     * 
     */
    private UMeRApp()
    {
    }

    /**
     * Função que faz executar toda a aplicação ImoobliáriaApp.
     */
    static public void main(String[] args)
    {
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
    static private void apresentarMenu()
    {
        int running = 1;
        menu_principal.executa();
        switch (menu_principal.getOpcao()) {
            case 1 : {
                menuRegistarAtor();
                break;
            }
            case 2 : {
                menuIniciarSeccao();
                break;
            }
            case 0 : {
                break;
            }
            default : {
                menuErro();
                apresentarMenu();
                break;
            }
        }
        umer.setTentativasDeLoginFalhadas(0);
    }

    /**
     * 
     */
    static private void menuRegistarAtor()
    {
        menu_registar_atores.executa();
        int opcao = menu_registar_atores.getOpcao();
        if (opcao != 0) {
            menuRegistar(opcao);
        }
        else {
            apresentarMenu();
        }
    }

    /**
     * Apresenta o Menu consoante o tipo de utilizador com sessão iniciada.
     */
    static private void menu()
    {
        /* if(umer.getBaseDeDados() == null) running_menu_cliente();*/
    }

    /**
     * Carrega todos os menus para apresentar.
     */
    static private void carregarMenus()
    {
        String[] menu1 = {"Registar Utilizador", "Iniciar sessão"};
        String[] menu2 = {"Cliente", "Motorista"};
        String[] menu3 = {"Solicitar Viagem", "Consultar listagem de viagems efetuadas", "Ver Dados Pessoais"};
        String[] menu4 = {"XXXX", };
        String[] menu5 = {"Lista dos utilizadores registados", "Lista dos clientes que mais gastam"};
        String[] menu6 = {"Lista de Carros de um dado tipo", };
        String[] menu7 = {"Viagens Efetuadas (entre datas)", "Ver 10 clientes que mais gastam"};
        String[] menu8 = {"Efetuar viagem"};
        String[] menu9 = {"Editar Dados"};
        menu_principal =  new  UMeRMenu("Menu Inicial", menu1);
        menu_registar_atores =  new  UMeRMenu("Escolha o tipo de utilizador a registar", menu2);
        menu_cliente =  new  UMeRMenu("Menu - cliente", menu3);
        menu_motorista =  new  UMeRMenu("Menu - Motoristas", menu4);
        menu_admin =  new  UMeRMenu("Menu - Admin", menu5);
        menu_cliente_efetuarViagem =  new  UMeRMenu(menu5);
        menu_dados_pessoais =  new  UMeRMenu("Opçoes Dados Pessoais", menu9);
    }

    /**
     * Carrega o estado da aplicação da última vez que esta foi fechada. @param fich
     */
    static private void initApp(String fich)
    {
        try {
            BDInterface bd = UMeR.leObj(fich);
            umer =  new  UMeR(bd);
            adicionarAdminPorDefeito();
        }
        catch (IOException e) {
            umer =  new  UMeR();
            System.out.println("Não consegui ler os dados!\nErro de leitura.");
        }
        catch (ClassNotFoundException e) {
            umer =  new  UMeR();
            System.out.println("Não consegui ler os dados!\nFicheiro com formato desconhecido.");
        }
        catch (ClassCastException e) {
            umer =  new  UMeR();
            System.out.println("Não consegui ler os dados!\nErro de formato.");
        }
    }

    /**
     * 
     */
    static private void adicionarAdminPorDefeito()
    {
        if ( ! umer.temAdminsRegistados()) {
            AtorInterface admin =  new  Admin("admin@admin.com", Utils.encriptar("admin"), "admin", null, null,  new  Coordenadas());
            try {
                umer.registarUtilizador(admin);
            }
            catch (AtorExistenteException e) {
                System.out.println("Nao e possivel registar admin default: " + e.getMessage());
            }
        }
    }

    /**
     * Atualiza o estado da aplicação. @param fich
     */
    static private void atualizarApp(String fich)
    {
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
    static private void menuRegistar(int opcao)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        AtorInterface ator;
        Scanner is =  new  Scanner(System.in);
        String nome;
        String email;
        String password;
        String morada;
        LocalDate dataNascimento;
        int grauCumprimentoHorario;
        int classificacao;
        double totalKms;
        boolean disponivel;
        boolean horarioTrabalho;
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
        dataNascimento = LocalDate.parse(is.nextLine(), formatter);
        /* Estes dados sao inseridos depois de fazer loggin e outros sao inseridos com base das viagens feitas if(opcao == 2){ System.out.print("Grau de cumprimento de horário de motorista: "); grauCumprimentoHorario = is.nextInt(); System.out.print("Classificação de motorista: "); classificacao = is.nextInt(); System.out.print("Total de kms percorridos: "); totalKms = is.nextInt(); System.out.print("Disponibilidade: "); disponivel = false; System.out.print("Horário de trabalho: "); horarioTrabalho = false; System.out.print("Destreza: "); destreza = is.nextInt(); }*/
        is.close();
        switch (opcao) {
            case 1 : {
                ator =  new  Cliente(email, nome, password, morada, dataNascimento,  new  Coordenadas());
                break;
            }
            case 2 : {
                ator =  new  Motorista(email, nome, password, morada, dataNascimento);
                break;
            }
            case 3 : {
                ator =  new  Admin(email, nome, password, morada, dataNascimento,  new  Coordenadas());
                break;
            }
            default : {
                ator =  new  Cliente();
            }
        }
        try {
            umer.registarUtilizador(ator);
            /* antes de apresentar o menu apresentar mensagem de sucesso.*/
            apresentarMenu();
        }
        catch (AtorExistenteException e) {
            System.out.println("Este utizador já existe!");
            /* TODO: Apresentar mensagem de erro e depois esperar por um entrar e voltar para o menu principal (inicial);*/
        }
    }

    /**
     * Inicio de sessão na UMeRApp.
     */
    static private void menuIniciarSeccao()
    {
        Scanner is =  new  Scanner(System.in);
        String email;
        String password;
        System.out.print("E-mail: ");
        email = is.nextLine();
        System.out.print("Password: ");
        password = is.nextLine();
        is.close();
        try {
            umer.iniciaSessao(email, password);
            menuOpcoesAtores();
        }
        catch (SemAutorizacaoException e) {
            System.out.println(e.getMessage());
            /* TODO: Se falhar deve apresentar uma mensagem para voltar a tentar ou sair.*/
            if (umer.getTentativasDeLoginFalhadas() < 3) {
                umer.adicionarTentativaDeLoginFalhadas();
                menuIniciarSeccao();
            }
            else {
                System.out.println("Falhou o login 3 vezes. Por favor tente mais tarde");
                apresentarMenu();
                umer.setTentativasDeLoginFalhadas(0);
            }
        }
    }

    /**
     * Menu por tipo de utilizador.
     */
    static private void menuOpcoesAtores()
    {
        AtorInterface ator = umer.getAtorLoggado();
        if (ator instanceof Cliente) {
            menuCliente();
        }
        if (ator instanceof Motorista) {
            /* menu_motorista.executa();*/
        }
        if (ator instanceof Admin) {
            menuAdmin();
        }
    }

    /**
     * 
     */
    static private void menuCliente()
    {
        menu_cliente.executa();
        switch (menu_cliente.getOpcao()) {
            case 1 : {
                solicitarViagem();
                break;
            }
            case 2 : {
                verHistoricoViagens();
                break;
            }
            case 3 : {
                verDadosPessoais();
                break;
            }
            case 0 : {
                fecharSessao();
                break;
            }
            default : {
                menuErro();
                menuCliente();
                break;
            }
        }
    }

    /**
     * 
     */
    static private void solicitarViagem()
    {
    }

    /**
     * 
     */
    static private void verHistoricoViagens()
    {
    }

    /**
     * 
     */
    static private void verDadosPessoais()
    {
        System.out.print("\n*********** Dados Pessoais ***************\n");
        System.out.print(umer.getAtorLoggado().toString());
        System.out.print("\n*********** Dados Pessoais ***************\n");
        menuEditarDadosPessoais();
    }

    /**
     * 
     */
    static private void menuEditarDadosPessoais()
    {
        menu_dados_pessoais.executa();
        switch (menu_dados_pessoais.getOpcao()) {
            case 1 : {
                editarDadosPessoais();
                break;
            }
            case 0 : {
                menuCliente();
                break;
            }
            default : {
                menuErro();
                menuEditarDadosPessoais();
                break;
            }
        }
    }

    /**
     * 
     */
    static private void editarDadosPessoais()
    {
    }

    /**
     * 
     */
    static private void menuAdmin()
    {
        menu_admin.executa();
        switch (menu_admin.getOpcao()) {
            case 1 : {
                listaUtilizadores();
                break;
                /* TODO: adicionar menus das outras funcionaldiade do admin case 2: verHistoricoViagens(); break; case 3: verDadosPessoais(); break;*/
            }
            case 0 : {
                fecharSessao();
                break;
            }
            default : {
                menuErro();
                menuAdmin();
                break;
            }
        }
    }

    /**
     * 
     */
    static private void listaUtilizadores()
    {
        System.out.println("\n*********** Lista de Clientes ***************");
        List<AtorInterface> clientes = umer.listaClientes();
        for (final AtorInterface cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome() + " | Email: " + cliente.getEmail());
        }
        System.out.println("\n*********** Lista de Motoristas ***************");
        List<AtorInterface> motoristas = umer.listaMotoristas();
        for (final AtorInterface motorista : motoristas) {
            System.out.println("Nome: " + motorista.getNome() + " | Email: " + motorista.getEmail());
        }
        menuAdmin();
    }

    /**
     * Fechar sessão na UMeRApp.
     */
    static private void fecharSessao()
    {
        umer.fechaSessao();
        umer.setTentativasDeLoginFalhadas(0);
        apresentarMenu();
    }

    /**
     * Executar menu para vendedores.
     */
    static private void running_menu_admin()
    {
        menu_admin.executa();
        switch (menu_admin.getOpcao()) {
            case 1 : {
                System.out.println("Adiciona Veiculo");
                /* adicionaVeiculo();*/
                break;
            }
            case 2 : {
                System.out.println("Adiciona Motorista");
                /* adicionaMotorista();*/
                break;
            }
        }
    }

    /**
     * 
     */
    static private void menuErro()
    {
        System.out.println("Opçao invalida! Volta a tentar");
    }
}

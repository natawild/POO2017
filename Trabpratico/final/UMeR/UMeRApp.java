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
 * @author celia @version 1.0
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
    private static UMeRMenu menu_registar_veiculos;
    private static UMeRMenu menu_solicitarViagem; 
    private static UMeRMenu menu_inserir_coord_destino;
    /**
     * 
     */
    private UMeRApp()
    {
    }

    /**
     * Função que faz executar toda a aplicação UMeR.
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
        String[] menu4 = {"Iniciar Viagem", "Visualizar Histórico de viagens (entre datas)", 
                            "Visualizar 10 melhores clientes", "Registar Veiculo", "Ver Dados Pessoais"};
        String[] menu5 = {"Registar Veiculo","Remover Veiculo ", "Ver Lista dos utilizadores registados",
                            "Ver Lista dos Veiculos Registados", "Ver Lista dos clientes que mais gastam", 
                            "Ver Dados Pessoais"};
        String[] menu6 = {"Lista de Carros de um dado tipo" };
        String[] menu7 = {"Viagens Efetuadas (entre datas)", "Ver 10 clientes que mais gastam"};
        String[] menu8 = {"Moto", "Carro Ligeiro", "Carrinha", "Moto Com Fila de Espera", 
                        "Carro Ligeiro Com Fila de Espera", "Carrinha Com Fila de Espera","Voltar para trás"};
        String[] menu9 = {"Escolher táxi mais Próximo", "Escolher táxi especifico com fila de Espera"};
        String[] menu10 = {"Editar Dados"};
        String[] menu11 = {"Inserir Coordenadas"}; 
        
        menu_principal =  new  UMeRMenu("Menu Inicial", menu1);
        menu_registar_atores =  new  UMeRMenu("Escolha o tipo de utilizador a registar", menu2);
        menu_cliente =  new  UMeRMenu("Menu - Cliente", menu3);
        menu_motorista =  new  UMeRMenu("Menu - Motoristas", menu4);
        menu_solicitarViagem = new UMeRMenu("Menu - Solicitar Viagem", menu9);
        menu_admin =  new  UMeRMenu(" Menu - Admin ", menu5);
        menu_registar_veiculos = new UMeRMenu ("Registar Veiculos", menu8); 
        menu_cliente_efetuarViagem =  new  UMeRMenu(menu8);
        menu_dados_pessoais =  new  UMeRMenu("Opçoes Dados Pessoais", menu10);
        menu_inserir_coord_destino = new UMeRMenu ("Inserir Coordenadas de destino", menu11); 
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
            AtorInterface admin =  new  Admin("admin@admin.com", "admin", "admin", null, null,  new  Coordenadas());
            try {
                umer.registarUtilizador(admin);
            }
            catch (AtorExistenteException e) {
                System.out.println("Nao e possivel registar admin default: " + e.getMessage());
            }
        }
    }

    /**
     * Atualiza o estado da aplicação. 
     * @param fich
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
            System.out.print ('\f');
            System.out.print("Parabéns está registado na UMeR!");
            apresentarMenu();
        }
        catch (AtorExistenteException e) {
            System.out.println("Este utizador já existe!");
            /* TODO: Apresentar mensagem de erro e depois esperar por um entrar e voltar para o menu principal (inicial);*/
            apresentarMenu();
        }
    }
    
    
    /**
     * Registo na UMeRApp.
     */
    static private void menuAtualizarAtor()
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
        System.out.print("Password: ");
        password = is.nextLine();
        System.out.print("Morada: ");
        morada = is.nextLine();
        System.out.print("Data de nascimento (YYYY-MM-DD): ");
        dataNascimento = LocalDate.parse(is.nextLine(), formatter);
        is.close();
        
        AtorInterface atorLogado = umer.getAtorLoggado();
        
        if(atorLogado instanceof Cliente){
            ator =  new  Cliente(atorLogado.getEmail(), nome, password, morada, dataNascimento,  new  Coordenadas());
        }
        else if(atorLogado instanceof Motorista){
            ator =  new  Motorista(atorLogado.getEmail(), nome, password, morada, dataNascimento);
        }
        else{       
            ator =  new  Admin(atorLogado.getEmail(), nome, password, morada, dataNascimento,  new  Coordenadas());
        }
        umer.atualizarUtilizador(ator);
        System.out.print ('\f');
        System.out.print("Parabéns atualizou os seus dados pessoais\n");
        //Tem de voltar ao menus anterior/ meno do tipo de ator
        if(atorLogado instanceof Cliente){
            menuCliente();  
        }
        else if(atorLogado instanceof Motorista){
            menuMotorista();  
        }
        else{ menuAdmin();       
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
            if (umer.getTentativasDeLoginFalhadas() < 2) {
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
           menuMotorista();
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
                inserirCoordenadas(); 
                break;
            }
            case 2 : {
                verHistoricoViagensEntreDatas();
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

   
    
    static private void menuInserirCoordenadas(){
        Scanner is =  new  Scanner(System.in);
        //Coordenadas localizacao = new Coordenadas(); 
        double x; 
        double y; 
        System.out.println("Introduza a coordenada x: (0,0 a 80,0)"); 
        x = is.nextDouble();
        System.out.println("Introduza a coordenada y: (0,0 a 80,0)"); 
        y = is.nextDouble();
        is.close();
        Coordenadas localizacao = new Coordenadas(x,y);
        System.out.println("Introduziu as coordenadas " +localizacao+ " com sucesso! ");
        
        solicitarViagem(); 
        
    }
    
    static private void inserirCoordenadas(){
        menu_inserir_coord_destino.executa(); 
        switch (menu_inserir_coord_destino.getOpcao()) {
            case 1 : {
                menuInserirCoordenadas(); 
                break; 
            }
            
            default : {
                menuErro();
                break;
            }
        }
    }
    
    /**
     * 
     */
    static  private  void solicitarViagem(){
        menu_solicitarViagem.executa(); 
        switch (menu_solicitarViagem.getOpcao()) {
            case 1 : {
                requisitarTaxiMaisProx();
                break;
            }
            case 2 : {
                requisitarTaxiEspecifico();
                break;
            }
            
            case 0:{
                menuCliente(); 
            }
            default : {
                menuErro();
                break;
            }
        }
 
    }
    
    /**
     * Requisitar taxi mais próximo de um cliente logado 
     */
    static private void requisitarTaxiMaisProx(){
       System.out.println("\n*********** Taxi mais próximo:  ***************");
       AtorInterface ator = umer.getAtorLoggado();
       if (ator instanceof Cliente) {
           Cliente clientelogado = (Cliente) ator;
           umer.motoristaMaisPertoCliente(clientelogado);   
       }
       System.out.println();
    }

    /**
     * 
     */
    static private void verHistoricoViagensEntreDatas(){
      
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
    static private void menuEditarDadosPessoais(){
        AtorInterface ator = umer.getAtorLoggado(); 
        menu_dados_pessoais.executa();
        switch (menu_dados_pessoais.getOpcao()) {
            case 1 : {
                if(ator instanceof Cliente){
                    editarDadosPessoais();
                    umer.atualizarUtilizador(ator);
                }
                else if(ator instanceof Motorista){
                    editarDadosPessoais();
                    umer.atualizarUtilizador(ator);
                }
                else {
                    editarDadosPessoais();
                    umer.atualizarUtilizador(ator);   
                }
                break;
            }
    
            case 0 : {
                fecharSessao();
                break;
            }

             default : {
                menuErro();
                menuEditarDadosPessoais();
                break;
            }
        }
   }

   
    
    static private void requisitarTaxiEspecifico(){
    
    }
    

    /**
     * 
     */
    static private void editarDadosPessoais(){
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
        System.out.print("Password: ");
        password = is.nextLine();
        System.out.print("Morada: ");
        morada = is.nextLine();
        System.out.print("Data de nascimento (YYYY-MM-DD): ");
        dataNascimento = LocalDate.parse(is.nextLine(), formatter);
        is.close();
        
        AtorInterface atorLogado = umer.getAtorLoggado();
        
        if(atorLogado instanceof Cliente){
            ator =  new  Cliente(atorLogado.getEmail(), nome, password, morada, dataNascimento,  new  Coordenadas());
        }
        else if(atorLogado instanceof Motorista){
            ator =  new  Motorista(atorLogado.getEmail(), nome, password, morada, dataNascimento);
        }
        else{       
            ator =  new  Admin(atorLogado.getEmail(), nome, password, morada, dataNascimento,  new  Coordenadas());
        }
        umer.atualizarUtilizador(ator);
        System.out.print ('\f');
        System.out.print("Parabéns atualizou os seus dados pessoais\n");
        //Tem de voltar ao menus anterior/ meno do tipo de ator
        if(atorLogado instanceof Cliente){
            menuCliente();  
        }
        else if(atorLogado instanceof Motorista){
            menuMotorista();  
        }
        else{ menuAdmin();       
        }
        
        
    }

    
    static private void menuMotorista()
    {
        menu_motorista.executa();
        switch (menu_motorista.getOpcao()) {
            case 1 : {
                iniciarViagem();
                break;
                /* TODO: adicionar menus das outras funcionaldiade do admin case 2: verHistoricoViagens(); break; case 3: verDadosPessoais(); break;*/
            }
            case 2 : {
                visualizarHistorico();
                break;
            }
            case 3 : {
                visualizarMelhoresClientes();
                break;
            }
            case 4 : {
                MenuRegistarVeiculo();
                break;
            }
            
            case 5: {
                verDadosPessoais();
                break; 
            }
            
            case 0 : {
                fecharSessao();
                break;
            }
            default : {
                menuErro();
                break;
            }
        }
        
    }
    
    
    static private void iniciarViagem(){
    
    }
    
    static private void visualizarHistorico(){
    
    }
    
    static private void visualizarMelhoresClientes(){
    
    }
    
    
    /**
     * 
     */
    static private void menuAdmin()
    {
        menu_admin.executa();
        switch (menu_admin.getOpcao()) {
            case 1 : {
                MenuRegistarVeiculo(); 
                break; 
            }
            
            case 2 : {
                removerVeiculo(); 
                break; 
            }
            
            case 3 : {
                listaUtilizadores();
                break;
                /* TODO: adicionar menus das outras funcionaldiade do admin case 2: verHistoricoViagens(); break; case 3: verDadosPessoais(); break;*/
            }
            
            case 4: {
                listaVeiculos(); 
                break;
            }

            case 5: {
                listaUtilizadoresMaisGastamNaUMeR(); 
                break; 
            
            }
            
            case 6 : {
                verDadosPessoais();
                break; 
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

    static private void registarVeiculo(int opcao){
        AtorInterface atorLogado = umer.getAtorLoggado();
   
        VeiculoInterface veiculo;
        Scanner is =  new  Scanner(System.in);
        String matricula;
        String marca;
        float fiabilidade;
        System.out.print("Matricula: ");
        matricula = is.nextLine();
        System.out.print("Marca: ");
        marca = is.nextLine();
        System.out.print("Fiabilidade (0,8 a 1,2): ");
        fiabilidade = is.nextFloat();
        List<Cliente> filaEspera = new ArrayList<>(); 

        /* Estes dados sao inseridos depois de fazer loggin e outros sao inseridos com base das viagens feitas if(opcao == 2){ System.out.print("Grau de cumprimento de horário de motorista: "); grauCumprimentoHorario = is.nextInt(); System.out.print("Classificação de motorista: "); classificacao = is.nextInt(); System.out.print("Total de kms percorridos: "); totalKms = is.nextInt(); System.out.print("Disponibilidade: "); disponivel = false; System.out.print("Horário de trabalho: "); horarioTrabalho = false; System.out.print("Destreza: "); destreza = is.nextInt(); }*/
        is.close();
        switch (opcao) {
            case 1 : {
                veiculo =  new  Moto(matricula, marca, fiabilidade, new  Coordenadas());
                break;
            }
            case 2 : {
                veiculo =  new  CarroLig(matricula, marca,  fiabilidade, new  Coordenadas());
                break;
            }
            case 3 : {   
                veiculo =  new  Carrinha(matricula, marca,  fiabilidade, new  Coordenadas());
                break;
            }
            case 4 : {
                veiculo =  new  MotoFilaEspera(matricula, marca, fiabilidade, new  Coordenadas(),filaEspera);
                break;
            }
            case 5 : {
                veiculo =  new  CarroFilaEspera(matricula, marca,  fiabilidade, new  Coordenadas(), filaEspera);
                break;
            }
            case 6 : {   
                veiculo =  new  CarrinhaFilaEspera(matricula, marca,  fiabilidade, new  Coordenadas(), filaEspera);
                break;
            }
            
            default : {
                veiculo =  new  CarroLig();
            }
        }
        try {
            umer.registarViatura(veiculo);//registei o veiculo
            /*
            AtorInterface atorLogadoAtualizado = ((Motorista) umer.getAtorLoggado()).setVeiculo(veiculo);
            umer.setAtorLoggado(atorLogadoAtualizado); 
            */
            umer.atualizaVeiculoAtorLogado(veiculo); 
            System.out.print("Veiculo Registado na UMeR!");
            /* antes de apresentar o menu apresentar mensagem de sucesso.*/
           if(atorLogado instanceof Admin){
            menuAdmin(); 
           }
            else if(atorLogado instanceof Motorista){
            menuMotorista();  
           }
        }
        catch (ViaturaExistenteException e) {
            System.out.println("Este veiculo já existe!");
            /* TODO: Apresentar mensagem de erro e depois esperar por um entrar e voltar para o menu principal (inicial);*/
            MenuRegistarVeiculo(); 
        }

     }
     
     /**
     * 
     */
    static private void MenuRegistarVeiculo()
    {
        menu_registar_veiculos.executa();
        int opcao = menu_registar_veiculos.getOpcao();
   
        if (opcao != 0) {
            registarVeiculo(opcao);
        }
        else {
            apresentarMenu();
        }
    }
  
    
    /**
     * Admin remove veiculo da base de dados 
     */
    static private void removerVeiculo(){
        /*
        Veiculo veiculo; 
        umer.listaVeiculos().remove(veiculo.getMatricula());
        */
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
    
    
    static private void listaVeiculos(){
        System.out.println("\n*********** Lista de Veiculos ***************");
        List<VeiculoInterface> veiculos = umer.listaVeiculos();
        for (final VeiculoInterface veiculo : veiculos) {
            System.out.println("Matricula: " + veiculo.getMatricula() + " | Marca: " + veiculo.getMarca());
        }
        menuAdmin();
    }

    static private void listaUtilizadoresMaisGastamNaUMeR(){
    
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
     * Executar menu para administradores.
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

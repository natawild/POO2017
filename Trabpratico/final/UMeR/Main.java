import java.time.LocalDate; 
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import Exceptions.*;
import java.io.IOException;
/**
 * Escreva a descrição da classe Main aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Main
{
    public static void main(String[] args){
        BDInterface baseDados = new BD (); 
        
        Cliente cliente1 = new Cliente(); 
        cliente1.setNome("Rui"); 
        cliente1.setEmail("rui@rui.com"); 
        cliente1.setPassword(Utils.encriptar("rui")); 
        cliente1.setMorada("Rua da costa ");
        LocalDate dataNas1 = LocalDate.of (1993,12,24); 
        cliente1.setDataNascimento(dataNas1); 
        baseDados.addCliente(cliente1);
        //System.out.println(cliente1.toString());
        
        Coordenadas localizacao2 = new Coordenadas();
        LocalDate dataNas2 = LocalDate.of (1993,12,24); 
        Cliente cliente2 = new Cliente("celia@celia.com","Celia", Utils.encriptar("celia"), "Rua do cão", dataNas2, localizacao2, false);
        //System.out.println(cliente2.toString());
        baseDados.addCliente(cliente2);
        
        localizacao2 = new Coordenadas();
        dataNas1 = LocalDate.of (1993,12,24); 
        Cliente cliente3 = new Cliente("luis@luis.com","Luis", Utils.encriptar("luis"), "Rua da cinderela", dataNas2, localizacao2, false);
        //System.out.println(cliente2.toString());
        baseDados.addCliente(cliente3);
        
        VeiculoInterface v1 = new CarroLig("qt-76-22","Mercedes", 0.8f, new Coordenadas(20, 40)); 
        VeiculoInterface v2 = new Carrinha("qt-34-22","Renault", 1.2f, new Coordenadas(10, 15)); 
        VeiculoInterface v3 = new Moto("25-76-22","Fiat", 0.8f, new Coordenadas()); 
        
        baseDados.addVeiculo(v1); 
        baseDados.addVeiculo(v2); 
        baseDados.addVeiculo(v3); 
        
        LocalDate dataNasM2 = LocalDate.of (1989,12,24);
        Motorista motorista2 = new Motorista("acores@acores.com","João César", Utils.encriptar("acores"), "Rua Fábrica do pelo", 
        dataNasM2);
        motorista2.setDisponivel(true);
        motorista2.setHorarioTrabalho(true);
        motorista2.setVeiculo(v1);
        baseDados.addMotorista(motorista2); 
        
        dataNasM2 = LocalDate.of (1989,10,24);
        Motorista motorista3 = new Motorista("manuel@manuel.com","Manuel César", Utils.encriptar("manuel"), "Rua Conego do pelo", 
        dataNasM2);
        motorista3.setDisponivel(true);
        motorista3.setHorarioTrabalho(true);
        motorista3.setVeiculo(v2);
        baseDados.addMotorista(motorista3); 
        
        dataNasM2 = LocalDate.of (1989,11,24);
        Motorista motorista4 = new Motorista("rita@rita.com","Rita César", Utils.encriptar("rita"), "Rua Fábrica do sabão", 
        dataNasM2);
        motorista4.setVeiculo(v3);
        baseDados.addMotorista(motorista4); 
       
       Admin admin =  new  Admin("admin@admin.com", "admin", Utils.encriptar("admin"), null, null,  new  Coordenadas());
       baseDados.addAdmin(admin); 
        
        UMeR umer = new UMeR(baseDados); 
        
        try{
            umer.gravaObj("bdInicial.obj");
        }
        catch (IOException e ){
            System.out.println("Erro: " + e); 
        }
        
         /*
        Map<String, AtorInterface> list = ((BD)baseDados).getClientes();
        list.put(cliente2.getEmail(),cliente2.clone()); 
        ((BD)baseDados).setClientes(list);
       
        
        Coordenadas localizacaoCarr1 = new Coordenadas(10d, 4d); 
        VeiculoInterface v1 = new CarroLig("qt-76-22","Mercedes", 3f, localizacaoCarr1); 

        Motorista motorista1= new Motorista(); 
        motorista1.setNome("luis"); 
        motorista1.setEmail("olaluis@ola.com"); 
        motorista1.setPassword("tolinho"); 
        motorista1.setMorada("Rua da costa nr23");
        LocalDate dataNasM1 = LocalDate.of (1989,12,24); 
        motorista1.setDataNascimento(dataNasM1); 
        motorista1.setGrauCumprimentoHorario(3);
        motorista1.setClassificacao(80); 
        motorista1.setTotalKms(200); 
        motorista1.setDisponivel(true); 
        motorista1.setDestreza(1.5f); 
        motorista1.setVeiculo(v1); 
        //System.out.println(motorista1.toString());
        
        baseDados.addMotorista(motorista1);
        
        baseDados.addVeiculo(v1);
        Coordenadas localizacaoCarr2 = new Coordenadas(20d, 45d); 
        VeiculoInterface v2 = new CarroLig("25-99-PZ","Renault", 4f, localizacaoCarr2); 
        LocalDate dataNasM3 = LocalDate.of (1989,12,24);
        Motorista motorista4 = new Motorista("acores@gmail.com","João César", "Gostarias?", "Rua Fábrica do pelo", 
        dataNasM2, 2, 76, 320d, true,true, 1.3f,v2); 
        baseDados.addMotorista(motorista2); 
        baseDados.addVeiculo(v2);
        
        /*
        System.out.println(baseDados.toString());
        System.out.println("/////////");
        */
        
        //List<AtorInterface> list2 = ((BD)baseDados).getClientes(); 
        //list2.remove(cliente2); 
        //((BD)baseDados).setClientes(list2);
        //é o mesmo que as 3 linhas a cima.
        //((BD)baseDados).setClientes(((BD)baseDados).getClientes().remove(cliente2));
        
        //outra opção. A mais interessante porque não se tem de estar a fazer o set depois de adicionar
        //baseDados.removeCliente(cliente2);
        //baseDados.removeMotorista(motorista1); 
        
        /*
        List<AtorInterface> listm = ((BD)baseDados).getMotoristas(); 
        listm.remove(motorista1);
        ((BD)baseDados).setMotoristas(listm); 
        
        
        System.out.println("333333333333"+baseDados.toString());

        
        /*
        AtorInterface clientEnc = baseDados.findClientePeloNome("celia"); 
        if(clientEnc!=null){
            System.out.println("O cliente com o nome"+ clientEnc.getNome()+" tem os seguintes dados: \n"); 
            System.out.println(clientEnc.toString());
        }
        else{
        System.out.println("Cliente não encontrado \n");
        }
        
        Coordenadas localizacaoCarr3 = new Coordenadas(60d, 10d);
        VeiculoInterface v3 = new Carrinha("25-62-PZ", 41d, 3.0d, 1f, localizacaoCarr3);
        baseDados.addVeiculo(v3); 
        List<String> listMatriculas = baseDados.matriculasReg();
        
        System.out.println("As matriculas armezanadas na base de dados são: \n");
        for(String matricula: listMatriculas){
            System.out.println("Matricula: " + matricula);
        }
        System.out.println("Fim das matriculas encontradas \n");
        
        
       
     
        
       List <AtorInterface> listaClientes = baseDados.listaClientes();
       for(AtorInterface clientes: listaClientes){
            System.out.println("Clientes:++++++++++++++++++++ " + clientes);
        }
       
       UMeR programa = new UMeR(baseDados);
       Cliente clientePesquisado = programa.pesquisaCliente("ola@ola.com");
       Motorista motoristaMaisPerto = programa.getMotoristaMaisPerto(clientePesquisado);
       
       System.out.println("\n-------------------------Teste:Pesquisa de motorista mais perto---\n");
       System.out.println("Cliente: \n" + clientePesquisado);
       System.out.println("Motorista: \n" + motoristaMaisPerto);
       
      
       List<AtorInterface> listaClientes2 = programa.listaClientes(); 
       System.out.println("Lista de clientes......: \n" + listaClientes2);
       
       
       //Teste: adicionar a msm lista veiculos con file e sem fila
       /*
       MotoFilaEspera motaFila = new MotoFilaEspera();
       Moto motaSemFila = new Moto();
       
       boolean eVeiculoInterface = motaFila instanceof VeiculoInterface;
       
       System.out.println("motaFila instanceof VeiculoInterface: " + eVeiculoInterface );
       
       List<VeiculoInterface> veiculosComESemFiles = new ArrayList<VeiculoInterface>();
       veiculosComESemFiles.add(motaFila);
       veiculosComESemFiles.add(motaSemFila);
       
       System.out.println("\nLista de veiculos com e sem file de espera \n" + veiculosComESemFiles );
       
       System.out.println("\n motaSemFila instanceof FilaEsperaInterface: " + (motaSemFila instanceof FilaEsperaInterface) );
        
       */
      /*
      List<AtorInterface> lista3 = programa.findClientePeloNome ("ba");
      System.out.println("Os clientes com o nome ba são " +lista3); 
      
      Map<AtorInterface, VeiculoInterface> lista4 = programa.obterMapMotoVei();
      System.out.println("Os motoristas com os veiculos são os seguintes.......:  " +lista4); 
      
      
      Utils.Meteorologia.getEstadoTempo(); 
      System.out.println(Utils.Meteorologia.getEstadoTempo()); 
      
      Utils.Transito.getEstadoTransito(); 
      System.out.println(Utils.Transito.getEstadoTransito()); 
      
      
      /*
      
      System.out.println(programa.duracaoRealViagem(30d, 0.9f, 0.9f,0.9f,0.9f));
      
      System.out.println(programa.custoRealViagem(19.68d, 20, 2, 30));
      
     System.out.println( programa.custoRealViagem(29.69d, 50, 2, 46.15d));
     
     Cliente clienteN = new Cliente("celia2@gmail.com","Celia2", "batatas2", "Rua do cão", dataNas2, localizacao2);
     
     VeiculoInterface v3 = new CarroLig("25-99-PZZZZZZZ","Renault", 4f, localizacaoCarr2);
     
     try{
         programa.registarUtilizador(clienteN);
    }
    catch (AtorExistenteException e){
        System.out.println(e.getMessage());
    }
    System.out.println("----BD---");
    System.out.println(programa.getBaseDeDados());
    
     try{
         programa.iniciaSessao("olaluis@ola.com", "tolinho1");
    }
    catch (SemAutorizacaoException e){
        System.out.println(e.getMessage());
    }
    
    try{
        programa.registarViatura( v3);
    }
    catch(ViaturaExistenteException e) {
         System.out.println(e.getMessage());
        }
        
    System.out.println(programa.getBaseDeDados());
    
    Cliente clientePesquisado2 = programa.pesquisaCliente("celia2@gmail.com");
    Motorista motoristaMaisPert = programa.motoristaMaisPertoCliente(clientePesquisado);
    System.out.println("\n---Teste:Pesquisa de motorista mais perto da celia---\n");
       System.out.println("Cliente: \n" + clientePesquisado2);
       System.out.println("Motorista: \n" + motoristaMaisPert);
       
     
    /* Teste da leitura do ficheiro
    String file_name = "UMeR_estado.obj";
    UMeR umer = null;
    
    try {
        BDInterface bd = UMeR.leObj(file_name);
        umer = new UMeR (bd);
        System.out.println("DADOS DA BD");
        System.out.println(umer.toString());
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
    
        
    System.out.println("password: '"+ Utils.encriptar("admin") +"'");
      
    */
  }
  
  
}

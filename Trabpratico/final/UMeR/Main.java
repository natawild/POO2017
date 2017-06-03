import java.time.LocalDate; 
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import Exceptions.*;
import java.io.IOException;
import java.time.LocalDateTime; 
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
       
        
        Coordenadas localizacao2 = new Coordenadas();
        LocalDate dataNas2 = LocalDate.of (1993,12,24); 
        Cliente cliente2 = new Cliente("celia@celia.com","Celia", Utils.encriptar("celia"), "Rua do cão", dataNas2, localizacao2, false);
        baseDados.addCliente(cliente2);
        
        dataNas1 = LocalDate.of (1993,12,24); 
        Cliente cliente3 = new Cliente("luis@luis.com","Luis", Utils.encriptar("luis"), "Rua da cinderela", dataNas2, localizacao2, false);
        baseDados.addCliente(cliente3);
        
        dataNas1 = LocalDate.of (1993,01,24); 
        Cliente cliente4 = new Cliente("marcia@marcia.com","Márcia", Utils.encriptar("marcia"), "Rua da Televisão", dataNas2, localizacao2, false);
        baseDados.addCliente(cliente4);
        
        dataNas1 = LocalDate.of (1993,01,26); 
        Cliente cliente5 = new Cliente("celia@gmail.com","Célia", Utils.encriptar("celia"), "Rua das margaridas", dataNas2, localizacao2, false);
        baseDados.addCliente(cliente5);
        
        dataNas1 = LocalDate.of (1993,01,26); 
        Cliente cliente6 = new Cliente("carlosfaria@gmail.com","Carlos Faria", Utils.encriptar("carlosfaria"), "Rua dos cravos", dataNas2, localizacao2, false);
        baseDados.addCliente(cliente6);
        
        dataNas1 = LocalDate.of (1993,01,26); 
        Cliente cliente7 = new Cliente("adriana@adriana.com","Adriana Pereira", Utils.encriptar("adriana"), "Rua de Boticas", dataNas2, localizacao2, false);
        baseDados.addCliente(cliente7);
        
        dataNas1 = LocalDate.of (1993,01,25); 
        Cliente cliente8 = new Cliente("xavier@xavier.com","Xavier Francisco", Utils.encriptar("xavier"), "Rua dos pastorinhos", dataNas2, localizacao2, false);
        baseDados.addCliente(cliente8);
        
        dataNas1 = LocalDate.of (1993,01,01); 
        Cliente cliente9 = new Cliente("daniel@daniel.com","Daniel Faria", Utils.encriptar("daniel"), "Rua do Ouro", dataNas2, localizacao2, false);
        baseDados.addCliente(cliente9);
        
        dataNas1 = LocalDate.of (1993,01,01); 
        Cliente cliente10 = new Cliente("filipa@filipa.com","Filipa Faria", Utils.encriptar("filipa"), "Rua das avestruzes", dataNas2, localizacao2, false);
        baseDados.addCliente(cliente10);
        
        dataNas1 = LocalDate.of (1993,01,01); 
        Cliente cliente11 = new Cliente("nazare@nazare.com","Nazare Faria", Utils.encriptar("nazare"), "Rua da cunha", dataNas2, localizacao2, false);
        baseDados.addCliente(cliente11);
        
        dataNas1 = LocalDate.of (1993,01,01); 
        Cliente cliente12= new Cliente("nuno@nuno.com","Nuno Faria", Utils.encriptar("nuno"), "Rua do faro", dataNas2, localizacao2, false);
        baseDados.addCliente(cliente12);
        
        dataNas1 = LocalDate.of (1993,01,01); 
        Cliente cliente13 = new Cliente("carla@carla.com","Carla Faria", Utils.encriptar("carla"), "Rua do bairro", dataNas2, localizacao2, false);
        baseDados.addCliente(cliente13);
        
        dataNas1 = LocalDate.of (1993,01,01); 
        Cliente cliente14 = new Cliente("andreia@andreia.com","Andreia Faria", Utils.encriptar("andreia"), "Rua do bairro", dataNas2, localizacao2, false);
        baseDados.addCliente(cliente14);
        
        
        VeiculoInterface v1 = new CarroLig("qt-76-22","Mercedes", 0.8f, new Coordenadas()); 
        VeiculoInterface v2 = new Carrinha("qt-34-22","Renault", 1.2f, new Coordenadas()); 
        VeiculoInterface v3 = new Moto("25-76-22","Fiat", 0.8f, new Coordenadas()); 
        VeiculoInterface v4 = new CarroLig("23-az-24","Toyota", 0.9f, new Coordenadas()); 
        VeiculoInterface v5 = new Moto("10-az-24","Toyota", 0.9f, new Coordenadas()); 
        VeiculoInterface v6 = new Moto("23-az-20","Honda", 0.9f, new Coordenadas()); 
        VeiculoInterface v7 = new Carrinha("24-az-28","Honda", 0.8f, new Coordenadas()); 
        VeiculoInterface v8 = new Carrinha("25-fb-20","Volvo", 0.9f, new Coordenadas()); 
        VeiculoInterface v9 = new CarroLig("25-tr-19","BMW", 1.1f, new Coordenadas()); 
        VeiculoInterface v10 = new CarroLig("09-bm-09","Audi", 1.0f, new Coordenadas()); 
        
        baseDados.addVeiculo(v1); 
        baseDados.addVeiculo(v2); 
        baseDados.addVeiculo(v3); 
        baseDados.addVeiculo(v4); 
        baseDados.addVeiculo(v4);
        baseDados.addVeiculo(v6); 
        baseDados.addVeiculo(v7); 
        baseDados.addVeiculo(v8); 
        baseDados.addVeiculo(v9);
        baseDados.addVeiculo(v10);
        
        LocalDate dataNasM2 = LocalDate.of (1989,12,24);
        Motorista motorista2 = new Motorista("acores@acores.com","João César", Utils.encriptar("acores"), "Rua Fábrica do pelo", 
        dataNasM2);
        motorista2.setDisponivel(true);
        motorista2.setHorarioTrabalho(true);
        motorista2.setVeiculo(v1);
        motorista2.setGrauCumprimentoHorario(50); 
        motorista2.setClassificacao(37); 
        baseDados.addMotorista(motorista2); 
        
        dataNasM2 = LocalDate.of (1989,10,24);
        Motorista motorista3 = new Motorista("manuel@manuel.com","Manuel César", Utils.encriptar("manuel"), "Rua Conego do pelo", 
        dataNasM2);
        motorista3.setDisponivel(true);
        motorista3.setHorarioTrabalho(true);
        motorista3.setVeiculo(v2);
        motorista3.setGrauCumprimentoHorario(98); 
        motorista3.setClassificacao(70); 
        baseDados.addMotorista(motorista3); 
        
        dataNasM2 = LocalDate.of (1979,01,24);
        Motorista motorista4 = new Motorista("rita@rita.com","Rita César", Utils.encriptar("rita"), "Rua Fábrica do sabão", 
        dataNasM2);
        motorista4.setDisponivel(true);
        motorista4.setHorarioTrabalho(true);
        motorista4.setVeiculo(v4);
        motorista4.setGrauCumprimentoHorario(63); 
        motorista4.setClassificacao(50); 
        baseDados.addMotorista(motorista4); 
        
        dataNasM2 = LocalDate.of (1979,02,25);
        Motorista motorista5 = new Motorista("carlos@carlos.com","Carlos César", Utils.encriptar("carlos"), "Rua das Laranjas", 
        dataNasM2);
        motorista5.setDisponivel(true);
        motorista5.setHorarioTrabalho(true);
        motorista5.setVeiculo(v5);
        motorista5.setGrauCumprimentoHorario(73); 
        motorista5.setClassificacao(70); 
        baseDados.addMotorista(motorista5); 
        
        dataNasM2 = LocalDate.of (1979,02,25);
        Motorista motorista6 = new Motorista("antonio@antonio.com","António César", Utils.encriptar("antonio"), "Rua das batatas", 
        dataNasM2);
        motorista6.setDisponivel(true);
        motorista6.setHorarioTrabalho(true);
        motorista6.setVeiculo(v9);
        motorista6.setGrauCumprimentoHorario(100); 
        motorista6.setClassificacao(90); 
        baseDados.addMotorista(motorista6); 
        
        dataNasM2 = LocalDate.of (1979,02,25);
        Motorista motorista7 = new Motorista("maria@maria.com","Maria César", Utils.encriptar("maria"), "Rua das marias", 
        dataNasM2);
        motorista7.setDisponivel(true);
        motorista7.setHorarioTrabalho(true);
        motorista7.setVeiculo(v10);
        motorista7.setGrauCumprimentoHorario(67); 
        motorista7.setClassificacao(80); 
        baseDados.addMotorista(motorista7);
        
        dataNasM2 = LocalDate.of (1988,02,07);
        Motorista motorista8 = new Motorista("joana@joana.com","Joana César", Utils.encriptar("joana"), "Rua das joanas", 
        dataNasM2);
        motorista8.setDisponivel(true);
        motorista8.setHorarioTrabalho(true);
        motorista8.setVeiculo(v8);
        motorista8.setGrauCumprimentoHorario(50); 
        motorista8.setClassificacao(89); 
        baseDados.addMotorista(motorista8);
       
       
       Admin admin =  new  Admin("admin@admin.com", "admin", Utils.encriptar("admin"), null, null,  new  Coordenadas());
       baseDados.addAdmin(admin); 
       
       
       Historico h = new Historico();
       LocalDate data = LocalDate.of(2017, 02, 27); 
       LocalDateTime dataTime = LocalDateTime.of(data, LocalDateTime.MIN.toLocalTime());
       h.setDataDeInicioDeServico(dataTime); 
       h.setEmailCliente("marcia@marcia.com"); 
       h.setEmailMotorista("acores@acores.com"); 
       h.setDistancia(50d);
       h.setTempoEstimado(100d); 
       h.setTempoReal(120d); 
       h.setValorEstimado(300);
       h.setValorCobrado(300);
       h.setEstadoTempo("Neve"); 
       h.setEstadoTransito("Transito Normal");
       h.setTerminado(true); 
       Coordenadas origem = new Coordenadas(); 
       Coordenadas destino = new Coordenadas(); 
       h.setOrigem(origem); 
       h.setDestino(destino);
       h.setClassificacao(10); 
       baseDados.addHistorico(h); 
       
       Historico h1 = new Historico();
       LocalDate data1 = LocalDate.of(2017, 03, 27); 
       LocalDateTime dataTime1 = LocalDateTime.of(data1, LocalDateTime.MIN.toLocalTime());
       h1.setDataDeInicioDeServico(dataTime1); 
       h1.setEmailCliente("celia@celia.com"); 
       h1.setEmailMotorista("acores@acores.com"); 
       h1.setDistancia(50d);
       h1.setTempoEstimado(50d); 
       h1.setTempoReal(100d); 
       h1.setValorEstimado(150);
       h1.setValorCobrado(150);
       h1.setEstadoTempo("Sol"); 
       h1.setEstadoTransito("Sem Transito");
       h1.setTerminado(true); 
       Coordenadas origem1 = new Coordenadas(); 
       Coordenadas destino1 = new Coordenadas(); 
       h1.setOrigem(origem1); 
       h1.setDestino(destino1);
       h1.setClassificacao(20); 
       baseDados.addHistorico(h1);
       
       Historico h2 = new Historico();
       LocalDate data2 = LocalDate.of(2017, 04, 27); 
       LocalDateTime dataTime2 = LocalDateTime.of(data2, LocalDateTime.MIN.toLocalTime());
       h2.setDataDeInicioDeServico(dataTime2); 
       h2.setEmailCliente("daniel@daniel.com"); 
       h2.setEmailMotorista("acores@acores.com"); 
       h2.setDistancia(20d);
       h2.setTempoEstimado(15d); 
       h2.setTempoReal(10d); 
       h2.setValorEstimado(45);
       h2.setValorCobrado(40);
       h2.setEstadoTempo("Sol"); 
       h2.setEstadoTransito("Sem Transito");
       h2.setTerminado(true); 
       h2.setOrigem(new Coordenadas()); 
       h2.setDestino(new Coordenadas());
       h2.setClassificacao(80); 
       baseDados.addHistorico(h2);
       
       Historico h3 = new Historico();
       LocalDate data3 = LocalDate.of(2017, 05, 27); 
       LocalDateTime dataTime3 = LocalDateTime.of(data3, LocalDateTime.MIN.toLocalTime());
       h3.setDataDeInicioDeServico(dataTime3); 
       h3.setEmailCliente("nuno@nuno.com"); 
       h3.setEmailMotorista("manuel@manuel.com"); 
       h3.setDistancia(50d);
       h3.setTempoEstimado(30d); 
       h3.setTempoReal(35d); 
       h3.setValorEstimado(90);
       h3.setValorCobrado(90);
       h3.setEstadoTempo("Chuva"); 
       h3.setEstadoTransito("Sem Transito");
       h3.setTerminado(true); 
       h3.setOrigem(new Coordenadas()); 
       h3.setDestino(new Coordenadas());
       h3.setClassificacao(70); 
       baseDados.addHistorico(h3);
       
       Historico h4 = new Historico();
       LocalDate data4 = LocalDate.of(2017, 05, 29); 
       LocalDateTime dataTime4 = LocalDateTime.of(data4, LocalDateTime.MIN.toLocalTime());
       h4.setDataDeInicioDeServico(dataTime4); 
       h4.setEmailCliente("nazare@nazare.com"); 
       h4.setEmailMotorista("manuel@manuel.com"); 
       h4.setDistancia(100d);
       h4.setTempoEstimado(30d); 
       h4.setTempoReal(20d); 
       h4.setValorEstimado(90);
       h4.setValorCobrado(90);
       h4.setEstadoTempo("Sol"); 
       h4.setEstadoTransito("Muito Transito");
       h4.setTerminado(true); 
       h4.setOrigem(new Coordenadas()); 
       h4.setDestino(new Coordenadas());
       h4.setClassificacao(90); 
       baseDados.addHistorico(h4);
       
       Historico h5 = new Historico();
       LocalDate data5 = LocalDate.of(2017, 05, 30); 
       LocalDateTime dataTime5 = LocalDateTime.of(data5, LocalDateTime.MIN.toLocalTime());
       h5.setDataDeInicioDeServico(dataTime5); 
       h5.setEmailCliente("luis@luis.com"); 
       h5.setEmailMotorista("manuel@manuel.com"); 
       h5.setDistancia(100d);
       h5.setTempoEstimado(30d); 
       h5.setTempoReal(35d); 
       h5.setValorEstimado(90);
       h5.setValorCobrado(90);
       h5.setEstadoTempo("Sol"); 
       h5.setEstadoTransito("Transito Normal");
       h5.setTerminado(true); 
       h5.setOrigem(new Coordenadas()); 
       h5.setDestino(new Coordenadas());
       h5.setClassificacao(50); 
       baseDados.addHistorico(h5);
       
       Historico h6 = new Historico();
       LocalDate data6 = LocalDate.of(2017, 05, 23); 
       LocalDateTime dataTime6 = LocalDateTime.of(data6, LocalDateTime.MIN.toLocalTime());
       h6.setDataDeInicioDeServico(dataTime6); 
       h6.setEmailCliente("carla@carla.com"); 
       h6.setEmailMotorista("rita@rita.com"); 
       h6.setDistancia(100d);
       h6.setTempoEstimado(30d); 
       h6.setTempoReal(48d); 
       h6.setValorEstimado(90);
       h6.setValorCobrado(90);
       h6.setEstadoTempo("Sol"); 
       h6.setEstadoTransito("Muito Transito");
       h6.setTerminado(true); 
       h6.setOrigem(new Coordenadas()); 
       h6.setDestino(new Coordenadas());
       h6.setClassificacao(50); 
       baseDados.addHistorico(h6);
       
       Historico h7 = new Historico();
       LocalDate data7 = LocalDate.of(2017, 05, 03); 
       LocalDateTime dataTime7 = LocalDateTime.of(data7, LocalDateTime.MIN.toLocalTime());
       h7.setDataDeInicioDeServico(dataTime7); 
       h7.setEmailCliente("xavier@xavier.com"); 
       h7.setEmailMotorista("carlos@carlos.com"); 
       h7.setDistancia(100d);
       h7.setTempoEstimado(30d); 
       h7.setTempoReal(22d); 
       h7.setValorEstimado(90);
       h7.setValorCobrado(70);
       h7.setEstadoTempo("Nevoeiro"); 
       h7.setEstadoTransito("Transito Normal");
       h7.setTerminado(true); 
       h7.setOrigem(new Coordenadas()); 
       h7.setDestino(new Coordenadas());
       h7.setClassificacao(90); 
       baseDados.addHistorico(h7);
       
       
       Historico h8 = new Historico();
       LocalDate data8 = LocalDate.of(2017, 06, 02); 
       LocalDateTime dataTime8 = LocalDateTime.of(data8, LocalDateTime.MIN.toLocalTime());
       h8.setDataDeInicioDeServico(dataTime8); 
       h8.setEmailCliente("andreia@andreia.com"); 
       h8.setEmailMotorista("antonio@antonio.com"); 
       h8.setDistancia(130d);
       h8.setTempoEstimado(50d); 
       h8.setTempoReal(40d); 
       h8.setValorEstimado(90);
       h8.setValorCobrado(90);
       h8.setEstadoTempo("Nevoeiro"); 
       h8.setEstadoTransito("Muito Transito");
       h8.setTerminado(true); 
       h8.setOrigem(new Coordenadas()); 
       h8.setDestino(new Coordenadas());
       h8.setClassificacao(90); 
       baseDados.addHistorico(h8);
       
       Historico h9 = new Historico();
       LocalDate data9 = LocalDate.of(2017, 06, 12); 
       LocalDateTime dataTime9 = LocalDateTime.of(data9, LocalDateTime.MIN.toLocalTime());
       h9.setDataDeInicioDeServico(dataTime9); 
       h9.setEmailCliente("carlosfaria@gmail.com"); 
       h9.setEmailMotorista("maria@maria.com"); 
       h9.setDistancia(20d);
       h9.setTempoEstimado(10d); 
       h9.setTempoReal(15d); 
       h9.setValorEstimado(30);
       h9.setValorCobrado(37);
       h9.setEstadoTempo("Nevoeiro"); 
       h9.setEstadoTransito("Muito Transito");
       h9.setTerminado(true); 
       h9.setOrigem(new Coordenadas()); 
       h9.setDestino(new Coordenadas());
       h9.setClassificacao(80); 
       baseDados.addHistorico(h9);
       
       Historico h10 = new Historico();
       LocalDate data10 = LocalDate.of(2017, 06, 03); 
       LocalDateTime dataTime10 = LocalDateTime.of(data10, LocalDateTime.MIN.toLocalTime());
       h10.setDataDeInicioDeServico(dataTime10); 
       h10.setEmailCliente("celia@gmail.com"); 
       h10.setEmailMotorista("maria@maria.com"); 
       h10.setDistancia(40d);
       h10.setTempoEstimado(30d); 
       h10.setTempoReal(20d); 
       h10.setValorEstimado(120);
       h10.setValorCobrado(120);
       h10.setEstadoTempo("Chuva"); 
       h10.setEstadoTransito("Sem Transito");
       h10.setTerminado(true); 
       h10.setOrigem(new Coordenadas()); 
       h10.setDestino(new Coordenadas());
       h10.setClassificacao(80); 
       baseDados.addHistorico(h10);
       
       Historico h11 = new Historico();
       LocalDate data11 = LocalDate.of(2017, 05, 14); 
       LocalDateTime dataTime11 = LocalDateTime.of(data11, LocalDateTime.MIN.toLocalTime());
       h11.setDataDeInicioDeServico(dataTime11); 
       h11.setEmailCliente("filipa@filipa.com"); 
       h11.setEmailMotorista("joana@joana.com"); 
       h11.setDistancia(12d);
       h11.setTempoEstimado(6d); 
       h11.setTempoReal(12d); 
       h11.setValorEstimado(18);
       h11.setValorCobrado(18);
       h11.setEstadoTempo("Chuva"); 
       h11.setEstadoTransito("Muito Transito");
       h11.setTerminado(true); 
       h11.setOrigem(new Coordenadas()); 
       h11.setDestino(new Coordenadas());
       h11.setClassificacao(89); 
       baseDados.addHistorico(h11);
        
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

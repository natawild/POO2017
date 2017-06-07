import java.util.List; 
import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ArrayList; 
import java.util.Set; 
import java.util.TreeSet; 
import java.time.LocalDate; 
import java.time.LocalDateTime; 
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileWriter;
import java.util.Map; 
import java.util.HashMap;
import java.util.TreeMap; 
import java.io.Serializable;
import Exceptions.*;

/**
 * Classe UMeR terá a implementação das funções necessárias ao funcionamento da aplicaçao 
 * @celia
 * @version 2.1
 */
public class UMeR{
    private BDInterface baseDeDados;
    private AtorInterface atorLoggado;
    private int tentativasDeLoginFalhadas;
    
    public UMeR(){
        this.baseDeDados= new BD();  
        this.tentativasDeLoginFalhadas = 0;
    }
    
    public UMeR(BDInterface baseDeDados, int tentativasDeLoginFalhadas){
        this.baseDeDados= baseDeDados.clone(); 
        this.tentativasDeLoginFalhadas = tentativasDeLoginFalhadas;
    }
    
     public UMeR(BDInterface baseDeDados){
        this.baseDeDados= baseDeDados.clone(); 
        this.tentativasDeLoginFalhadas = 0;
    }

    public UMeR(UMeR u){
        this.baseDeDados = u.getBaseDeDados(); 
        this.tentativasDeLoginFalhadas = u.getTentativasDeLoginFalhadas();
    }
   
    public BDInterface getBaseDeDados(){
       return baseDeDados.clone();
    }
    
    public void setBaseDeDados(BDInterface bd){
        this.baseDeDados = bd.clone();
    }
    
    public AtorInterface getAtorLoggado(){
        return this.atorLoggado.clone();
    }
    
    public AtorInterface setAtorLoggado(AtorInterface ator){
        return this.atorLoggado = ator;
    }
    
    public int getTentativasDeLoginFalhadas(){
           return this.tentativasDeLoginFalhadas;
    }
    
    public void setTentativasDeLoginFalhadas(int tentativasDeLoginFalhadas){
        this.tentativasDeLoginFalhadas= tentativasDeLoginFalhadas;
    }
    
     /**
     * método equals 
     */
    
    public boolean equals (Object u){
       if(this==u) 
            return true;
       if((u == null) || (this.getClass()!=u.getClass()))
       return false; 
       
       UMeR umer = (UMeR) u; 
       return this.baseDeDados.equals(umer.getBaseDeDados());       
    }
    
    /**
     * método toString
     * 
     */
    public String toString (){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Base de dados: " + this.baseDeDados);
        return sb.toString(); 
    }
    
    
    public UMeR clone (){
        return new UMeR(this);    
    }
    
    public void adicionarTentativaDeLoginFalhadas(){
        this.tentativasDeLoginFalhadas =  this.tentativasDeLoginFalhadas+1;
    }
    
    
    /**
     * Método que pesquisa motorista por email
     * @param email
     */
    public Motorista pesquisaMotorista(String email){
        return (Motorista) this.baseDeDados.getMotoristaComEmail(email);
    }
    
    
    /**
     * Método que pesquisa cliente por email
     * @param email
     */
    public Cliente pesquisaCliente(String email){
        return (Cliente) this.baseDeDados.getClienteComEmail(email);
    }
    
    
    /**
     * Método que procura o motorista mais perto do Cliente
     * @param cliente
     */
    public Motorista getMotoristaMaisPerto(Cliente cliente){
        double distancia = Double.MAX_VALUE;
        Motorista motoristaMaisPerto = null;
        for(AtorInterface motorista: baseDeDados.listaMotoristas()){
            Motorista m = (Motorista) motorista;
            VeiculoInterface v = m.getVeiculo();
            Veiculo veiculoMotorista = (Veiculo) v;
            Coordenadas coordenadasMotorista = veiculoMotorista.getLoc();
            if(m.getDisponivel() && distancia > coordenadasMotorista.getDistancia(cliente.getLoc())){
                distancia = coordenadasMotorista.getDistancia(cliente.getLoc());
                motoristaMaisPerto = m;
            }
        }
        
        return motoristaMaisPerto;
    }
    
    /**
     * Método que devolve uma lista de Clientes
     */
    
    public List<AtorInterface> listaClientes(){
        return this.baseDeDados.listaClientes(); 
    }
    
     public List<AtorInterface> listaMotoristas(){
        return this.baseDeDados.listaMotoristas(); 
    }
    
    public List<VeiculoInterface> listaVeiculos(){
        return this.baseDeDados.listaVeiculos(); 
        
    }
    
    public List<AtorInterface> findClientePeloNome (String nome){
        return this.baseDeDados.findClientePeloNome(nome); 
    
    }
    
    public LocalDateTime getDataViagem(){
        return LocalDateTime.now(); 
    }
    
    /**
     * duracaoEstimadaViagem é calculada com base na formula tempo=distancia(km)/velocidade(km/h)
     * @return tempoEstimadoViagem em minutos 
     */
    public double duracaoEstimadaViagem (double distancia, double velocidade){
        double tempoEstimadoViagem=0; 
        tempoEstimadoViagem= (distancia/velocidade)*60.0; 

        return tempoEstimadoViagem; 
    }
    
    /**
     * custoEstimadoViagem será calculado com o preço por km * distancia
     */
    public double custoEstimadoViagem(double distancia, double preco){
        double custoEstimadoViagem=0.0d; 
        custoEstimadoViagem= distancia*preco; 
        return custoEstimadoViagem; 
    
    }
    
    /**
     * Tempo real da viagem é influenciado pela fiabilidade (0.9 a 1.2) do veiculo cumprir o tempo, pela destreza (0.5 e 1.9) do condutor,
     * pelo transito(0.9, 1.0, 1.1) e pela meteorologia(0.9 a 1.3)
     */
    
    public double duracaoRealViagem(double duracaoEstimadoDaViagem,double fiabilidade, double destreza,double transito, double meteorologia ){
        double tempoRealViagem= 0;  
        tempoRealViagem = duracaoEstimadoDaViagem*fiabilidade*destreza*transito*meteorologia; 
        return tempoRealViagem; 
    }
    
    /**
     * custoRealViagem 
     */
    
    public double custoRealViagem(double duracaoRealDaViagem, double distancia, double precoUnitario, double duracaoEstimaDaViagem){
        if((duracaoEstimaDaViagem/duracaoRealDaViagem) >= 1 && duracaoRealDaViagem < duracaoEstimaDaViagem * 0.75){
             return (custoEstimadoViagem(distancia, precoUnitario) * duracaoRealDaViagem / duracaoEstimaDaViagem);
        }
        else {
            return custoEstimadoViagem(distancia, precoUnitario) ;
        }  
    }
    
    
    
    /**
     * Registar Ator 
     * 
     */
    public void registarUtilizador(AtorInterface ator) throws AtorExistenteException {
        if(ator instanceof Cliente){
            Cliente novo = (Cliente) ator; 
            
            if (((BD) this.baseDeDados).getClientes().containsKey(novo.getEmail())){
                throw new AtorExistenteException("Utilizador "+novo.getEmail() +" já existe");
            }
            else {
                novo.setPassword(Utils.encriptar(novo.getPassword()));
                this.baseDeDados.addCliente(novo);
            } 
        }
        
        if(ator instanceof Motorista){
            Motorista novo = (Motorista) ator; 
            
            if (((BD) this.baseDeDados).getMotoristas().containsKey(novo.getEmail())){
                throw new AtorExistenteException("Utilizador "+novo.getEmail() +" já existe");
            }
            else {
                novo.setPassword(Utils.encriptar(novo.getPassword()));
                this.baseDeDados.addMotorista(novo);
            } 
        }
        
        if(ator instanceof Admin){
            Admin novo= (Admin) ator; 
            
            if (((BD) this.baseDeDados).getAdmins().containsKey(novo.getEmail())){
                throw new AtorExistenteException("Utilizador "+novo.getEmail() +" já existe");
            }
            else {
                novo.setPassword(Utils.encriptar(novo.getPassword()));
                this.baseDeDados.addAdmin(novo);
                //Map<String, AtorInterface> mapAdmins = ((BD) this.baseDeDados).getAdmins();
                //mapAdmins.put(novo2.getEmail(), novo2.clone());
                //((BD) this.baseDeDados).setAdmins(mapAdmins); 
            } 
        }
    }
    
    
     /**
     * Atualizar Ator 
     * 
     */
    public void atualizarUtilizador(AtorInterface ator) {
       if(ator instanceof Cliente){
            Cliente novo = (Cliente) ator; 
            if (((BD) this.baseDeDados).getClientes().containsKey(novo.getEmail())){
                novo.setPassword(Utils.encriptar(novo.getPassword()));
                this.baseDeDados.atualizaAtor(novo);
            }  
       }
       else if(ator instanceof Motorista){
            Motorista novo = (Motorista) ator;          
            if (((BD) this.baseDeDados).getMotoristas().containsKey(novo.getEmail())){
                novo.setPassword(Utils.encriptar(novo.getPassword()));
                this.baseDeDados.atualizaAtor(novo);
            } 
       } 
       else if(ator instanceof Admin){
           Admin novo= (Admin) ator; 
           if (((BD) this.baseDeDados).getAdmins().containsKey(novo.getEmail())){
               novo.setPassword(Utils.encriptar(novo.getPassword()));
               this.baseDeDados.atualizaAtor(novo);
           }
       }
        
       //atualizar ator loggado
       if(this.atorLoggado instanceof Cliente){
           this.atorLoggado = this.baseDeDados.getClienteComEmail(this.atorLoggado.getEmail());
       }
       else if(this.atorLoggado instanceof Motorista){
           this.atorLoggado = this.baseDeDados.getMotoristaComEmail(this.atorLoggado.getEmail());
       }
       else if(this.atorLoggado instanceof Cliente){
           this.atorLoggado = this.baseDeDados.getAdminComEmail(this.atorLoggado.getEmail());
       }
        
    }
    
    
    /**
     * Iniciar sessão na aplicação.
     * @param email
     * @param password
     */
     public void iniciaSessao(String email, String password) throws SemAutorizacaoException {
        if (this.atorLoggado == null) {
            
            if( ((BD) this.baseDeDados).getClientes().containsKey(email)){
                AtorInterface clienteGuardado =  ((BD) this.baseDeDados).getClientes().get(email);
                if(clienteGuardado.getPassword().equals(Utils.encriptar(password))){
                    this.atorLoggado = clienteGuardado;
                }
                else {
                    throw new SemAutorizacaoException("Username ou password Errados");
                }
                
            }
            
           else if( ((BD) this.baseDeDados).getMotoristas().containsKey(email)){
                AtorInterface motoristaGuardado =  ((BD) this.baseDeDados).getMotoristas().get(email);
                if(motoristaGuardado.getPassword().equals(Utils.encriptar(password))){
                    this.atorLoggado = motoristaGuardado;
                }
                else {
                    throw new SemAutorizacaoException("Username ou password Errados");
                }
                
            }
           else if( ((BD) this.baseDeDados).getAdmins().containsKey(email)){
                AtorInterface adminGuardado =  ((BD) this.baseDeDados).getAdmins().get(email);
                if(adminGuardado.getPassword().equals(Utils.encriptar(password))){
                    this.atorLoggado = adminGuardado;
                }
                else {
                    throw new SemAutorizacaoException("Username ou password Errados");
                }
                
            }
            else throw new SemAutorizacaoException("O utilizador nao esta registado");
        }
        else {
            throw new SemAutorizacaoException("Já tem uma sessão iniciada");
        }
    }
    
    public void registarViatura(VeiculoInterface veiculo) throws ViaturaExistenteException {
            
        if (this.baseDeDados.carroEstaRegistado(veiculo.getMatricula())){
             throw new ViaturaExistenteException("Veiculo "+veiculo.getMatricula() +" já existe");
        }
        else {
              this.baseDeDados.addVeiculo(veiculo);
        } 
    }
    
    public void associaMotoristaAVeiculo(Motorista m, VeiculoInterface v){
        
        m.setVeiculo(v);
        this.baseDeDados.carroAdicionadoMotorista(m); 
        /* estas duas linhas fazem o memso que a linha em cima. Temos que fazer set à variavel  motoristas da classe BD
         * porque o método getMotoristas() devolve um cópia da variaval motoristas e portanto tem um endereço diferente
        Map <Motorista,VeiculoInterface> assoc = this.baseDeDados.getMotoristas().put(m.getEmail(), m);
        this.baseDeDados.setMotoristas(assoc); 
        */
    }
    
    public void atualizaDadosCliente (AtorInterface cliente){
        
        //this.baseDeDados.getClientes().put(cliente.getEmail(), cliente);
        Map <String,AtorInterface> dadosClientes = ((BD) this.baseDeDados).getClientes(); 
        dadosClientes.put(cliente.getEmail(), cliente);
        ((BD)this.baseDeDados).setClientes(dadosClientes);

    }
    
    
    public Motorista motoristaMaisPertoCliente (Cliente cliente){
       double novaDistancia = Double.MAX_VALUE; 
       Motorista maisPerto = null; 
        
       for(AtorInterface m : ((BD)this.baseDeDados).getMotoristas().values()){
            if(m instanceof Motorista){
                Motorista m1 = (Motorista) m;
                if (m1.getVeiculo()!=null){
                    Coordenadas coordVeic = m1.getVeiculo().getLoc(); //localizacao do motorista 
                    double distancia= coordVeic.getDistancia(cliente.getLoc());
                    if(m1.getDisponivel() && m1.getHorarioTrabalho() && distancia < novaDistancia){
                        novaDistancia= distancia; 
                        maisPerto = m1;  
                    }
               }
           }
       }
       return maisPerto;
    }
    
    public List<AtorInterface> listaDeMotoristasLivres(Cliente cliente){
        List<AtorInterface> motoristas = new ArrayList<AtorInterface>();
        
        for(AtorInterface m : ((BD)this.baseDeDados).getMotoristas().values()){
            Motorista m1 = (Motorista) m;

            if (m1.getVeiculo() != null){
                Coordenadas coordVeic = m1.getVeiculo().getLoc(); //localizacao do motorista 
                double distancia= coordVeic.getDistancia(cliente.getLoc());
                if(m1.getDisponivel() && m1.getHorarioTrabalho()){
                   inserirOrdenadoLista(motoristas, cliente, m1);
                }
           }
       }
       return motoristas;   
    }
    
   private void inserirOrdenadoLista(List<AtorInterface> motoristas, Cliente c, Motorista m){
        int i= 0;
        for(AtorInterface ator: motoristas){
            Motorista m1 = (Motorista) m;
            if (m1.getVeiculo() != null){
                Coordenadas coordVeic = m1.getVeiculo().getLoc();
                if(coordVeic.getDistancia(c.getLoc()) < c.getLoc().getDistancia(m.getVeiculo().getLoc())){
                    i++;
                    System.out.println("i++");
                }
            }
        }
        motoristas.add(i, m.clone());
    }
    
    
    /**
     * Fechar sessão na aplicação.
     */
    public void fechaSessao(){
        this.atorLoggado = null;
    }
    
    /**
     * Obter mapeamento para cada motorista, respetivo veiculo 
     * @return Mapeamento veiculo, motorista
     */
    /*
    public Map<AtorInterface, VeiculoInterface> obterMapMotoVei() {
        Map<AtorInterface, VeiculoInterface> map = new TreeMap<>();

        for(AtorInterface u: this.baseDeDados.listaDeMotoristas()) {
            if (u instanceof Motorista) {
                Motorista m = (Motorista) u;

                for(VeiculoInterface vi: this.baseDeDados.listaVeiculos()){
                    if(vi instanceof VeiculoInterface){
                        VeiculoInterface v = (VeiculoInterface) vi; 
                    }
                    map.put(m, vi);
                }
            }
        }

        return map;
    }
    */
   
    
    /**
     * Gravar o estado da aplicação num determinado ficheiro.
     * @param fich
     */
    public void gravaObj(String fich) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fich));
        oos.writeObject(this.baseDeDados);
        oos.flush();
        oos.close();
    }

    /**
     * Iniciar a aplicação com o estado guardado num determinado ficheiro.
     * @param fich
     * @return
     */
    public static BDInterface leObj(String fich) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
        BDInterface bd = (BDInterface) ois.readObject();
        ois.close();
        return bd;
    }

    /**
     * Fazer um ficheiro de texto log com toda a informação na UMeR no momento em que é fechada.
     * @param f
     * @param ap
     */
   public void log(String f, boolean ap) throws IOException {
        FileWriter fw = new FileWriter(f, ap);
        fw.write("\n-------------------------- LOG --------------------------\n");
        fw.write(this.toString());
        fw.write("\n-------------------------- LOG --------------------------\n");
        fw.flush();
        fw.close();
   }
    
    
   public boolean temAdminsRegistados(){
        return this.baseDeDados.temAdminsRegistados();
   }
    
   public void atualizaVeiculoAtorLogado (VeiculoInterface veiculo){
        ((Motorista) this.atorLoggado).setVeiculo(veiculo); 
   }
    
   public void adicionaVeiculoAMotorista(VeiculoInterface v){
       /*
       Map <String, AtorInterface> motoristasCopia = ((BD) this.baseDeDados).getMotoristas();
       AtorInterface motoristaCopia = motoristasCopia.get(this.atorLoggado.getEmail()); 
       ((Motorista) motoristaCopia).setVeiculo(v); 
        
       ((BD) this.baseDeDados).setMotoristas(motoristasCopia); 
       */
      this.baseDeDados.adicionaVeiculoAMotorista(this.atorLoggado, v);

    }
    
   public void alteraDisponibilidade(AtorInterface ator, boolean estado){
       /*
       Map<String, AtorInterface> motoristasCopia = ((BD) this.baseDeDados).getMotoristas(); 
       AtorInterface motoristaCopia = motoristasCopia.get(this.atorLoggado.getEmail()); 
       ((Motorista) motoristaCopia).setDisponivel(true);
      ((BD)this.baseDeDados).setMotoristas(motoristasCopia);
      */
     ((Motorista) ator).setDisponivel(estado);
     this.baseDeDados.alteraDisponibilidade(ator, estado);
    }
    
   public void atualizaHorario(boolean estado){
       this.baseDeDados.atualizaHorario(atorLoggado, estado); 
    }
    
   public void adicionarHistorico(Historico historico){
       this.baseDeDados.addHistorico(historico); 
   }
    
   public void clienteEmViagem(boolean estado){
       ((Cliente) this.atorLoggado).setEmViagem(estado);
       this.baseDeDados.clienteEmViagem(this.atorLoggado, estado); 
   }
   
   public void adicionaViagemEmProcessoAoMotorista(AtorInterface motorista, Historico historico){
       this.baseDeDados.adicionaViagemEmProcessoAoMotorista(motorista, historico); 
   }
   
   public void terminarViagem(){  
       AtorInterface motorista = this.baseDeDados.terminarViagem(atorLoggado);
       atorLoggado = motorista;
       
   }
   
   public List<Historico> historicoViagens(){
       List<Historico> historicoPorAtor = new ArrayList<Historico>();
        
        if(atorLoggado instanceof Motorista) {
            for(Historico h: ((BD) this.baseDeDados).getHistorico()){
                if(h.getEmailMotorista().equals(this.atorLoggado.getEmail()) && h.getTerminado()){
                    historicoPorAtor.add(h.clone());
                }
            }
        } 
        else if(atorLoggado instanceof Cliente){
             for(Historico h: ((BD) this.baseDeDados).getHistorico()){
                if(h.getEmailCliente().equals(this.atorLoggado.getEmail()) && h.getTerminado()){
                    historicoPorAtor.add(h.clone());
                }
             }
        }
        else {
             for(Historico h: ((BD) this.baseDeDados).getHistorico()){
                if(h.getTerminado()){
                    historicoPorAtor.add(h.clone());
                }
             }
        }
        
        return historicoPorAtor;   
   }
   
   public List<Historico> historicoEntreDatas(LocalDateTime inicio, LocalDateTime fim) {  
        List<Historico> historico = new ArrayList<Historico>();
        Iterator<Historico> iterator = ((BD) this.baseDeDados).getHistorico().iterator();
        
        if(this.atorLoggado instanceof Motorista) {
            while(iterator.hasNext()) {
                Historico h = iterator.next();
                if(h.getEmailMotorista().equals(this.atorLoggado.getEmail()) && h.getTerminado() && h.getDataDeInicioDeServico().isAfter(inicio) && h.getDataDeInicioDeServico().isBefore(fim)){
                    historico.add(h.clone());
                }
            }   
        }
        else if(this.atorLoggado instanceof Cliente){
            while(iterator.hasNext()) {
                Historico h = iterator.next();
                if(h.getEmailCliente().equals(this.atorLoggado.getEmail()) && h.getTerminado() && h.getDataDeInicioDeServico().isAfter(inicio) && h.getDataDeInicioDeServico().isBefore(fim)){
                    historico.add(h.clone());
                }
            }   
        }
        else {
            while(iterator.hasNext()) {
                Historico h = iterator.next();
                if(h.getTerminado() && h.getDataDeInicioDeServico().isAfter(inicio) && h.getDataDeInicioDeServico().isBefore(fim)){
                    historico.add(h.clone());
                }
            }   
        }
        
        return historico;                
    }
   
   public List<Historico> historicoViagensPorClassificar(){
       return this.baseDeDados.historicoViagensPorClassificarPorAtor(this.atorLoggado);
   }
   
   public void atualizaClassificacao(Historico h, int classificacao){
       this.baseDeDados.atualizaClassificacao(h, classificacao);
   }
   
   public void removeVeiculoDeAtor(){
      this.atorLoggado = this.baseDeDados.removeVeiculoDeAtor(atorLoggado);
   }
   
   public boolean temVeiculo(){
       boolean jaTemCarro = false;
       if(this.atorLoggado instanceof Motorista){
           Motorista m = (Motorista) atorLoggado;
           if(m.getVeiculo() != null){
                jaTemCarro = true;
           }
       }
       return jaTemCarro;
   }

   public List<AtorInterface> listaClientesMaisGastam(){
      List<AtorInterface> listaClientesMaisGastam = new ArrayList<AtorInterface>();
      Map<String, Double> totalGastoPorCliente = new TreeMap<String, Double>();

      if(atorLoggado instanceof Motorista){
           for(String emailCliente: ((BD) this.baseDeDados).getClientes().keySet()){  
               Double totalPorCliente = 0d;
               for(Historico h: ((BD) this.baseDeDados).getHistorico()){
                   if(h.getEmailCliente().equals(emailCliente) && h.getEmailMotorista().equals(atorLoggado.getEmail()) && h.getTerminado()){
                       totalPorCliente += h.getValorCobrado();
                   }
               }
               if(totalPorCliente > 0){
                   totalGastoPorCliente.put(emailCliente, totalPorCliente);
               }
           }
      }
      else if(atorLoggado instanceof Admin){
           for(String emailCliente: ((BD) this.baseDeDados).getClientes().keySet()){  
               Double totalPorCliente = 0d;
               for(Historico h: ((BD) this.baseDeDados).getHistorico()){
                   if(h.getEmailCliente().equals(emailCliente) && h.getTerminado()){
                       totalPorCliente += h.getValorCobrado();
                   }
               }
               if(totalPorCliente > 0){
                   totalGastoPorCliente.put(emailCliente, totalPorCliente);
               }
           }
      }
      
       
      TreeMap<String, Double> clintesQueMaisGastamOrdenado = new TreeMap<String, Double>(new ComparatorClientesQueMaisGastam(totalGastoPorCliente));
      clintesQueMaisGastamOrdenado.putAll(totalGastoPorCliente);
      
      int i =0;
      for(String key: clintesQueMaisGastamOrdenado.descendingKeySet()){
          if(i<10){
              listaClientesMaisGastam.add(this.baseDeDados.getClienteComEmail(key));
              i++;
          }
          else {
              break;
          }
      } 
      
      return listaClientesMaisGastam;
   }
   
   public double totalGastoPorCliente(AtorInterface cliente){
       Double total = 0d;
       
       for(Historico h: ((BD) this.baseDeDados).getHistorico()){
            if(h.getEmailCliente().equals(cliente.getEmail()) && h.getTerminado()){
               total += h.getValorCobrado(); 
            }
       }
       return total;
   }
   
   public List<Motorista> motoristasComMaisDesviosDeTempo(){
       List<Motorista> motoristasComMaisDesviosDeTempo = new ArrayList<Motorista>();
       
       for(AtorInterface ator: ((BD) this.baseDeDados).getMotoristas().values()){  
           motoristasComMaisDesviosDeTempo.add((Motorista) ator);
       }
       
       Collections.sort(motoristasComMaisDesviosDeTempo, Motorista.Comparators.GrauDeCumprimento);
       
       if(motoristasComMaisDesviosDeTempo.size() > 0 && motoristasComMaisDesviosDeTempo.size() <= 5)
            return motoristasComMaisDesviosDeTempo.subList(0, motoristasComMaisDesviosDeTempo.size());
       else 
            return motoristasComMaisDesviosDeTempo.subList(0, 5);
   }
   
   public List<Motorista> motoristasComMaisDesviosDeCusto(){
       List<Motorista> motoristasComMaisDesviosDeTempo =  new ArrayList<Motorista>();
       Map<String, Double> grauCumprimentoCustoPorMotorista = new TreeMap<>();
       
       for(AtorInterface ator: ((BD) this.baseDeDados).getMotoristas().values()){  
           List<Historico> historicoPorCliente = this.baseDeDados.historicoViagensPorAtor(ator);
           int i = 0;
           double totalCusto = 0;
           for(Historico h: historicoPorCliente){
               totalCusto += (h.getValorCobrado()/h.getValorEstimado() ) * 100;
               i++;
           }
           //se não tem histórico o custo é zero, se tem o custo é o custo total/nr de históricos
           if(i == 0) {
               totalCusto = 0;
           }
           else {
               totalCusto = totalCusto/ i;
           }
           grauCumprimentoCustoPorMotorista.put(ator.getEmail(), totalCusto);
       }
       
       TreeMap<String, Double> motoristasOrdenados = new TreeMap<String, Double>(new ComparatorGrauCumprimentoCusto(grauCumprimentoCustoPorMotorista));
       motoristasOrdenados.putAll(grauCumprimentoCustoPorMotorista);
      
       int i = 0;
       for(String email :motoristasOrdenados.keySet()){
          if(i<5){
              motoristasComMaisDesviosDeTempo.add((Motorista) this.baseDeDados.getMotoristaComEmail(email));
              i++;
          }  
          else {
              break;
          }
       }

       return motoristasComMaisDesviosDeTempo;
   }
   
   public int grauCumprimentoCusto(Motorista m){
       int i = 0;
       double totalCusto = 0;
       List<Historico> historicoPorCliente = this.baseDeDados.historicoViagensPorAtor(m);
       for(Historico h: historicoPorCliente){
           totalCusto += (h.getValorCobrado()/h.getValorEstimado()) * 100;
           i++;
       }
       
       if(i == 0) {
           totalCusto = 0;
       }
       else {
           totalCusto = totalCusto/ i;
       }
       
       return (int) totalCusto;
   }
   
   public List<AtorInterface> faturacaoMotoristas(){
       List<AtorInterface> motoristas =  new ArrayList<AtorInterface>();
       Map<String, Double> faturacaoPorMotorista = new TreeMap<>();
       
       for(AtorInterface ator: ((BD) this.baseDeDados).getMotoristas().values()){  
           List<Historico> historicoPorCliente = this.baseDeDados.historicoViagensPorAtor(ator);
           double totalFaturado = 0;
           for(Historico h: historicoPorCliente){
               totalFaturado += h.getValorCobrado();
           }
           
           faturacaoPorMotorista.put(ator.getEmail(), totalFaturado);
       }
       
       TreeMap<String, Double> motoristasOrdenados = new TreeMap<String, Double>(new ComparatorFaturacao(faturacaoPorMotorista));
       motoristasOrdenados.putAll(faturacaoPorMotorista); 
       
       for(String email :motoristasOrdenados.keySet()){
           motoristas.add(this.baseDeDados.getMotoristaComEmail(email));
       }
       
       return motoristas;
   }
   
   public double faturacaoPorMotorista(AtorInterface m){ 
      List<Historico> historicoPorCliente = this.baseDeDados.historicoViagensPorAtor(m);
      double totalFaturado = 0;
      for(Historico h: historicoPorCliente){
          totalFaturado += h.getValorCobrado();
      }
       
      return totalFaturado;
   }
   
   public double faturacaoPorMotorista(AtorInterface m, LocalDateTime inicio, LocalDateTime fim) { 
      List<Historico> historicoPorCliente = this.baseDeDados.historicoViagensPorAtor(m, inicio, fim);
      double totalFaturado = 0;
      for(Historico h: historicoPorCliente){
          totalFaturado += h.getValorCobrado();
      }
       
      return totalFaturado;
   }
   
   
   public List<AtorInterface> faturacaoMotoristas(LocalDateTime inicio, LocalDateTime fim){
       List<AtorInterface> motoristas =  new ArrayList<AtorInterface>();
       Map<String, Double> faturacaoPorMotorista = new TreeMap<>();
       
       for(AtorInterface ator: ((BD) this.baseDeDados).getMotoristas().values()){  
           List<Historico> historicoPorAtor = this.baseDeDados.historicoViagensPorAtor(ator, inicio, fim);
           double totalFaturado = 0;
           for(Historico h: historicoPorAtor){
               totalFaturado += h.getValorCobrado();
           }
           faturacaoPorMotorista.put(ator.getEmail(), totalFaturado);
       }
       
       TreeMap<String, Double> motoristasOrdenados = new TreeMap<String, Double>(new ComparatorFaturacao(faturacaoPorMotorista));
       motoristasOrdenados.putAll(faturacaoPorMotorista); 
       
       for(String email :motoristasOrdenados.keySet()){
           motoristas.add(this.baseDeDados.getMotoristaComEmail(email));
       }
       
       return motoristas;
   }
   
   public void atualizaLocalizacao(Coordenadas loc){
       this.atorLoggado = this.baseDeDados.atualizaLocalizacao(this.atorLoggado, loc);
   }
   
      /**
    * O metodo devolve true se o utilizador logado pode atualiazar a sua localizaçao
    */
   public boolean podeAtualizarLocalicacao () {
       boolean podeAtualizar = false;
       
       if(atorLoggado instanceof Motorista){
           Motorista m = (Motorista) atorLoggado;
           VeiculoInterface v = m.getVeiculo();
           if(v !=null && m.getViagemEmProcesso() == null ){
               podeAtualizar = true;
           }
       }
       else if (atorLoggado instanceof Cliente){
           Cliente c = (Cliente) atorLoggado;
           if(c.getEmViagem() == false) {
              podeAtualizar = true;
           }
       }
       return podeAtualizar;
   }
}



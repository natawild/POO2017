import java.util.List; 
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
import java.util.TreeMap; 
import java.io.Serializable;
import Exceptions.*;

/**
 * Classe UMeR terá a implementação das funções necessárias ao funcionamento da aplicaçao 
 * @celia
 * @version 1.0
 */
public class UMeR{
    private BDInterface baseDeDados;
    private AtorInterface atorLoggado; 
    private Map<String, AtorInterface> atores;
    
    public UMeR(){
        this.baseDeDados= new BD();  
    }
    
    public UMeR(BDInterface baseDeDados){
        this.baseDeDados= baseDeDados.clone(); 
    }

    public UMeR(UMeR u){
        this.baseDeDados = u.getBaseDeDados(); 
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
        for(AtorInterface motorista: baseDeDados.listaDeMotoristas()){
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
    
    public double duracaoRealViagem(double duracaoEstimadoDaViagem,float fiabilidade, float destreza,float transito, float meteorologia ){

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
                this.baseDeDados.addCliente(novo);
            } 
        }
        
        if(ator instanceof Motorista){
            Motorista novo = (Motorista) ator; 
            
            if (((BD) this.baseDeDados).getMotoristas().containsKey(novo.getEmail())){
                throw new AtorExistenteException("Utilizador "+novo.getEmail() +" já existe");
            }
            else {
                this.baseDeDados.addMotorista(novo);
            } 
        }
        
        if(ator instanceof Admin){
            Admin novo= (Admin) ator; 
            
            if (((BD) this.baseDeDados).getAdmins().containsKey(novo.getEmail())){
                throw new AtorExistenteException("Utilizador "+novo.getEmail() +" já existe");
            }
            else {
                this.baseDeDados.addAdmin(novo);
                //Map<String, AtorInterface> mapAdmins = ((BD) this.baseDeDados).getAdmins();
                //mapAdmins.put(novo2.getEmail(), novo2.clone());
                //((BD) this.baseDeDados).setAdmins(mapAdmins); 
            } 
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
                if(clienteGuardado.getPassword().equals(password)){
                    this.atorLoggado = clienteGuardado;
                }
                else {
                    throw new SemAutorizacaoException("Username ou password Errados");
                }
                
            }
            
           else if( ((BD) this.baseDeDados).getMotoristas().containsKey(email)){
                AtorInterface motoristaGuardado =  ((BD) this.baseDeDados).getMotoristas().get(email);
                if(motoristaGuardado.getPassword().equals(password)){
                    this.atorLoggado = motoristaGuardado;
                }
                else {
                    throw new SemAutorizacaoException("Username ou password Errados");
                }
                
            }
           else if( ((BD) this.baseDeDados).getAdmins().containsKey(email)){
                AtorInterface adminGuardado =  ((BD) this.baseDeDados).getAdmins().get(email);
                if(adminGuardado.getPassword().equals(password)){
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
                Coordenadas coordVeic = m1.getVeiculo().getLoc(); //localizacao do motorista 
                double distancia= coordVeic.getDistancia(cliente.getLoc());
                if(m1.getDisponivel() && m1.getHorarioTrabalho() && distancia < novaDistancia){
                    novaDistancia= distancia; 
                    maisPerto = m1;  
                }
            }
       }
       return maisPerto;
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
     * motoristas ordenados pela menor distancia a um cliente
     * treset de motoristas 
     */
    
    /*
    public Set<AtorInterface> procuraMotoristaMaisPerto (Cliente c){
        Set<Veiculo> conjVeiculos= new TreeSet<>(//new ComparatorMotoristas()); 

        for(Veiculo v: conjVeiculos){
            double distancia = c.getLoc().getDistancia(v.getLoc());
            
            if(conjVeiculos.isEmpty()){
                conjVeiculos.add(v);
            }
            
            else {
                for(Veiculo v2: conjVeiculos){
                    if(c.getLoc().getDistancia(v2.getLoc()) > distancia){
                        int index = conjVeiculos.get(v2);
                        conjVeiculos.add(index, v);
                        break;
                    }
    
                }
            }
            
            
        }
        
        return conjVeiculos;
    }
    */
    
    // GRAVAR
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
     * Fazer um ficheiro de texto log com toda a informação na Imobiliária no momento em que é fechada.
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

}

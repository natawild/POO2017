import java.util.List; 
import java.util.Set;
import java.util.ArrayList; 
import java.util.List; 
import java.util.TreeSet;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import java.util.stream.Collectors; 
import java.lang.Math;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.util.Map;  
import java.util.HashMap; 
/**
 * A classe BD tem a lista de clientes, motoristas,  veiculos, historico  existentes na empresa
 * 
 * @celia
 * @version 1.0
 */
public class BD implements BDInterface {
    
    private Map<String, AtorInterface> clientes;
    private Map<String, Motorista> motoristas; 
    private List<VeiculoInterface> veiculos; 
    private Set<Historico> historico;
    
    /**
     * Construtor vazio
     */
    
    public BD (){
        this.clientes = new HashMap<String, AtorInterface>();
        this.motoristas = new HashMap<>(); 
        this.veiculos = new ArrayList<VeiculoInterface>(); 
        this.historico = new TreeSet<Historico>();
    }
    
    /**
     * Construtor parametrizado
     * @param c List<AtorInterface>
     * @param m List<AtorInterface>
     * @param v List<VeiculoInterface>
     * @param h Set<Historico>
     */
    
    public BD (HashMap<String, AtorInterface> c, Map<String, Motorista> m, List<VeiculoInterface> v , Set<Historico> h){
        clientes = c; 
        motoristas = m; 
        veiculos = v; 
        historico = h;
    }
    /**
     * Construtor por cópia 
     */
    public BD (BD bd){
        clientes = bd.getClientes(); 
        motoristas = bd.getMotoristas();
        veiculos = bd.getVeiculos(); 
        historico = bd.getHistorico();
    }
    
    //gets
    /**
     * getClientes() - Devolve um map contendo todos os clientes 
     * 
     */
    public Map<String, AtorInterface> getClientes(){
       Map <String, AtorInterface> mapClientes = new HashMap<>(); 
       for(String key: this.clientes.keySet()){
           AtorInterface c = this.clientes.get(key); 
           //if(atorInterface instanceof Cliente){
                //Cliente cliente = (Cliente) atorInterface;
               // mapClientes.put(key,cliente.clone());
            //}
           mapClientes.put(key, c.clone());
       }
       
        return mapClientes; 
    }
    
    /**
     * getMotoristas() - Devolve uma lista contendo todos os motoristas 
     */
    
    public Map<String, Motorista> getMotoristas(){
       Map<String, Motorista> mapMotoristas = new HashMap<>(); 
       
       for(String key : this.motoristas.keySet()){
           Motorista m = this.motoristas.get(key); 
           //if(ator instanceof Motorista){
               //Motorista m = (Motorista) ator;
               //mapMotoristas.put(key,m.clone());
             //}
             mapMotoristas.put(key,m.clone()); 
        }
        return mapMotoristas; 
    }
    /**
     * getVeiculos()- devolve uma lista contendo todos os Veiculos 
     * (Iterador Interno) 
     */
    
    public List<VeiculoInterface> getVeiculos(){
        return veiculos.stream()
                       .map(VeiculoInterface::clone)
                       .collect(toList()); 
    }
    
    public Set<Historico> getHistorico(){
        return historico.stream()
                        .map(Historico::clone)
                        .collect(Collectors.toCollection(TreeSet::new)); 
        
        /*
        TreeSet<Historico> historicoCopia = new TreeSet<Historico>();
        for(Historico h: historico){
            historicoCopia.add(h.clone());
        }
        
        return historicoCopia;
        */
    }
    
    //sets
    /**
     * setClientes(Map<String, AtorInterface> c)) - Modifica a lista de clientes
     * @param c : Map<String, AtorInterface> c
     */
    
    
     /*
     * iterador externo 
     
    public Map<String, Lugar> getLugares(){
        Map<String, Lugar> copia = new HashMap<>(); 
        for(Map.Entry<String,Lugar> e : lugares.entrySet()){
            copia.put(e.getKey(), e.getValue().clone());
        
        }
        return copia; 
        //return lugares.entrySet().stream().collect(Collectors.toMap(e->egetValue().clone()));
    
    }
    */
    public void setClientes (Map<String, AtorInterface> c){
        Map<String,AtorInterface> copia = new HashMap<>(); 
            for(Map.Entry<String,AtorInterface> e : clientes.entrySet()){
                copia.put(e.getKey(), e.getValue().clone());
            }
            this.clientes=copia;
        
        /*
        this.clientes= c.entrySet()
                        .stream()
                        .collect(Collectors.toMap(e.getKey(),e->getValue().clone()));*/
    }
    
    /**
     * setMotoristas(Map<String, Motorista> m) - Modifica a lista de Motoristas
     * @param m : Map<String, Motorista>
     */
    
    public void setMotoristas (Map<String, Motorista> m){
        this.motoristas =m.entrySet()
                        .stream()
                        .collect(Collectors.toMap((e)->e.getKey(),
                                                  (e)->e.getValue().clone()));
        /*
         * Aqui está como fazer com listas 
        this.motoristas = m.stream()
                           .map(AtorInterface::clone)
                           .collect(toList()) ;*/                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
    }
    
    /**
     * setVeiculos(List<VeiculoInterface> v - Modifica a lista de Veiculos
     * @param v : List<VeiculoInterface> v
     * 
     */
    
    public void setVeiculos(List<VeiculoInterface> v){
        this.veiculos=v.stream()
                       .map(VeiculoInterface::clone)
                       .collect(toList()); 
    }
    
     /**
     * setHistorico(Set<Historico> v - Modifica a lista de historico
     * @param v : Set<Historico> v
     * 
     */
    
    public void setHistorico(Set<Historico> h){
        this.historico=h.stream()
                        .map(Historico::clone)
                        .collect(Collectors.toCollection(TreeSet::new));
        
        /*
        TreeSet<Historico> historicoCopia = new TreeSet<Historico>();
        for(Historico historico: h){
            historicoCopia.add(historico.clone());
        }
        
        this.historico=historicoCopia;
        *
        
        /** Isto nao funciona.Pesquisar como se faz
            this.historico=h.stream()
                       .map(VeiculoInterface::clone)
                       .collect(toSet());
        */
    }
    
    
    public BDInterface clone(){
        return new BD(this);
    }

     /**
     * A função equals recebe um Objeto genérico e verifica se é exatamente igual a uma BD.
     * @param obj Objecto a comparar.
     */
    public boolean equals (Object obj){
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        
        BD c = (BD) obj;
        
        //return(BD.equalsListAtores(this.clientes, c.getClientes()) && BD.equalsListAtores(this.motoristas, c.getMotoristas()) && BD.equalsVeiculos(this.veiculos, c.getVeiculos()));
        // return(this.equalsCLientes(c.getClientes()) fazer o mesmo para motoristas e veiculos);
        return true;
    }
    
    
    /**
     * Método que faz o equals dos Clientes 
     */
    private boolean equalsClientes(Map<String, Cliente> cs){
        if(this.clientes.size() != cs.size() ){
            return false;
        }
        for(String email: this.clientes.keySet()){
            AtorInterface a = this.clientes.get(email);
            Cliente b = cs.get(email);
            
            if(a instanceof Cliente && b instanceof Cliente){
                Cliente a1 = (Cliente) a;
                Cliente b1 = (Cliente) b;
                if(a1.equals(b1) == false){
                    return false;
                }
            }
            else {
                return false;
            }
            
        }
        return true;
    }
    
    /**
     * Método que faz o equals de uma lista de Atores, diferenciando se são Cliente ou Motorista
     */
    
    public static boolean equalsListAtores(Map<String, Cliente> atores1, Map<String, Motorista> atores2){
        if(atores1.size()!= atores2.size()){
            return false;
        }
        
        for(AtorInterface ator: atores1.values()){
            if(ator instanceof Cliente){
                Cliente c = (Cliente) ator;
                if(atores2.containsKey(c)==false){
                    return false;
                }    
            }
             if(ator instanceof Motorista){
                Motorista c = (Motorista) ator;
                if(!atores2.containsKey(c)){
                    return false;
                }
                
            }
        } 
        return true;
    }
    
    /**
     * Metodo auxiliar para fazer o equals da lista de Veiculos
     */
    
    public static boolean equalsVeiculos(Map<String, VeiculoInterface> veiculos1, Map<String, VeiculoInterface> veiculos2){
        for(VeiculoInterface veiculo: veiculos1.values()){
            if(veiculo instanceof VeiculoInterface){
                Veiculo c = (Veiculo) veiculo;
                if(veiculos2.containsKey(c)==false){
                    return false;
                }  
            }
        } 
        return true;
    }
    
    /**
     * toString
     */
    public String toString(){
       StringBuilder sb = new StringBuilder();
       sb.append("Lista de Clientes: \n" +clientes );
       sb.append("LIsta de Motoristas: \n" +motoristas);  
       sb.append("Lista de Veiculos: \n" +veiculos);
       sb.append("Historico: \n" + historico);   
       return sb.toString();
    
    }
    
     /**
     * Método listaDeMotoristas - devolve uma lista com todos os motoristas
     */
    
    public List<Motorista> listaDeMotoristas(){
        List<Motorista> listaMotoristas = new ArrayList<>();
        
        for(Map.Entry<String,Motorista> entry: this.motoristas.entrySet()){
            Motorista motorista = entry.getValue();
            listaMotoristas.add(motorista.clone()); 
        }
        return listaMotoristas; 
    }
    
    
    /**
     * Método que devolve a lista de todos os Clientes 
     */
    
    public List <AtorInterface> listaClientes(){
        List<AtorInterface> listaClientes = new ArrayList<AtorInterface>();
        
        for (Map.Entry<String, AtorInterface> entry : this.clientes.entrySet()) {
            //String key = entry.getKey();
            AtorInterface cliente = entry.getValue();
            listaClientes.add(cliente.clone());
        }
        
        return listaClientes; 
    }
    
    /**
     * Método addCliente - Adiciona um cliente 
     * @param cliente
     */
    public void addCliente(Cliente cliente){
        this.clientes.put(cliente.getEmail(), cliente.clone());
    }
    
     /**
     * Método addMotorista - Adiciona um motorista
     * @param motorista
     */
    
    public void addMotorista(Motorista motorista){
        this.motoristas.put(motorista.getEmail(),motorista.clone());
    }
    
     /**
     * Método addVeiculo - Adiciona um veiculo 
     * @param veiculo
     */
    
    public void addVeiculo(VeiculoInterface veiculo){
        this.veiculos.add(veiculo.clone());
    }
    
    
         /**
     * Método addHistorico - Adiciona um historico 
     * @param historico
     */
    
    public void addHistorico(Historico historico){
        this.historico.add(historico.clone());
    }
    
    
    /**
     * removeCliente(Cliente cliente) - Método para remover um cliente da lista
     * @param cliente
     */
    
    public void removeCliente(Cliente cliente){
        this.clientes.remove(cliente.getEmail());
    }
    
    /**
     * removeVeiculo(Veiculo veiculo) - Método para remover um veiculo da lista
     * @param veiculo
     */
    
    public void removeVeiculo(Veiculo veiculo){
        if(this.veiculos.contains(veiculo)){
              this.veiculos.remove(veiculo);
        }
    }
    
     /**
     * removeMotorista(Motorista motorista) - Método para remover um motorista da lista
     * @param motorista
     */
    
    public void removeMotorista(Motorista motorista){
        if(this.motoristas.containsKey(motorista)){
            this.motoristas.remove(motorista); 
        }
  
    }
    /**
     * Devolve o primeiro Cliente com determinado email, quer esteja com maiúsculas ou minúsculas 
     * @param email
     */
    
    public AtorInterface findClientePeloNome (String email){
        
        if(this.clientes.containsKey(email))
            return this.clientes.get(email);
        
         else return null;   
        
         
    }
    
    /**
     * devolve a lista de todas as matriculas registadas 
     */
    
    public List<String> matriculasReg(){
        List<String> res = new ArrayList<String>();
        
        for(VeiculoInterface veiculoInterface: this.veiculos){
            if(veiculoInterface instanceof Moto){
                Moto m = (Moto) veiculoInterface; 
                res.add(m.getMatricula());
            }
            if(veiculoInterface instanceof Carrinha){
                Carrinha c = (Carrinha) veiculoInterface; 
                res.add(c.getMatricula());
            }
             if(veiculoInterface instanceof CarroLig){
                CarroLig c = (CarroLig) veiculoInterface; 
                res.add(c.getMatricula());
            }
            
        }
        
        return res;
    }
    
    public boolean loginValido (String email, String password) {
        AtorInterface cliente = getClienteComEmail(email);
        if(cliente!=null && cliente.getPassword().equals(codificar(password))){
            return true;
        }
        return false;
    }
    
    
    public AtorInterface getClienteComEmail(String email){
        return this.clientes.get(email);
    }
    
    public AtorInterface getMotoristaComEmail(String email){
         for(AtorInterface ator: this.motoristas.values()){
             if(ator.getEmail().equals(email)){
                return ator.clone();
             }
         }
         return null;
    }
    
    
    public Motorista getMotoristaMaisPerto(AtorInterface cliente){
        for(AtorInterface ator: this.motoristas.values()){
            
        }
        
        return null;
    }
    
    
    
    /*
     * TODO: implementar funçao para codificar a password
     */
    
    
    

    /** Encontrei este 
     * 
     * 
     * try    {
             MessageDigest digest = MessageDigest.getInstance("MD5");
             digest.update(pass.getBytes());
             return digest.digest();
             //BASE64Encoder encoder = new BASE64Encoder (); 
             //return encoder.encode(digest.digest()); 
         }catch (NoSuchAlgorithmException ns) {
             ns.printStackTrace ();
             return senha;
            
            }
     * 
     
    public static String encripta (String senha) {

        */
       
       private String codificar ( String pass ){
           return null; 
        
        }
    /*
     throws NoSuchAlgorithmException{
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(pass.getBytes("UTF-8"));
 
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
        
            return hexString.toString();
        
        }  
        
        */
            
    }
    
 

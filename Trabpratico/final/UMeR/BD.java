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
import java.io.Serializable;
/**
 * A classe BD tem a lista de clientes, motoristas,  veiculos, historico  existentes na empresa
 * 
 * @celia
 * @version 1.0
 */
public class BD implements BDInterface {
    
    private Map<String, AtorInterface> clientes;
    private Map<String, AtorInterface> motoristas; 
    private Map<String, AtorInterface> admins; 
    private Map<String,VeiculoInterface> veiculos; 
    private Set<Historico> historico;
    
    /**
     * Construtor vazio
     */
    
    public BD (){
        this.clientes = new HashMap<>();
        this.motoristas = new HashMap<>(); 
        this.admins = new HashMap<>();
        this.veiculos = new HashMap<>();
        this.historico = new TreeSet<Historico>();
    }
    
    /**
     * Construtor parametrizado
     * @param c List<AtorInterface>
     * @param m List<AtorInterface>
     * @param v List<VeiculoInterface>
     * @param h Set<Historico>
     */
    
    public BD (HashMap<String, AtorInterface> c, Map<String, AtorInterface> m,Map<String, AtorInterface> a, 
                Map<String,VeiculoInterface> v , Set<Historico> h){
        clientes = c; 
        motoristas = m; 
        admins = a; 
        veiculos = v; 
        historico = h;
    }
    /**
     * Construtor por cópia 
     */
    public BD (BD bd){
        clientes = bd.getClientes(); 
        motoristas = bd.getMotoristas();
        admins = bd.getAdmins(); 
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
    
    public Map<String, AtorInterface> getMotoristas(){
       Map<String, AtorInterface> mapMotoristas = new HashMap<>(); 
       
       for(String key : this.motoristas.keySet()){
           AtorInterface m = this.motoristas.get(key); 
           //if(ator instanceof Motorista){
              // Motorista m = (Motorista) motoristas;
               //mapMotoristas.put(key,m.clone());
             //}
             mapMotoristas.put(key,m.clone()); 
        }
        return mapMotoristas; 
    }
    
    /**
     * getAdmins() - Devolve um Map contendo todos os admins da aplicação 
     */
    
    public Map<String, AtorInterface> getAdmins(){
       Map<String, AtorInterface> mapAdmins = new HashMap<>(); 
       
       for(String key : this.admins.keySet()){
           AtorInterface a = this.admins.get(key); 
           mapAdmins.put(key,a.clone()); 
        }
        return mapAdmins; 
    }
    
    
    
    
    /**
     * getVeiculos()- devolve uma lista contendo todos os Veiculos 
     * (Iterador Interno) 
     */
    
    public Map<String,VeiculoInterface> getVeiculos(){
        Map<String,VeiculoInterface>  mapVeiculos = new HashMap<>(); 
        for(String key: this.veiculos.keySet()){
            VeiculoInterface v = this.veiculos.get(key);
            mapVeiculos.put(key,v.clone()); 
        }
        return mapVeiculos; 
        
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
    
    public void setMotoristas (Map<String, AtorInterface> m){
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
    
    public void setAdmins (Map<String, AtorInterface> m){
        this.admins =m.entrySet()
                        .stream()
                        .collect(Collectors.toMap((e)->e.getKey(),
                                                  (e)->e.getValue().clone()));
                                                }
    
    
    /**
     * setVeiculos(List<VeiculoInterface> v - Modifica a lista de Veiculos
     * @param v : List<VeiculoInterface> v
     * 
     */
    
    public void setVeiculos(Map<String,VeiculoInterface> v){
        this.veiculos=v.entrySet()
                        .stream()
                        .collect(Collectors.toMap((e)->e.getKey(),
                                                  (e)->e.getValue().clone()));
                                                
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
        
        return equalsClientes(c.getClientes()) && equalsMotoristas(c.getMotoristas()) && equalsAdmins(c.getAdmins()) && 
        equalsVeiculos(c.getVeiculos()); 
        // return(this.equalsCLientes(c.getClientes()) fazer o mesmo para motoristas e veiculos);
        //return true;
    }
    
    
    /**
     * Método que faz o equals dos Clientes 
     */
    private boolean equalsClientes(Map<String, AtorInterface> cs){
        if(this.clientes.size() != cs.size() ){
            return false;
        }
        for(String email: this.clientes.keySet()){
            AtorInterface a = this.clientes.get(email);
            AtorInterface b = cs.get(email);
            
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
     * Método que faz o equals dos Motoristas 
     */
    private boolean equalsMotoristas(Map<String, AtorInterface> ms){
        if(this.motoristas.size() != ms.size() ){
            return false;
        }
        for(String email: this.motoristas.keySet()){
            AtorInterface a = this.motoristas.get(email);
            AtorInterface b = ms.get(email);
            
            if(a instanceof Motorista && b instanceof Motorista){
                Motorista a1 = (Motorista) a;
                Motorista b1 = (Motorista) b;
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
    
    public static boolean equalsListAtores(Map<String, AtorInterface> atores1, Map<String, AtorInterface> atores2){
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
     * Método que faz o equals dos Admin 
     * ver este 
     */
    private boolean equalsAdmins(Map<String, AtorInterface> cs){
        if(this.clientes.size() != cs.size() ){
            return false;
        }
        for(String email: this.clientes.keySet()){
            AtorInterface a = this.clientes.get(email);
            AtorInterface b = cs.get(email);
            
            if(a instanceof Admin && b instanceof Admin){
                Admin a1 = (Admin) a;
                Admin b1 = (Admin) b;
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
     * Metodo auxiliar para fazer o equals do map de Veiculos
     */
    
    private boolean equalsVeiculos(Map<String,VeiculoInterface> vi) {
        
        if(this.veiculos.size() != vi.size() ){
            return false;
        }
        for(String matricula: this.veiculos.keySet()){
            VeiculoInterface a = this.veiculos.get(matricula);
            VeiculoInterface b = vi.get(matricula);
            
            if(a.equals(b) == false){
                return false; 
            }  
        }
        return true;
    }
    
    
    /*
    public static boolean equalsVeiculos(List <VeiculoInterface> veiculos1, List<VeiculoInterface> veiculos2){
        for(VeiculoInterface veiculo: veiculos1){
            if(veiculo instanceof VeiculoInterface){
                Veiculo c = (Veiculo) veiculo;
                if(veiculos2.contains(c)==false){
                    return false;
                }  
            }
        } 
        return true;
    }
    
    private boolean equalsVeiculos(List<VeiculoInterface> vs){
        if(this.veiculos.size() != vs.size()){
           return false;  
        }
        for(VeiculoInterface v:this.veiculos){
            if(vs.contains(v)==false){
                return false; 
            }
        }
        return true; 
    }
    */
    
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
    
    public List<AtorInterface> listaDeMotoristas(){
        List<AtorInterface> listaMotoristas = new ArrayList<>();
        
        for(Map.Entry<String,AtorInterface> entry: this.motoristas.entrySet()){
            AtorInterface motorista = entry.getValue();
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
     * Método que devolve a lista de todos os Veiculos 
     */
    
    public List <VeiculoInterface> listaVeiculos(){
          List<VeiculoInterface> listaVeiculos = new ArrayList<>();
          for (Map.Entry<String, VeiculoInterface> entry : this.veiculos.entrySet()) {
            //String key = entry.getKey();
            VeiculoInterface veiculo = entry.getValue();
            listaVeiculos.add(veiculo.clone());
        }
        return listaVeiculos;
    }
    /*
    public List <VeiculoInterface> listaVeiculos(){
        List<VeiculoInterface> listaVeiculos = new ArrayList<>();
        
        for (VeiculoInterface v: veiculos) {
            listaVeiculos.add(v.clone()); 
    
        }
        
        return listaVeiculos; 
    }
    */
    
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
     * Método addAdmin - Adiciona um admin
     * @param admin
     */
    public void addAdmin(Admin admin){
        this.admins.put(admin.getEmail(), admin.clone());
    }
    
     /**
     * Método addVeiculo - Adiciona um veiculo 
     * @param veiculo
     */
    
    public void addVeiculo(VeiculoInterface veiculo){
        this.veiculos.put(veiculo.getMatricula(),veiculo.clone());
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
         this.veiculos.remove(veiculo.getMatricula());
        
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
     * @param nome
     */
    
    public List<AtorInterface> findClientePeloNome (String nome){
        List<AtorInterface> listClientes = new ArrayList<>(); 
        for(AtorInterface cliente: this.clientes.values()){
            if(cliente.getNome().toUpperCase().contains(nome.toUpperCase())){
                listClientes.add(cliente); 
            }
        }
        return listClientes; 
    }
    
    /**
     * devolve a lista de todas as matriculas registadas 
     */
    public List<String> matriculasReg(){
        List<String> res = new ArrayList<>();
        
        for(String key : this.veiculos.keySet()){
                res.add(key);
            }

        return res;
    }
    
    /**
     * Method loginValido
     *
     * @param email A parameter
     * @param password A parameter
     * @return The return value
     */
    /*
    public boolean loginValido (String email, String password) {
        char caracter; 
        AtorInterface cliente = getClienteComEmail(email);
        if(cliente!=null && cliente.getPassword().equals(AtorInterfaceesconderPassword(password, caracter ))){
            return true;
        }
        return false;
    }*/
    
    
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
    
    
    public boolean carroEstaRegistado(String matricula){
        
        if(this.veiculos.containsKey(matricula)){
            return true; 
        }
        return false; 
        
    }
    
    
    public void carroAdicionadoMotorista(Motorista motorista){
        this.motoristas.put(motorista.getEmail(),motorista); 
    }
    
    }
    
 

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
/**
 * A classe BD tem a lista de clientes, motoristas e veiculos existentes na empresa
 * 
 * @celia
 * @version 1.0
 */
public class BD implements BDInterface {
    
    private List<AtorInterface> clientes;
    private List<AtorInterface> motoristas; 
    private List<VeiculoInterface> veiculos; 
    private Set<Historico> historico;
    
    /**
     * Construtor vazio
     */
    
    public BD (){
        this.clientes = new ArrayList<AtorInterface>();
        this.motoristas = new ArrayList<AtorInterface>(); 
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
    
    public BD (List<AtorInterface> c,List<AtorInterface> m, List<VeiculoInterface> v , Set<Historico> h){
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
     * getClientes() - Devolve uma lista contendo todos os clientes 
     * 
     */
    public List<AtorInterface> getClientes(){
       List <AtorInterface> listaClientes = new ArrayList<AtorInterface>(); 
       
       for(AtorInterface ator : this.clientes){
           if(ator instanceof Cliente){
               Cliente c = (Cliente) ator;
               listaClientes.add(c.clone());
           }
        }
        return listaClientes; 
    }
    
    /**
     * getMotoristas() - Devolve uma lista contendo todos os motoristas 
     */
    
    public List<AtorInterface> getMotoristas(){
       List <AtorInterface> listaMotoristas = new ArrayList<AtorInterface>(); 
       
       for(AtorInterface ator : this.motoristas){
           if(ator instanceof Motorista){
               Motorista m = (Motorista) ator;
               listaMotoristas.add(m.clone());
           }
        }
        return listaMotoristas; 
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
     
        /** Isto nao funciona.Pesquisar como se faz
        return historico.stream()
                       .map(Historico::clone)
                       .collect(toSet());               
        */
    }
    
    //sets
    /**
     * setClientes(List<AtorInterface> c) - Modifica a lista de clientes
     * @param c : List<AtorInterface>
     */
    public void setClientes(List<AtorInterface> c){
        this.clientes=c.stream()
                       .map(AtorInterface::clone)
                       .collect(toList()); 
    }
    
    /**
     * setMotoristas(List<AtorInterface> m) - Modifica a lista de Motoristas
     * @param m : List<AtorInterface>
     */
    
    public void setMotoristas(List<AtorInterface> m){
        this.motoristas = m.stream()
                           .map(AtorInterface::clone)
                           .collect(toList()) ;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
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
        
        return(BD.equalsListAtores(this.clientes, c.getClientes()) && BD.equalsListAtores(this.motoristas, c.getMotoristas()) && BD.equalsVeiculos(this.veiculos, c.getVeiculos()));
        // return(this.equalsCLientes(c.getClientes()) fazer o mesmo para motoristas e veiculos);
    }
    
    
    /**
     * Método que faz o equals dos Clientes 
     */
    private boolean equalsClientes(List<Cliente> clientes){
        for(AtorInterface ator: this.clientes){
            if(ator instanceof Cliente){
                Cliente c = (Cliente) ator;
                if(clientes.contains(c)==false){
                    return false;
                }
            }
         }
         return true;
    }
    
    /**
     * Método que faz o equals de uma lista de Atores, diferenciando se são Cliente ou Motorista
     */
    
    public static boolean equalsListAtores(List<AtorInterface> atores1, List<AtorInterface> atores2){
        for(AtorInterface ator: atores1){
            if(ator instanceof Cliente){
                Cliente c = (Cliente) ator;
                if(atores2.contains(c)==false){
                    return false;
                }
                
            }
             if(ator instanceof Motorista){
                Motorista c = (Motorista) ator;
                if(!atores2.contains(c)){
                    return false;
                }
                
            }
        } 
        return true;
    }
    
    /**
     * Método auxiliar para fazer o equals da lista de Veiculos
     */
    
    public static boolean equalsVeiculos(List<VeiculoInterface> veiculos1, List<VeiculoInterface> veiculos2){
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
     * Método getListaDeMotoristas - devolve uma lista com todos os motoristas
     */
    
    public List<AtorInterface> getListaDeMotoristas(){
        return getMotoristas();
    }
    
    
    /**
     * Método que devolve a lista de todos os Clientes 
     */
    
    public List <AtorInterface> getListaClientes(){
        return getClientes(); 
    }
    
    /**
     * Método addCliente - Adiciona um cliente 
     * @param cliente
     */
    public void addCliente(Cliente cliente){
        this.clientes.add(cliente.clone());
    }
    
     /**
     * Método addMotorista - Adiciona um motorista
     * @param motorista
     */
    
    public void addMotorista(Motorista motorista){
        this.motoristas.add(motorista.clone());
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
        for(AtorInterface atorInterface: this.clientes){
            if(atorInterface instanceof Cliente){
                Cliente c = (Cliente) atorInterface;
                if(c.equals(cliente)){
                    this.clientes.remove(atorInterface);
                    break;
                }
            }
        }
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
        if(this.motoristas.contains(motorista)){
            this.motoristas.remove(motorista); 
        }
  
    }
    /**
     * Devolve a lista de Clientes com determinado nome, quer esteja com maiúsculas ou minúsculas 
     * @param nome
     */
    
    public AtorInterface findClientePeloNome(String nome){
        for(AtorInterface cliente : this.clientes){
            if(cliente.getNome().toLowerCase().equals(nome.toLowerCase())){
                return cliente; 
            }
            
        }
        return null; 
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
         for(AtorInterface ator: this.clientes){
             if(ator.getEmail().equals(email)){
                return ator.clone();
             }
         }
         return null;
    }
    
    public AtorInterface getMotoristaComEmail(String email){
         for(AtorInterface ator: this.motoristas){
             if(ator.getEmail().equals(email)){
                return ator.clone();
             }
         }
         return null;
    }
    
    
    public Motorista getMotoristaMaisPerto(AtorInterface cliente){
        for(AtorInterface ator: this.motoristas){
            
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
             BASE64Encoder encoder = new BASE64Encoder (); 
             return encoder.encode(digest.digest()); 
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
    
 

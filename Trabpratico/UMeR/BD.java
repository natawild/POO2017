import java.util.List; 
import java.util.ArrayList; 
import static java.util.stream.Collectors.toList;

/**
 * A classe BD tem a lista de clientes, motoristas e veiculos existentes na empresa
 * 
 * @celia
 * @version 1.0
 */
public class BD{
    
    private List<AtorInterface> clientes;
    private List<AtorInterface> motoristas; 
    private List<VeiculoInterface> veiculos; 
    
    /**
     * Construtor vazio
     */
    
    public BD (){
        this.clientes = new ArrayList<AtorInterface>();
        this.motoristas = new ArrayList<AtorInterface>(); 
        this.veiculos = new ArrayList<VeiculoInterface>(); 
    
    }
    
    /**
     * Construtor parametrizado
     */
    
    public BD (List<AtorInterface> c,List<AtorInterface> m,List<VeiculoInterface> v ){
        clientes = c; 
        motoristas = m; 
        veiculos = v; 
    }
    
    /**
     * Construtor por cópia 
     */
    public BD (BD bd){
        clientes = bd.getClientes(); 
        motoristas = bd.getMotoristas();
        veiculos = bd.getVeiculos(); 
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
       sb.append( "Lista de Clientes: \n" +clientes );
       sb.append(" LIsta de Motoristas: \n" +motoristas);  
       sb.append(" LIsta de Veiculos: \n" +veiculos);         
       return sb.toString();
    
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
    
    
    

}

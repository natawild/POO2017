import java.util.List; 
import java.util.ArrayList;  
import java.io.Serializable;
/**
 * classe CarroFilaEspera 
 * 
 * @celia
 * @version (número de versão ou data)
 */
public class CarroFilaEspera extends CarroLig implements FilaEsperaInterface,Serializable{
    List<Cliente> filaClientes; 
    
    /**
     * Construtor vazio 
     */
    
    public CarroFilaEspera (){
        super(); 
        this.filaClientes = new ArrayList<Cliente>(); 
    }
    
    /**
     * Construtor parametrizado 
     * @param matricula
     * @param marca
     * @param vm
     * @param preco
     * @param fiabilidade
     * @param coord
     * @param filaEspera
     * 
     */
    
    public CarroFilaEspera(String matricula,String marca, float fiabilidade, 
    Coordenadas coord, List<Cliente> filaClientes){
        super(matricula,marca,fiabilidade, coord);
        this.filaClientes= filaClientes; 
    }
    
    
    /**
     * Construtor de cópia 
     * @param mfe
     */
    
    public CarroFilaEspera (CarroFilaEspera mfe){
        super(mfe); 
        this.filaClientes= mfe.getFilaClientes();   
    }
    
    /**
     * get 
     */
    
    public List <Cliente> getFilaClientes(){
        List<Cliente> listaClientes = new ArrayList<>();
        
        for(Cliente cliente : this.filaClientes){
              listaClientes.add(cliente.clone()); 
        }
        return listaClientes;
    }
    
    /**
     * set
     */
    public void setFilaEspera (List<Cliente> filaClientes){
        List<Cliente> listaClientes = new ArrayList<>();
         
        for(Cliente cliente: filaClientes){
              listaClientes.add(cliente.clone()); 
            } 
            
        this.filaClientes=listaClientes;  
    }
    
    /**
     * FIFO 
     * Método que indica qual o próximo cliente da lista a ser atendido 
     * if(fila de clientes é diferente de zero){
     *     o cliente a ser removido será o primeiro da lista 
     *  }
     * 
     */
    public Cliente proximoCliente(){
        if(this.filaClientes.size()!=0) {
              Cliente a = this.filaClientes.get(0);
              this.filaClientes.remove(a);
              return a; 
        }
        else 
            return null; 
    }
    
      /**
     * Metodo equals
     */
     public boolean equals (Object carroFilaEsp){
        if(this == carroFilaEsp) 
            return true; 
            
        if((carroFilaEsp == null) || (this.getClass()!= carroFilaEsp.getClass()))
        return false; 
        
        CarroFilaEspera c = (CarroFilaEspera) carroFilaEsp;
        
        return super.equals(c) && equalsListas(c.getFilaClientes());  
    }
    
    public boolean equalsListas (List <Cliente> l1){
        if(l1.size()!=this.filaClientes.size())
            return false; 
        else{
            for(Cliente cliente : l1){
                if(filaClientes.contains(cliente)==false){
                    return false; 
                }
            }
            return true; 
        
        }
 
    }
    
    /**
     * método toString 
     */
    
    public String toString (){
        StringBuilder sb = new StringBuilder("Carro com fila de espera\n"); 
        sb.append(super.toString());
        sb.append("Clientes em Espera: " + this.getFilaClientes());
        return sb.toString();  
    }
    
    
    //clone
    public CarroFilaEspera clone (){
        return new CarroFilaEspera(this);    
    }
}

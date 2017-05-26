import java.util.List; 
import java.util.ArrayList; 
import java.io.Serializable;
/**
 * A classe MotoFilaEspera 
 * 
 * @celia
 * @version 1.0
 */
public class MotoFilaEspera extends Moto implements FilaEsperaInterface,Serializable{
    private List<Cliente> filaClientes;
    
    /**
     * Construtor vazio 
     */
    
    public MotoFilaEspera (){
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
     * @param filaClientes
     * 
     */
    
    public MotoFilaEspera(String matricula,String marca, float fiabilidade, 
    Coordenadas coord, List<Cliente> filaClientes){
        super(matricula,marca,fiabilidade, coord);
        this.filaClientes= filaClientes; 
    }
    
    
    /**
     * Construtor de cópia 
     * @param mfe
     */
    
    public MotoFilaEspera (MotoFilaEspera mfe){
        super(mfe); 
        this.filaClientes= mfe.getFilaClientes();   
    }
    
    /**
     * get 
     */
    
    public List<Cliente> getFilaClientes(){
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
     * Metodo equals
     */
     public boolean equals (Object motoFilaEsp){
        if(this == motoFilaEsp) 
            return true; 
            
        if((motoFilaEsp == null) || (this.getClass()!= motoFilaEsp.getClass()))
        return false; 
        
        MotoFilaEspera c = (MotoFilaEspera) motoFilaEsp;
        
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
        return null; 
    }
    
    /**
     * método toString 
     */
    
    public String toString (){
        StringBuilder sb = new StringBuilder("Moto com fila de espera\n"); 
        sb.append(super.toString());
        sb.append("Clientes em Espera: " + this.getFilaClientes());
        return sb.toString();  
    }
    
    
    //clone
    public MotoFilaEspera clone (){
        return new MotoFilaEspera(this);    
    }
    
    
    
    
}

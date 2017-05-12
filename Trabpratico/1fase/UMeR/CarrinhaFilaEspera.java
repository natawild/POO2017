import java.util.List; 
import java.util.ArrayList; 
/**
 * A classe CarrinhaFilaEspera serve para especificar quais os veiculos do tipo Carrinha que permitem fila 
 * de espera por parte dos clientes. 
 * 
 * @celia
 * @version (número de versão ou data)
 */
public class CarrinhaFilaEspera extends Carrinha implements FilaEsperaInterface {
    
    private List<Cliente> filaClientes;
    
    /**
     * Construtor vazio 
     */
    
    public CarrinhaFilaEspera (){
        super(); 
        this.filaClientes = new ArrayList<>(); 
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
    
    public CarrinhaFilaEspera(String matricula,String marca, double vm, double preco, int fiabilidade, 
    Coordenadas coord, List<Cliente> filaClientes){
        super(matricula,marca,vm,preco,fiabilidade, coord);
        this.filaClientes= filaClientes; 
    }
    
    
    /**
     * Construtor de cópia 
     * @param mfe
     */
    
    public CarrinhaFilaEspera (CarrinhaFilaEspera mfe){
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
     public boolean equals (Object carrinhaFilaEsp){
        if(this == carrinhaFilaEsp) 
            return true; 
            
        if((carrinhaFilaEsp == null) || (this.getClass()!= carrinhaFilaEsp.getClass()))
        return false; 
        
        CarrinhaFilaEspera c = (CarrinhaFilaEspera) carrinhaFilaEsp;
        
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
        StringBuilder sb = new StringBuilder(); 
        sb.append("Carrinha com fila de espera\n");
        sb.append("Carrinha dados: " + super.toString());
        sb.append("Clientes em Espera: " + this.getFilaClientes());
        return sb.toString();  
    }
    
    
    //clone
    public CarrinhaFilaEspera clone (){
        return new CarrinhaFilaEspera(this);    
    }
}

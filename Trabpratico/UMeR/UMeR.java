
/**
 * Classe UMeR aqui será a implementação das funções necessárias
 * @celia
 * @version 1.0
 */
public class UMeR{
    private BDInterface baseDeDados;
    
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
        StringBuilder sb = new StringBuilder("Motorista: \n"); 
        sb.append("Base de dados: " + this.baseDeDados);
        return sb.toString(); 
    }
    
    
    public UMeR clone (){
        return new UMeR(this);    
    }
    
    public Motorista pesquisaMotorista(String email){
        return (Motorista) this.baseDeDados.getMotoristaComEmail(email);
    }
    
    public Cliente pesquisaCliente(String email){
        return (Cliente) this.baseDeDados.getClienteComEmail(email);
    }
    
    public Motorista getMotoristaMaisPerto(Cliente cliente){
        double distancia= Double.MAX_VALUE;
        Motorista motoristaMaisPerto = null;
        for(AtorInterface motorista: baseDeDados.getListaDeMotoristas()){
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
}

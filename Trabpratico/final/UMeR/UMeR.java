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
    private AtorInterface ator; 
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
     * Registar Ator 
     * 
     */
    public void registarUtilizador(Cliente cliente) throws AtorExistenteException {
		String id = cliente.getEmail();

		if (cliente.getEmail().contains(id))
			throw new AtorExistenteException("Utilizador "+id+" já existe");

		this.baseDeDados.listaClientes().add(cliente.clone());
	}
    
	
	/**
     * Iniciar sessão na aplicação.
     * @param email
     * @param password
     */
     public void iniciaSessao(String email, String password) throws SemAutorizacaoException {

        if (this.ator == null) {

            if(atores.containsKey(email)){
                 AtorInterface user = atores.get(email);
                 if (password.equals(ator.getPassword())) {
                        ator = user;
                 }
                 else {
                        throw new SemAutorizacaoException("Dados Errados");
                 }
            }
            else throw new SemAutorizacaoException("Dados Errados");
        }
        else {
            throw new SemAutorizacaoException("Ja tem uma sessão iniciada");
        }

    }
    
    /**
     * Fechar sessão na aplicação.
     */
    public void fechaSessao(){
        this.ator = null;
    }


    
    /**
	 * Obter mapeamento para cada motorista, respetivo veiculo 
	 * @return Mapeamento veiculo, motorista
	 */
	public Map<AtorInterface, VeiculoInterface> obterMapMotoVei() {
		Map<AtorInterface, VeiculoInterface> map = new TreeMap<>();

		for(AtorInterface u: this.baseDeDados.listaDeMotoristas()) {
			if (u instanceof Motorista) {
				Motorista m = (Motorista) u;

				for(VeiculoInterface vi: this.baseDeDados.listaVeiculos()){
				    
					map.put(m, vi);
				}
			}
		}

		return map;
	}
    
    
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
        oos.writeObject(this);

        oos.flush();
        oos.close();
    }

    /**
     * Iniciar a aplicação com o estado guardado num determinado ficheiro.
     * @param fich
     * @return
     */
    public static UMeR leObj(String fich) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));

        UMeR te = (UMeR) ois.readObject();

        ois.close();
        return te;
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

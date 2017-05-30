import java.util.List; 
import java.util.Set;
/**
 * A interface BDInterface serve para especificar quais métodos que as classes terão que implementar. 
 * Quando uma classe implementa BDInterface, esta classe também precisa de implementar todos os métodos 
 * que estão na interface, apenas quando usamos classes abstratas que implementam a interface é que não precisamos 
 * obrigatoriamente de implementar todos os métodos.
 * 
 * @celia
 * @version (número da versão ou data)
 */

public interface BDInterface{  
    
    public BDInterface clone();
    
    public String toString();
    
    public List<AtorInterface> listaMotoristas();
    
    public List<AtorInterface> listaClientes(); 
    
    public List <VeiculoInterface> listaVeiculos();
    
    public void addCliente(Cliente cliente);
    
    public void addMotorista(Motorista motorista);
    
    public void addVeiculo(VeiculoInterface veiculo);
    
    public void addAdmin(Admin admin);
    
    public void addHistorico(Historico historico);
    
    public void removeCliente(Cliente cliente);
    
    public void removeVeiculo(Veiculo veiculo);
    
    public void removeMotorista(Motorista motorista);
    
    public List<AtorInterface> findClientePeloNome (String nome);
    
    /*public boolean loginValido(String email, String password);*/
    
    public AtorInterface getClienteComEmail(String email);
    
    public AtorInterface getMotoristaComEmail(String email);
    
    public List<String> matriculasReg();
    
    public boolean carroEstaRegistado(String matricula); 
    
    public void carroAdicionadoMotorista(Motorista motorista);
    
    public boolean temAdminsRegistados();
    
    public void atualizaAtor(AtorInterface ator);
    
    public void adicionaVeiculoAMotorista(AtorInterface atorLogado,VeiculoInterface v);
    
    public void alteraDisponibilidade(AtorInterface atorLogado, boolean estado);
    
    public void atualizaHorario(AtorInterface atorLogado, boolean estado); 
    
    public void clienteEmViagem(AtorInterface ator, boolean estado);
    
    public void adicionaViagemEmProcessoAoMotorista(AtorInterface motorista, Historico historico);
    
    public AtorInterface terminarViagem(AtorInterface motorista);
    
    public List<Historico> historicoViagensPorAtor (AtorInterface ator);
     
    public List<Historico> historicoViagensPorClassificarPorAtor(AtorInterface ator);
    
    public void atualizaClassificacao(Historico h, int classificacao);
}

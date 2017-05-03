import java.util.List; 
import java.util.Set;
/**
 * Escreva a descrição da interface BDInterface aqui.
 * 
 * @author (seu nome) 
 * @version (número da versão ou data)
 */

public interface BDInterface
{    
    public BDInterface clone();
    
    public String toString();
    
    public List<AtorInterface> getListaDeMotoristas();
    
    public void addCliente(Cliente cliente);
    
    public void addMotorista(Motorista motorista);
    
    public void addVeiculo(VeiculoInterface veiculo);
    
    public void addHistorico(Historico historico);
    
    public void removeCliente(Cliente cliente);
    
    public void removeVeiculo(Veiculo veiculo);
    
    public void removeMotorista(Motorista motorista);
    
    public AtorInterface findClientePeloNome(String nome);
    
    public boolean loginValido(String email, String password);
    
    public AtorInterface getClienteComEmail(String email);
    
    public AtorInterface getMotoristaComEmail(String email);
    
    public Motorista getMotoristaMaisPerto(AtorInterface cliente);
    
    public List<String> matriculasReg();
}

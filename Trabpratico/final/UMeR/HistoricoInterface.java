import java.time.LocalDateTime; 
/**
 * Escreva a descrição da interface HistoricoInterface aqui.
 * 
 * @author (seu nome) 
 * @version (número da versão ou data)
 */

public interface HistoricoInterface
{
    public Historico clone();
    
    public LocalDateTime getDataDeInicioDeServico();
    
    public double getTempoReal();
    
    public double getValorCobrado();
    
    public void setDataDeInicioDeServico (LocalDateTime dataDeInicioDeServico);
    
    public void setTempoEstimado(double tempoEstimado);
    
    public void setTempoReal(double tempoReal);
    
    public void setValorCobrado( double valorCobrado);
    
    public boolean equals (Object o);
    
    public String toString();
}

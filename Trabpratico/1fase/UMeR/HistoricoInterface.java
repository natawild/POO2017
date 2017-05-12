import java.time.LocalDateTime; 
/**
 * Escreva a descrição da interface HistoricoInterface aqui.
 * 
 * @author (seu nome) 
 * @version (número da versão ou data)
 */

public interface HistoricoInterface
{
    public HistoricoAtor clone();
    
    public LocalDateTime getDataDeInicioDeServico();
    
    public float getTempoReal();
    
    public float getValorCobrado();
    
    public void setDataDeInicioDeServico (LocalDateTime dataDeInicioDeServico);
    
    public void setTempoEstimado(float tempoEstimado);
    
    public void setTempoReal(float tempoReal);
    
    public void setValorCobrado( float valorCobrado);
    
    public boolean equals (Object o);
    
    public String toString();
}

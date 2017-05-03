import java.util.Comparator; 
/**
 * Escreva a descrição da classe NomeComparator aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class NomeComparator implements Comparator <Lugar>{
    public int compare (Lugar l1, Lugar l2){
    return l1.getNome().compareTo(l2.getNome());
    }
   
}

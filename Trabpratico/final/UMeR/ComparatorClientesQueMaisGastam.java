import java.util.Comparator;
import java.util.Map;
/**
 * Escreva a descrição da classe Comparator aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ComparatorClientesQueMaisGastam implements Comparator<String> {

    private Map<String, Double> map;

    public ComparatorClientesQueMaisGastam(Map<String, Double> map) {
        this.map = map;
    }

    public int compare(String a, String b) {
        return map.get(a).compareTo(map.get(b));
    }
}

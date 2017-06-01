import java.util.Comparator;
import java.util.Map;
/**
 * Escreva a descrição da classe ComparatorGrauCumprimentoCUsto aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ComparatorGrauCumprimentoCusto implements Comparator<String> {

    private Map<String, Double> map;

    public ComparatorGrauCumprimentoCusto(Map<String, Double> map) {
        this.map = map;
    }

    public int compare(String a, String b) {
        if(map.get(b).compareTo(map.get(a)) == 0){
            return -1;
        }
        return map.get(b).compareTo(map.get(a));
    }
}

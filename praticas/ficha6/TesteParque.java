import java.util.HashSet; 
/**
 * Escreva a descrição da classe TesteParque aqui.
 * 
 * @celia (seu nome) 
 * @version (número de versão ou data)
 */
public class TesteParque{
    public static void main(String[] args){
        Parque p1 = new Parque(); 
        HashSet<Parque> hs = new HashSet<>(); 
        Lugar l = new Lugar("a","a",10,true); 
        
        p1.addLugar(l);
        p1.addLugar(new Lugar()); 
        hs.add(p1);
        System.out.println("OK? (1)" +hs.size());
        System.out.println("OK? (true)" +hs.contains(p1));
        
        hs.add(new Parque());
        hs.add(new Parque());
        System.out.println("OK? (2)" +hs.size());
        System.out.println("OK? (true)" +hs.contains(new Parque()));
        
       hs.forEach(p->System.out.println("OK?" +p1.getLugaresPorTempo()));
       
       System.out.println("Ordenado" +p1.getLugaresPorTempo());
       //System.out.println("Ordenado" +p1.getLugaresPorTempo(new NomeComparator()));
    
    }
    
    
 
}

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.List; 
import java.util.ArrayList; 
import java.util.stream.Collectors; 
import java.lang.StringBuilder; 
import java.util.TreeSet;
/*
 * Escreva a descrição da classe Parque aqui.
 * 
 * @celia (seu nome) 
 * @version (número de versão ou data)
 */
public class Parque {
    
    //associação entre uma classe e outra é um map 
    
    private String nome; 
    private Map<String,Lugar> lugares; 
    
    
    /**
     * Construtor vazio
     */
    public Parque (){
        this(" ");
    
    }
    
    public Parque (String nome){
        this.nome=nome; 
        this.lugares = new HashMap<String,Lugar>(); 
    
    }
    
    /**
     * construtor por cópia
     */
    public Parque (Parque p){
        this.nome= p.getNome();
        this.lugares= p.getLugares(); 
    }
    
    public Parque (String nome, Map<String, Lugar> lug){
        this(nome); //encadeamento de construtores
        //this.nome=nome;
        //this.lugares = new HashMap<String,Lugar>();
        /**
        for(String m : lug.keySet()){
            Lugar l = lug.get(m); 
            this.lugares.put(m,l.clone()); 
            this.lugares = lugares.clone() ; //usamos o clone para manter privado 
        }//ficamos com uma copia dos lugares que nos passaram
        
        /**
         * percorrer todos os valores 
        
        
        for(Lugar l : lug.values()){
            this.lugares.put(l.getMatricula(), l.clone()); 
        }
        */
        
       /**
         * percorrer a pares 
         */
        
        for(Map.Entry<String, Lugar> e : lug.entrySet()){
            this.lugares.put(e.getKey(), e.getValue().clone()); 
        
        }

    }       
    
    public Set<String> getMatriculas(){
        return this.lugares.keySet();
        
    }
    
    public void addLugar(Lugar l){
        this.lugares.put(l.getMatricula(),l.clone());
    
    }
    
    public void remove(String mat){
        this.lugares.remove(mat); 
    
    }
    
    public void alteraTempo(String mat, int tempo){
        this.lugares.get(mat).setMinutos(tempo); 
        
    }
    
    /**
     * pré-condição a matricula tem que existir 
     */
    
    public void alteraMinuto(String mat, int tempo){
       Lugar l = this.lugares.get(mat); 
       if(l!=null){
           l.setMinutos(tempo);
        }
        
    }
    
    public int totalMinutos(){
        /**
        Iterator <Lugar> it = this.lugaresvalues().iterator();
        while(it.hasNext()){
            Lugar l = it.next();
            total+=l.getMinutos();
        
        }
        */
        int total=0; 
        for(Lugar l: this.lugares.values()){
            total+=l.getMinutos();
        }
        return total; 
    
    }
    
    /**
     * versão com iterador interno streams 
     */
    public int totalMinutosF() {
        return this.lugares.values()
                            .stream()
                            .mapToInt(Lugar::getMinutos)
                            .sum(); 
    }
    
    public boolean existe(String mat){
        return this.lugares.containsKey(mat); 
    
    }
    
    public List<String> getPermanentes(int tempo){
        List<String> res= new ArrayList<String>(); 
        
        for(Lugar l : this.lugares.values()){
            if(l.getMinutos() > tempo && l.getPermanente()){
                res.add(l.getMatricula()); 
            }
        }
        return res; 
        
    }
    
    public List<String> getPermanentesF(int tempo){
        return this.lugares.values()
                            .stream()
                            .filter(l -> l.getMinutos()>tempo && l.getPermanente())
                            .map(Lugar::getMatricula)
                            .collect(Collectors.toList());
    }
    
    
    
    
    public String toString(){
        StringBuilder sb = new StringBuilder("Parque("); 
        sb.append(nome); 
        sb.append(", "); 
        sb.append(lugares.toString()); 
        sb.append(")"); 
        return sb.toString();
    
    }
    
    public int hasCode(){
    return nome.hashCode(); 
    }
    
    public boolean equals(Object o){
        if(o== this) return true; 
        if((o== null) || (o.getClass()!=this.getClass()))
        return false; 
        Parque p = (Parque) o; 
        return this.nome.equals(p.getNome()) && this.lugares.equals(p.getLugares());
    }
    
    
    public String getNome(){
    return this.nome; 
    }
    
    /**
     * iterador externo 
     */
    public Map<String, Lugar> getLugares(){
        Map<String, Lugar> copia = new HashMap<>(); 
        for(Map.Entry<String,Lugar> e : lugares.entrySet()){
            copia.put(e.getKey(), e.getValue().clone());
        
        }
        return copia; 
        //return lugares.entrySet().stream().collect(Collectors.toMap(e->egetValue().clone()));
    
    }
    
    
    /**
     * iterador interno 
     * return lugares.entrySet().stream().collect(Collectors.toMap(e->egetValue().clone())); 
     */
    
   
    //procurar os lugares por tempo
     public TreeSet <Lugar> getLugaresPorTempo(){
        //TreeSet<Lugar> res = new TreeSet<>(); //usa a ordem natural dos objetos
        TreeSet<Lugar> res = new TreeSet<>();
        for(Lugar l : lugares.values() ){
            res.add(l.clone());
        
        }
        return res; 
    
    }
    
     public Map<Integer, List<Lugar>> getAgrupPorTempo(){
        Map<Integer, List<Lugar> >res = new HashMap<>(); 
        for(Lugar l : lugares.values()){
            if(!res.containsKey(l.getMinutos())){
                res.put(l.getMinutos(), new ArrayList<>());
            }
            res.get(l.getMinutos()).add(l.clone());
        }
        return res; 

      
    }
    
    /**
     * return this.lugares.values().stream().map(Lugar::clone).collect(Collectors.groupingBy(Lugar::getMinutos)))
     */
    
    
   
}

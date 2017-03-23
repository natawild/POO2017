import java.util.List; 
import java.util.stream.Stream; 
import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.stream.Collectors; 

/**
 * Escreva a descrição da classe Playlist aqui.
 * 
 * @celia
 * @version (número de versão ou data)
 */
public class Playlist{
    
    private String nome;
    private List <Faixa> lista; 
    
    public Playlist(){
        this.nome="";
        this.lista = new ArrayList();
    }
    
    /**
     * 
     */
    public List<Faixa> getLista(){
        List<Faixa> copia = new ArrayList<Faixa>();
        for(Faixa f:lista){
            copia.add(f.clone());
        }
        return copia; 
    }
    
    /**Iterador interno 
     * 
     */
    
     public List<Faixa> getListai(){
         List<Faixa> copia = new ArrayList<Faixa>();
         lista.forEach(Faixa->copia.add(Faixa.clone()));
         return copia; 
         
     }
     
     /**
     * 
     */
    
    public List<Faixa> getListastream(){
        return lista.stream().map(Faixa->Faixa.clone()).collect(Collectors.toList());
    }

    
    /**
     * Determinar o numero total de faixas na Playlist
     */

    public int numFaixas(){
        int i=0;
        return i; 
        
    }
    
    
    /**
     * Adicionar uma nova faixa no final da playList
     */
    
    public void addFaixa(){
    }
    
    /**
     * Remover uma  faixa  da plaList
     */
    public void removeFaixa(){
    }
    
    /**
     * Dado um List de faixa, juntar tais faixas à playlist recetora. Implementar com iterador externo
     */
    
    public void adicionar(List<Faixa>faixas){
        
        faixas.forEach(Faixa->lista.add(Faixa.clone()));
    }
    
    /**
     * Dado um List de faixa, juntar tais faixas à playlist recetora. Implementar com iterador interno
     */
    
    public void adicionarF(List<Faixa>faixas){
        lista=Stream.concat(lista.stream()
                           ,faixas.stream().map(Faixa::clone)).collect(Collectors.toList()); 
    }
    
    /**
     * Determinar quantas faixas tem uma classificacao superior à faixa dada como parametro, implementado
     * como iterador externo
     */
    public int classificacaoSuperior(Faixa f){
        List <Faixa> aux = new ArrayList<Faixa>();
        for(Faixa fx : lista){
            Faixa copia = fx.clone(); 
            copia.setClassificacao(f.getClassificacao());
            aux.add(copia);
        }
        return aux; 
    }
    
     /**
     * Determinar quantas faixas tem uma classificacao superior à faixa dada como parametro, implementado
     * como iterador INTERNO
     */
    public int classificacaoSuperiorF(Faixa f){
        return (int) lista.stream().filter(aux->aux.getClassificacao()>f.getClassificacao()).count(); 
    }
    
    
    /**
     *Determinar se alguma faixa tem duracao superior ao valor passado como parametro. Implementar 
     *como iterador externo
     **/

    public boolean duracaoSuperior(double d ){
        boolean enc= false; 
        for(Faixa f : lista){
            if(f.getDuracao()>d){
                enc=true; 
            }
        }
        return enc; 
    }
    
    /**
     *Determinar se alguma faixa tem duracao superior ao valor passado como parametro
     *Iterador externo 
     **/
    public boolean duracaoSuperioritex(double d ){
        boolean enc=false; 
        Iterator<Faixa> it = lista.iterator();
        while(it.hasNext() && !enc){
            Faixa f = it.next();
            if(f.getDuracao()>d){
                enc=true; 
            }
        }
        return enc;
    }
    
     /**
     *Determinar se alguma faixa tem duracao superior ao valor passado como parametro
     *Iterador interno
     **/
    
    public boolean duracaoSuperiorF(double d ){
        boolean enc=false; 
        lista.forEach((Faixa f)->{if(f.getDuracao()>d) enc=true;});
        return enc;
    }
    

     /**
     *Determinar se alguma faixa tem duracao superior ao valor passado como parametro
     *Iterador interno
     *Utilizando streams pego nos elementos da lista e vejo se faz match 
     **/

     public boolean duracaoSuperiorFn(double d ){
         return lista.stream().anyMatch(f->f.getDuracao()>d);
         
        }
        
     /**
      * Devolver uma cópia listagem de músicas, em que o valor da sua classificação seja alterado
      * para o valor passado como parâmetro. Implementar como iterador externo
      */
     public List<Faixa> getCopiaFaixas(int n){
     }
     
      /**
      * Devolver uma cópia listagem de músicas, em que o valor da sua classificação seja alterado
      * para o valor passado como parâmetro. Implementar como iterador interno
      */
     public List<Faixa> getCopiaFaixasF(int n){
     }
     
     /**
      * determinar a duraação total da playlist. Implementar como iterador externo
      */
     public double duracaoTotal(){
        }
        
      /**
      * determinar a duraação total da playlist. Implementar como iterador interno
      */
     public double duracaoTotalF(){
        }
        
     /**
      * Remover as faixas de determinado autor. Implementar como iterador externo
      */
     
     public void removeFaixas(String autor){
        }
        
      /**
      * Remover as faixas de determinado autor. Implementar como iterador interno
      */
     
     public void removeFaixasF(String autor){
        }
         
}

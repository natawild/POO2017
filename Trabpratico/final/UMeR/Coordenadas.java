import java.io.Serializable;
/**
 * A classe Coordenadas tem o objetivo de guardar a localização de um Veiculo,
 * utilizando coordenadas (x (x) e y (y)).
 * 
 * @celia 1.0
 */

public class Coordenadas implements Serializable{
    
    private double x;
    private double y;
    
    /**
     * Construtor vazio, ou seja, inicia as coordenadas a 0.
     */
    public Coordenadas(){
        this.x=Utils.generateRandom(0f, 100f);
        this.y=Utils.generateRandom(0f, 100f);
    }
    
    /**
     * Construtor parametrizado, ou seja, recebe a x (x) e a y (y) e cria uma coordenada
     * com esses valores.
     * @param   x    x do veiculo.
     * @param   y    y do veiculo.
     */
    public Coordenadas(double x, double y){
        this.x=x;
        this.y=y;
    }
    
    /**
     * Construtor por cópia, ou seja, copia os dados de uma Coordenada já existente.
     * @param   c   Coordenadas que irão ser copiadas.
     */
   
    public Coordenadas(Coordenadas c){
        this.x = c.getX();
        this.y = c.getY();
    }
    
    /*
     * Gets
     */
    
    /**
     * A função getX devolve a x de uma Coordenada.
     */
    public double getX(){ 
        return x; 
    }
    
    /**
     * A função getY devolve a y de uma Coordenada.
     */
    public double getY(){ 
        return y; 
    }
    
    /*
     * Sets
     */
    
    /**
     * A função setx altera a x de uma Coordenada.
     * @param x Valor da x que irá substituir a x.
     */
    public void setX(double x){ 
        this.x=x; 
    }
    
    /**
     * A função sety altera a y de uma Coordenada.
     * @param y Valor da x que irá substituir a y.
     */
    public void setY(double y){ 
        this.y=y; 
    }
    
    /*
     * Funcoes aux
     */
    
    /**
     * A função toString imprime uma Coordenada, ou seja, imprime a x e y da mesma.
     * @param c A coordenada que irá ser impressa.
     */
    public String toString (){
       StringBuilder str = new StringBuilder();
       str.append( "x: "  + this.x);
       str.append(" y: " + this.y);         
       return str.toString();
    }
        
    /**
     * A função equals recebe um Objeto genérico e verifica se é exatamente igual a uma Coordenada.
     * @param obj Objecto a comparar.
     */
    public boolean equals(Object obj){
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        
        Coordenadas c = (Coordenadas) obj;
        
        return(this.x==c.getX() && this.y==c.getY());
    }
    
    /**
     * A função clone faz um clone de uma Coordenada, a partir do construtor por cópia.
     */
    public Coordenadas clone(){
        return new Coordenadas(this);
    }
    
    /**
     * O método getDistancia() calcula distancias, neste caso a distância euclidiana 
     * que é obtida pela seguinte fórmula: 
     * distancia = Math.sqrt( Math.pow( (x1 - x2),2 ) +
                               Math.pow( (y1 - y2),2 ) );
                               
      @param c Coordenadas                         
     */
    
    public double getDistancia (Coordenadas c){
        double distancia=0; 
        distancia = Math.sqrt( Math.pow( (this.x - c.getX()),2 ) +
                               Math.pow( (this.y - c.getY()),2 ) );
        return distancia; 
    
    }
    
    
  
}

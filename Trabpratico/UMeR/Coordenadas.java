/**
 *  * A classe Coordenadas tem o objetivo de guardar a localização de um Veiculo,
 *  * utilizando coordenadas (latitude (x) e longitude (y)).
 * 
 * @celia 1.0
 */

public class Coordenadas{
    
    private double latitude;
    private double longitude;
    
    /**
     * Construtor vazio, ou seja, inicia as coordenadas a 0.
     */
    public Coordenadas(){
        this.latitude=0;
        this.longitude=0;
    }
    
    /**
     * Construtor parametrizado, ou seja, recebe a latitude (x) e a longitude (y) e cria uma coordenada
     * com esses valores.
     * @param   lat     Latitude da cache.
     * @param   lon     Longitude da cache.
     */
    public Coordenadas(double lat, double lon){
        this.latitude=lat;
        this.longitude=lon;
    }
    
    /**
     * Construtor por cópia, ou seja, copia os dados de uma Coordenada já existente.
     * @param   c   Coordenadas que irão ser copiadas.
     */
   
    public Coordenadas(Coordenadas c){
        this.latitude = c.getLatitude();
        this.longitude = c.getLongitude();
    }
    
    /*
     * Gets
     */
    
    /**
     * A função getLatitude devolve a latitude de uma Coordenada.
     */
    public double getLatitude(){ 
        return latitude; 
    }
    
    /**
     * A função getLongitude devolve a longitude de uma Coordenada.
     */
    public double getLongitude(){ 
        return longitude; 
    }
    
    /*
     * Sets
     */
    
    /**
     * A função setLatitude altera a latitude de uma Coordenada.
     * @param lat Valor da latitude que irá substituir a latitude.
     */
    public void setLatitude(double lat){ 
        this.latitude=lat; 
    }
    
    /**
     * A função setLongitude altera a longitude de uma Coordenada.
     * @param lon Valor da latitude que irá substituir a longitude.
     */
    public void setLongitude(double lon){ 
        this.longitude=lon; 
    }
    
    /*
     * Funcoes aux
     */
    
    /**
     * A função toString imprime uma Coordenada, ou seja, imprime a latitude e longitude da mesma.
     * @param c A coordenada que irá ser impressa.
     */
    public StringBuilder toString (Coordenadas c){
       StringBuilder str = new StringBuilder();
       str.append( "Latitude "  + c.getLatitude());
       str.append(",Longitude " + c.getLongitude());         
       return str;
    }
        
    /**
     * A função equals recebe um Objeto genérico e verifica se é exatamente igual a uma Coordenada.
     * @param obj Objecto a comparar.
     */
    public boolean equals(Object obj){
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        
        Coordenadas c = (Coordenadas) obj;
        
        return(this.latitude==c.getLatitude() && this.longitude==c.getLongitude());
    }
    
    /**
     * A função clone faz um clone de uma Coordenada, a partir do construtor por cópia.
     */
    public Coordenadas clone(){
        return new Coordenadas(this);
    }
    
    /*
     * Fazer a função que Calcula distancias 
     */
  
}

package RedeSocial;

/**
 * Classe Distância
 * 
 * @author Fábio Silva e Rui Marinhp
 */
public class Distancia {
    
    private double distancia;
    private Cidade cOrig;
    private Cidade cDest;
    
    /**
     * Construtor da classe com parâmetros
     * 
     * @param distance
     * @param cOrig
     * @param cDest
     */
    public Distancia(double distance, Cidade cOrig, Cidade cDest){
        
        this.distancia = distance;
        this.cOrig = cOrig;
        this.cDest = cDest;
    }

    /**
     * Devolve a distancia
     * 
     * @return distancia
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * Devolve Cidade origem
     * 
     * @return cOrig
     */
    public Cidade getcOrig() {
        return cOrig;
    }

    /**
     *Devolve Cidade destino
     * 
     * @return cDest
     */
    public Cidade getcDest() {
        return cDest;
    }
}

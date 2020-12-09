package RedeSocial;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Classe cidade 
 * 
 * @author Fábio Silva e Rui Marinho
 */
public class Cidade  implements Comparable {
    
    private String nome;
    private double latitude;
    private double longitude;
    private Set<Utilizador> listaUtilizadores;

    /**
     * Construtor da classe com parâmetros
     * 
     * @param capitalName
     * @param latitude
     * @param longitude
     */
    public Cidade (String capitalName, double latitude, double longitude){
        
        this.nome = capitalName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.listaUtilizadores = new HashSet<>();
        
    }

    /**
     * Devolve o nome da cidade
     * 
     * @return nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Devolve a latitude
     * 
     * @return latitude
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * Devolve Longitude
     * 
     * @return longitude
     */
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * Devolve o Set de Utilizadores da Cidade
     * 
     * @return listaUtilizadores
     */
    public Set<Utilizador> getListaUtilizadores() {
        return listaUtilizadores;
    }
   
    @Override
    public String toString() {
        return "Cidade{" + nome + '}';
    }
    
    /**
     * Insere Utilizador no Set de Utilizadores
     * 
     * @param utilizador
     */
    public void insertUtilizador(Utilizador utilizador){
        
        if(utilizador != null){
            listaUtilizadores.add(utilizador);
        }
    }
    
    /**
     * Devolve o tamanho da lista de Utilizadores
     * 
     * @return int
     */
    public int listaUtilizadoresSize(){
        
        return this.listaUtilizadores.size();
    }
        @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (this.nome != other.nome) {
            return false;
        }
        return true;
    }
      /**
     * Método que compara objectos do mesmo tipo
     * @param o
     * @return int
     * 
  **/
    @Override
    public int compareTo(Object o) {
        
        if(this.equals(o)) return 0;
        Cidade c = (Cidade) o;
        
    return this.nome.compareTo(c.getNome());
    }
}


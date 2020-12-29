package RedeSocial;

/**
 * Classe Pais
 * 
 * @author Fábio Silva e Rui Marinho
 */
public class Pais {
    
    private String nome;
    private Cidade capital;
    private String continente;
    private double populacao;
    
    /**
     * Construtor com parâmetros
     * 
     * @param countryName
     * @param capital
     * @param continent
     * @param population
     * @param latitude
     * @param longitude
     */
    public Pais(String countryName, String capital, String continent, double population, double latitude, double longitude) {
        
        this.nome = countryName;
        this.capital = new Cidade (capital, longitude, latitude);
        this.continente = continent;
        this.populacao = population;
    
    }

    /**
     * Devolve o nome do Pais
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve a capital do Pais
     * 
     * @return capital
     */
    public Cidade getCapital() {
        return capital;
    }
}

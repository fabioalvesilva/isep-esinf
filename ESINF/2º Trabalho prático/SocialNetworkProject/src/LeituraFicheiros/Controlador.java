package LeituraFicheiros;

import RedeSocial.Pais;
import RedeSocial.RedeCidades;
import RedeSocial.RedeSocial;
import RedeSocial.Utilizador;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Classe Controlador
 * 
 * @author Fábio Silva e Rui Marinho
 */
public class Controlador {
    
    private RedeCidades redeCidades;
    private RedeSocial redeSocial;
    
    private Set<Pais> paises;
    private Set<Utilizador> utilizadores;

    
    private LeituraPaises lP;
    private LeituraFronteiras lF;
    private LeituraUtilizadores lU;
    private LeituraRelacoes lR;
    
    /**
     * Construtor sem parâmetros
     */
    public Controlador() {
        
        this.redeCidades = new RedeCidades();
        this.paises = new HashSet<>();
        this.utilizadores = new HashSet<>();
        this.redeSocial = new RedeSocial();
        
        this.lP = new LeituraPaises(redeCidades, paises);
        this.lF = new LeituraFronteiras(redeCidades, paises);
        this.lU = new LeituraUtilizadores(redeCidades, utilizadores);
        this.lR = new LeituraRelacoes(redeSocial, utilizadores);
    }

    /**
     * Devolve o grafo Cidades
     * 
     * @return redeCidades
     */
    public RedeCidades getRedeCidades() {
        return redeCidades;
    }

    /**
     * Devolve o Set de Paises
     * 
     * @return paises
     */
    public Set<Pais> getPaises() {
        return paises;
    }

    /**
     * Devolve o Set de Utilizadores
     * 
     * @return utilizadores
     */
    public Set<Utilizador> getUtilizadores() {
        return utilizadores;
    }

    /**
     * Devolve o grafo de Utilizadores
     * 
     * @return redeSocial
     */
    public RedeSocial getRedeSocial() {
        return redeSocial;
    }
    
    /**
     * Devolve o número de Utilizadores
     * 
     * @return int
     */
    public int getUtilizadoresSize (){
        return this.utilizadores.size();
    }

    /**
     * Chama o método lerPaises()
     * 
     * @throws FileNotFoundException
     */
    public void lerPaises(String ficheiro) throws FileNotFoundException{
        this.lP.lerPaises(ficheiro);
    }
    
    /**
     * Chama o método lerFronteiras()
     * 
     * @throws FileNotFoundException
     */
    public void lerFronteiras(String ficheiro) throws FileNotFoundException{
        this.lF.lerFronteiras(ficheiro);
    }
    
    /**
     * Chama o método lerUtilizadores()
     * 
     * @throws FileNotFoundException
     */
    public void lerUtilizadores(String ficheiro) throws FileNotFoundException{
        this.utilizadores = this.lU.lerUtilizadores(ficheiro);
    }
    
    /**
     * Adiciona Utilizadores ao grafo Rede Social
     */
    public void adicionarUtilizadores(){
        
        Iterator<Utilizador> it = utilizadores.iterator();
        
        while (it.hasNext()){
            redeSocial.insertUtilizador(it.next());
        } 
    }
    
    /**
     * Chama o método lerRelacoes()
     * 
     * @throws FileNotFoundException
     */
    public void lerRelacoes(String ficheiro) throws FileNotFoundException{
        this.lR.lerRelacoes(ficheiro);
    }
}

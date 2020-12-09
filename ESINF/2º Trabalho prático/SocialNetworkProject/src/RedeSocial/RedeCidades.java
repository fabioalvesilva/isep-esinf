package RedeSocial;

import GraphBase.Graph;

/**
 * Classe que representa a Rede de Cidades.
 * 
 * @author Fábio Silva e Rui Marinho
 */
public class RedeCidades {
    
    private Graph<Cidade, Distancia> redeCidades;
    
    /**
     * Construtor
     * 
     */
    public RedeCidades(){
       
        this.redeCidades = new Graph(false);
    }
    
    /**
     * Procura no grafo de cidades a cidade que corresponde ao nome
     * recebido por parâmetro.
     * @param nome
     * @return cidade
    */
    public Cidade getCidade(String nome){
        
        for (Cidade cidade : redeCidades.vertices()){
            if(cidade.getNome().equalsIgnoreCase(nome)){
                return cidade;
            }
        }
        
        return null;
    }

    /**
     * Devolve o grafo da classe
     * 
     * @return redeCidades
     */
    public Graph <Cidade, Distancia> getGraph(){
        return this.redeCidades;
    }
    
     /**
     * Devolve o numero de cidades (vertices)
     *
     * @return redeCidades.numVertices(), int, num de vertices (Cidade)
     */
    public int getNumCidades() {
        return redeCidades.numVertices();
    }
    
    /**
     * Devolve o numero de conexoes da rede
     *
     * @return redeCidades.numEdges(), int, num de conexoes da rede
     */
    public int getNumLigacoes() {
        return redeCidades.numEdges();
    }
    
     /**
     * Metodo que acrescenta vertices à rede
     *
     * @param cidade, Cidade a ser inserida
     * @return boolean, true se inserir com sucesso ou falso caso contrario
     */
    public boolean insertCidade(Cidade cidade) {
        return redeCidades.insertVertex(cidade);
    }
    
    /**
     * Metodo que insere uma Distancia na redeCidades
     * 
     * @param distancia, Distancia, que contem a informacao com a distancia entre
     * cidade origem e cidade destino
     * @return boolean, true se inseriu a distancia no mapaRede, false caso
     * contrario
     */
    public boolean insertDistancia(Distancia distancia) {
       
        return ((redeCidades.insertEdge(distancia.getcOrig(), distancia.getcDest(),
                distancia, distancia.getDistancia())) && (redeCidades.insertEdge(distancia.getcDest(), distancia.getcOrig(),
                distancia, distancia.getDistancia())) );
    }
    
}

package GestaoRedes;

import MatrixGraph.AdjacencyMatrixGraph;
import MatrixGraph.EdgeAsDoubleGraphAlgorithms;
import MatrixGraph.GraphAlgorithms;
import RedeSocial.Utilizador;
import java.util.LinkedList;

/**
 * Esta classe responde à alínea 3 do enunciado.
 * Utilizamos o algoritmo DFS para verificar a sua conectividade e o shortestPath
 * para devolver o número mínimo de ligações.
 * 
 * @author Fábio Silva e Rui Marinho
 */
public class Conectividade {
    
    /**
     * Método que verifica a conectividade do grafo com o DFS
     * 
     * @param <Utilizador>
     * @param <Boolean>
     * @param redeUtilizadores
     * @return
     */
    public static <Utilizador, Boolean> boolean verificarConectividade (AdjacencyMatrixGraph<Utilizador, Double> redeUtilizadores){
        
        LinkedList<Utilizador> utilizadores = new LinkedList<>();
        
        if (redeUtilizadores.numVertices() == 0) {
            return false;
        }
        
        for (Utilizador ut : redeUtilizadores.vertices()){
            utilizadores.add(ut);
        }
        
        LinkedList<Utilizador> conUtilizadores = GraphAlgorithms.DFS(redeUtilizadores, utilizadores.get(0));
        
        if (conUtilizadores.size() == redeUtilizadores.numVertices()){
            return true;
        }else{
            return false;
        }
        
    }
    
    /**
     * Método que verifica o número mínimo de ligações
     * necessário para nesta rede qualquer utilizador conseguir
     * contactar um qualquer outro utilizador
     * 
     * @param redeUtilizadores
     * @return
     */
    public static double caminhoMinimoPossivel (AdjacencyMatrixGraph<Utilizador, Double> redeUtilizadores){
        
       double max = 0;
       
       for (Utilizador k : redeUtilizadores.vertices()){
           for(Utilizador j : redeUtilizadores.vertices()){
               LinkedList<Utilizador> caminho = new LinkedList<>();
               double doubleTemp = EdgeAsDoubleGraphAlgorithms.shortestPath(redeUtilizadores, k, j, caminho);
               if (doubleTemp > max){
               max = doubleTemp;
               }
           }
       }
       return max;
    }
}

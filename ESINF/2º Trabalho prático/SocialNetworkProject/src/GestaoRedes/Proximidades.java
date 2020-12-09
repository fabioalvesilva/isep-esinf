package GestaoRedes;

import GraphBase.Graph;
import MatrixGraph.AdjacencyMatrixGraph;
import RedeSocial.Cidade;
import RedeSocial.Distancia;
import RedeSocial.Utilizador;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Esta classe responde à alínea 4 do enunciado.
 * Nesta classe adpatamos o algorítmo breadthFirstSearch para responder ao pretendido
 * 
 * @author Fábio Silva e Fabio Silva
 */
public class Proximidades {
    
    /**
     * Algoritmo Breadth First Search adaptado
     * 
     * @param <V>
     * @param <E>
     * @param g
     * @param vert
     * @param n
     * @return Set<V> tmpUtilizador
     */
    public static <V,E> Set<V> breadthFirstSearchComFronteiras(Graph<V,E> g, V vert, int n){
        
        if(!g.validVertex(vert)){
            return null;
        }
        
        Set<V> tmpUtilizador = new HashSet<>();
        
        //CRIA MATRIZ LEVEL /!\
        int level[] = new int[g.numVertices()+1]; 
        boolean visited [] = new boolean [g.numVertices()];
        
        LinkedList<V> auxQueue = new LinkedList<>();
        auxQueue.add(vert);
        
        level[g.getKey(vert)] = 0;
        visited[g.getKey(vert)] = true;
        
        while (!auxQueue.isEmpty()){
            vert = auxQueue.removeFirst();
            for (V vAdj : g.adjVertices(vert)){
                
                if (!visited[g.getKey(vAdj)] == true){
                    
                    auxQueue.add(vAdj);

                    level[g.getKey(vAdj)] = level[g.getKey(vert)+1];
                    visited[g.getKey(vAdj)]=true;
                    
                    if(level[g.getKey(vAdj)] <= n){
                        tmpUtilizador.add(vAdj);
                    }
                }
            }
        }
        return tmpUtilizador;
    }
    
    /**
     * Verifica os amigos comuns do utilizador ut em cada cidade
     * 
     * @param utilizadores
     * @param redeCidades
     * @param n
     * @param ut
     * @param redeSocial
     * @return TreeMap<Cidade, TreeSet<Utilizador>> map
     */
    public static TreeMap<Cidade, TreeSet<Utilizador>> amigosNasProximidades (LinkedList<Utilizador> utilizadores, Graph<Cidade, Distancia> redeCidades, int n, Utilizador ut, AdjacencyMatrixGraph<Utilizador, Double> redeSocial){
        
        Cidade cTemp = ut.getCidade();
        TreeMap<Cidade, TreeSet<Utilizador>> map = new TreeMap<Cidade, TreeSet<Utilizador>>();
        
        TreeSet<Utilizador> amigosUtilizador = new TreeSet<>((Collection<? extends Utilizador>) redeSocial.directConnections(ut));
        
        Set<Cidade> cidadesTemps = breadthFirstSearchComFronteiras(redeCidades, cTemp, n);
        
        TreeSet<Utilizador> amigosCidade = new TreeSet<>();
        
        
        for (Cidade c : cidadesTemps){
            
            amigosCidade = (TreeSet<Utilizador>) amigosUtilizador.clone();
            
            TreeSet<Utilizador> utilizadoresCidade = new TreeSet<Utilizador> (c.getListaUtilizadores());
            amigosCidade.retainAll(utilizadoresCidade);
            
            if (!amigosCidade.isEmpty()){
                map.put(c, amigosCidade);
            }
        }
        return map;
    }
}

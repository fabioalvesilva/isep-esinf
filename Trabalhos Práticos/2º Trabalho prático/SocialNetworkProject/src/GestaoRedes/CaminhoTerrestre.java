/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoRedes;

import GraphBase.Graph;
import MatrixGraph.AdjacencyMatrixGraph;
import RedeSocial.Cidade;
import RedeSocial.Distancia;
import RedeSocial.Utilizador;
import java.util.*;
import static GraphBase.GraphAlgorithms.*;
import javafx.util.Pair;

/**
 *
 * @author rmarinho
 */
public class CaminhoTerrestre {

    /**
     * Método que responde à alínea 6. Devolver o caminho terrestre mais curto
     * entre dois utilizadores, passando obrigatoriamente pelas n cidade(s)
     * intermédias onde cada utilizador tenha o maior número de amigos. N A
     * popularidade de um utilizador é dada pelo seu número de amizades.
     *
     * @param graph Adjacencias Cidades
     * @param matrix Adjacencias Utilizadores
     * @param n cidade(s) intermédias
     * @param u1 Utilizador1
     * @param u2 Utilizador2 ;
     * @return LinkedList<Pair<Cidade, Double>>, returns null if invalid input
     * or no path existent;
     */
    public static LinkedList<Pair<Cidade, Double>> caminhoTerrestre(Graph<Cidade, Distancia> graph, AdjacencyMatrixGraph<Utilizador, Double> matrix, int n, Utilizador u1, Utilizador u2) {
        LinkedList<Cidade> caminho = new LinkedList<>();

        //Validacoes
        if (u1 == null || u2 == null) {
            return null;
        }
        if (u1.getCidade().getNome().equals(u2.getCidade().getNome())) {
            return null;
        }
        if (!graph.validVertex(u1.getCidade()) || !graph.validVertex(u2.getCidade())) {
            return null;
        }
        if (n < 0 || n > graph.numVertices()) {
            return null;
        }

        Cidade cidade1 = u1.getCidade();
        Cidade cidade2 = u2.getCidade();

        LinkedList<Cidade> verticesAlcancaveis = GraphBase.GraphAlgorithms.DepthFirstSearch(graph, cidade1);

        caminho.clear();
        Double finalDist = null;

        //VErifica conexao do grafo 
        caminho = GraphBase.GraphAlgorithms.DepthFirstSearch(graph, cidade1);

        if (!caminho.contains(cidade2)) {
            return null;
        }

        caminho.clear();

        if (n == 0) {
            if ((!verticesAlcancaveis.contains(cidade1) || !verticesAlcancaveis.contains(cidade2))) {
                caminho.clear();
                return null;
            }
            finalDist = shortestPath(graph, cidade1, cidade2, caminho);
            if (caminho.size() < 2) {
                //    caminho.clear();
                return null;
            }
            return contruirLista(caminho, finalDist);
        } else {
            //Amigos u1
            Map<Cidade, Integer> map1AmigosCidade = cidadesComMaisAmigos(matrix, graph, u1, u2);
            //Amigos u2
            Map<Cidade, Integer> map2AmigosCidade = cidadesComMaisAmigos(matrix, graph, u2, u1);
            //MErge de lista de amigos de acordo com o n 
            Set<Cidade> pathConstrained = topCidadesAmigos(map1AmigosCidade, map2AmigosCidade, n);

            if ((!verticesAlcancaveis.contains(cidade1) || !verticesAlcancaveis.contains(cidade2) || !verticesAlcancaveis.containsAll(pathConstrained))) {
                //    caminho.clear();
                return null;
            }
            //List with shortestPath
            LinkedList<Cidade> shtPath = new LinkedList<>();
            //List with temp shortest Path
            LinkedList<Cidade> tmpPath = new LinkedList<>();

            //Distancia shotest Path e tmp path
            double shtDist = 0;
            double tmpDist = 0;
            //Caminho primeira cidade a 1 cidade intermedia mais proxima 

            for (Cidade c : pathConstrained) {
                tmpDist = shortestPath(graph, cidade1, c, tmpPath);
                if (tmpDist > shtDist && (!tmpPath.contains(u2.getCidade()))) {
                    shtDist = tmpDist;
                    shtPath = tmpPath;
                }

            }

            //Adiciona ao caminho final o caminho descoberto 
            caminho.addAll(shtPath);
            finalDist = shtDist;
            if (caminho.size() < 2) {
                return null;
            }
            //remove do set de cidades intermedias a cidade ja adicionada ao caminho final 
            pathConstrained.removeAll(shtPath);
            //zerar os paths
            shtDist = 0;
            tmpDist = 0;
            tmpPath.clear();
            shtPath.clear();
            Cidade source = caminho.removeLast();
            
            while (!pathConstrained.isEmpty()) {

                for (Cidade c : pathConstrained) {

                    tmpDist = shortestPath(graph, source, c, tmpPath);
                    if (tmpDist > shtDist) {
                        //tmpPath.removeFirst();
                        shtDist = tmpDist;
                        shtPath = tmpPath;
                    }
                }

                caminho.addAll(shtPath);
                finalDist = finalDist + shtDist;
                pathConstrained.removeAll(shtPath);
                if (!pathConstrained.isEmpty()) {
                    source = caminho.removeLast();
                }
            }
            //Path ultimo vertice e destino
            
            
            if (!caminho.getLast().getNome().equals(cidade2.getNome())) {
                shtPath.clear();
              source = caminho.removeLast();  
                shtDist = shortestPath(graph, source, cidade2, shtPath);
                caminho.addAll(shtPath);
                finalDist = shtDist + finalDist;
            }

            return contruirLista(caminho, finalDist);

        }
    }

    /**
     * Método que retorna Lista de cidades com mais amigos
     *
     * @param graph Adjacencias Cidades
     * @param matrix Adjacencias Utilizadores
     * @param u1 Utilizador1
     * @param u2 Utilizador2 ;
     * @return Map<Cidade, Integer> ;
     */
    public static Map<Cidade, Integer> cidadesComMaisAmigos(AdjacencyMatrixGraph<Utilizador, Double> matrix, Graph<Cidade, Distancia> graph,
            Utilizador user, Utilizador user2) {

        Map<Cidade, Integer> mapAmigosCidade = new TreeMap<>();

        Set<Utilizador> uAmigos = new HashSet<>((Collection) matrix.directConnections(user));
        int i = 0;
        for (Utilizador u : uAmigos) {
            //Filtrar para nao adicionar a cidade de destino nem de origem (cidade user 1 e user 2)
            if ((!user.getCidade().equals(u.getCidade())) && (!user2.getCidade().equals(u.getCidade()))) {

                if (mapAmigosCidade.containsKey(u.getCidade())) {
                    i = mapAmigosCidade.get(u.getCidade());
                }

                mapAmigosCidade.put(u.getCidade(), (i + 1));
                //mapAmigosCidade.put(u.getCidade(), mapAmigosCidade.get(u.getCidade()) +1);
            } else {
                mapAmigosCidade.put(u.getCidade(), 1);
                //mapAmigosCidade.put(u.getCidade(), i);

            }

        }
        //Order by value
        mapAmigosCidade = Util.Utils.ordenaPorValorDecrescente(mapAmigosCidade);
        return mapAmigosCidade;

    }

    /**
     * Método que faz o merge entre as duas listas de amigos
     *
     * @param graph Adjacencias Cidades
     * @param matrix Adjacencias Utilizadores
     * @param u1 Utilizador1
     * @param u2 Utilizador2 ;
     * @return Set<Cidade> ;
     */
    public static Set<Cidade> topCidadesAmigos(Map<Cidade, Integer> map1, Map<Cidade, Integer> map2, int n) {
        Set<Cidade> topCidades = new HashSet<>();
        Iterator<Cidade> it;

        int counter = 0;
        if (!map1.isEmpty()) {
            it = map1.keySet().iterator();
            while (it.hasNext()) {
                if (topCidades.add(it.next())) {
                    counter++;
                }
                if (counter == n) {
                    break;
                }
                it.remove();
            }
        }

        counter = 0;
        if (!map2.isEmpty()) {
            it = map2.keySet().iterator();

            while (it.hasNext()) {
                if (topCidades.add(it.next())) {
                    counter++;
                }
                if (counter == n) {
                    break;
                }
                it.remove();
            }

        }
        return topCidades;

    }

    /**
     *
     * @param caminho
     * @param distancia
     * @return LinkedList<Pair<Cidade, Double>>
     */
    public static LinkedList<Pair<Cidade, Double>> contruirLista(LinkedList<Cidade> caminho, Double distancia) {
        LinkedList<Pair<Cidade, Double>> listaCaminho = new LinkedList<>();
        for (Cidade c : caminho) {
            listaCaminho.add(new Pair(c, distancia));
        }
        return listaCaminho;
    }

}

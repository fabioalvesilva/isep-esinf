package GestaoRedes;

import GraphBase.Edge;
import GraphBase.Graph;
import MatrixGraph.AdjacencyMatrixGraph;
import RedeSocial.Cidade;
import RedeSocial.Distancia;
import RedeSocial.Utilizador;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import javafx.util.Pair;

/**
 * Esta classe responde à alínea 5 do enunciado.
 * 
 * @author Fábio Silva e Rui Marinho
 */
public class Centralidade {

    /**
     * Cidades mais proximas de todas as outras(com mais centralidade)
     * Cidades onde habitem p% utilizadors
     * 
     * Constrói uma matriz de adjacências com as respectivas distâncias entre as cidades
     * Constrói uma matriz aplicando o fecho transitivo
     * 
     * @param redeUtilizadores
     * @param redeCidades
     * @param p
     * @param n
     * @return Set<Cidade>
     */
    public static Set<Cidade> getCidadesMaiorCentralidade(AdjacencyMatrixGraph<Utilizador, Double> redeUtilizadores, Graph<Cidade, Distancia> redeCidades, double p, int n) {

        int totalUtilizadores = redeUtilizadores.numVertices();
        
        LinkedList<Cidade> cidadesOrdenadas = new LinkedList();
        
        //Matriz com as distancias das respectivas cidades
        double[][] matrixInt = matrizDistancias(redeUtilizadores, redeCidades, 
                n, cidadesOrdenadas);
        
        //Set de Pair das cidades com a media de distancias
        Set<Pair<Cidade, Double>> setCidadesDistancia = matrizMediasCidades(redeCidades, 
                matrixInt, totalUtilizadores, p, n, cidadesOrdenadas);
        
        TreeSet<Cidade> finalCidades = new TreeSet<>();
        Iterator it = setCidadesDistancia.iterator();
        
        int i = 0;
        while (it.hasNext() && i < n) {
            Pair<Cidade, Double> tmpPair = (Pair<Cidade, Double>) it.next();
            finalCidades.add(tmpPair.getKey());

            i++;
        }
        return finalCidades;
    }
    
    /**
     * Fecho transitivo entre as cidades aplicando o algorítimo Floyd-Warshall
     * Complexidade O(n³) 
     * 
     * @param redeCidades
     * @param caminhos
     * @return double[][] caminhos
     */
    public static double[][] fechoTransitivo(Graph<Cidade, Distancia> redeCidades, double[][] caminhos) {

        
        for (int k = 0; k < caminhos.length; k++) {
            for (int i = 0; i < caminhos.length; i++) {
                if (i != k && caminhos[i][k] != Double.MAX_VALUE) {
                    for (int j = 0; j < redeCidades.numVertices(); j++) {
                        if (i != j && k != j && caminhos[k][j] != Double.MAX_VALUE) {
                            if (caminhos[i][j] > caminhos[i][k] + caminhos[k][j]) {
                                caminhos[i][j] = caminhos[i][k] + caminhos[k][j];
                            }
                        }
                    }
                }
            }
        }

        return caminhos;
    }

    /**
     * Matriz de distancias entre cidades
     * Conversao de mapa adjacencias para matriz de adjacencias
     * 
     * @param redeUtilizadores
     * @param redeCidades
     * @param n
     * @param listaCidades
     * @return
     */
    public static double[][] matrizDistancias(AdjacencyMatrixGraph<Utilizador, Double> redeUtilizadores, Graph<Cidade, Distancia> redeCidades, int n, LinkedList<Cidade> listaCidades) {

        double[][] matrizInt = new double[redeCidades.numVertices()][redeCidades.numVertices()];

        for (Cidade i : redeCidades.vertices()) {
            listaCidades.add(i);
            for (Cidade j : redeCidades.vertices()) {
                if (i != j && i != null && j != null) {
                    Edge<Cidade, Distancia> dist = redeCidades.getEdge(i, j);
                    if (dist == null) {
                        matrizInt[redeCidades.getKey(i)][redeCidades.getKey(j)] = Double.MAX_VALUE;
                    }
                    if (dist != null) {
                        double peso = dist.getElement().getDistancia();
                        matrizInt[redeCidades.getKey(i)][redeCidades.getKey(j)] = peso;
                    }
                }
            }
        }
        matrizInt = fechoTransitivo(redeCidades, matrizInt);

        return matrizInt;
    }

    /**
     * Set ordenado pela media de centralidade cidade
     * 
     * @param graph
     * @param matrizFloyd
     * @param numUsers
     * @param p
     * @param n
     * @param listCidades
     * @return Set<Pair<Cidade, Double>> setCidadesDistancia
     */
    public static Set<Pair<Cidade, Double>> matrizMediasCidades(Graph<Cidade, Distancia> graph, double[][] matrizFloyd, int numUsers, double p, int n, LinkedList<Cidade> listCidades) {

        Set<Pair<Cidade, Double>> setCidadesDistancia = new TreeSet<Pair<Cidade, Double>>(Util.Utils.sortDistancia);
        
        double soma = 0;
        int count = 0;

        for (int i = 0; i < graph.numVertices(); i++) {
            
            ///So coloca cidade no mapa se tem p percentagem de users
            if (percentagemUtilizadoresCidade(listCidades.get(i), p, numUsers)) {
                for (int j = 0; j < graph.numVertices(); j++) {
                    if (i != j && matrizFloyd[i][j] != Double.MAX_VALUE) {
                        soma = soma + matrizFloyd[i][j];
                        count++;
                    }
                }
                setCidadesDistancia.add(new Pair(listCidades.get(i), (soma / (double) count)));
            }
        }
        return setCidadesDistancia;
    }

    /**
     * Verifica se percentagem Utilizadores da cidade é maior ou igual a p
     * 
     * @param c
     * @param p
     * @param totalUtilizadores
     * @return boolean
     */
    public static boolean percentagemUtilizadoresCidade(Cidade c, double p, int totalUtilizadores) {
        double pUtilizadoresCidade = ((c.listaUtilizadoresSize() / (double) 
                totalUtilizadores) * 100);
        return pUtilizadoresCidade >= p;
    }

}

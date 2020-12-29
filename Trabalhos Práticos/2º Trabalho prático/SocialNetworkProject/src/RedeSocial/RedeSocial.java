/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RedeSocial;

import MatrixGraph.AdjacencyMatrixGraph;

/**
 *
 * @author Fábio Silva e Rui Marinho
 */
public class RedeSocial {

    private AdjacencyMatrixGraph<Utilizador, Double> matrix;

    /**
     * Construtor
     */
    public RedeSocial() {

        this.matrix = new AdjacencyMatrixGraph();
    }

    /**
     * Construtor com parâmetros
     * 
     * @param tamanhoRede
     */
    public RedeSocial(int tamanhoRede) {
        this.matrix = new AdjacencyMatrixGraph(tamanhoRede);
    }

    /**
     * Devolve a matriz do grafo
     * 
     * @return matrix
     */
    public AdjacencyMatrixGraph<Utilizador, Double> getMatrix() {
        return matrix;
    }

    /**
     * Insere um Utilizador na matriz
     * 
     * @param utilizador
     */
    public void insertUtilizador(Utilizador utilizador) {
        this.matrix.insertVertex(utilizador);
    }

    /**
     * Insere um Edge na matriz
     * 
     * @param u1
     * @param u2
     * @return boolean, true se sucesso, false se não for adicionado
     */
    public boolean insertConexao(Utilizador u1, Utilizador u2) {
        if (u1 != null && u2 != null) {

            if (this.matrix.insertEdge(u1, u2, 1.0)) {
                u1.incrementNrAmigos();
                u2.incrementNrAmigos();
                return true;
            }
        }
        return false;
    }
}

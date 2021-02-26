/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaPeriodica;

import EstruturasArvores.AVL;

/**
 * Classe Arvore Elemento
 *
 * @author Fábio Silva e Rui Marinho
 */
public class ArvoreElemento extends AVL<ElementoNome> {

    /**
     * Construtor
     */
    public ArvoreElemento() {

        new AVL();
    }

    /**
     * Método procurarPorNome
     *
     * @param nome
     * @return ElementoNome
     */
    public ElementoNome procurarPorNome(String nome) {

        ElementoNome e = this.procurarPorNome(this.root(), nome);

        return e;
    }

    /**
     * Método procurarPorNome
     *
     * @param node
     * @param nome
     * @return ElementoNome
     */
    public ElementoNome procurarPorNome(Node<ElementoNome> node, String nome) {

        if (node == null) {
            return null;
        }
        if (node.getElement().getElemento().getElemento().equals(nome)) {
            return node.getElement();
        }
        if (node.getElement().getElemento().getElemento().compareTo(nome) > 0) {
            return procurarPorNome(node.getLeft(), nome);
        } else {
            return procurarPorNome(node.getRight(), nome);
        }
    }
}

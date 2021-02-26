/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaPeriodica;

import EstruturasArvores.AVL;

/**
 * Classe Arvore Simbolo
 *
 * @author Fábio Silva e Rui Marinho
 */
public class ArvoreSimbolo extends AVL<ElementoSimbolo> {

    /**
     * Construtor
     */
    public ArvoreSimbolo() {
        new AVL();
    }

    /**
     * Método procurarPorSimbolo
     *
     * @param simbolo
     * @return ElementoSimbolo
     */
    public ElementoSimbolo procurarPorSimbolo(String simbolo) {

        ElementoSimbolo e = this.procurarPorSimbolo(this.root(), simbolo);

        return e;
    }

    /**
     * Método procurarPorSimbolo
     *
     * @param node
     * @param simbolo
     * @return ElementoSimbolo
     */
    public ElementoSimbolo procurarPorSimbolo(Node<ElementoSimbolo> node, String simbolo) {

        if (node == null) {
            return null;
        }
        if (node.getElement().getElemento().getSimbolo().compareTo(simbolo) == 0) {
            return node.getElement();
        }
        if (node.getElement().getElemento().getSimbolo().compareTo(simbolo) > 0) {
            return procurarPorSimbolo(node.getLeft(), simbolo);
        } else {
            return procurarPorSimbolo(node.getRight(), simbolo);
        }
    }
}

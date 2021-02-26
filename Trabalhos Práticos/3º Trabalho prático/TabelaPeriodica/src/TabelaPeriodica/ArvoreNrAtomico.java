/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaPeriodica;

import EstruturasArvores.AVL;

/**
 * Classe Arvore Nr Atomico
 *
 * @author Fábio Silva e Rui Marinho
 */
public class ArvoreNrAtomico extends AVL<ElementoNrAtomico> {

    /**
     * Construtor
     */
    public ArvoreNrAtomico() {
        new AVL();
    }

    /**
     * Método procurarPorNrAtomico
     *
     * @param numero
     * @return ElementoNrAtomico
     */
    public ElementoNrAtomico procurarPorNrAtomico(Integer numero) {

        ElementoNrAtomico e = this.procurarPorNrAtomico(this.root(), numero);

        return e;
    }

    /**
     * Método procurarPorNrAtomico
     *
     * @param node
     * @param numero
     * @return ElementoNrAtomico
     */
    public ElementoNrAtomico procurarPorNrAtomico(Node<ElementoNrAtomico> node, Integer numero) {

        if (node == null) {
            return null;
        }
        if (node.getElement().getElemento().getNumeroAtomico().compareTo(numero) == 0) {
            return node.getElement();
        }
        if (node.getElement().getElemento().getNumeroAtomico().compareTo(numero) > 0) {
            return procurarPorNrAtomico(node.getLeft(), numero);
        } else {
            return procurarPorNrAtomico(node.getRight(), numero);
        }
    }

}

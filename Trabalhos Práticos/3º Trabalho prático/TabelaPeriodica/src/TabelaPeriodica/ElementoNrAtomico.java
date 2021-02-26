/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaPeriodica;

/**
 * Elemento Nr Atomico
 *
 * @author Fábio Silva e Rui Marinho
 */
public class ElementoNrAtomico implements Comparable<ElementoNrAtomico> {

    private Elemento elemento;

    /**
     * Construtor
     *
     * @param e
     */
    public ElementoNrAtomico(Elemento e) {

        this.elemento = e;
    }

    /**
     * Construtor Vazio
     */
    public ElementoNrAtomico() {

        this.elemento = null;
    }

    /**
     * Método getElemento()
     *
     * @return Elemento
     */
    public Elemento getElemento() {
        return elemento;
    }

    @Override
    public int compareTo(ElementoNrAtomico o) {
        return this.getElemento().getNumeroAtomico().compareTo(o.getElemento().getNumeroAtomico());
    }

}

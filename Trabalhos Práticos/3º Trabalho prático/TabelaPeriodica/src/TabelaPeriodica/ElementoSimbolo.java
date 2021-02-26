/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaPeriodica;

/**
 * Elemento Simbolo
 *
 * @author Fábio Silva e Rui Marinho
 */
public class ElementoSimbolo implements Comparable<ElementoSimbolo> {

    private Elemento elemento;

    /**
     * Construtor
     *
     * @param e
     */
    public ElementoSimbolo(Elemento e) {

        this.elemento = e;
    }

    /**
     * Método getElemento()
     *
     * @return Elemento
     */
    public Elemento getElemento() {
        return this.elemento;
    }

    @Override
    public int compareTo(ElementoSimbolo o) {
        return this.getElemento().getSimbolo().compareTo(o.getElemento().getSimbolo());
    }

}

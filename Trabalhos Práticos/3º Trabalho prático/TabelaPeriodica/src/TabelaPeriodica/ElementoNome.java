/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaPeriodica;

/**
 * Elemento Nome
 *
 * @author Fábio Silva e Rui Marinho
 */
public class ElementoNome implements Comparable<ElementoNome> {

    private Elemento elemento;

    /**
     * Construtor
     *
     * @param e
     */
    public ElementoNome(Elemento e) {

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
    public int compareTo(ElementoNome o) {
        return this.getElemento().getElemento().compareTo(o.getElemento().getElemento());
    }

}

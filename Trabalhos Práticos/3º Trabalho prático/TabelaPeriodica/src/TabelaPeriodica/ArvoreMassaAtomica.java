package TabelaPeriodica;

import EstruturasArvores.AVL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Classe Arvore Massa Atomica
 *
 * @author Fabio Silva e Rui Marinho
 */
public class ArvoreMassaAtomica extends AVL<ElementoMassaAtomica> implements Cloneable {

    /**
     * Construtor
     */
    public ArvoreMassaAtomica() {

        new AVL();
    }

    /**
     * Método procurarPorMassaAtomica
     *
     * @param massa
     * @return ElementoMassaAtomica
     */
    public ElementoMassaAtomica procurarPorMassaAtomica(Double massa) {

        ElementoMassaAtomica e = this.procurarPorMassaAtomica(this.root(), massa);

        return e;
    }

    /**
     * Método procurarPorMassaAtomica
     *
     * @param node
     * @param massa
     * @return ElementoMassaAtomica
     */
    public ElementoMassaAtomica procurarPorMassaAtomica(Node<ElementoMassaAtomica> node, Double massa) {

        if (node == null) {
            return null;
        }
        if (node.getElement().getElemento().getMassaAtomica().compareTo(massa) == 0) {
            return node.getElement();
        }
        if (node.getElement().getElemento().getMassaAtomica().compareTo(massa) > 0) {
            return procurarPorMassaAtomica(node.getLeft(), massa);
        } else {
            return procurarPorMassaAtomica(node.getRight(), massa);
        }
    }

    /**
     * Método pesquisaPorMassaIntervalo
     *
     * @param arvore
     * @param min
     * @param max
     * @return LinkedList<ElementoMassaAtomica>
     * @throws CloneNotSupportedException
     */
    public List<ElementoMassaAtomica> pesquisaPorMassaIntervalo(ArvoreMassaAtomica arvore, Double min, Double max) throws CloneNotSupportedException {

        Node<ElementoMassaAtomica> node = this.root;

        List<ElementoMassaAtomica> list = new ArrayList();
        Set<ElementoMassaAtomica> set = new TreeSet();

        ArvoreMassaAtomica tmp = (ArvoreMassaAtomica) this.clone();

        pesquisaPorMassaIntervalo(node, min, max, list, tmp);

        Collections.sort(list, new MassaAtomicaComparator());
        elementosAgrupadosTipoFase(list);

        return list;

    }

    private void pesquisaPorMassaIntervalo(Node<ElementoMassaAtomica> node, Double min, Double max, List<ElementoMassaAtomica> list, ArvoreMassaAtomica tmp) {

        if (!tmp.isEmpty()) {

            if (node.getElement().getElemento().getMassaAtomica() >= min && node.getElement().getElemento().getMassaAtomica() <= max) {
                list.add(node.getElement());
            }

            tmp.remove(node.getElement());
            pesquisaPorMassaIntervalo(tmp.root, min, max, list, tmp);
        }
    }

    private void elementosAgrupadosTipoFase(List<ElementoMassaAtomica> list) {

        Map<String, Map<String, Long>> map = list.stream()
                .collect(Collectors.groupingBy(e -> e.getTipo(), TreeMap::new,
                        Collectors.groupingBy(x -> x.getFase(), Collectors.counting())));

        System.out.printf("%25s | %10s | %10s\n", "Tipo", "Fase", "Quantidade");
        map.forEach((k, v) -> v.forEach((a, b) -> System.out.printf("%25s | %10s | %10d\n", k, a, b)));

    }
}

/**
 * Comparator Massa Atomica para ordenação da tabela
 */
class MassaAtomicaComparator implements Comparator<Object> {

    @Override
    public int compare(Object a, Object b) {

        ElementoMassaAtomica eA = (ElementoMassaAtomica) a;
        ElementoMassaAtomica eB = (ElementoMassaAtomica) b;

        if (eA.getElemento().getDescobridor().compareTo(eB.getElemento().getDescobridor()) == 0) {
            //Segundo Critério
            if (eA.getElemento().getAno().compareTo(eB.getElemento().getAno()) == 0) {
                return eA.getElemento().getMassaAtomica().compareTo(eB.getElemento().getMassaAtomica());
            } else if (eA.getElemento().getAno().compareTo(eB.getElemento().getAno()) > 0) {
                return -1;
            }
        }
        //Primeiro Critério
        return eA.getElemento().getDescobridor().compareTo(eB.getElemento().getDescobridor());
    }
}

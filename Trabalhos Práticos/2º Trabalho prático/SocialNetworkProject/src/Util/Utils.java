package Util;

import RedeSocial.Cidade;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;
import javafx.util.Pair;


/**
 * Classe de Utils
 * 
 * @author Fábio Silva e Rui Marinho
 */
public class Utils {
    
    /**
     * Método que calcula a distancia através da longitude e latitude recebida
     * 
     * @param lat1
     * @param lon1
     * @param lat2
     * @param lon2
     * @return
     */
    public static double distance(double lat1, double lon1, double lat2, double lon2) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) 
                                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) 
                                * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			//dis to KM
				dist = dist * 1.609344;
                                dist = Math.round (dist * 100.0) / 100.0;
			return dist;
		}
	}
    
    /**
     * Método que ordena pelo valor um Map
     * 
     * @param <K>
     * @param <V>
     * @param map
     * @return
     */
    public static <K, V> Map<K, V> ordenaPorValor (Map<K, V> map) {
        
        List<Entry<K, V>> list = new LinkedList<>(map.entrySet());
        
        Collections.sort(list, new Comparator<Object>() {
            
            @SuppressWarnings("unchecked")
            public int compare(Object o1, Object o2) {
                return ((Comparable<V>) ((Map.Entry<K, V>) (o1)).getValue()).compareTo(((Map.Entry<K, V>) (o2)).getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Iterator<Entry<K, V>> it = list.iterator(); it.hasNext();) {
            Map.Entry<K, V> entry = (Map.Entry<K, V>) it.next();
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
    
        /**
     * Método que ordena pelo valor DECRESCENTE um Map
     * 
     * @param <K>
     * @param <V>
     * @param map
     * @return
     */
    public static <K, V> Map<K, V> ordenaPorValorDecrescente (Map<K, V> map) {
        
        List<Entry<K, V>> list = new LinkedList<>(map.entrySet());
        
        Collections.sort(list, new Comparator<Object>() {
            
            @SuppressWarnings("unchecked")
            public int compare(Object o1, Object o2) {
                return ((Comparable<V>) ((Map.Entry<K, V>) (o2)).getValue()).compareTo(((Map.Entry<K, V>) (o1)).getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Iterator<Entry<K, V>> it = list.iterator(); it.hasNext();) {
            Map.Entry<K, V> entry = (Map.Entry<K, V>) it.next();
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
    
    
    /**
     * Comparator que ordena por valor
     */
    public static  Comparator<Pair<Cidade,Double>> sortDistancia = new Comparator<Pair<Cidade,Double>>() {
        
            @Override
            public int compare(Pair o1, Pair o2) {
                Double i1 = (Double) o1.getValue();
                Double i2 = (Double) o2.getValue();
                return i1.compareTo(i2);
            }
        };
    
    
    //----
    public static void printMatriz2D(double [][]matriz){
                    String lineSplit = "";
        StringJoiner splitJoiner = new StringJoiner("+", "|", "|");
        for (int index = 0; index < matriz[0].length; index++) {
            splitJoiner.add(String.format("%10s", "").replace(" ", "-"));
        }
        lineSplit = splitJoiner.toString();
        for (       double[] row : matriz) {
            StringJoiner sj = new StringJoiner(" | ", "| ", " |");
            for (double col : row) {
                if(col == Double.MAX_VALUE) col = -1;
                sj.add(String.format("%8.2f", col));
            }
            System.out.println(lineSplit);
            System.out.println(sj.toString());
        }
        System.out.println(lineSplit);
    }

    
}

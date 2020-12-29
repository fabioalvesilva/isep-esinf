/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericsortingarrays;

import java.util.Arrays;

/**
 *
 * @author DEI-ISEP
 */


public class GenericSortingArrays {

/**
* Swaps two vector positions                  O(1)
*/
public static <E> void swap(E[] v, int i, int j) {
    
    E temp = v[i];
    v[i] = v[j];
    v[j] = temp;
}
 
 //  printArray                                
public static<E> void printArray(E[] v)
{
    for (E element : v)
        System.out.println(", "+ element);
}  

/**
* Selection Sort Algorithm       
*/  
public static <E extends Comparable<E>> void selectionSort(E[] v){
    
    for (int i=0; i<v.length-1; i++){
        int min = i;
        for (int j=i+1; j< v.length; j++){
            if(v[j].compareTo(v[min]) < 0){
                min = j;
            }
            swap(v, i, min);
        }
        
    }
}   

/**
* Bubble Sort Algorithm        
* @param v
*/  
public static <E extends Comparable<E> > void bubbleSort(E[] v, int n) {
    
    for (int i = 0; i < n-1; i++){
        for(int j = n-1; j > i; j--){
            if (v[j-1].compareTo(v[j]) == 1){
                swap(v, j, j-1);
            }
        }
    }
} 

/**
* insertionSort Algorithm     
*/     
public static <E extends Comparable<E>> void insertionSort (E[] v) {

    for (int i = 1; i< v.length-1; i++){
        int j = i;
        E x = v[i];
        
        while(j > 0 && (x.compareTo(v[j-1])) == -1){
            v[j] = v[j-1];
            j = j-1;
        }
        
        v[j] = x;
    }
}

/**
*  Mergesort Algorithm
*/ 
private static <E extends Comparable<E>> void merge(E[] S1, E[] S2, E[] S) { 
    throw new UnsupportedOperationException("Not supported yet.");
}
     
public static <E extends Comparable<E>> void mergeSort(E[] S) { 
    
    
    if ( S.length >= 2){
        
        int mid =S.length/2;
        
        E[] S1 = S;
        E[] S2 = S;        
        
        mergeSort(S1);
        mergeSort(S2);
        
        merge(S1, S2, S);
        
    }
}

/**
* Quicksort Algorithm
*/ 
public static <E extends Comparable<E> > void quickSort(E v[]) {
    
    quickSort(v, 0, v.length-1);
}
 
private static <E extends Comparable<E> > void quickSort(E v[], int left, int right) {
    
    
    
    E pivot = v[(left+right)/2];
    
    int i = left;
    int j = right;
    
    while (i <= j) {
        
        while(v[i].compareTo(pivot) < 0){
            i++;
        }
        while (v[i].compareTo(pivot) > 0){
            j--;
        }
        if(i<=j){
            swap(v, i, j);
            i++;
            j--;
        }
    }
    
    if(left < j){
        quickSort(v, left, j);
    }
    if(right > i){
        quickSort(v, i, right);
    }
}

}

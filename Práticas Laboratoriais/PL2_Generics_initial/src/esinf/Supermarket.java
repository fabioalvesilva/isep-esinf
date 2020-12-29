/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author DEI-ISEP
 */
public class Supermarket {
    
    Map <Invoice, Set<Product>> m;
    
    Supermarket() {
        m = new HashMap<>();
    }
    
    // Reads invoices from a list of String
    void getInvoices(List <String> l) throws Exception {
        
        Invoice i= null;
        Product p = null;
        
        for (String s : l){
            String [] lt = s.split(",");
            switch (lt[0]) {
                case "I":
                    i = new Invoice (lt[1], lt[2]);
                    m.put(i, new TreeSet<>());
                    break;
                case "P":
                    p = new Product (lt[1], Integer.parseInt(lt[2]), Long.parseLong(lt[3]));
                    m.get(i).add(p);
                default:
                    throw new Exception("Invoice Line unrecognized");
            }
        }
     
    }   
    // returns a set in which each number is the number of products in the r
    // invoice 
    Map<Invoice, Integer> numberOfProductsPerInvoice() {
        
        Map<Invoice, Integer> r = new HashMap<>();
        
        for (Invoice i : m.keySet()){
            r.put (i, m.get(i).size());
        }
        
        return r;
    }

    // returns a Set of invoices in which each date is >d1 and <d2
    Set <Invoice> betweenDates(LocalDate d1, LocalDate d2) {
        
        Set <Invoice> s = new TreeSet<>();
        
        for (Invoice i : m.keySet()){
            if (i.getDate().isAfter(d1) && i.getDate().isBefore(d2)){
                s.add(i);
            }
        }
        
        return s;
        
    }
    
    // returns the sum of the price of the product in all the invoices
    long totalOfProduct(String productId) {
        
        long sum = 0;
        
        //Product queryProduct = new Product (productId);
        
        for (Invoice i : m.keySet()){
   
            //if (m.get(i).contains(queryProduct))
                
                for (Product p : m.get(i)){
                    if (p.getIdentification().equals(productId)){
                        sum = sum + (p.getQuantity()*p.getPrice());
                    }
                }
        }
        
        return sum;
    }
    
    // converts a map of invoices and products to a map which key is a product 
    // identification and the values are a set of the invoice references 
    // in which it appearss
    Map <String, Set<Invoice>> convertInvoices() {
        
        //Declaração de um Map, em que cada producto terá um Set de Invoices.
        Map <String, Set<Invoice>> newMap = new HashMap<>();
        
        //Percorrer a lista de Invoices 'm'
        for (Invoice i : m.keySet()){
                for (Product p : m.get(i)){
                    /*Para cada produto encontrado, não duplicado, adiciona-o 
                    ao novo Map 'newMap'*/
                    newMap.put(p.getIdentification(), new HashSet<Invoice>());
                    }
        }
        
        //Percorre os produtos do novo Set
        for (String productStr : newMap.keySet()){
            
            //Para cada produto do Map 'newMap', criará um Set para guardar os
            //respectivos Invoices
            Set <Invoice> productInvoices = new HashSet<>();
            
            //Percorre a lista de Invoices
            for (Invoice i : m.keySet()){
                //Percorre novamente a lista de produtos
                for (Product p : m.get(i)){
                    //Verifica se productStr == p identification. Se for, adiciona
                    //o Invoice 'i' ao Set productInvoices.
                    if (p.getIdentification() == productStr){
                        productInvoices.add(i);
                    }
                }
            }
            //No final, adicionamos o novo Set de 'Invoices', para ficar ligado,
            //ao productStr.
            newMap.put(productStr, productInvoices);
        }
        
//        Set <Invoice> newInvoice = new HashSet();
//        
//        for (Invoice i : m.keySet()){
//            for (String pID: newMap.keySet()){
//                for (Product p : m.get(i)){
//                    if (pID == p.getIdentification()){
//                        newInvoice.add(i);
//                    }
//                }
//            }
//        }
//        
        return newMap;
    }
}
    

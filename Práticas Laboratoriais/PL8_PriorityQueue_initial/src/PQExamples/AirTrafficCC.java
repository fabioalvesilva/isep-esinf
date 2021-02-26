/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PQExamples;

//import static java.lang.System.out;
import Priority_queue.HeapPriorityQueue;
import Priority_queue.Entry;

/**
 *
 * @author antoniosilva
 */
public class AirTrafficCC {

    private final HeapPriorityQueue<Integer, String> cc;
    int timeslot = 5;  // time slot allocated to land each plane

    public AirTrafficCC(Integer[] p, String[] f) {
        this.cc = new HeapPriorityQueue(p, f);
    }

    public String nextPlaneLanding() {
        return cc.min().getValue();
    }

    public void addPlane2Queue(String id, Integer pr) {
        cc.insert(pr, id);
    }

    public Entry<Integer, String> clearPlane4Landing() {
        return cc.removeMin();
    }

    public Integer nrPlanesWaiting() {
        return cc.size();
    }

    public Integer time2land(String id) {
        int time = 0;
        Entry<Integer, String> entry = cc.removeMin();
        
        while (!entry.getValue().equals(id)) {
            time += timeslot;
            entry = cc.removeMin();
        }
        return time;
    }

    public void changePriority2(String id, Integer newp) {
        Entry<Integer, String> entry = cc.removeMin();
        while (!entry.getValue().equals(id)) {
            entry = cc.removeMin();
        }
        cc.removeMin();
        cc.insert(newp, id);
    }

    public Integer testRemove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

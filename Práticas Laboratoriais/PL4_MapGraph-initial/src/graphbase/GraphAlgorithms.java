/*
* A collection of graph algorithms.
 */
package graphbase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author DEI-ESINF
 */
public class GraphAlgorithms {

    /**
     * Performs breadth-first search of a Graph starting in a Vertex
     *
     * @param g Graph instance
     * @param vInf information of the Vertex that will be the source of the
     * search
     * @return qbfs a queue with the vertices of breadth-first search
     */
    public static <V, E> LinkedList<V> BreadthFirstSearch(Graph<V, E> g, V vert) {

        LinkedList<V> qbfs = new LinkedList<>();
        LinkedList<V> qaux = new LinkedList<>();

        if (g.validVertex(vert)) {
            qbfs.add(vert);
            qaux.add(vert);
        } else {
            return null;
        }

        while (!qaux.isEmpty()) {
            vert = qaux.removeFirst();
            
            for (V vertex : g.adjVertices(vert)) {
                if (!qbfs.contains(vertex)) {
                    qaux.add(vertex);
                    qbfs.add(vertex);
                }
            }

        }

        return qbfs;

    }

    /**
     * Performs depth-first search starting in a Vertex
     *
     * @param g Graph instance
     * @param vOrig Vertex of graph g that will be the source of the search
     * @param visited set of discovered vertices
     * @param qdfs queue with vertices of depth-first search
     */
    private static <V, E> void DepthFirstSearch(Graph<V, E> g, V vOrig, LinkedList<V> qdfs) {

        qdfs.add(vOrig);

        for (V vertex : g.adjVertices(vOrig)) {
            if (!qdfs.contains(vertex)) {
                DepthFirstSearch(g, vertex, qdfs);
            }
        }
    }

    /**
     * @param g Graph instance
     * @param vInf information of the Vertex that will be the source of the
     * search
     * @return qdfs a queue with the vertices of depth-first search
     */
    public static <V, E> LinkedList<V> DepthFirstSearch(Graph<V, E> g, V vert) {

        LinkedList<V> verticesList = new LinkedList();

        if (!g.validVertex(vert)) {
            return null;
        }

        DepthFirstSearch(g, vert, verticesList);

        return verticesList;
    }

    /**
     * Returns all paths from vOrig to vDest
     *
     * @param g Graph instance
     * @param vOrig Vertex that will be the source of the path
     * @param vDest Vertex that will be the end of the path
     * @param visited set of discovered vertices
     * @param path stack with vertices of the current path (the path is in
     * reverse order)
     * @param paths ArrayList with all the paths (in correct order)
     */
    private static <V, E> void allPaths(Graph<V, E> g, V vOrig, V vDest,
            LinkedList<V> path, ArrayList<LinkedList<V>> paths) {
        
        path.add(vOrig);
        
        for (V vAdj:g.adjVertices(vOrig)){
            if(vAdj == vDest){
                path.add(vAdj);
                paths.add(path);
                path.removeLast();
            }else{
                if(!path.contains(vAdj)){
                    allPaths(g, vAdj, vDest, path, paths);
                }
            }
        }

        path.removeLast();
    }

    /**
     * @param g Graph instance
     * @param voInf information of the Vertex origin
     * @param vdInf information of the Vertex destination
     * @return paths ArrayList with all paths from voInf to vdInf
     */
    public static <V, E> ArrayList<LinkedList<V>> allPaths(Graph<V, E> g, V vOrig, V vDest) {

        if ((!g.validVertex(vOrig))||(!g.validVertex(vDest))){
            return null;
        }
        
        LinkedList<V> path = new LinkedList<>();
        
        ArrayList<LinkedList<V>> allPaths = new ArrayList<>();
        
        allPaths(g, vOrig, vDest, path, allPaths);
        
        return allPaths;
    }

    /**
     * Computes shortest-path distance from a source vertex to all reachable
     * vertices of a graph g with nonnegative edge weights This implementation
     * uses Dijkstra's algorithm
     *
     * @param g Graph instance
     * @param vOrig Vertex that will be the source of the path
     * @param visited set of discovered vertices
     * @param pathkeys minimum path vertices keys
     * @param dist minimum distances
     */
    protected static <V, E> void shortestPathLength(Graph<V, E> g, V vOrig,
            boolean[] visited, int[] pathKeys, double[] dist) {


    }

    /**
     * Extracts from pathKeys the minimum path between voInf and vdInf The path
     * is constructed from the end to the beginning
     *
     * @param g Graph instance
     * @param voInf information of the Vertex origin
     * @param vdInf information of the Vertex destination
     * @param pathkeys minimum path vertices keys
     * @param path stack with the minimum path (correct order)
     */
    protected static <V, E> void getPath(Graph<V, E> g, V vOrig, V vDest, V[] pathKeys, LinkedList<V> path) {

        throw new UnsupportedOperationException("Not supported yet.");
    }

    //shortest-path between vOrig and vDest
    public static <V, E> double shortestPath(Graph<V, E> g, V vOrig, V vDest, LinkedList<V> shortPath) {

        throw new UnsupportedOperationException("Not supported yet.");
    }

    //shortest-path between voInf and all other
    public static <V, E> boolean shortestPaths(Graph<V, E> g, V vOrig, ArrayList<LinkedList<V>> paths, ArrayList<Double> dists) {

        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Reverses the path
     *
     * @param path stack with path
     */
    private static <V, E> LinkedList<V> revPath(LinkedList<V> path) {

        LinkedList<V> pathcopy = new LinkedList<>(path);
        LinkedList<V> pathrev = new LinkedList<>();

        while (!pathcopy.isEmpty()) {
            pathrev.push(pathcopy.pop());
        }

        return pathrev;
    }
}

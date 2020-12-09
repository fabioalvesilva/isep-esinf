/*
* A collection of graph algorithms.
 */
package GraphBase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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
        if (!g.validVertex(vert)) {
            return null;
        }

        LinkedList<V> resultQueue = new LinkedList<>();

        LinkedList<V> auxQueue = new LinkedList<>();

        resultQueue.add(vert);
        auxQueue.add(vert);

        while (!auxQueue.isEmpty()) {
            vert = auxQueue.removeFirst();
            for (V vAdj : g.adjVertices(vert)) {
                if (!resultQueue.contains(vAdj)) {
                    resultQueue.add(vAdj);
                    auxQueue.add(vAdj);
                }
            }
        }
        return resultQueue;
    }

    /**
     * Performs depth-first search starting in a Vertex - to be called
     * recursively
     *
     * @param g Graph instance
     * @param vOrig Vertex of graph g that will be the source of the search
     * @param visited set of discovered vertices
     * @param qdfs queue with vertices of depth-first search
     */
    private static <V, E> void DepthFirstSearch(Graph<V, E> g, V vOrig, LinkedList<V> qdfs) {
        qdfs.add(vOrig);
        for (V adjVert : g.adjVertices(vOrig)) {
            if (!qdfs.contains(adjVert)) {
                DepthFirstSearch(g, adjVert, qdfs);
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
        if (!g.validVertex(vert)) {
            return null;
        }
        LinkedList<V> qdfs = new LinkedList<>();
        qdfs.add(vert);
        for (V adjVert : g.adjVertices(vert)) {
            if (!qdfs.contains(adjVert)) {
                DepthFirstSearch(g, adjVert, qdfs);
            }
        }
        return qdfs;
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
        for (V adjVert : g.adjVertices(vOrig)) {
            if (adjVert.equals(vDest)) {
                path.add(vDest);
                paths.add(path);
                path.removeLast();
            } else {
                if (!path.contains(adjVert)) {
                    allPaths(g, adjVert, vDest, path, paths);
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
        if (!g.validVertex(vOrig) || !g.validVertex(vDest)) {
            return null;
        }
        LinkedList<V> path = new LinkedList<>();
        ArrayList<LinkedList<V>> paths = new ArrayList<>();

        path.add(vOrig);
        for (V adjVert : g.adjVertices(vOrig)) {
            if (adjVert.equals(vDest)) {
                path.add(vDest);
                paths.add(path);
                path.removeLast();
            } else {
                if (!path.contains(adjVert)) {
                    allPaths(g, adjVert, vDest, path, paths);
                }
            }
        }
        return paths;
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
            boolean[] visited, V[] pathKeys, double[] dist) {

        HashMap<Integer, V> keyVerts = new HashMap<>();

        for (V vertx : g.vertices()) {
            int vertxKey = g.getKey(vertx);
            dist[vertxKey] = Double.MAX_VALUE;
            pathKeys[vertxKey] = null;
            visited[vertxKey] = false;
            keyVerts.put(vertxKey, vertx);
        }
        int keyVetOrig = g.getKey(vOrig);
        dist[keyVetOrig] = 0;
        while (keyVetOrig != -1) {
            vOrig = keyVerts.get(keyVetOrig);
            visited[keyVetOrig] = true;
            for (V adjVert : g.adjVertices(vOrig)) {
                Edge<V, E> edge = g.getEdge(vOrig, adjVert);
                if (!visited[g.getKey(adjVert)] && dist[g.getKey(adjVert)] > dist[g.getKey(vOrig)] + edge.getWeight()) {
                    dist[g.getKey(adjVert)] = dist[g.getKey(vOrig)] + edge.getWeight();
                    pathKeys[g.getKey(adjVert)] = vOrig;
                }
            }
            keyVetOrig = getVertMinDist(dist, visited);
        }

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
        if (!vOrig.equals(vDest)) {
            path.push(vDest);
            V vert = pathKeys[g.getKey(vDest)];
            if (vert != null) {
                vDest = vert;
                getPath(g, vOrig, vDest, pathKeys, path);
            }
        } else {
            path.push(vOrig);
        }
    }

    //shortest-path between vOrig and vDest
    public static <V, E> double shortestPath(Graph<V, E> g, V vOrig, V vDest, LinkedList<V> shortPath) {
        if (!g.validVertex(vOrig) || !g.validVertex(vDest)) {
            return 0;
        }
        shortPath.clear();
        boolean[] visited = new boolean[g.numVertices()];
        double[] dist = new double[g.numVertices()];
        V[] pathKeys = (V[]) Array.newInstance(vOrig.getClass(), g.numVertices());

        shortestPathLength(g, vOrig, visited, pathKeys, dist);
        if (dist[g.getKey(vDest)] != Double.MAX_VALUE) {
            getPath(g, vOrig, vDest, pathKeys, shortPath);
        }
        return shortPath.isEmpty() ? 0 : dist[g.getKey(vDest)];
    }

    //shortest-path between voInf and all other
    public static <V, E> boolean shortestPaths(Graph<V, E> g, V vOrig, ArrayList<LinkedList<V>> paths, ArrayList<Double> dists) {
        if (!g.validVertex(vOrig)) {
            return false;
        }
        boolean[] visited = new boolean[g.numVertices()];
        double[] dist = new double[g.numVertices()];
        V[] pathKeys = (V[]) Array.newInstance(vOrig.getClass(), g.numVertices());

        shortestPathLength(g, vOrig, visited, pathKeys, dist);

        dists.clear();
        paths.clear();
        for (int i = 0; i < g.numVertices(); i++) {
            paths.add(null);
            dists.add(null);
        }
        for (V vertex : g.vertices()) {
            LinkedList<V> shortPath = new LinkedList<>();
            if (dist[g.getKey(vertex)] != Double.MAX_VALUE) {
                getPath(g, vOrig, vertex, pathKeys, shortPath);
            }
            paths.set(g.getKey(vertex), shortPath);
            dists.set(g.getKey(vertex), dist[g.getKey(vertex)]);
        }
        return true;
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

    private static int getVertMinDist(double[] dist, boolean[] visited) {
        double mindist = Double.MAX_VALUE;
        int indice = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < mindist) {
                indice = i;
                mindist = dist[i];
            }
        }
        return indice;
    }
}
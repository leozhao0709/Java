package algorithms.graph;

import java.util.ArrayList;

class SparseGraph {

    private ArrayList[] g;
    private int nVertex;
    private boolean directed;

    public SparseGraph(int nVertex, boolean directed) {
        this.nVertex = nVertex;
        this.g = new ArrayList[nVertex];
        this.directed = directed;

        for (int i = 0; i < nVertex; i++) {
            this.g[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int i, int j, int weight) {
        
    }
}

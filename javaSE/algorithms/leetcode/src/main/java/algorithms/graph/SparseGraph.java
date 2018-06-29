package algorithms.graph;

import java.util.ArrayList;

class SparseGraph extends Graph {

    private ArrayList<Edge>[] graph;
    private int nVertex;
    private boolean directed;

    public SparseGraph(int nVertex, boolean directed) {
        this.nVertex = nVertex;
        this.graph = new ArrayList[nVertex];
        this.directed = directed;

        for (int i = 0; i < nVertex; i++) {
            this.graph[i] = new ArrayList<Edge>();
        }
    }

    public void addEdge(int from, int to, double weight) {
        Edge edge = new Edge(from, to, weight);

        this.graph[from].add(edge);

        if (!this.directed) {
            Edge reverseEdge = new Edge(to, from, weight);
            this.graph[to].add(reverseEdge);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.nVertex; i++) {
            sb.append("vertex").append(i).append(": ");
            for (int j = 0; j < this.graph[i].size(); j++) {
                sb.append(this.graph[i].get(j)).append("        ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

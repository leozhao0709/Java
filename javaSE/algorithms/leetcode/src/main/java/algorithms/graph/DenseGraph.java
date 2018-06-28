package algorithms.graph;

import java.util.Arrays;

class DenseGraph {

    private Edge[][] graph;
    private int nVertex;
    private boolean directed;

    public DenseGraph(int nVertex, boolean directed) {
        this.nVertex = nVertex;
        this.graph = new Edge[nVertex][nVertex];
        this.directed = directed;
    }

    public void addEdge(int from, int to, double weight) {
        Edge edge = new Edge(from, to, weight);
        this.graph[from][to] = edge;

        if (!this.directed) {
            Edge reverseEdge = new Edge(to, from, weight);
            this.graph[to][from] = reverseEdge;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.nVertex; i++) {
            sb.append("vertex").append(i).append(": ");
            for (int j = 0; j < this.nVertex; j++) {
                if (this.graph[i][j] != null) {
                    sb.append(this.graph[i][j].getWeight());
                } else {
                    sb.append("null");
                }
                sb.append("     ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

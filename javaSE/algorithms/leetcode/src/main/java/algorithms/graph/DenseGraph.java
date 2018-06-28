package algorithms.graph;

class DenseGraph {

    private int[][] graph;
    private int nVertex;
    private boolean directed;

    public DenseGraph(int nVertex, boolean directed) {
        this.nVertex = nVertex;
        this.graph = new int[nVertex][nVertex];
        this.directed = directed;
    }

    public void addEdge(int i, int j, int weight) {
        this.graph[i][j] = weight;

        if (!this.directed) {
            this.graph[j][i] = weight;
        }
    }
}

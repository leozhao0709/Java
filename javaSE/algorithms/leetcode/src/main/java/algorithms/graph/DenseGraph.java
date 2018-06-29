package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class DenseGraph extends Graph {

    private Edge[][] graph;
    private int nVertex;
    private boolean directed;
    private int[] pathFrom; // path array
    private ArrayList<Edge> mstPath;

    public DenseGraph(int nVertex, boolean directed) {
        this.nVertex = nVertex;
        this.graph = new Edge[nVertex][nVertex];
        this.directed = directed;
        this.pathFrom = new int[nVertex];

        for (int i = 0; i < this.nVertex; i++) {
            this.pathFrom[i] = -1;
        }

        this.mstPath = new ArrayList<>();
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

    public void DFS(int vertex) {
        boolean[] visited = new boolean[this.nVertex];
        this.DFS(vertex, visited);
    }

    private void DFS(int vertex, boolean[] visited) {
        visited[vertex] = true;
        Edge[] edges = this.graph[vertex];
        System.out.println("Vertex" + vertex);
        for (int i = 0; i < nVertex; i++) {
            if (edges[i] != null && !visited[edges[i].getTo()]) {
                this.pathFrom[edges[i].getTo()] = edges[i].getFrom();
                this.DFS(edges[i].getTo(), visited);
            }
        }
    }

    public List<Integer> getPath(int src, int des) {
        assert src < this.nVertex && des < this.nVertex;
        this.pathFrom = new int[this.nVertex];
        for (int i = 0; i < this.pathFrom.length; i++) {
            this.pathFrom[i] = -1;
        }


        this.DFS(src);

        List<Integer> path = new ArrayList<>();

        if (this.pathFrom[des] == -1) {
            return path;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(des);

        int parent = this.pathFrom[des];
        while (parent != -1) {
            stack.push(parent);
            parent = this.pathFrom[parent];
        }

        while (!stack.isEmpty()) {
            path.add(stack.pop());
        }

        return path;
    }

    public double minimumSpanTree(int vertex) {
        Double[] minimum = new Double[this.nVertex];
        boolean[] visited = new boolean[this.nVertex];

        // to edge
        Edge[] minimumEdges = new Edge[this.nVertex];

        for (int i = 0; i < this.nVertex; i++) {

            if (this.graph[vertex][i] != null) {
                minimum[this.graph[vertex][i].getTo()] = this.graph[vertex][i].getWeight();
            } else {
                minimum[i] = 0.0;
            }
        }

        this.visit(vertex, minimum, visited, minimumEdges);

        double minimumSum = 0;
        for (int i = 0; i < this.nVertex; i++) {
            minimumSum += minimum[i];
        }
        System.out.println(Arrays.toString(minimum));
        return minimumSum;
    }

    private void visit(int vertex, Double[] minimum, boolean[] visited, Edge[] minimumEdges) {
        Edge[] edges = this.graph[vertex];
        visited[vertex] = true;
        for (int i = 0; i < edges.length; i++) {
            Edge edge = edges[i];
            if (edge != null) {
                int to = edge.getTo();
                double weight = edge.getWeight();
                if (!visited[to]) {
                    if (minimum[to] == 0) {
                        minimum[to] = weight;
                    } else {
                        if (minimum[to] > weight) {
                            minimum[to] = weight;
                        }
                    }
                }
            }

            if (edge != null) {
                if (!visited[edge.getTo()]) {
                    if (minimumEdges[i] == null) {
                        minimumEdges[i] = edge;
                    } else if (minimumEdges[i].compareTo(edge) > 0) {
                        minimumEdges[i] = edge;
                    }
                }
            }
        }

        double min = Integer.MAX_VALUE;
        int nextVertex = -1;
        Edge minimumEdge = new Edge(-1, -1, Double.MAX_VALUE);
        for (int i = 0; i < this.nVertex; i++) {
            if ( minimum[i] > 0 && !visited[i] && minimum[i] < min) {
                min = minimum[i];
                nextVertex = i;
            }

            if (minimumEdges[i] != null && !visited[i] && minimumEdges[i].compareTo(minimumEdge) < 0) {
                minimumEdge = minimumEdges[i];
            }
        }



        if (nextVertex != -1) {
            this.mstPath.add(minimumEdge);
            this.visit(nextVertex, minimum, visited, minimumEdges);
        }
    }

    public List<Edge> getMSTPath() {
        return this.mstPath;
    }


}

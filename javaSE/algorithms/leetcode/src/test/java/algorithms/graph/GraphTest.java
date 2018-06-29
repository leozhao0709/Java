package algorithms.graph;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class GraphTest {

    private DenseGraph undirectedDenseGraph;
    private SparseGraph undirectedSparseGraph;

    private DenseGraph directedDenseGraph;

    @Before
    public void setUp() throws Exception {

        int nVertex = 9;
        this.undirectedDenseGraph = new DenseGraph(nVertex, false);
        this.undirectedSparseGraph = new SparseGraph(nVertex, false);

        String testG1Path = "./src/test/java/algorithms/graph/testG1.txt";
        this.readGraph(testG1Path, this.undirectedDenseGraph);
        this.readGraph(testG1Path, this.undirectedSparseGraph);

        nVertex = 9;
        this.directedDenseGraph = new DenseGraph(nVertex, true);
        String testG2Path = "./src/test/java/algorithms/graph/testG2.txt";
        this.readGraph(testG2Path, this.directedDenseGraph);
    }

    private void readGraph(String filePath, Graph graph) throws IOException {
        File file = new File(filePath);
        List<String> lines = Files.readAllLines(file.toPath());

        for (int i = 0; i < lines.size(); i++) {
            String[] split = lines.get(i).split("\\s+");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            double weight = Double.parseDouble(split[2]);

            graph.addEdge(from, to ,weight);
        }
    }

    @Test
    public void printGraph() {
        System.out.println(this.undirectedDenseGraph);
        System.out.println("-----------------------------");
        System.out.println(this.undirectedSparseGraph);
        System.out.println("-----------------------------");
        System.out.println(this.directedDenseGraph);
    }

    @Test
    public void DFS() {
        this.undirectedDenseGraph.DFS(0);
    }

    @Test
    public void getPath() {
        int src = 0;
        int des = 8;

        List<Integer> path = this.undirectedDenseGraph.getPath(src, des);

        System.out.println(Arrays.toString(path.toArray()));
    }

    @Test
    public void minimumSpanTree() {
        double minimumSum = this.undirectedDenseGraph.minimumSpanTree(0);

        System.out.println(minimumSum);

        System.out.println(Arrays.toString(this.undirectedDenseGraph.getMSTPath().toArray()));
    }
}
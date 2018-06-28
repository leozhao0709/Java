package algorithms.graph;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GraphTest {

    private DenseGraph denseGraph;
    private SparseGraph sparseGraph;

    @Before
    public void setUp() throws Exception {

        int n = 9;
        this.denseGraph = new DenseGraph(n, false);
        this.sparseGraph = new SparseGraph(n, false);

//        File file = new File( System.getProperty("user.dir") + "/src/test/java/algorithms/graph/testG1.txt");
        File file = new File( "./src/test/java/algorithms/graph/testG1.txt");
        List<String> lines = Files.readAllLines(file.toPath());

        for (int i = 0; i < lines.size(); i++) {
            String[] split = lines.get(i).split("\\s+");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            double weight = Double.parseDouble(split[2]);

            this.denseGraph.addEdge(from, to ,weight);
            this.sparseGraph.addEdge(from, to, weight);
        }

    }

    @Test
    public void printGraph() {
        System.out.println(this.denseGraph);
        System.out.println("-----------------------------");
        System.out.println(this.sparseGraph);
    }
}
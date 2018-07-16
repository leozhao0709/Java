package _041_080._054_spiralMatrix;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SpiralMatrixTest {

    private SpiralMatrix spiralMatrix;

    @Before
    public void setUp() throws Exception {
        this.spiralMatrix = new SpiralMatrix();
    }

    @Test
    public void spiralOrder() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12}};
        int[][] matrix2 = {{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}};
        List<Integer> res = this.spiralMatrix.spiralOrder(matrix);

        System.out.println(Arrays.toString(res.toArray()));
    }
}
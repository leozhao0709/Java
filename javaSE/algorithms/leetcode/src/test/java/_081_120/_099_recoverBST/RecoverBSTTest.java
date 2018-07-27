package _081_120._099_recoverBST;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecoverBSTTest {

    private RecoverBST recoverBST;

    @Before
    public void setUp() throws Exception {
        this.recoverBST = new RecoverBST();
    }

    @Test
    public void recoverTree() {
        RecoverBST.TreeNode root = new RecoverBST.TreeNode(3);
        root.left = new RecoverBST.TreeNode(1);
        root.right = new RecoverBST.TreeNode(4);
        root.right.left= new RecoverBST.TreeNode(2);

        this.recoverBST.recoverTree(root);
    }
}
package _041_080._055_jumpGame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameTest {

    private JumpGame jumpGame;

    @Before
    public void setUp() throws Exception {
        this.jumpGame = new JumpGame();
    }

    @Test
    public void canJump() {
        int[] nums = {2,3,1,1,4};
        int[] nums1 = {3,2,1,0,4};
        System.out.println(this.jumpGame.canJump(nums1));
    }
}
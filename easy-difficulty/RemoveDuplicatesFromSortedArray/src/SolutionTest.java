import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void firstTest() {
        Assert.assertEquals(2, solution.removeDuplicates(new int[]{1,1,2}));
    }

    @Test
    public void secondTest() {
        Assert.assertEquals(5, solution.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    @Test
    public void emptyArray() {
        Assert.assertEquals(0, solution.removeDuplicates(new int[]{}));
    }
}

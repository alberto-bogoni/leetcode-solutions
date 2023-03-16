import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void firstTest() {
        Assert.assertEquals(true, solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void secondTest() {
        Assert.assertEquals(false, solution.isPalindrome("race a car"));
    }

    @Test
    public void thirdTest() {
        Assert.assertEquals(false, solution.isPalindrome("0P"));
    }
}

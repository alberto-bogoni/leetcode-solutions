import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void stringWithLastWordAtTheEnd() {
        Assert.assertEquals(5, solution.lengthOfLastWord("Hello World"));
    }

    @Test
    public void emptyString() {
        Assert.assertEquals(0, solution.lengthOfLastWord(""));
    }
}

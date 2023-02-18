import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void palindromePositiveNumber() {
        Assert.assertEquals(true, solution.isPalindrome(121));
    }

    @Test
    public void notPalindromeNegativeNumber() {
        Assert.assertEquals(false, solution.isPalindrome(-121));
    }

    @Test
    public void notPalindromeNumber() {
        Assert.assertEquals(false, solution.isPalindrome(10));
    }

    @Test
    public void palindromeLargeNumber() {
        Assert.assertEquals(true, solution.isPalindrome(55511555));
    }

    @Test
    public void notPalindromeLargeNumber() {
        Assert.assertEquals(false, solution.isPalindrome(1000401));
    }
}

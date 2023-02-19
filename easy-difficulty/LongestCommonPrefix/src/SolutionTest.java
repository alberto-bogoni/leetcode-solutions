import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {
    Solution solution = new Solution();
    @Test
    public void stringsWithCommonPrefix() {
        Assert.assertEquals("fl", solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    @Test
    public void stringsWithoutCommonPrefix() {
        Assert.assertEquals("", solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    @Test
    public void singleCharacter() {
        Assert.assertEquals("a", solution.longestCommonPrefix(new String[]{"a"}));
    }

    @Test
    public void emptyArray() {
        Assert.assertEquals("", solution.longestCommonPrefix(new String[]{}));
    }

    @Test
    public void arrayWithEmptyStrings() {
        Assert.assertEquals("", solution.longestCommonPrefix(new String[]{"", ""}));
    }

    @Test
    public void arrayWithMultipleEqualStrings() {
        Assert.assertEquals("flower", solution.longestCommonPrefix(new String[]{"flower","flower","flower","flower"}));
    }
}

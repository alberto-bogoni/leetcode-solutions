import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void unitNumber() {
        Assert.assertEquals(3, solution.romanToInt("III"));
    }

    @Test
    public void decimalNumber() {
        Assert.assertEquals(58, solution.romanToInt("LVIII"));
    }

    @Test
    public void thousandNumber() {
        Assert.assertEquals(1994, solution.romanToInt("MCMXCIV"));
    }
}
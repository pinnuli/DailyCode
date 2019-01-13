package the5_replaceSpace;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void replaceBlank() throws Exception {
        Solution solution = new Solution();
        String result = solution.replaceBlank(new StringBuffer(" we are chinese "));
        System.out.println(result);
    }
}
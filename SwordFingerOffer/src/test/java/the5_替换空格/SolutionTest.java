package the5_替换空格;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void replaceBlank() throws Exception {
        Solution solution = new Solution();
        String result = solution.replaceBlank(new StringBuffer(" we are chinese "));
        System.out.println(result);
    }
}
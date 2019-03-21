
package the50_第一个只出现一次的字符.题目一_1;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Solution1 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>三月 21, 2019</pre>
 */
public class SolutionTest {

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: deleteFirstExistSecond(String str1, String str2)
     */
    @Test
    public void testDeleteFirstExistSecond() throws Exception {
        Solution1 solution1 = new Solution1();
        String str1 = "We are students.";
        String str2 = "aeiou.";
        System.out.println(solution1.deleteFirstExistSecondByMap(str1, str2));
    }


} 

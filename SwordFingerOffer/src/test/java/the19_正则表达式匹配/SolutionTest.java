
package the19_正则表达式匹配;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Solution Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>二月 21, 2019</pre>
 */
public class SolutionTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: match(char[] str, char[] pattern)
     */
    @Test
    public void testMatch() throws Exception {
        String string1 = "aaa";
        String string2 = "aaab";
        String string3 = "";
        char[] str1 = string1.toCharArray();
        char[] str2 = string2.toCharArray();
        char[] str3 = string3.toCharArray();

        String pattern1 = "a.a";
        String pattern2 = "ab*ac*a";
        String pattern3 = "aa.a";
        String pattern4 = "ab*a";
        String pattern5 = ".*";
        char[] pat1 = pattern1.toCharArray();
        char[] pat2 = pattern2.toCharArray();
        char[] pat3 = pattern3.toCharArray();
        char[] pat4 = pattern4.toCharArray();
        char[] pat5 = pattern5.toCharArray();


        Solution solution = new Solution();
        System.out.println(string1 + " " + pattern1 + ": " + solution.match(str1, pat1));
        System.out.println(string2 + " " + pattern1 + ": " + solution.match(str2, pat1));
        System.out.println(string3 + " " + pattern1 + ": " + solution.match(str3, pat1));
        System.out.println(string1 + " " + pattern2 + ": " + solution.match(str1, pat2));
        System.out.println(string1 + " " + pattern3 + ": " + solution.match(str1, pat3));
        System.out.println(string1 + " " + pattern4 + ": " + solution.match(str1, pat4));
        System.out.println(string1 + " " + pattern5 + ": " + solution.match(str1, pat5));
        System.out.println(string3 + " " + pattern5 + ": " + solution.match(str3, pat5));
    }

    /**
     * Method: matchCore(char[] str, char[] pattern, int strIndex, int patIndex)
     */
    @Test
    public void testMatchCore() throws Exception {
//TODO: Test goes here... 
    }


} 

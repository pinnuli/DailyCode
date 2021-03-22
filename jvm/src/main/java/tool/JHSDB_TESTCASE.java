package tool;

/**
 * @author: linxiaoyi
 * @date: 2021/1/16
 */
public class JHSDB_TESTCASE {

    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }

    }


    private static class ObjectHolder {
    }

    public static void main(String[] args) {
        Test test = new JHSDB_TESTCASE.Test();
        test.foo();
    }

}

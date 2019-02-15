package singleton;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 * 不安全
 * @author: pinnuli
 * @date: 2019-02-15
 */

public class SingleExample1 {

    private SingleExample1() {}

    private static SingleExample1 instance = null;

    public static SingleExample1 getInstance() {
        if (instance == null) {
            instance = new SingleExample1();
        }
        return instance;
    }
}

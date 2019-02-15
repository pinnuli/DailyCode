package singleton;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 * @author: pinnuli
 * @date: 2019-02-15
 */

public class SingleExample2 {

    private SingleExample2() {}

    private static SingleExample2 instance = new SingleExample2();

    public static SingleExample2 getInstance() {
        return instance;
    }
}

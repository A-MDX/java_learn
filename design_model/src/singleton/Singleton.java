package singleton;

/**
 * Created by A-mdx on 2016/11/1.
 */
public class Singleton {

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static Singleton ourInstance = null;

    /**
     * 这个类基本满足要求，但是像这样毫无线程安全保护的类，多线程会有问题
     * 我们可以加同步锁,
     * 第一次创建时候，加锁！
     * @return
     */
    public static Singleton getInstance() {
        if (ourInstance == null ){
            synchronized (ourInstance){
                if (ourInstance == null){
                    ourInstance = new Singleton();
                }
            }
        }
        return ourInstance;
    }

    private Singleton() {
    }
}

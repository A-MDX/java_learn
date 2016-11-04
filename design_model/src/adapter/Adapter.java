package adapter;

/**
 * 这就是传说中的适配器模式
 * Created by A-mdx on 2016/11/4.
 */
public class Adapter extends Source implements Targetable {
    
    //  这样Targetable接口的实现类就具有了Source类的功能。
    
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}

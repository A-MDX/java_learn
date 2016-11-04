package adapter;

/**
 * 把这个类的实例直接装进去。
 * Created by A-mdx on 2016/11/4.
 */
public class Wrapper implements Targetable {
    
    private Source source;
    
    public Wrapper(Source source){
        this.source = source;
    }
    
    public void method1() {
        source.method1();
    }

    public void method2() {
        System.out.println("this is the targetable method!");
    }
}

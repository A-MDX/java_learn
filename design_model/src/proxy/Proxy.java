package proxy;

/**
 * Created by A-mdx on 2016/11/7.
 */
public class Proxy implements Soureable {
    
    private Source source;
    
    public Proxy(){
        this.source = new Source();
    }
    
    public void method() {
        before();
        source.method();
        after();
    }
    
    private void before(){
        System.out.println("before proxy!");
    }
    private void after(){
        System.out.println("after proxy!");
    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.method();
    }
    
}

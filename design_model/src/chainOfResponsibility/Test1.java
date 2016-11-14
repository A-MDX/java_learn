package chainOfResponsibility;

/**
 * Created by A-mdx on 2016/11/14.
 */
public class Test1 {

    public static void main(String[] args) {
        MyHandler h1 = new MyHandler("h1");
        MyHandler h2 = new MyHandler("h2");
        MyHandler h3 = new MyHandler("h3");
        
        h1.setHandler(h2);
        h2.setHandler(h3);
        
        h1.operator();
        
    }
    
}

package decorator;

/**
 * Created by A-mdx on 2016/11/4.
 */
public class Decotator implements Sourceable {
    
    private Sourceable sourceable;

    public Decotator(Sourceable sourceable) {
        this.sourceable = sourceable;
    }

    public void method() {
        System.out.println("before decorator!");
        sourceable.method();
        System.out.println("after decorator!");
        
    }
}

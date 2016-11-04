package decorator;

import org.junit.Test;

/**
 * Created by A-mdx on 2016/11/4.
 */
public class Test1 {
    
    @Test
    public void test1(){
        Sourceable sourceable = new Source();
        Sourceable obj = new Decotator(sourceable);
        obj.method();
    }
    
}

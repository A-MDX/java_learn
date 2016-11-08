package templateMethod;

import org.junit.Test;

/**
 * Created by A-mdx on 2016/11/8.
 */
public class TemplateTest {
    
    @Test
    public void test1(){
        String exp = "8+8";
        AbstractCal cal = new Plus();
        int result = cal.calculate(exp,"\\+");
        System.out.println(exp + " --> "+result);
    }
    
}

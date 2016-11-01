package abstractFactory;

import factoryMethod.Sender;
import org.junit.Test;

/**
 * Created by A-mdx on 2016/11/1.
 */
public class AbstractTest {
    
    @Test
    public void test(){
        System.out.println("// 抽象工厂方法！");
        Provider provider = new MailFactory();
        Sender mail = provider.produce();
        mail.send();
    }
    
}

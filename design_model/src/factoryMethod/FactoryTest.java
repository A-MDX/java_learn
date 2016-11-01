package factoryMethod;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by A-mdx on 2016/11/1.
 */
public class FactoryTest {
    
    private SendFactory sendFactory;
    
    @Before
    public void setUp(){
        this.sendFactory = new SendFactory();
    }
    
    @Test
    public void testNormal(){
        System.out.println("// 1. 普通工厂模式测试！");
        Sender sender = sendFactory.produce("qq");
        sender.send();
    }
    
    @Test
    public void testMoreFactory(){
        System.out.println("// 2. 多个工厂模式！");
        Sender qq = sendFactory.produceQq();
        qq.send();
        Sender mail = sendFactory.produceMail();
        mail.send();
        
    }
    
    @Test
    public void testStaticFactory(){
        System.out.println("// 3. 静态工厂模式！");
        Sender mail = SendFactory.produeMail();
        mail.send();
        
    }
    
    
}

package builder;

import factoryMethod.MailSender;
import factoryMethod.QqSender;
import factoryMethod.Sender;

import java.util.ArrayList;
import java.util.List;

/**
 * 关于建造者模式，就是一个复合的建造者，比如，建造车子等。
 * 它可以创建出更复杂的对象
 * Created by A-mdx on 2016/11/1.
 */
public class Builder {
    private List<Sender> list = new ArrayList<Sender>();
    
    public void produceMailSender(int count){
        for (int i = 0; i < count; i++){
            list.add(new MailSender());
        }
    }
    
    public void produceQqSender(int count){
        for (int i = 0 ;i < count; i++){
            list.add(new QqSender());
        }
    }
    
}

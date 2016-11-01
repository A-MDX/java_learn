package abstractFactory;

import factoryMethod.QqSender;
import factoryMethod.Sender;

/**
 * Created by A-mdx on 2016/11/1.
 */
public class QqFactory implements Provider {
    public Sender produce() {
        return new QqSender();
    }
}

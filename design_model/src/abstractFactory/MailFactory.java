package abstractFactory;

import factoryMethod.MailSender;
import factoryMethod.Sender;

/**
 * Created by A-mdx on 2016/11/1.
 */
public class MailFactory implements Provider {
    public Sender produce() {
        return new MailSender();
    }
}

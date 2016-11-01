package factoryMethod;

/**
 * Created by A-mdx on 2016/11/1.
 */
public class MailSender implements Sender {
    public void send() {
        System.out.println("This is mail sender!");
    }
}

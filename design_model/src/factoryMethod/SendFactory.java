package factoryMethod;

/**
 * Created by A-mdx on 2016/11/1.
 */
public class SendFactory {

    /**
     * 1.普通工厂方法
     * @param type
     * @return
     */
    public Sender produce(String type){
        if (type.equals("mail")) {
            return new MailSender();
        } else if (type.equals("qq")) {
            return new QqSender();
        } else {
            System.out.println("请输入正确类型！");
        }
        return null;
        
    }


    /**
     * 2.多个工厂模式
     * @return
     */
    public Sender produceMail(){
        return new MailSender();
    }
    public Sender produceQq(){
        return new QqSender();
    }

    /**
     * 3.静态工厂方法模式
     * @return
     */
    public static Sender produeMail(){
        return new MailSender();
    }
    public static Sender produeQQ(){
        return new QqSender();
    }
    
}

package mediator;

/**
 * 这个中介者模式，感觉好无聊，
 * 而且，太耦合了把。
 * Created by A-mdx on 2016/11/15.
 */
public class TestM {
    public static void main(String[] args) {
        Mediator mediator = new MyMediator();
        mediator.creatorMediator();
        mediator.workAll();
    }
}

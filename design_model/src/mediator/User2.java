package mediator;

/**
 * Created by A-mdx on 2016/11/15.
 */
public class User2 extends User {
    
    public User2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user2 exe!");
    }
}

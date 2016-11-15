package mediator;

/**
 * Created by A-mdx on 2016/11/15.
 */
public abstract class User {
    private Mediator mediator;

    public User(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }
    
    public abstract void work();
}

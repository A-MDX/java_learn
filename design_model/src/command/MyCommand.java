package command;

/**
 * 命令
 * Created by A-mdx on 2016/11/14.
 */
public class MyCommand implements Command {
    
    private Receiver receiver;
    
    public MyCommand(Receiver receiver){
        this.receiver = receiver;
    }
    
    public void exe() {
        receiver.action();
    }
}

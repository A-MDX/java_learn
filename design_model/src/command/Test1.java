package command;

/**
 * Created by A-mdx on 2016/11/14.
 */
public class Test1 {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command cmd = new MyCommand(receiver);
        Invoker invoker = new Invoker(cmd);
        invoker.action();
    }
}

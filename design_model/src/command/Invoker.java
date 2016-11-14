package command;

/**
 * 调用者，司令员
 * Created by A-mdx on 2016/11/14.
 */
public class Invoker {
    
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }
    
    public void action(){
        command.exe();
    }
}

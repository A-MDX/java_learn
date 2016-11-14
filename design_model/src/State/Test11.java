package State;

/**
 * Created by A-mdx on 2016/11/14.
 */
public class Test11 {
    public static void main(String[] args) {
        State state = new State();
        
        Context context = new Context(state);
        
        // state 1
        state.setValue("state1");
        context.method();
        
        // state 2
        state.setValue("state2");
        context.method();
        
    }
}

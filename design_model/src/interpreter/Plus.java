package interpreter;

/**
 * Created by A-mdx on 2016/11/15.
 */
public class Plus implements Expression {
    public int interpret(Context context) {
        return context.getNum1()+context.getNum2();
    }
}

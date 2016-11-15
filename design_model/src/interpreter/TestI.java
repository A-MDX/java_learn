package interpreter;

/**
 * 这个好玩啊
 * Created by A-mdx on 2016/11/15.
 */
public class TestI {
    public static void main(String[] args) {
        Context context = new Context(99,11);
        
        System.out.println(new Plus().interpret(context)+new Minus().interpret(context));
    }
}

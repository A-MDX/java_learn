package visitor;

/**
 * Created by A-mdx on 2016/11/15.
 */
public class TestV {
    public static void main(String[] args) {
        Visitor visitor = new MyVisitor();
        Subject sub = new MySubject();
        sub.accept(visitor);
    }
}

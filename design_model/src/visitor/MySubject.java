package visitor;

/**
 * Created by A-mdx on 2016/11/15.
 */
public class MySubject implements Subject {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getSubject() {
        return "love";
    }
}

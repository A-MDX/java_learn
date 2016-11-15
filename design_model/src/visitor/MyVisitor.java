package visitor;

/**
 * Created by A-mdx on 2016/11/15.
 */
public class MyVisitor implements Visitor {
    public void visit(Subject sub) {
        System.out.println("Visit the subject:"+sub.getSubject());
    }
}

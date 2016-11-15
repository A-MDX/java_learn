package visitor;

/**
 * Created by A-mdx on 2016/11/15.
 */
public interface Subject {
    void accept(Visitor visitor);
    String getSubject();
}

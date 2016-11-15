package interpreter;

/**
 * Context类是一个上下文环境类，Plus和Minus分别是用来计算的实现，
 * Created by A-mdx on 2016/11/15.
 */
public class Context {
    
    private int num1;
    private int num2;

    public Context(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
}

package State;

/**
 * 状态的核心类
 * Created by A-mdx on 2016/11/14.
 */
public class State {
    
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public void method1(){
        System.out.println("execute the first option.");
    }
    
    public void method2(){
        System.out.println("execute the second option.");
    }
    
}

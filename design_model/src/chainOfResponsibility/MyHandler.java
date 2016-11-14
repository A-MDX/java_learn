package chainOfResponsibility;

/**
 * 主类
 * Created by A-mdx on 2016/11/14.
 */
public class MyHandler extends AbstractHandler implements Handler {
    
    private String name;

    public MyHandler(String name){
        this.name = name;
    }

    public void operator() {
        System.out.println("name --> "+name); 
        if (getHandler() != null){
            getHandler().operator();
        }
    }
}

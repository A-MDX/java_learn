package observer;

/**
 * Created by A-mdx on 2016/11/10.
 */
public class MySubject extends AbstractSubject {
    
    public void operation() {
        System.out.println("update myself!");
        notifyObservers();
    }

    public static void main(String[] args) {
        //测试
        
        Subject my = new MySubject();
        my.add(new Observer1());
        my.add(new Observer2());
        
        // 操作了
        my.operation();
        
    }
}

package observer;

/**
 * 这个是让 观察者 看的
 * Created by A-mdx on 2016/11/10.
 */
public interface Subject {
    //增加
    void add(Observer observer);
    //删除
    void del(Observer observer);
    
    // 通知所有观察者
    void notifyObservers();
    
    // 自身操作
    void operation();
    
    
}

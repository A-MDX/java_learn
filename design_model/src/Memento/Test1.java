package Memento;

/**
 * Created by A-mdx on 2016/11/14.
 */
public class Test1 {

    public static void main(String[] args) {
        
        // 1. 创建原始类
        Original original = new Original("egg");
        
        // 2.创建备忘录
        Storage storage = new Storage(original.createMemento());
        
        // 3.修改原始类的状态 
        System.out.println("before --> "+original.getValue());
        original.setValue("cookie");
        System.out.println("after --> "+original.getValue());
        
        // 4.恢复原始类状态
        original.restoreMemento(storage.getMemento());
        System.out.println("then --> "+original.getValue());
        
    }
    
}

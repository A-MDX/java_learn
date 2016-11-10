package observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by A-mdx on 2016/11/10.
 */
public abstract class AbstractSubject implements Subject{
    private Vector<Observer> vector = new Vector<Observer>();

    public void add(Observer observer) {
        vector.add(observer);
    }

    public void del(Observer observer) {
        vector.remove(observer);
    }

    public void notifyObservers() {
        Enumeration<Observer> enumo = vector.elements();
        while(enumo.hasMoreElements()){
            enumo.nextElement().update();
        }
    }
}

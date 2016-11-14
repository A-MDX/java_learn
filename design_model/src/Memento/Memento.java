package Memento;

/**
 * Created by A-mdx on 2016/11/14.
 */
public class Memento {
    
    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

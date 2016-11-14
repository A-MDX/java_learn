package Memento;

/**
 * Created by A-mdx on 2016/11/14.
 */
public class Original {
    
    private String value;

    public Original(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public Memento createMemento(){
        return new Memento(this.value);
    }
    
    public void restoreMemento(Memento memento){
        this.value = memento.getValue();
    }
}

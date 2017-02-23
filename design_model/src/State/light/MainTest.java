package State.light;

/**
 * Created by A-mdx on 2017/2/23.
 */
public class MainTest {

    public static void main(String[] args) {
        Light light = new Light(new Off());
        light.PressSwitch();
        light.PressSwitch();
    }
    
    
}

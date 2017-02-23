package State.light;

/**
 * Created by A-mdx on 2017/2/23.
 */
public class Off extends LightState {

    protected void PressSwich(Light light) {
        System.out.println("Turn on this light.");
        light.setState(new On());
    }
}

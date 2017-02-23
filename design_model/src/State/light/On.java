package State.light;

/**
 * Created by A-mdx on 2017/2/23.
 */
public class On extends LightState {
    protected void PressSwich(Light light) {
        System.out.println("Turn off this light.");
        light.setState(new Off());
    }
}

package State.light;

/**
 * Created by A-mdx on 2017/2/23.
 */
public class Light {
    private LightState state;
    
    public Light(LightState state){
        this.state = state;
    }
    
    public void PressSwitch(){
        state.PressSwich(this);
    }

    public LightState getState() {
        return state;
    }

    public void setState(LightState state) {
        this.state = state;
    }
}

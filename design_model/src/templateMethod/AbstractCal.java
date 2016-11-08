package templateMethod;

/**
 * Created by A-mdx on 2016/11/8.
 */
public abstract class AbstractCal {

    /**
     * 主方法，实现对本类其他方法的调用
     */
    public final int calculate(String exp, String opt){
        int[] arr = split(exp,opt);
        return cal(arr[0],arr[1]);
    }

    abstract public int cal(int num1,int num2);
    
    public int[] split(String exp, String opt){
        String array[] = exp.split(opt);
        int[] arrInt = new int[2];
        arrInt[0] = Integer.valueOf(array[0]);
        arrInt[1] = Integer.valueOf(array[1]);
        return arrInt;
    }
    
}

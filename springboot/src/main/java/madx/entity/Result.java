package madx.entity;

/**
 * Created by A-mdx on 2016/11/24.
 */
public class Result {
    
    public static final int RESULT_SUCCESS = 50;
    public static final int RESULT_PARAME_ERRROR = 5;
    public static final int RESULT_ERROR = 0;
    
    private Integer code;
    private String msg;
    private Object data;

    /**
     * 使用静态工厂方法，快速赋值与初始化
     * @return
     */
    public static Result getInstance(){
        Result result = new Result();
        result.setCode(RESULT_SUCCESS);
        result.setMsg("ok");
        return result;
    }
    
    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

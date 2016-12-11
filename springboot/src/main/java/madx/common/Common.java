package madx.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import javax.servlet.ServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 通用方法类，以及常量类
 * Created by A-mdx on 2016/12/2.
 */
public class Common {
    
    // 统计行数，大路径
    public static final int JAVA_FILE_PATH = 1001;
    public static final int JAVA_FILE_PATH_BIG = 10011002;
    public static final int JAVA_FILE_PATH_SMALL = 10011001;
    
    // 是否状态
    public static final int STATUS = 1002;
    public static final int STATUS_YES = 10021001;
    public static final int STATUS_NO = 10021002;

    /**
     *  转换 int集合 --> 数据
     *  一般用于jdbc中
     * @param intList
     * @return
     */
    public static int[] convertIntArr(List<Integer> intList){
        int size = intList.size();
        int[] arr = new int[size];
        for (int i = 0; i < size;i++){
            arr[i] = intList.get(i);
        }
        return arr;
    }

    /**
     * 判断是否为空，然后不为空，则顺便添加元素等
     * 一般用于 jdbc 中
     * @param param
     * @param colum
     * @param objList
     * @return
     */
    public static boolean isNotNull(Map<String,Object> param,String colum,List<Object> objList){
        Object obj = param.get(colum);
        if (obj != null && StringUtils.isNotBlank(obj.toString())){
            objList.add(obj);
            return true;
        }
        return false;
    }
    
    /**
     * 拷贝springside中的 方法
     * @param request
     * @param prefix
     * @return
     */
    public static Map<String, Object> getParametersStartingWith(ServletRequest request, String prefix) {
        Validate.notNull(request, "Request must not be null", new Object[0]);
        Enumeration paramNames = request.getParameterNames();
        TreeMap params = new TreeMap();
        if(prefix == null) {
            prefix = "";
        }

        while(paramNames != null && paramNames.hasMoreElements()) {
            String paramName = (String)paramNames.nextElement();
            if("".equals(prefix) || paramName.startsWith(prefix)) {
                String unprefixed = paramName.substring(prefix.length());
                String[] values = request.getParameterValues(paramName);
                if(values != null && values.length != 0) {
                    if(values.length > 1) {
                        params.put(unprefixed, values);
                    } else {
                        params.put(unprefixed, values[0]);
                    }
                }
            }
        }

        return params;
    }
    
}

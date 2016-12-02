package madx.common;

import org.apache.commons.lang3.Validate;

import javax.servlet.ServletRequest;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by A-mdx on 2016/12/2.
 */
public class Common {
    
    // 统计行数，大路径
    public static final int JAVA_FILE_PATH_BIG = 10011002;
    public static final int JAVA_FILE_PATH_SMALL = 10011001;

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

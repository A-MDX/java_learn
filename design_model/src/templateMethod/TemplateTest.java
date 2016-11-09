package templateMethod;

import org.junit.Test;

/**
 * Created by A-mdx on 2016/11/8.
 */
public class TemplateTest {
    
    @Test
    public void test1(){
        String exp = "8+8";
        AbstractCal cal = new Plus();
        int result = cal.calculate(exp,"\\+");
        System.out.println(exp + " --> "+result);
        
        String sql = "SELECT \n" +
                "  g.`group_code`,\n" +
                "  g.`creationtime`,\n" +
                "  g.`enablestate`,\n" +
                "  g.`post_url`,\n" +
                "  g.`post_key`,\n" +
                "  g.`name`,\n" +
                "  fc.`code_name` enablestate_str \n" +
                "FROM\n" +
                "  org_group g \n" +
                "  LEFT JOIN tm_fix_code fc \n" +
                "    ON fc.`code_type` = 1012 \n" +
                "    AND fc.`code` = g.`enablestate` \n" +
                "    WHERE 1 = 1\n" +
                "    AND g.`name` LIKE '%广%'\n" +
                "    AND g.`group_code` LIKE 'T'";
        
    }
    
}

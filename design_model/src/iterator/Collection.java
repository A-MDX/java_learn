package iterator;

/**
 * Created by A-mdx on 2016/11/11.
 */
public interface Collection {
    Iterator previous();
    
    // 取得集合元素
    Object get(int i);
    
    // 取得集合大小
    int size();
    
    
}
